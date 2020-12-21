package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.LinkedList;

/**
 * @author gzm
 * @date 2020/10/9 4:34 下午
 * @desc 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 */
public class No_239_Maximum_sliding_window {
    @Test
    public void test() {
        int[] nums = new int[]{1, 3};
        int k = 3;
        int[] maxSlidingWindow = maxSlidingWindow(nums, k);
        PrintUtils.print(maxSlidingWindow);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        if (N < k) {
            return null;
        }
        int[] windowMaxVals = new int[N - k + 1];
        // 双端队列, 放入的规则是从左到右为: 大 -> 小;  队列中存放的是数组的下标值
        LinkedList<Integer> queue = new LinkedList();
        for (int i = 0; i < N; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);

            // 剔除过期元素值
            if (queue.peekFirst() == i - k) {
                queue.pollFirst();
            }

            if (i >= k - 1) {
                windowMaxVals[i - k + 1] = nums[queue.peekFirst()];
            }
        }

        return windowMaxVals;
    }
}
