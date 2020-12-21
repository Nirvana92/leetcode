package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nirvana
 * @date 2020/11/3 23:08
 * <p>
 * 508. 出现次数最多的子树元素和
 */
public class No_508_The_most_frequently_occurring_subtree_elements_and {

    int maxCounts = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        Map<Integer, Integer> maps = new HashMap<>();
        fillSums(root, maps);

        int arrLens = 0;
        List<Integer> lists = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
            if (entry.getValue() == maxCounts) {
                lists.add(entry.getKey());
            }
        }

        int index = 0;
        int[] results = new int[lists.size()];
        for (Integer val : lists) {
            results[index++] = val;
        }

        return results;
    }

    int fillSums(TreeNode root, Map<Integer, Integer> maps) {
        if (root.left == null && root.right == null) {
            int curCounts = maps.getOrDefault(root.val, 0) + 1;
            maps.put(root.val, curCounts);
            maxCounts = Math.max(maxCounts, curCounts);
            return root.val;
        }

        int curSum = root.val;
        if (root.left != null) {
            curSum += fillSums(root.left, maps);
        }

        if (root.right != null) {
            curSum += fillSums(root.right, maps);
        }

        int curCounts = maps.getOrDefault(curSum, 0) + 1;
        maxCounts = Math.max(maxCounts, curCounts);
        maps.put(curSum, curCounts);

        return curSum;
    }
}
