package leetcode.editor.cn;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author Nirvana
 * @date 2021/2/11 20:32
 */
public class No_703_The_Kth_largest_element_in_the_data_stream {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4};
        int k = 2;

        nums = new int[]{4, 5, 8, 2};
        k = 3;

        KthLargest kthLargest = new KthLargest(k, nums);

        int add = kthLargest.add(3);
        System.out.println(add);
        add = kthLargest.add(5);
        System.out.println(add);

//        int add = kthLargest.add(0);
//        System.out.println(add);
    }

    class KthLargest {
        private PriorityQueue<Integer> queues = new PriorityQueue<>();
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;

            for (int num : nums) {
                queues.add(num);
                if (queues.size() > k) {
                    queues.poll();
                }
            }
        }

        public int add(int val) {
            queues.add(val);

            if (queues.size() > k) {
                queues.poll();
            }

            return queues.peek();
        }
    }
}
