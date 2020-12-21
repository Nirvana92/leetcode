package leetcode.editor.cn;

import org.junit.Test;

public class No_701_Insert_operation_in_binary_search_tree {
    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(7);
        TreeNode ll = new TreeNode(1);
        TreeNode lr = new TreeNode(3);
        l.left = ll;
        l.right = lr;
        root.left = l;
        root.right = r;

        int val = 5;
        TreeNode treeNode = insertIntoBST(root, val);
        System.out.println(treeNode);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val && root.left == null) {
            root.left = new TreeNode(val);
            return root;
        }

        if (val > root.val && root.right == null) {
            root.right = new TreeNode(val);
            return root;
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
