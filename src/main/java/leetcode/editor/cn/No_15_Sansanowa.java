package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

import java.util.*;

/**
 * @author gzm
 * @date 2020/9/24 10:57 上午
 * @desc 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 */
public class No_15_Sansanowa {
    @Test
    public void test() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        // nums = new int[]{-2, -2, 1, 0, 1, 5};
        nums = Utils.generIntArr(5, 15, -3, 5);
        List<List<Integer>> results = threeSum(nums);
        System.out.println(results);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        Set<Integer> deduplicationSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 遍历 i 必须存在, 看是否有答案
            int curNum = nums[i];
            if (deduplicationSet.contains(curNum)) {
                continue;
            }

            List<List<Integer>> rsts = twoSum(nums, i + 1, nums.length - 1, 0 - curNum);
            stitchingResult(results, curNum, rsts);
            deduplicationSet.add(curNum);
        }

        return results;
    }

    void stitchingResult(List<List<Integer>> results, int firstNum, List<List<Integer>> rsts) {
        for (List<Integer> rst : rsts) {
            List<Integer> tmpRst = new ArrayList<>();
            tmpRst.add(firstNum);
            tmpRst.addAll(rst);
            results.add(tmpRst);
        }
    }

    /**
     * nums[l...r] 是否有两个数的和为 target, 有的话返回这两个数
     *
     * @param nums
     * @param l
     * @param r
     * @param target
     */
    public List<List<Integer>> twoSum(int[] nums, int l, int r, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Set<Integer> deduplicationSet = new HashSet<>();
        while (l < r) {
            if (nums[l] + nums[r] == target && !deduplicationSet.contains(nums[l])) {
                List<Integer> rst = new ArrayList<>();
                rst.add(nums[l]);
                rst.add(nums[r]);
                results.add(rst);
                deduplicationSet.add(nums[l]);
                deduplicationSet.add(nums[r]);

                l++;
                r--;
            } else {
                if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return results;
    }
}
