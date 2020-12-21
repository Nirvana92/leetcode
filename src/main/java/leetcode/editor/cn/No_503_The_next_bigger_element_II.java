package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Nirvana
 * @date 2020/11/3 22:41
 * <p>
 * 503. 下一个更大元素 II
 */
public class No_503_The_next_bigger_element_II {
    @Test
    public void test() {
        int[] nums = new int[]{6, 2, 1, 5};
        int[] nextGreaterElements = nextGreaterElements(nums);
        PrintUtils.print(nextGreaterElements);
    }

    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;

        int[] results = new int[N];
        Arrays.fill(results, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * N; i++) {
            while (!stack.isEmpty() && nums[i % N] > nums[stack.peek() % N]) {
                Integer curIndex = stack.pop();
                if (curIndex < N) {
                    results[curIndex] = nums[i % N];
                }
            }

            stack.add(i);
        }

        return results;
    }
}
