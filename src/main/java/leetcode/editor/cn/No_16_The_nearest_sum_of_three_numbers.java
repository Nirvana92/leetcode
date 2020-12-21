package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 * 提示：
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No_16_The_nearest_sum_of_three_numbers {
    @Test
    public void test() {
        int[] nums = new int[]{-1, 3, 1};
        int target = 1;
        int threeSumClosest = threeSumClosest(nums, target);
        System.out.println(threeSumClosest);
    }

    /**
     * 排序 + 双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        // 先进行排序: 直接调用系统函数
        Arrays.sort(nums);
        int threeSum = 0;
        int diffVal = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 遍历 i 必须存在, 看是否有答案
            int curNum = nums[i];
            int[] rsts = twoSum(nums, i + 1, nums.length - 1, target - curNum);
            if (diffVal > rsts[0]) {
                diffVal = rsts[0];
                threeSum = curNum + rsts[1] + rsts[2];
            }
        }

        return threeSum;
    }

    /**
     * nums[l...r] 中两个数的和最接近target 的结果返回
     *
     * @param nums
     * @param l
     * @param r
     * @param target
     * @return: 0: 差值, 1、 2: 差值最小的两个数值
     */
    public int[] twoSum(int[] nums, int l, int r, int target) {
        // 返回两个数之和最接近targer 的值返回
        int[] rsts = new int[3];
        int diffVal = Integer.MAX_VALUE;
        rsts[0] = diffVal;
        rsts[1] = 0;
        rsts[2] = 0;

        while (l < r) {
            if (nums[l] + nums[r] == target) {
                rsts[0] = 0;
                rsts[1] = nums[l];
                rsts[2] = nums[r];
                return rsts;
            } else {
                int curDiff = Math.abs(target - (nums[l] + nums[r]));
                if (curDiff < diffVal) {
                    diffVal = curDiff;
                    rsts[0] = diffVal;
                    rsts[1] = nums[l];
                    rsts[2] = nums[r];
                }

                if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return rsts;
    }
}
