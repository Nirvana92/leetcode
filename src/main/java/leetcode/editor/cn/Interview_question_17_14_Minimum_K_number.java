package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2020/11/19 7:17 下午
 * @desc: 面试题 17.14. 最小K个数
 */
public class Interview_question_17_14_Minimum_K_number {
    @Test
    public void test() {
        int[] arr = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;

        int[] smallestK = smallestK(arr, k);
        PrintUtils.print(smallestK);
    }

    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queues = new PriorityQueue<>((i1, i2) -> i2 - i1);

        for (int i = 0; i < arr.length; i++) {
            queues.add(arr[i]);

            if (queues.size() > k) {
                queues.poll();
            }
        }

        int[] rets = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            rets[i] = queues.poll();
        }

        return rets;
    }
}
