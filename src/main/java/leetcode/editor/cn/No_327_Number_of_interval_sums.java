package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/7 12:46
 */
public class No_327_Number_of_interval_sums {
    @Test
    public void test() {
        int[] nums = new int[]{-2, 5, -1};
        int lower = -2, upper = 2;

        int countRangeSum = countRangeSum(nums, lower, upper);
        System.out.println(countRangeSum);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        return sort(sums, lower, upper, 0, sums.length - 1);
    }

    int sort(long[] sums, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);

        int leftNums = sort(sums, lower, upper, left, mid);
        int rightNums = sort(sums, lower, upper, mid + 1, right);

        int ret = leftNums + rightNums;

        // 首先统计下标对的数量
        int i = left;
        int l = mid + 1;
        int r = mid + 1;
        while (i <= mid) {
            while (l <= right && sums[l] - sums[i] < lower) {
                l++;
            }
            while (r <= right && sums[r] - sums[i] <= upper) {
                r++;
            }
            ret += r - l;
            i++;
        }

        // 随后合并两个排序数组
        int[] sorted = new int[right - left + 1];
        int p1 = left, p2 = mid + 1;
        int p = 0;
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid) {
                sorted[p++] = (int) sums[p2++];
            } else if (p2 > right) {
                sorted[p++] = (int) sums[p1++];
            } else {
                if (sums[p1] < sums[p2]) {
                    sorted[p++] = (int) sums[p1++];
                } else {
                    sorted[p++] = (int) sums[p2++];
                }
            }
        }
        for (int j = 0; j < sorted.length; j++) {
            sums[left + j] = sorted[j];
        }
        return ret;
    }
}
