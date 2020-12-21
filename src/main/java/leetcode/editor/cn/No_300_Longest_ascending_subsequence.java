package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;
import org.nirvana.util.Utils;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2020/10/4 12:20 上午
 * @desc: 300. 最长上升子序列
 */
public class No_300_Longest_ascending_subsequence {
    @Test
    public void test() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        nums = new int[]{4, 10, 4, 3, 8, 9};
        int lengthOfLIS = lengthOfLIS(nums);
        System.out.println(lengthOfLIS);
    }

    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        if (N == 1 || N == 0) {
            return N;
        }

        int[] help = new int[N];
        int helpLimit = 1, preIndex = 0;

        help[0] = nums[0];

        int maxLen = 1;
        for (int i = 1; i < N; i++) {
            preIndex = binarySearch(help, helpLimit, nums[i]);
            if (helpLimit == preIndex + 1) {
                // 大于help数组的最后一个值, 新增一个长度, 然后用num[i] 填充
                help[helpLimit++] = nums[i];
                maxLen = helpLimit;
            } else if (preIndex == -1) {
                if (help[0] > nums[i]) {
                    help[0] = nums[i];
                }
            } else {
                // 是在help 数组中的某一个值的下标索引, 直接替换preIndex 后一个位置的值
                help[preIndex + 1] = nums[i];
            }
        }

        return maxLen;
    }

    /**
     * 二分查找, 目标值大于等于的下标最大的值的下标
     *
     * @param nums
     * @param helpLimit
     * @param targetNum
     * @return
     */
    public int binarySearch(int[] nums, int helpLimit, int targetNum) {
        int l = 0, r = helpLimit, mid = 0;

        while (l <= r) {
            mid = (l + r) / 2;

            if (nums[mid] < targetNum) {
                if (mid == (helpLimit - 1) || nums[mid + 1] >= targetNum) {
                    return mid;
                }

                l = mid + 1;
            } else {
                // nums[mid] >= targetNum
                if (mid == 0 || nums[mid - 1] < targetNum) {
                    return mid - 1;
                }

                r = mid - 1;
            }
        }

        return l;
    }

    @Test
    public void testBinarySearch() {
        int times = 1000;
        while (times-- > 0) {
            int arrLen = (int) (Math.random() * 20) + 1;
            int[] nums = Utils.generIntArr(arrLen, 100);
            Arrays.sort(nums);
            int targetNum = (int) (Math.random() * 20);
            int bsRst = binarySearch(nums, nums.length, targetNum);
            int forRst = forSearch(nums, nums.length, targetNum);
            if (bsRst != forRst) {
                System.out.println("targetNum: " + targetNum + ", " + "bsRst:" + bsRst + ", forRst:" + forRst);
                PrintUtils.print(nums);
            }
        }
//        int[] nums = new int[]{4, 10};
//        int binarySearch = binarySearch(nums, nums.length, 4);
//        System.out.println(binarySearch);
    }

    public int forSearch(int[] nums, int helpLimit, int targetNum) {
        if (nums[0] >= targetNum) {
            return -1;
        }

        for (int i = 0; i < helpLimit; i++) {
            if (nums[i] < targetNum && (i + 1 == helpLimit || nums[i + 1] >= targetNum)) {
                return i;
            }
        }

        return helpLimit;
    }
}
