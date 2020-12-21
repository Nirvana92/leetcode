package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;
import org.nirvana.util.Utils;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2020/10/27 11:26 上午
 * @desc: 剑指 Offer 51. 数组中的逆序对
 * <p>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */
public class Offer_51_Reversed_pairs_in_the_array {
    @Test
    public void test() {
        int[] nums = new int[]{7, 5, 6, 4};
        nums = new int[]{26, 25, 22, 7, 6, 3};
        nums = new int[]{2, 1};

        int reversePairs = reversePairs(nums);
        System.out.println(reversePairs);
    }

    @Test
    public void t() {
        int times = 100000000;
        while (times-- > 0) {
            int[] arrs = Utils.generIntArr(0, 20, 1, 30);
            int[] baoliArrs = Arrays.copyOf(arrs, arrs.length);
            int reversePairs = reversePairs(arrs);
            int reverseParirsBaoli = reverseParirsBaoli(baoliArrs);
            // int reverseParirsBaoli = reversePairs;
            if (reversePairs != reverseParirsBaoli) {
                PrintUtils.print(arrs);
                System.out.println(reversePairs);
                System.out.println(reverseParirsBaoli);
                System.out.println("error");
                break;
            }
        }
    }

    /**
     * 归并排序方式找逆序对
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, r = nums.length - 1;

        return sort(nums, l, r);
    }

    /**
     * 归并排序
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    int sort(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }

        int mid = (l + r) >> 1;
        int left = sort(nums, l, mid);
        int right = sort(nums, mid + 1, r);

        int mergeNum = merge(nums, l, mid, mid + 1, r);
        return mergeNum + left + right;
    }

    int merge(int[] nums, int ll, int lr, int rl, int rr) {
        int[] mergeNums = new int[rr - ll + 1];

        int rPairs = 0;
        int mergeIndex = 0, leftIndex = ll, rightIndex = rl;
        while (leftIndex <= lr && rightIndex <= rr) {
            if (nums[leftIndex] > nums[rightIndex]) {
                rPairs += rr - rightIndex + 1;
                mergeNums[mergeIndex++] = nums[leftIndex++];
            } else {
                // if (nums[leftIndex] < nums[rightIndex])
                // 两个位置的数相等; 两个位置相等可以等于 该分支的逻辑
                mergeNums[mergeIndex++] = nums[rightIndex++];
            }
        }

        while (leftIndex <= lr) {
            mergeNums[mergeIndex++] = nums[leftIndex++];
        }

        while (rightIndex <= rr) {
            mergeNums[mergeIndex++] = nums[rightIndex++];
        }

        for (int i = 0; i < mergeNums.length; i++) {
            nums[ll + i] = mergeNums[i];
        }

        return rPairs;
    }

    /**
     * 暴利法
     *
     * @param nums
     * @return
     */
    int reverseParirsBaoli(int[] nums) {
        int reversePairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    reversePairs++;
                }
            }
        }

        return reversePairs;
    }
}
