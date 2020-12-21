package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/22 3:03 下午
 * @desc: 只需要判断 num[i] > num[i+1] 与否
 */
public class No_162_find_peak {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 1};
        int peakElement = findPeakElement(nums);
        int result = findPeak(nums);
        System.out.println(peakElement);
        System.out.println(result);
    }

    public int findPeakElement(int[] nums) {
        int N = nums.length;

        if (nums == null || N == 0) {
            return -1;
        }

        if (N == 1 || nums[0] > nums[1]) {
            return 0;
        }

        if (nums[N - 1] > nums[N - 2]) {
            return N - 1;
        }

        for (int i = 1; i < N - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    /**
     * log n
     *
     * @return
     */
    public int findPeak(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r + l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
