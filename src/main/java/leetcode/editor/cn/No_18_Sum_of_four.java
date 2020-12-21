package leetcode.editor.cn;

//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 507 👎 0

import org.junit.Test;

import java.util.*;

// FourSum
public class No_18_Sum_of_four {
    @Test
    public void test() {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> fourSum = fourSum(nums, target);
        System.out.println(fourSum);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
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

            List<List<Integer>> rsts = threeSum(nums, i + 1, nums.length - 1, target - curNum);
            stitchingResult(results, curNum, rsts);
            deduplicationSet.add(curNum);
        }

        return results;
    }

    public List<List<Integer>> threeSum(int[] nums, int l, int r, int target) {
        List<List<Integer>> results = new ArrayList<>();
        // System.out.println(Arrays.toString(nums));
        Set<Integer> deduplicationSet = new HashSet<>();
        for (int i = l; i <= r; i++) {
            // 遍历 i 必须存在, 看是否有答案
            int curNum = nums[i];
            if (deduplicationSet.contains(curNum)) {
                continue;
            }

            List<List<Integer>> rsts = twoSum(nums, i + 1, r, target - curNum);
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