package leetcode.editor.cn;

import org.junit.Test;

public class No_543Longestpalindromesubstring {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(5);
        // TreeNode rl = new TreeNode(6);
        l.left = ll;
        l.right = lr;
        // r.left = rl;
        root.left = l;
        root.right = r;

        int dis = diameterOfBinaryTree(root);
        System.out.println(dis);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return process(root).maxLen - 1;
    }

    Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftNode = process(root.left);
        Info rightNode = process(root.right);

        int maxLen = 0, maxLenWithHead = 1;
        if (leftNode != null) {
            maxLenWithHead += leftNode.maxLenWithHead;
            maxLen = Math.max(maxLen, leftNode.maxLen);
        }

        if (rightNode != null) {
            maxLenWithHead += rightNode.maxLenWithHead;
            maxLen = Math.max(maxLen, rightNode.maxLen);
        }

        maxLen = Math.max(maxLen, maxLenWithHead);
        return new Info(maxLen, maxLenWithHead);
    }
}

class Info {
    Integer maxLen;
    Integer maxLenWithHead;

    public Info(Integer maxLen, Integer maxLenWithHead) {
        this.maxLen = maxLen;
        this.maxLenWithHead = maxLenWithHead;
    }
}
