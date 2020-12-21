package leetcode.editor.cn;

/**
 * @author gzm
 * @date 2020/9/14 8:40 下午
 * @desc: 105. 从前序与中序遍历序列构造二叉树
 */
public class No_105_construct_a_binary_tree_from_preorder_and_middle_order_traversal_sequence {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] pre, int l1, int r1, int[] in, int l2, int r2) {
        // 说明没有节点, 直接返回null
        if (l1 > r1) {
            return null;
        }

        TreeNode head = new TreeNode(pre[l1]);
        // 说明只有一个节点
        if (l1 == r1) {
            return head;
        }

        // l1 < r1 的情况
        // l1 的头结点在 in 数组中的下标位置
        int headInIndex = l2;
        for (; headInIndex <= r2; headInIndex++) {
            if (in[headInIndex] == pre[l1]) {
                break;
            }
        }

        head.left = buildTree(pre, l1 + 1, headInIndex - l2 + l1, in, l2, headInIndex - 1);
        head.right = buildTree(pre, headInIndex - l2 + l1 + 1, r1, in, headInIndex + 1, r2);
        return head;
    }
}
