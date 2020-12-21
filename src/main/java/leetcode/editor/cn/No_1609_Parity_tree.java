package leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class No_1609_Parity_tree {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(10);
        TreeNode r = new TreeNode(4);
        root.left = l;
        root.right = r;

        TreeNode ll = new TreeNode(3);
        TreeNode rl = new TreeNode(7);
        TreeNode rr = new TreeNode(9);
        l.left = ll;
        r.left = rl;
        r.right = rr;

        TreeNode lll = new TreeNode(12);
        TreeNode llr = new TreeNode(8);
        TreeNode rll = new TreeNode(6);
        TreeNode rrr = new TreeNode(2);
        ll.left = lll;
        ll.right = llr;
        rl.left = rll;
        rr.right = rrr;

        boolean evenOddTree = isEvenOddTree(root);
        System.out.println(evenOddTree);
    }

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 当前层是否为奇数
        boolean odd = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Integer preVal = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (!isValid(odd, node.val, preVal)) {
                    return false;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                preVal = node.val;
            }

            odd = !odd;
            preVal = null;
        }

        return true;
    }

    boolean isValid(boolean odd, Integer curVal, Integer preVal) {
        if (odd) {
            if (curVal % 2 == 0) {
                return false;
            }
        } else {
            if (curVal % 2 == 1) {
                return false;
            }
        }

        if (preVal != null && ((!odd && curVal >= preVal) || (odd && curVal <= preVal))) {
            return false;
        }

        return true;
    }
}
