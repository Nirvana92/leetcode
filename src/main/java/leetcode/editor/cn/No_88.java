package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

public class No_88 {
    @Test
    public void test() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0}, nums2 = new int[]{2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        PrintUtils.print(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstIndex = m - 1, secondIndex = n - 1, fillIndex = m + n - 1;

        while (fillIndex >= 0 && firstIndex >= 0 && secondIndex >= 0) {
            if (nums1[firstIndex] > nums2[secondIndex]) {
                nums1[fillIndex--] = nums1[firstIndex--];
            } else {
                nums1[fillIndex--] = nums2[secondIndex--];
            }
        }

        while (firstIndex >= 0) {
            nums1[fillIndex--] = nums1[firstIndex--];
        }

        while (secondIndex >= 0) {
            nums1[fillIndex--] = nums2[secondIndex--];
        }
    }
}
