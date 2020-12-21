package leetcode.editor.cn;

import org.junit.Test;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class No_98 {
    public static void main(String[] args) {
        No_98 no_98 = new No_98();

//        TreeNode root = new TreeNode(10);
//        TreeNode l = new TreeNode(5);
//        TreeNode r = new TreeNode(15);
//
//        TreeNode rl = new TreeNode(6);
//        TreeNode rr = new TreeNode(20);
//        r.left = rl;
//        r.right = rr;
//
//        root.left = l;
//        root.right = r;
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(1);
        root.left = l;

        boolean validBST = no_98.isValidBST(root);
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {
        // 头结点
        TreeNode cur = root;
        // 最右节点
        TreeNode mostRight = null;

        Integer preVal = null;
        while (cur != null) {
            mostRight = cur.left;
            // 有左树
            if (mostRight != null) {
                // 找到最右节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    // 找到的最真实的最右节点
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    // 第二次回到头节点
                    mostRight.right = null;
                }
            }

            // 中序
            if (preVal != null && cur.val <= preVal) {
                return false;
            }
            preVal = cur.val;

            cur = cur.right;
        }

        return true;
    }

    @Test
    public void testBST() {
        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(1);

        TreeNode rl = new TreeNode(3);
        TreeNode rr = new TreeNode(6);
        TreeNode r = new TreeNode(4);
        r.left = rl;
        r.right = rr;
        root.left = l;
        root.right = r;

        boolean validBST = isValidBST(root);
        System.out.println(validBST);
    }
}
