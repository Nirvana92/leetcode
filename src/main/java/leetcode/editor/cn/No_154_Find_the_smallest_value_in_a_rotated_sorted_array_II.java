package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;
import org.nirvana.util.Utils;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Nirvana
 * @date 2020/11/1 20:39
 * <p>
 * 154. 寻找旋转排序数组中的最小值 II
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 * <p>
 * 局部参考: {@link No_153_Find_the_smallest_value_in_a_rotated_sorted_array}
 */
public class No_154_Find_the_smallest_value_in_a_rotated_sorted_array_II {
    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 5};
        nums = new int[]{2, 2, 2, 0, 1};

        // 问题1 的测试用例
        // nums = new int[]{2, 3, 4, 5, 6, 1};
        // nums = new int[]{3, 4, 5, 6, 1, 2};
        // nums = new int[]{4, 5, 6, 1, 2, 3};
        // nums = new int[]{5, 6, 1, 2, 3, 4};
        // nums = new int[]{6, 1, 2, 3, 4, 5};
        // nums = new int[]{1, 2};
        // nums = new int[]{2, 1};
        // nums = new int[]{1};
        nums = new int[]{14, 15, 17, 17, 19, 3, 3, 4, 9, 11, 13};
        nums = new int[]{6, 6, 7, 9, 9, 10, 11, 12, 12, 15, 16, 1, 2, 2, 2};
        nums = new int[]{18, 18, 5, 18};
        nums = new int[]{2, 3, 4, 5, 6, 6, 10, 10, 14, 17, 18, 18};
        nums = new int[]{9, 9, 15, 19, 2, 8};
        nums = new int[]{4, 7, 9, 9, 14, 18};

        int min = findMin(nums);
        System.out.println(min);
    }

    @Test
    public void t() {
        int times = 10000000;

        Random random = new Random();
        while (times-- > 0) {
            int[] oriArrs = Utils.generIntArr(1, 20, 1, 20);
            Arrays.sort(oriArrs);

            int N = oriArrs.length;
            int changeIndex = random.nextInt(N);
            int[] changeArrs = new int[N];

            for (int i = 0; i < N; i++) {
                changeArrs[i] = oriArrs[(changeIndex + i) % N];
            }

            // PrintUtils.print(changeArrs);
            int min = findMin(changeArrs);
            int minBaoli = getMinBaoli(oriArrs);
            if (min != minBaoli) {
                System.out.println(min);
                System.out.println(minBaoli);
                PrintUtils.print(changeArrs);
                System.out.println("error ");

                break;
            }
        }
    }

    /**
     * 下面几种情况找规律得到公式处理
     * 0, 1, 2, 2, 2
     * 2, 0, 1, 2, 2
     * 2,2,0,1,2
     * 2,2,2,0,1
     * 1,2,2,2,0
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r--;
            }
        }

        return nums[l];
    }

    public int getMinBaoli(int[] nums) {
        Arrays.sort(nums);

        return nums[0];
    }
}
