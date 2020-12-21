package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

/**
 * @author gzm
 * @date 2020/9/25 5:31 下午
 * @desc: 去重问题没有处理
 */
public class No_40_Combination_Sum_II {
    @Test
    public void test() {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        //candidates = new int[]{2, 5, 2, 1, 2};
        //target = 5;

        List<List<Integer>> combinationSum2 = combinationSum2(candidates, target);
        System.out.println(combinationSum2);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Map<Integer, Integer> countMaps = new HashMap<>();
        for (int i = 0; i < candidates.length; i++) {
            countMaps.put(candidates[i], countMaps.getOrDefault(candidates[i], 0) + 1);
        }

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        combinationSum(candidates, target, 0, paths, countMaps, results);
        return results;
    }

    void combinationSum(int[] candidates, int restTarget, int curIndex, List<Integer> paths,
                        Map<Integer, Integer> countMaps, List<List<Integer>> results) {
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

        if (!(curIndex - 1 >= 0 && candidates[curIndex] == candidates[curIndex - 1])) {
            int smaeNumLen = countMaps.get(curNum);
            for (int i = 0; i <= smaeNumLen; i++) {
                appendTimesNum(paths, i, curNum);
                combinationSum(candidates, restTarget - i * curNum, curIndex + smaeNumLen, paths, countMaps, results);
                removeTimesNum(paths, i, curNum);
            }
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
}
