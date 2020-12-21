package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2020/9/28 8:59 下午
 * @desc
 */
public class No_137_Number_that_appears_only_once_II {
    @Test
    public void test() {
        int[] nums = new int[]{2, 2, 3, 3, 2};
        int singleNumber = singleNumber(nums);
        int singleNum = singleNum(nums);
        System.out.println(singleNumber);
        System.out.println(singleNum);
    }

    // todo: 实现原理
    public int singleNum(int[] nums) {
        int once = 0, twice = 0;

        for (int num : nums) {
            once = ~twice & (once ^ num);
            twice = ~once & (twice ^ num);
        }

        System.out.println("twice: " + twice);

        return once;
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        Integer singleNum = null;
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return 0;
    }
}
