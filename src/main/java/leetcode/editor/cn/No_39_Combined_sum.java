package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzm
 * @date 2020/9/25 11:16 上午
 * @desc
 */
public class No_39_Combined_sum {
    @Test
    public void test() {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;

        candidates = new int[]{2, 3, 5};
        target = 8;

        List<List<Integer>> combinationSum = combinationSum(candidates, target);
        System.out.println(combinationSum);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        combinationSum(candidates, target, 0, paths, results);
        return results;
    }

    void combinationSum(int[] candidates, int restTarget, int curIndex, List<Integer> paths, List<List<Integer>> results) {
        int N = candidates.length;
        if (curIndex == N && restTarget == 0) {
            // 结算, 将结果放到results
            results.add(copyLists(paths));
        }

        if (curIndex == N || restTarget < 0) {
            return;
        }

        // 遍历 curIndex 选择使用 0 ~ n 次
        int curNum = candidates[curIndex];
        for (int i = 0; curNum * i <= restTarget; i++) {
            appendTimesNum(paths, i, curNum);
            combinationSum(candidates, restTarget - i * curNum, curIndex + 1, paths, results);
            removeTimesNum(paths, i, curNum);
        }
    }

    void appendTimesNum(List<Integer> paths, int times, int num) {
        for (int i = 0; i < times; i++) {
            paths.add(num);
        }
    }

    void removeTimesNum(List<Integer> paths, int times, int num) {
        for (int i = 0; i < times; i++) {
            paths.remove(paths.size() - 1);
        }
    }

    List<Integer> copyLists(List<Integer> paths) {
        List<Integer> copyList = new ArrayList<>();
        for (Integer num : paths) {
            copyList.add(num);
        }

        return copyList;
    }

    /**
     * candidates 可以使用无限次要求累加和为target 的方法数
     *
     * @param candidates
     * @param target
     * @return
     */
    public int process(int[] candidates, int target) {
        // candidates[0...row] 中无限次使用累加和为 col 的方法数
        int N = candidates.length;
        int[][] dp = new int[N][target + 1];

        // 填充第一列的数据: 满足累加和为0
        for (int row = 0; row < N; row++) {
            dp[row][0] = 1;
        }

        // 填充第一行的数据: candidates[0] 元素满足 累加和为 col 的方法数
        for (int col = 1; col <= target; col++) {
            if (col % candidates[0] == 0) {
                dp[0][col] = 1;
            }
        }

        // 填充普遍位置: 从左往右, 从上往下
        // 不选择 i 的情况下: dp[i-1][target-candidates[row]]
        // 选择 i 的情况下: 选一次, 选两次, 选三次, 遍历求和 ==>> dp[i][target-candidates[row]]
        for (int row = 1; row < N; row++) {
            for (int col = 1; col <= target; col++) {
                dp[row][col] += (col - candidates[row]) >= 0 ? dp[row - 1][col - candidates[row]] : 0;
                dp[row][col] += (col - candidates[row]) >= 0 ? dp[row][col - candidates[row]] : 0;
            }
        }

        return dp[N - 1][target];
    }
}
