package leetcode.editor.cn;

/**
 * @author gzm
 * @date 2020/10/26 8:23 下午
 * @desc: 剑指 Offer 55 - II. 平衡二叉树
 * <p>
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class Offer_55_Balanced_binary_tree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = process(root.left);
        int right = process(root.right);
        return left != -1 && right != -1 && Math.abs(left - right) <= 1;
    }

    /**
     * 返回最大深度
     *
     * @param root
     * @return
     */
    int process(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = process(root.left);
        int right = process(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            // 不是平衡二叉树
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
