package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2020/9/24 8:35 下午
 * @desc
 */
public class No_31_Next_permutation {
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 5};
        nums = Utils.generIntArr(3, 10, 4, 20);
        // nums = new int[]{11, 6, 20, 21, 9, 22, 18, 4};
        // [11, 6, 20, 21, 18, 4, 9, 22]
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testSort() {
        int times = 100000;
        while (times-- > 0) {
            int[] nums = Utils.generIntArr(4, 15, 1, 50);
            int[] sysNums = Arrays.copyOfRange(nums, 0, nums.length);
            sort(nums, 0, nums.length - 1);
            Arrays.sort(sysNums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != sysNums[i]) {
                    System.out.println("====error ");
                    System.out.println(Arrays.toString(nums));
                    System.out.println(Arrays.toString(sysNums));
                }
            }

        }
    }

    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        // 1. 末尾的一个数字往前面找 小于当前值的第一个数字
        int N = nums.length;
        int firstIndex = N - 2, secondIndex = N - 1;
        // boolean swaped = false;
        while (firstIndex >= 0 && nums[firstIndex] >= nums[firstIndex + 1]) {
            firstIndex--;
        }

        if (firstIndex >= 0) {
            while (secondIndex >= 0 && nums[secondIndex] <= nums[firstIndex]) {
                secondIndex--;
            }

            swap(nums, firstIndex, secondIndex);
        }

        reverse(nums, firstIndex + 1, N - 1);
    }

    void swap(int[] nums, int a, int b) {
        int tmpNum = nums[a];
        nums[a] = nums[b];
        nums[b] = tmpNum;
    }

    void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    void sort(int[] nums, int l, int r) {
        int[] copyOfRange = Arrays.copyOfRange(nums, l, r + 1);
        if (l == r) {
            return;
        }

        int mid = (r + l) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, r);
        // 合并

        int[] tmpNums = new int[r - l + 1];
        int tmpIndex = 0;
        int leftIndex = l, rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= r) {
            if (nums[leftIndex] > nums[rightIndex]) {
                tmpNums[tmpIndex++] = nums[rightIndex++];
            } else {
                tmpNums[tmpIndex++] = nums[leftIndex++];
            }
        }

        while (leftIndex <= mid) {
            tmpNums[tmpIndex++] = nums[leftIndex++];
        }

        while (rightIndex <= r) {
            tmpNums[tmpIndex++] = nums[rightIndex++];
        }

        for (int i = 0; i < tmpNums.length; i++) {
            nums[l + i] = tmpNums[i];
        }
    }
}
