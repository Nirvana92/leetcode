package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/10 5:01 下午
 * @desc: 参考的内容:https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 */
public class No_4_Find_the_median_of_two_positive_arrays {
    @Test
    public void test() {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};

        nums1 = new int[]{0, 0};
        nums2 = new int[]{0, 0};

        nums1 = new int[]{};
        nums2 = new int[]{1};

        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    /**
     * 思路1: 根据两个数组的长度找到中位数的下标, 然后通过两个指针往后一次找, 找到目标的下标值, 然后求得最终的中位数[O(m+n)]
     * 思路2:
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int mid = (len1 + len2) >> 1;
        if ((len1 + len2) % 2 == 1) {
            // 奇数
            return getKthNum(nums1, 0, len1 - 1, nums2, 0, len2 - 1, mid + 1);
        } else {
            // 偶数
            int midUpNum = getKthNum(nums1, 0, len1 - 1, nums2, 0, len2 - 1, mid);
            int midDownNum = getKthNum(nums1, 0, len1 - 1, nums2, 0, len2 - 1, mid + 1);
            return ((double) midUpNum + (double) midDownNum) / 2;
        }
    }

    public int getKthNum(int[] nums1, int startIndex1, int endIndex1, int[] nums2, int startIndex2, int endIndex2, int k) {
        int len1 = endIndex1 - startIndex1 + 1;
        int len2 = endIndex2 - startIndex2 + 1;

        if (len1 > len2) {
            return getKthNum(nums2, startIndex2, endIndex2, nums1, startIndex1, endIndex1, k);
        }

        if (len1 == 0) {
            return nums2[startIndex2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[startIndex1], nums2[startIndex2]);
        }
        int mid = k >> 1;

        int tmpEndIndex1 = Math.min(startIndex1 + mid - 1, startIndex1 + len1 - 1);
        int tmpEndIndex2 = Math.min(startIndex2 + mid - 1, startIndex2 + len2 - 1);

        if (nums1[tmpEndIndex1] > nums2[tmpEndIndex2]) {
            return getKthNum(nums1, startIndex1, endIndex1, nums2, tmpEndIndex2 + 1, endIndex2, k - (tmpEndIndex2 - startIndex2 + 1));
        } else {
            return getKthNum(nums1, tmpEndIndex1 + 1, endIndex1, nums2, startIndex2, endIndex2, k - (tmpEndIndex1 - startIndex1 + 1));
        }
    }
}
