package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author gzm
 * @date 2020/10/26 1:56 下午
 * @desc: 56. 合并区间
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
public class No_56_Merge_interval {
    @Test
    public void test() {
        int[][] intervals = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}};

        intervals = new int[][]{
                {1, 4},
                {0, 4}
        };

        intervals = new int[][]{
                {1, 4},
                {2, 3}
        };

        int[][] merge = merge(intervals);
        PrintUtils.print(merge);
    }

    public int[][] merge(int[][] intervals) {
        int[][] merges = new int[intervals.length][2];
        Arrays.sort(intervals, new Com());

        int mergeIndex = 0, iIndex = 0;
        while (iIndex < intervals.length) {
            if (mergeIndex == 0) {
                merges[mergeIndex][0] = intervals[iIndex][0];
                merges[mergeIndex][1] = intervals[iIndex][1];
                mergeIndex++;
            } else {
                if (intervals[iIndex][0] <= merges[mergeIndex - 1][1]) {
                    // 合并
                    merges[mergeIndex - 1][1] = Math.max(merges[mergeIndex - 1][1], intervals[iIndex][1]);
                } else {
                    merges[mergeIndex][0] = intervals[iIndex][0];
                    merges[mergeIndex][1] = intervals[iIndex][1];
                    mergeIndex++;
                }
            }

            iIndex++;
        }

        return Arrays.copyOfRange(merges, 0, mergeIndex);
    }

    class Com implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }
}
