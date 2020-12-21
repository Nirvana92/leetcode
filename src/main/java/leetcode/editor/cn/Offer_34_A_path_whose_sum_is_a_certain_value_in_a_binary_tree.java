package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzm
 * @date 2020/10/27 2:57 下午
 * @desc: 剑指 Offer 34. 二叉树中和为某一值的路径
 * <p>
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 */
public class Offer_34_A_path_whose_sum_is_a_certain_value_in_a_binary_tree {
    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(4);
        TreeNode r = new TreeNode(8);
        root.left = l;
        root.right = r;
        TreeNode ll = new TreeNode(11);
        l.left = ll;
        TreeNode rl = new TreeNode(13);
        TreeNode rr = new TreeNode(4);
        r.left = rl;
        r.right = rr;
        TreeNode lll = new TreeNode(7);
        TreeNode llr = new TreeNode(2);
        ll.left = lll;
        ll.right = llr;
        TreeNode rrl = new TreeNode(5);
        TreeNode rrr = new TreeNode(1);
        rr.left = rrl;
        rr.right = rrr;

        int sum = 22;
        List<List<Integer>> lists = pathSum(root, sum);
        System.out.println(lists);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rsts = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        process(root, sum, paths, rsts);

        return rsts;
    }

    void process(TreeNode root, int sum, List<Integer> paths, List<List<Integer>> rsts) {
        if (root == null) {
            return;
        }

        if (sum == root.val && root.left == null && root.right == null) {
            // 拿到结果, 赋值一份到结果集中
            paths.add(root.val);
            rsts.add(new ArrayList<>(paths));
            paths.remove(paths.size() - 1);

            return;
        }

        // 往左边走
        paths.add(root.val);
        process(root.left, sum - root.val, paths, rsts);
        // paths.remove(paths.size() - 1);
        process(root.right, sum - root.val, paths, rsts);
        paths.remove(paths.size() - 1);
    }
}
