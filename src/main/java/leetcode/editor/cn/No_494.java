package leetcode.editor.cn;

/**
 * 494. 目标和
 */
public class No_494 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0};
        int S = 1;

        No_494 no_494 = new No_494();
        int targetSumWays = no_494.findTargetSumWays(nums, S);
        System.out.println(targetSumWays);
    }

    public int findTargetSumWays(int[] nums, int S) {
        return process(nums, 0, nums.length - 1, S);
    }

    /**
     * nums[l...r] 通过 +/- 满足S 的情况的方法数
     *
     * @param nums
     * @param l
     * @param r
     * @param S
     * @return: 如果使用动态规划, 需要找到S 的范围, 即 S +/- sumOfNums 的范围
     */
    public int process(int[] nums, int l, int r, int S) {
        // 到达结尾
        if (l == r) {
            return (nums[l] == S && -nums[l] == S) ? 2 : ((nums[l] == S || -nums[l] == S) ? 1 : 0);
        }
        // l 上用+ 的方法数
        int addMethods = process(nums, l + 1, r, S - nums[l]);
        // l 上用- 的方法数
        int minusMethods = process(nums, l + 1, r, S + nums[l]);

        return addMethods + minusMethods;
    }
}
