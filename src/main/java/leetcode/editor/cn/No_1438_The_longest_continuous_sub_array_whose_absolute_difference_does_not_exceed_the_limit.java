package leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Nirvana
 * @date 2020/10/31 20:07
 * <p>
 * 1438. 绝对差不超过限制的最长连续子数组
 */
public class No_1438_The_longest_continuous_sub_array_whose_absolute_difference_does_not_exceed_the_limit {
    @Test
    public void test() {
        int[] nums = new int[]{8, 2, 4, 7};
        int limit = 4;

        nums = new int[]{10, 1, 2, 4, 7, 2};
        limit = 5;

        nums = new int[]{4, 2, 2, 2, 4, 4, 2, 2};
        limit = 0;

        nums = new int[]{1, 5, 6, 7, 8, 10, 6, 5, 6};
        limit = 4;

        int longestSubarray = longestSubarray(nums, limit);
        System.out.println(longestSubarray);
    }

    public int longestSubarray(int[] nums, int limit) {
        int N = nums.length;

        // maxs 记录窗口的最大值
        // mins 记录窗口的最小值
        LinkedList<Integer> maxs = new LinkedList<>(), mins = new LinkedList<>();

        int r = 0, longestSubArrs = 0;
        for (int i = 0; i < N; i++) {
            // 初始化最大值的窗口数据
            while (r < N && ((maxs.isEmpty() || mins.isEmpty()) || Math.abs(nums[maxs.peekFirst()] - nums[mins.peekFirst()]) <= limit)) {
                while (!maxs.isEmpty() && nums[maxs.peekLast()] <= nums[r]) {
                    maxs.pollLast();
                }

                while (!mins.isEmpty() && nums[mins.peekLast()] >= nums[r]) {
                    mins.pollLast();
                }

                maxs.add(r);
                mins.add(r);
                r++;
            }

            // 如果当前的r 满足limit 条件, 记录最长子数组长度
            if (Math.abs(nums[maxs.peekFirst()] - nums[mins.peekFirst()]) <= limit) {
                longestSubArrs = Math.max(longestSubArrs, r - i);
            } else {
                longestSubArrs = Math.max(longestSubArrs, r - i - 1);
            }

            if (maxs.peekFirst() == i) {
                maxs.pollFirst();
            }

            if (mins.peekFirst() == i) {
                mins.pollFirst();
            }
        }

        return longestSubArrs;
    }
}
