package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.Arrays;

/**
 * @author Nirvana
 * @date 2020/11/11 21:14
 * <p>
 * 1636. 按照频率将数组升序排序
 */
public class No_1636_Sort_the_array_in_ascending_order_by_frequency {
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 2, 2, 2, 3};
        nums = new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1};

        int[] frequencySort = frequencySort(nums);
        PrintUtils.print(frequencySort);
    }

    public int[] frequencySort(int[] nums) {
        int[] counts = new int[201];
        for (int num : nums) {
            counts[num + 100]++;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = 10000 * counts[nums[i] + 100] + 100 - nums[i];
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 100 - nums[i] % 10000;
        }

        return nums;
    }
}
