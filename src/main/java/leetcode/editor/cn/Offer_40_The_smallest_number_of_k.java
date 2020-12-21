package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2020/11/9 10:05 上午
 * @desc: 剑指 Offer 40. 最小的k个数
 */
public class Offer_40_The_smallest_number_of_k {
    @Test
    public void test() {
        int[] arr = new int[]{3, 2, 1};
        int k = 2;

        arr = new int[]{0, 1, 2, 1};
        k = 1;

        int[] leastNumbers = getLeastNumbers(arr, k);
        PrintUtils.print(leastNumbers);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        // Comparator.comparingInt(i -> i)
        PriorityQueue<Integer> queues = new PriorityQueue<>((i1, i2) -> i2 - i1);

        for (int i = 0; i < arr.length; i++) {
            queues.add(arr[i]);
            if (queues.size() > k) {
                queues.poll();
            }
        }

        int[] rets = new int[k];
        for (int i = 0; i < rets.length; i++) {
            rets[i] = queues.poll();
        }

        return rets;
    }
}
