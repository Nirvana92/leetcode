package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class No_113_Path_sum_II {
    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(4);
        TreeNode ll = new TreeNode(11);
        TreeNode lll = new TreeNode(7);
        TreeNode llr = new TreeNode(2);

        TreeNode r = new TreeNode(8);
        TreeNode rl = new TreeNode(13);
        TreeNode rr = new TreeNode(4);
        TreeNode rrl = new TreeNode(5);
        TreeNode rrr = new TreeNode(1);

        ll.left = lll;
        ll.right = llr;
        l.left = ll;

        r.left = rl;
        r.right = rr;
        rr.left = rrl;
        rr.right = rrr;

        root.left = l;
        root.right = r;

        int sum = 18;

        root = new TreeNode(-2);
        r = new TreeNode(-3);
        root.right = r;

        sum = -5;

        List<List<Integer>> results = pathSum(root, sum);
        System.out.println(results);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();

        process(root, sum, paths, results);

        return results;
    }

    void process(TreeNode root, int sum, List<Integer> paths, List<List<Integer>> results) {
        // || sum < 0 || root.val > sum
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && root.val == sum) {
            // 收集结果集
            paths.add(root.val);
            results.add(copyLists(paths));
            paths.remove(paths.size() - 1);

            return;
        }

        paths.add(root.val);
        process(root.left, sum - root.val, paths, results);
        process(root.right, sum - root.val, paths, results);
        paths.remove(paths.size() - 1);
    }

    List<Integer> copyLists(List<Integer> paths) {
        List<Integer> copyList = new ArrayList<>();
        for (Integer num : paths) {
            copyList.add(num);
        }

        return copyList;
    }
}
