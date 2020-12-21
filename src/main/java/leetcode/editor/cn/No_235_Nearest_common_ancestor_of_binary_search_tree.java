package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/27 5:23 下午
 * @desc
 */
public class No_235_Nearest_common_ancestor_of_binary_search_tree {
    @Test
    public void test() {
        TreeNode root = new TreeNode(6);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(8);
        TreeNode ll = new TreeNode(0);
        TreeNode lr = new TreeNode(4);
        TreeNode rl = new TreeNode(7);
        TreeNode rr = new TreeNode(9);
        TreeNode lrl = new TreeNode(3);
        TreeNode lrr = new TreeNode(5);
        lr.left = lrl;
        lr.right = lrr;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;
        root.left = l;
        root.right = r;

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);

        TreeNode ancestor = lowestCommonAncestor(root, p, q);
        System.out.println(ancestor);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return process(root, p, q).ancestor;
    }

    Info process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Info(false, false, null);
        }

        if (root.left == null && root.right == null) {
            return new Info(root.val == p.val, root.val == q.val, null);
        }

        boolean containP = root.val == p.val, containQ = root.val == q.val;
        TreeNode ancestor = null;
        Info leftInfo = process(root.left, p, q);
        if (leftInfo != null) {
            containP |= leftInfo.containP;
            containQ |= leftInfo.containQ;
            if (leftInfo.ancestor != null) {
                ancestor = leftInfo.ancestor;
            }
        }

        Info rightInfo = process(root.right, p, q);
        if (rightInfo != null) {
            containP |= rightInfo.containP;
            containQ |= rightInfo.containQ;
            if (rightInfo.ancestor != null) {
                ancestor = rightInfo.ancestor;
            }
        }

        if (ancestor == null && containP && containQ) {
            ancestor = root;
        }

        return new Info(containP, containQ, ancestor);
    }

    class Info {
        boolean containP;
        boolean containQ;
        TreeNode ancestor;

        public Info(boolean containP, boolean containQ, TreeNode ancestor) {
            this.containP = containP;
            this.containQ = containQ;
            this.ancestor = ancestor;
        }
    }
}
