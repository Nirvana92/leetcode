package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/25 10:47 上午
 * @desc
 */
public class No_106_Traverse_the_sequence_from_the_middle_order_and_the_post_order_to_construct_a_binary_tree {
    @Test
    public void test() {
        // 中序遍历
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        // 后续遍历
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }

        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR) {
        if (inL > inR || postL > postR) {
            return null;
        }

        // 后续遍历的最后一个元素是当前子树的头结点
        int rootVal = postorder[postR];
        int rootInOrderIndex = 0;
        TreeNode root = new TreeNode(rootVal);
        // 遍历找到中序中 rootVal 的位置
        for (int i = inL; i <= inR; i++) {
            if (inorder[i] == rootVal) {
                rootInOrderIndex = i;
                break;
            }
        }

        TreeNode leftNode = buildTree(inorder, inL, rootInOrderIndex - 1, postorder, postL, postL + (rootInOrderIndex - inL - 1));
        TreeNode rightNode = buildTree(inorder, rootInOrderIndex + 1, inR, postorder, postL + (rootInOrderIndex - inL), postR - 1);
        root.left = leftNode;
        root.right = rightNode;

        return root;
    }
}
