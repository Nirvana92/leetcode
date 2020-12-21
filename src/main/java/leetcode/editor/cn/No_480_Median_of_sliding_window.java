package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2020/10/29 7:46 下午
 * @desc: 480. 滑动窗口中位数
 */
public class No_480_Median_of_sliding_window {
    @Test
    public void test() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

//        nums = new int[]{2147483647, 2147483647};
//        k = 2;
//
//        nums = new int[]{2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647};
//        k = 2;
//
//        nums = new int[]{-2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648};
//        k = 3;

        double[] doubles = medianSlidingWindow(nums, k);
        PrintUtils.print(doubles);
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        double[] medianNums = new double[N - k + 1];

        MedianFinder medianFinder = new MedianFinder();
        for (int i = 0; i < nums.length; i++) {
            medianFinder.addNum(i, nums[i]);

            if (medianFinder.size == k) {
                // 获得均值, 然后删除开头的值
                medianNums[i - k + 1] = medianFinder.findMedian();
                medianFinder.delNum(i - k + 1);
            }
        }

        return medianNums;
    }

    class MedianFinder {
        private HashMap<Integer, Info> maps;
        private PriorityQueue<Info> minStack;
        private PriorityQueue<Info> maxStack;
        private int size;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            minStack = new PriorityQueue<>(new MinComparator());
            maxStack = new PriorityQueue<>(new MaxComparator());
            maps = new HashMap<>();
        }

        public void addNum(int index, int num) {
            // 如果小于 小跟堆的最大值放在
            Info info = new Info(index, num);
            maps.put(index, info);

            if (maxStack.size() == 0) {
                maxStack.add(info);
            } else {
                // 如果小于大根堆的最大值, 放到大根堆中
                if (num < maxStack.peek().val) {
                    maxStack.add(info);
                    // minStack.add(info);
                } else {
                    // maxStack.add(info);
                    minStack.add(info);
                }

                balance();
            }

            size++;
        }

        public void delNum(int index) {
            Info info = maps.get(index);
            maxStack.remove(info);
            minStack.remove(info);

            balance();

            size--;
        }

        public void balance() {
            // 平衡两个堆的大小
            if (maxStack.size() - minStack.size() >= 2) {
                minStack.add(maxStack.poll());
            }

            if (minStack.size() - maxStack.size() >= 2) {
                maxStack.add(minStack.poll());
            }
        }

        // 有序列表的中位数
        public double findMedian() {
            if (size % 2 == 1) {
                return maxStack.size() > minStack.size() ? maxStack.peek().val : minStack.peek().val;
            } else {
                return ((double) (maxStack.peek().val + minStack.peek().val)) / 2;
            }
        }
    }

    class Info {
        int index;
        long val;

        public Info(int index, long val) {
            this.index = index;
            this.val = val;
        }
    }

    /**
     * 权限
     */
    class MinComparator implements Comparator<Info> {
        @Override
        public int compare(Info o1, Info o2) {
            long diffVal = o1.val - o2.val;
            return diffVal < 0 ? -1 : (diffVal == 0 ? 0 : 1);
        }
    }

    /**
     *
     */
    class MaxComparator implements Comparator<Info> {
        @Override
        public int compare(Info o1, Info o2) {
            long diffVal = o2.val - o1.val;
            return diffVal < 0 ? -1 : (diffVal == 0 ? 0 : 1);
        }
    }

    @Test
    public void t() {
        PriorityQueue<Info> queue = new PriorityQueue<>(new MinComparator());
        // -2147483648, 2147483647
        Info info1 = new Info(0, 2147483647);
        Info info2 = new Info(1, -2147483648);

        queue.add(info1);
        queue.add(info2);

        System.out.println(queue.peek().val);
    }
}
