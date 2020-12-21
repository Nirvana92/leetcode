package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzm
 * @date 2020/10/12 7:51 下午
 * @desc: todo: 可以考虑改写为morris 遍历
 * <p>
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
public class No_530_Minimum_absolute_difference_of_binary_search_tree {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode r = new TreeNode(3);
        TreeNode rl = new TreeNode(2);
        r.left = rl;
        root.right = r;

        int minimumDifference = getMinimumDifference(root);
        System.out.println(minimumDifference);
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        return process(root, lists);
    }

    int process(TreeNode root, List<Integer> lists) {

        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int minDiff = Integer.MAX_VALUE;
        if (root.left != null) {
            minDiff = Math.min(minDiff, process(root.left, lists));
        }

        if (lists.size() > 0) {
            minDiff = Math.min(minDiff, Math.abs(root.val - lists.get(lists.size() - 1)));
        }
        lists.add(root.val);

        if (root.right != null) {
            minDiff = Math.min(minDiff, process(root.right, lists));
        }

        return minDiff;
    }

    /**
     * 理解错题意了, 这个方法是求两个相邻节点的差的绝对值的最小值
     *
     * @param root
     * @return
     */
    public int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return Integer.MAX_VALUE;
        }

        int minDiff = Integer.MAX_VALUE;

        if (root.left != null) {
            minDiff = Math.min(minDiff, getMinimumDifference(root.left));
            minDiff = Math.min(minDiff, Math.abs(root.val - root.left.val));
        }

        if (root.right != null) {
            minDiff = Math.min(minDiff, getMinimumDifference(root.right));
            minDiff = Math.min(minDiff, Math.abs(root.val - root.right.val));
        }

        return minDiff;
    }
}
