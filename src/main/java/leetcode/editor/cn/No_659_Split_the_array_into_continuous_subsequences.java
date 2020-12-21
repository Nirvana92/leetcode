package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2020/12/4 3:18 下午
 * @desc: 659. 分割数组为连续子序列
 */
public class No_659_Split_the_array_into_continuous_subsequences {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 3, 4, 5};
        nums = new int[]{1, 2, 3, 3, 4, 4, 5, 5};
        // nums = new int[]{1, 2, 3, 4, 4, 5};

        boolean b = isPossible(nums);
        System.out.println(b);
    }

    /**
     * 记录一个结尾的数组的个数和每个数字的剩余个数
     * <p>
     * 1. 优先找以 x-1 结尾的做消除
     * 2. 找不到的话，找后面两个数字的个数进行消除
     *
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        int N = nums.length;
        if (N < 3) {
            return false;
        }

        Map<Integer, Integer> countMaps = new HashMap<>();
        Map<Integer, Integer> endMaps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMaps.put(nums[i], countMaps.getOrDefault(nums[i], 0) + 1);
        }

        for (int num : nums) {
            Integer curCount = countMaps.getOrDefault(num, 0);
            if (curCount > 0) {
                Integer preCount = endMaps.getOrDefault(num - 1, 0);
                if (preCount > 0) {
                    endMaps.put(num - 1, preCount - 1);
                    endMaps.put(num, endMaps.getOrDefault(num, 0) + 1);
                    countMaps.put(num, curCount - 1);
                } else {
                    Integer _1Counts = countMaps.getOrDefault(num + 1, 0);
                    Integer _2Counts = countMaps.getOrDefault(num + 2, 0);

                    if (_1Counts > 0 && _2Counts > 0) {
                        countMaps.put(num, curCount - 1);
                        countMaps.put(num + 1, _1Counts - 1);
                        countMaps.put(num + 2, _2Counts - 1);

                        endMaps.put(num + 2, endMaps.getOrDefault(num + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
