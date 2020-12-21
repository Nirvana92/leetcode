package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gzm
 * @date 2020/12/21 10:05 上午
 * @desc: 1695. 删除子数组的最大得分
 * <p>
 * 滑动窗口: 保证窗口中的最大累加和
 */
public class No_1695_Remove_the_maximum_score_of_the_sub_array {
    @Test
    public void test() {
        int[] nums = new int[]{4, 2, 4, 5, 6};
        nums = new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5};

        int maximumUniqueSubarray = maximumUniqueSubarray(nums);
        System.out.println(maximumUniqueSubarray);
    }

    public int maximumUniqueSubarray(int[] nums) {
        int N = nums.length;
        int maxRet = 0;

        Set<Integer> containSets = new HashSet<>();
        int curRet = 0, r = 0;
        for (int i = 0; i < N; i++) {
            while (r < N && !containSets.contains(nums[r])) {
                curRet += nums[r];
                containSets.add(nums[r]);
                r++;
            }

            maxRet = Math.max(maxRet, curRet);

            curRet -= nums[i];
            containSets.remove(nums[i]);
        }

        return maxRet;
    }
}
