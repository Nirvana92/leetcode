package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/16 4:11 下午
 * @desc: 740. 删除与获得点数
 * <p>
 * 给定一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * 示例:
 * 输入: nums = [3, 4, 2]
 * 输出: 6
 * 解释:
 * 删除 4 来获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
 * <p>
 * <p>
 * 示例:
 * 输入: nums = [2, 2, 3, 3, 3, 4]
 * 输出: 9
 * 解释:
 * 删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 */
public class No_740_Delete_and_earn_points {
    @Test
    public void test() {
        int[] nums = new int[]{3, 4, 2};
        nums = new int[]{2, 2, 3, 3, 3, 4};
        int deleteAndEarn = deleteAndEarn(nums);
        System.out.println(deleteAndEarn);
    }

    /**
     * 从1 ~ 10000 的数, 然后如果 curNum 值取, 则 curNum 不取, 动态规划求取结果
     *
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 记录 1~10000 出现的次数
        // 这边需要转换下动态规划的方式, 通过具体的数内容的大小来进行dp
        int[] numCounts = new int[10001];
        int maxVal = 0;
        for (int num : nums) {
            numCounts[num]++;
            maxVal = Math.max(maxVal, num);
        }

        int[] dp = new int[maxVal + 1];
        dp[1] = numCounts[1] * 1;
        //  如果 i位置选择了 则 i+1 位置不能选择, i+2 的位置可以选择
        for (int i = 2; i <= maxVal; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + numCounts[i] * i);
        }

        return dp[maxVal];
    }
}
