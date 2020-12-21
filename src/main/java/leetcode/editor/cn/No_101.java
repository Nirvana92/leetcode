package leetcode.editor.cn;

/**
 * 101. 对称二叉树
 */
public class No_101 {
    public static void main(String[] args) {
        No_101 no_101 = new No_101();

        TreeNode root = new TreeNode(1);

        TreeNode lr = new TreeNode(2);
        TreeNode l = new TreeNode(2);
        l.right = lr;

        TreeNode rr = new TreeNode(3);
        TreeNode r = new TreeNode(3);
        r.right = rr;

        root.left = l;
        root.right = r;

        boolean symmetric = no_101.isSymmetric(root);
        System.out.println(symmetric);
    }

    public boolean isSymmetric(TreeNode root) {
        // 获得中序遍历, 然后判断是否是对称的
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    /**
     * 判断 leftNode 和 rightNode 是否是相等的
     *
     * @param leftNode
     * @param rightNode
     * @return
     */
    boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }

        if (leftNode == null || rightNode == null) {
            return false;
        }

        return leftNode.val == rightNode.val && isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }
}
