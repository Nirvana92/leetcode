package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2020/9/24 11:26 上午
 * @desc
 */
public class No_1_Sum_of_two_numbers {
    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(target - nums[i])) {
                return new int[]{maps.get(target - nums[i]), i};
            }

            maps.put(nums[i], i);
        }

        return new int[2];
    }
}
