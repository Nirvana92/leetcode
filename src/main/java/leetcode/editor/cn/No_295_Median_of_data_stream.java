package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2020/10/9 4:49 下午
 * @desc: 295. 数据流的中位数
 */
public class No_295_Median_of_data_stream {
    @Test
    public void test() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(3);
//        medianFinder.addNum(5);
//        medianFinder.addNum(3);

//        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(6);
//        medianFinder.addNum(10);
//        medianFinder.addNum(2);
//        medianFinder.addNum(6);
//        medianFinder.addNum(5);
//        medianFinder.addNum(0);
//        medianFinder.addNum(6);
//        medianFinder.addNum(3);
//        medianFinder.addNum(1);
//        medianFinder.addNum(0);
//        medianFinder.addNum(0);

        double median = medianFinder.findMedian();
        System.out.println(median);
    }

    /**
     * 通过两个堆来完成该功能, 一个大根堆一个小跟堆
     */
    class MedianFinder {
        private PriorityQueue<Integer> minStack;
        private PriorityQueue<Integer> maxStack;
        private int size;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            minStack = new PriorityQueue<>(new MinComparator());
            maxStack = new PriorityQueue<>(new MaxComparator());
        }

        public void addNum(int num) {
            // 如果小于 小跟堆的最大值放在
            if (size == 0) {
                maxStack.add(num);
            } else {
                // 如果小于大根堆的最大值, 放到大根堆中
                if (num < maxStack.peek()) {
                    maxStack.add(num);
                } else {
                    minStack.add(num);
                }

                // 平衡两个堆的大小
                if (maxStack.size() - minStack.size() >= 2) {
                    minStack.add(maxStack.poll());
                }

                if (minStack.size() - maxStack.size() >= 2) {
                    maxStack.add(minStack.poll());
                }
            }

            size++;
        }

        // 有序列表的中位数
        public double findMedian() {
            if (size % 2 == 1) {
                return maxStack.size() > minStack.size() ? maxStack.peek() : minStack.peek();
            } else {
                return ((double) (maxStack.peek() + minStack.peek())) / 2;
            }
        }
    }

    /**
     * 权限
     */
    class MinComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    /**
     *
     */
    class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    @Test
    public void testComparator() {
        Integer[] nums = new Integer[]{5, 4, 4, 5, 7, 5, 2, 8};
        Arrays.sort(nums, new MaxComparator());
        PrintUtils.print(nums);
    }
}
