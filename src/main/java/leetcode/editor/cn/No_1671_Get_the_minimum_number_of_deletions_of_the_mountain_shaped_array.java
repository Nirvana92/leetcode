package leetcode.editor.cn;

import org.classic_interview_questions.traincamp._5._5_4_Longest_increasing_subsequence;
import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/4 5:51 下午
 * @desc: 1671. 得到山形数组的最少删除次数
 * <p>
 * 类似最长递增子序列, 参考: {@link _5_4_Longest_increasing_subsequence}
 */
public class No_1671_Get_the_minimum_number_of_deletions_of_the_mountain_shaped_array {
    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 1};
        // nums = new int[]{2, 1, 1, 5, 6, 2, 3, 1};
        // nums = new int[]{4, 3, 2, 1, 1, 2, 3, 1};
        // nums = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        // nums = new int[]{100, 92, 89, 77, 74, 66, 64, 66, 64};

        int minimumMountainRemovals = minimumMountainRemovals(nums);
        System.out.println(minimumMountainRemovals);
    }

    /**
     * 解题思路:
     * 1. 从左往右求每个下标的最长递增[参考连续递增子数组的解法]
     * 2. 从右往左求每个下标的最长递减
     * 3. 然后依次遍历每个节点找到最长的左右满足条件的长度
     * <p>
     *
     * @param nums
     * @return
     */
    public int minimumMountainRemovals(int[] nums) {
        // 给的条件就是 nums.len >= 3
        int N = nums.length;

        int[] lToR = getNexts(nums);
        int[] tmpNums = new int[N];
        for (int i = 0; i < N; i++) {
            tmpNums[N - 1 - i] = nums[i];
        }

        int[] rToL = getNexts(tmpNums);

        int maxLen = 0;
        for (int i = 1; i < N; i++) {
            // 遍历每个中间位置的情况找到满足条件
            if (lToR[i] > 0 && rToL[N - i - 1] > 0) {
                maxLen = Math.max(maxLen, lToR[i] + rToL[N - 1 - i] - 1);
            }
        }

        return N - maxLen;
    }

    /**
     * 求一个方向上的递增长度
     *
     * @param nums
     * @return
     */
    int[] getNexts(int[] nums) {
        int N = nums.length;

        int nextLimit = 0;
        // 标识到当前位置的最大递增长度
        int[] dp = new int[N];
        int[] nexts = new int[N];
        nexts[0] = nums[0];

        // 从左往右的递增
        for (int i = 1; i < N; i++) {
            // nexts 数组中小于 nums[i] 的最大值的下标索引
            int ltIndex = binarySearch(nexts, nextLimit, nums[i]);

            if (ltIndex == nextLimit) {
                nexts[nextLimit + 1] = nums[i];
                nextLimit = nextLimit + 1;

                dp[i] = nextLimit > 0 ? nextLimit + 1 : nextLimit;
                // dp[i] = nextLimit;
            } else {
                if (nums[i] < nexts[ltIndex + 1]) {
                    // 如果当前的值小于后面一位的值, 则进行数值的替换
                    nexts[ltIndex + 1] = nums[i];
                }
                dp[i] = ltIndex + 1 > 0 ? (ltIndex + 2) : 0;
                // dp[i] = ltIndex + 1;
            }
        }

        return dp;
    }

    /**
     * 找到当前值小于等于的最大位置
     *
     * @param nexts
     * @param limit
     * @return: 返回的下标索引 < curVal
     */
    int binarySearch(int[] nexts, int limit, int curVal) {
        int l = 0, r = limit;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nexts[mid] == curVal) {
                return mid - 1;
            } else if (nexts[mid] > curVal) {
                if (mid - 1 < 0) {
                    return mid - 1;
                }

                if (curVal > nexts[mid - 1]) {
                    return mid - 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (mid + 1 > r) {
                    return mid + 1;
                }
                if (curVal <= nexts[mid + 1]) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return nexts[l] < curVal ? l : l - 1;
    }
}
