package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/1/5 9:33 上午
 * @desc: 1448. 统计二叉树中好节点的数目
 */
public class No_1448_Count_the_number_of_good_nodes_in_the_binary_tree {
    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(1);
        TreeNode r = new TreeNode(4);
        root.left = l;
        root.right = r;

        TreeNode ll = new TreeNode(3);
        l.left = ll;

        TreeNode rl = new TreeNode(1);
        TreeNode rr = new TreeNode(5);
        r.left = rl;
        r.right = rr;


        root = new TreeNode(3);
        l = new TreeNode(3);
        ll = new TreeNode(4);
        TreeNode lr = new TreeNode(2);
        root.left = l;
        // root.right = null;
        l.left = ll;
        l.right = lr;

        root = new TreeNode(1);

        int goodNodes = goodNodes(root);
        System.out.println(goodNodes);
    }

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ret = 1;
        if (root.left != null) {
            ret += goodNodes(root.left, root.val);
        }

        if (root.right != null) {
            ret += goodNodes(root.right, root.val);
        }

        return ret;
    }

    int goodNodes(TreeNode root, int preMaxVal) {
        int ret = preMaxVal <= root.val ? 1 : 0;

        if (root.left != null) {
            ret += goodNodes(root.left, Math.max(preMaxVal, root.val));
        }

        if (root.right != null) {
            ret += goodNodes(root.right, Math.max(preMaxVal, root.val));
        }

        return ret;
    }
}
