package leetcode.editor.cn;

/**
 * 最长同值路径
 */
public class No_687 {

    public static void main(String[] args) {
        No_687 no_687 = new No_687();
        int longestUnivalue = no_687.longestUnivaluePath(null);
        System.out.println(longestUnivalue);
    }

    public int longestUnivaluePath(TreeNode root) {
        return process(root).max;
    }

    public Info process(TreeNode node) {
        if(node == null) {
            return new Info(0, 0);
        }

        TreeNode left = node.left;
        TreeNode right = node.right;

        Info leftInfo = process(left);
        Info rightInfo = process(right);

        int len = 0, max = 0;
        if(left != null && node.val == left.val) {
            len = Math.max(len, leftInfo.len+1);
        }

        if(right != null && node.val == right.val) {
            len = Math.max(len, rightInfo.len+1);
        }

        max = Math.max(Math.max(leftInfo.max, rightInfo.max), len);

        if(left != null && right != null && node.val == left.val && node.val == right.val) {
            max = Math.max(max, leftInfo.len+rightInfo.len+1);
        }

        return new Info(len, max);
    }

    class Info {
        int len;
        int max;

        public Info(int len, int max) {
            this.len = len;
            this.max = max;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


