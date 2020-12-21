package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nirvana
 * @date 2020/12/16 23:13
 */
public class No_1679_Maximum_number_of_K_sum_pairs {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4};
        int k = 5;

        nums = new int[]{3, 1, 3, 4, 3};
        k = 6;

        int maxOperations = maxOperations(nums, k);
        System.out.println(maxOperations);
    }

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], maps.getOrDefault(nums[i], 0) + 1);
        }


        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!maps.containsKey(nums[i])) {
                continue;
            }

            Integer count = maps.get(nums[i]);
            if (count == 1) {
                maps.remove(nums[i]);
            } else {
                maps.put(nums[i], count - 1);
            }

            if (maps.containsKey(k - nums[i])) {
                ret++;
                Integer c = maps.get(k - nums[i]);
                if (c == 1) {
                    maps.remove(k - nums[i]);
                } else {
                    maps.put(k - nums[i], c - 1);
                }

            }
        }

        return ret;
    }
}
