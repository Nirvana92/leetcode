package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/21 2:17 下午
 * @desc: 后序遍历, 定义一个变量将后续遍历过程中的值都累加起来
 */
public class No_538_convert_binary_search_tree_to_cumulative_treeLongestpalindromesubstring {
    @Test
    public void test() {
//        TreeNode root = new TreeNode(5);
//        TreeNode r = new TreeNode(13);
//        TreeNode l = new TreeNode(2);
//        root.left = l;
//        root.right = r;

        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(3);
        TreeNode ll = new TreeNode(2);
        TreeNode lr = new TreeNode(4);
        l.left = ll;
        l.right = lr;
        TreeNode r = new TreeNode(7);
        TreeNode rl = new TreeNode(6);
        TreeNode rr = new TreeNode(8);
        r.left = rl;
        r.right = rr;
        root.left = l;
        root.right = r;

        TreeNode result = convertBST(root);
        System.out.println(result);
    }

    public TreeNode convertBST(TreeNode root) {
        postOrder(root, 0);
        return root;
    }

    int postOrder(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }

        int curNodeWaitAddNum = preSum;
        if (root.right != null) {
            curNodeWaitAddNum = postOrder(root.right, curNodeWaitAddNum);
        }

        // 计算当前头结点
        root.val = root.val + curNodeWaitAddNum;

        int nextLeftNodeWaitAddNum = root.val;
        if (root.left != null) {
            nextLeftNodeWaitAddNum = postOrder(root.left, nextLeftNodeWaitAddNum);
        }

        return nextLeftNodeWaitAddNum;
    }
}
