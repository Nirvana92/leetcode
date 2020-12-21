package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.Stack;

/**
 * @author gzm
 * @date 2020/10/26 4:50 下午
 * @desc: 739. 每日温度
 * <p>
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class No_739_Daily_temperature {
    @Test
    public void test() {
        int[] nums = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] dailyTemperatures = dailyTemperatures(nums);
        PrintUtils.print(dailyTemperatures);
    }

    public int[] dailyTemperatures(int[] nums) {
        int[] dailys = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        // 有大到小
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.add(i);
            } else {
                // 计算前面的位置的值
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    int preIndex = stack.pop();
                    dailys[preIndex] = i - preIndex;
                }

                stack.add(i);
            }
        }

        return dailys;
    }
}
