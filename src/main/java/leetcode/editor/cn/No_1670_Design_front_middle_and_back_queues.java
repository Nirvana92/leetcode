package leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author gzm
 * @date 2020/12/4 4:18 下午
 * @desc: 1670. 设计前中后队列
 */
public class No_1670_Design_front_middle_and_back_queues {
    @Test
    public void test() {
        FrontMiddleBackQueue queue = new FrontMiddleBackQueue();

//        queue.pushFront(1);
//        queue.pushBack(2);
//        queue.pushMiddle(3);
//        queue.pushMiddle(4);
//        System.out.println(queue.popFront());
//        System.out.println(queue.popMiddle());
//        System.out.println(queue.popMiddle());
//        System.out.println(queue.popBack());
//        System.out.println(queue.popFront());


//        queue.pushFront(1);
//        queue.pushFront(2);
//        queue.pushFront(3);
//        queue.pushFront(4);
//
//        System.out.println(queue.popBack());
//        System.out.println(queue.popBack());
//        System.out.println(queue.popBack());
//        System.out.println(queue.popBack());

        queue.pushMiddle(493299);
        System.out.println(queue.popMiddle());
        queue.pushMiddle(75427);
        System.out.println(queue.popMiddle());
        queue.pushFront(753523);
        queue.pushMiddle(677444);
        queue.pushMiddle(431158);
        System.out.println(queue.popMiddle());
        System.out.println(queue.popMiddle());
        queue.pushBack(47949);
        System.out.println(queue.popMiddle());
    }

    class FrontMiddleBackQueue {
        LinkedList<Integer> firstQueues = null;
        LinkedList<Integer> lastQueues = null;

        public FrontMiddleBackQueue() {
            firstQueues = new LinkedList<>();
            lastQueues = new LinkedList<>();
        }

        public void pushFront(int val) {
            firstQueues.addFirst(val);
            balance();
        }

        public void pushMiddle(int val) {
            if (firstQueues.size() < lastQueues.size()) {
                firstQueues.addLast(val);
            } else {
                lastQueues.addFirst(val);
            }

            balance();
        }

        public void pushBack(int val) {
            lastQueues.addLast(val);
            balance();
        }

        public int popFront() {
            if (firstQueues.size() > 0) {
                Integer retVal = firstQueues.pollFirst();
                balance();
                return retVal;
            }

            if (lastQueues.size() > 0) {
                Integer retVal = lastQueues.pollFirst();
                balance();
                return retVal;
            }
            return -1;
        }

        public int popMiddle() {
            if (firstQueues.size() == 0 && lastQueues.size() == 0) {
                return -1;
            }

            if (firstQueues.size() >= lastQueues.size()) {
                Integer retVal = firstQueues.pollLast();
                balance();
                return retVal;
            } else {
                Integer retVal = lastQueues.pollFirst();
                balance();
                return retVal;
            }
        }

        public int popBack() {
            if (lastQueues.size() > 0) {
                Integer retVal = lastQueues.pollLast();
                balance();
                return retVal;
            }

            if (firstQueues.size() > 0) {
                Integer retVal = firstQueues.pollLast();
                balance();
                return retVal;
            }

            return -1;
        }

        /**
         * 平衡两个队列的方法
         */
        void balance() {
            if (firstQueues.size() - lastQueues.size() >= 1) {
                lastQueues.addFirst(firstQueues.pollLast());
            }

            if (lastQueues.size() - firstQueues.size() >= 2) {
                firstQueues.addLast(lastQueues.pollFirst());
            }
        }
    }
}
