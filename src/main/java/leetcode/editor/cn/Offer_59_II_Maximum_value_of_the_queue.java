package leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Nirvana
 * @date 2020/11/15 23:13
 * <p>
 * 剑指 Offer 59 - II. 队列的最大值
 * <p>
 * 滑动窗口处理
 */
public class Offer_59_II_Maximum_value_of_the_queue {
    @Test
    public void test() {
//        MaxQueue maxQueue = new MaxQueue();
//        maxQueue.push_back(1);
//        maxQueue.push_back(2);
//        int max_value = maxQueue.max_value();
//        int pop_front = maxQueue.pop_front();
//        int max_value1 = maxQueue.max_value();
//        System.out.println("max_value: " + max_value);
//        System.out.println("pop_front: " + pop_front);
//        System.out.println("max_value1: " + max_value1);

        MaxQueue maxQueue = new MaxQueue();
        int pop_front = maxQueue.pop_front();
        int max_value = maxQueue.max_value();
        System.out.println("pop_front: " + pop_front);
        System.out.println("max_value: " + max_value);
    }

    class MaxQueue {
        private LinkedList<Integer> queues;
        private LinkedList<Integer> maxValQueues;

        public MaxQueue() {
            queues = new LinkedList<>();
            maxValQueues = new LinkedList<>();
        }

        public int max_value() {
            if (maxValQueues.isEmpty()) {
                return -1;
            }

            return maxValQueues.peekFirst();
        }

        public void push_back(int value) {
            queues.addLast(value);

            while (!maxValQueues.isEmpty() && value > maxValQueues.peekLast()) {
                maxValQueues.pollLast();
            }

            maxValQueues.addLast(value);
        }

        public int pop_front() {
            if (queues.isEmpty()) {
                return -1;
            }

            Integer popVal = queues.pollFirst();
            if (!maxValQueues.isEmpty() && popVal.equals(maxValQueues.peekFirst())) {
                maxValQueues.pollFirst();
            }
            return popVal;
        }
    }
}
