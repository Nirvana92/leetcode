package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/28 11:14
 * <p>
 * 493. 翻转对
 * <p>
 * 归并排序改版
 */
public class No_493_Flip_pair {
    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 2, 3, 1};
        nums = new int[]{2, 4, 3, 5, 1};

        int reversePairs = reversePairs(nums);
        System.out.println(reversePairs);
    }

    public int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    public int sort(int[] arrs, int l, int r) {
        if (arrs == null || arrs.length <= 1 || l == r) {
            return 0;
        }

        int m = (r + l) >> 1;

        int leftRet = sort(arrs, l, m);
        int rightRet = sort(arrs, m + 1, r);
        int reversedPairs = findReversedPairs(arrs, l, r);
        merge(arrs, l, m, r);

        return leftRet + rightRet + reversedPairs;
    }

    public void merge(int[] arrs, int l, int m, int r) {
        int[] help = new int[(r - l) + 1];
        int helpIndex = 0, lIndex = l, rIndex = m + 1;


        while (lIndex <= m && rIndex <= r) {
            help[helpIndex++] = arrs[lIndex] > arrs[rIndex] ? arrs[rIndex++] : arrs[lIndex++];
        }

        while (lIndex <= m) {
            help[helpIndex++] = arrs[lIndex++];
        }

        while (rIndex <= r) {
            help[helpIndex++] = arrs[rIndex++];
        }

        for (int i = 0; i < help.length; i++) {
            arrs[l + i] = help[i];
        }
    }

    private int findReversedPairs(int[] nums, int left, int right) {
        int res = 0, mid = left + (right - left) / 2;
        int i = left, j = mid + 1;
        for (; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                res += mid - i + 1;
                j++;
            }
        }
        return res;
    }
}
