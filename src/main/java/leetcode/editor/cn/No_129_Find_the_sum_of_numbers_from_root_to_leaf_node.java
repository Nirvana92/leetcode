package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/28 7:53 下午
 * @desc
 */
public class No_129_Find_the_sum_of_numbers_from_root_to_leaf_node {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        root.left = l;
        root.right = r;

        int sum = sumNumbers(root);
        System.out.println(sum);
    }

    public int sumNumbers(TreeNode root) {
        return sumNum(root, 0);
    }

    int sumNum(TreeNode root, int preNum) {
        if (root == null) {
            return preNum;
        }

        if (root.left == null && root.right == null) {
            return preNum * 10 + root.val;
        }

        int sum = 0, leftDepth = 0, rightDepth = 0;
        if (root.left != null) {
            sum += sumNum(root.left, preNum * 10 + root.val);
        }

        if (root.right != null) {
            sum += sumNum(root.right, preNum * 10 + root.val);
        }

        return sum;
    }
}
