package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author gzm
 * @date 2020/12/31 9:23 上午
 * @desc: 435. 无重叠区间
 * <p>
 * <p>
 * 思路: 先按照第一位数字从小到大排序, 然后求第二位数组成的数组的最长递增子序列
 * <p>
 * 最长递增子序列的O(n*logn) 的求解方法参考: {@link No_1671_Get_the_minimum_number_of_deletions_of_the_mountain_shaped_array}
 * <p>
 * 转换成最长递增子序列
 */
public class No_435_Non_overlapping_interval {
    @Test
    public void test() {
        int[][] intervals = new int[][]{{1, 2}, {2, 3}};
        intervals = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        intervals = new int[][]{{0, 0}, {0, 1}, {17, 93}, {17, 21}, {23, 82}};
        intervals = new int[][]{{0, 0}, {0, 0}, {7, 90}, {53, 68}, {75, 76}};
        intervals = new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}};

        int eraseOverlapIntervals = eraseOverlapIntervals(intervals);
        System.out.println(eraseOverlapIntervals);
    }

    @Test
    public void t() {
        int times = 10000;

        while (times-- > 0) {
            int len = Utils.generInt(2, 4);

            int[][] intervals = new int[len][2];
            for (int i = 0; i < len; i++) {
                int minVal = Utils.generInt(1, 100);
                int maxVal = Utils.generInt(1, 100);
                intervals[i][0] = Math.min(minVal, maxVal);
                intervals[i][1] = Math.max(minVal, maxVal);

                int eraseOverlapIntervals = eraseOverlapIntervals(intervals);

            }

        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        // 排序完成之后, 然后删除范围大的数组
        int len = intervals.length;

        if (len <= 1) {
            return 0;
        }

        // Arrays.sort(intervals,);
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            // 判断当前的范围是否和之前的范围冲突

            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    // preVal = intervals[i];
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return len - maxLen;
    }
}
