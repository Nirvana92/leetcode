package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.*;

/**
 * @author gzm
 * @date 2020/10/28 5:46 下午
 * @desc: 632. 最小区间
 * <p>
 * todo: 复习
 *
 * <p>
 * 你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 */
public class No_632_Minimum_interval {
    @Test
    public void test() {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(4, 10, 15, 24, 26);
        List<Integer> list2 = Arrays.asList(0, 9, 12, 20);
        List<Integer> list3 = Arrays.asList(5, 18, 22, 30);
        nums.add(list1);
        nums.add(list2);
        nums.add(list3);

        nums = new ArrayList<>();
        list1 = Arrays.asList(1, 2, 3);
        list2 = Arrays.asList(1, 2, 3);
        list3 = Arrays.asList(1, 2, 3);
        nums.add(list1);
        nums.add(list2);
        nums.add(list3);

        nums = new ArrayList<>();
        list1 = Arrays.asList(10, 10);
        list2 = Arrays.asList(11, 11);
        nums.add(list1);
        nums.add(list2);

        nums = new ArrayList<>();
        list1 = Arrays.asList(10);
        list2 = Arrays.asList(11);
        nums.add(list1);
        nums.add(list2);

        nums = new ArrayList<>();
        list1 = Arrays.asList(1);
        list2 = Arrays.asList(2);
        list3 = Arrays.asList(3);
        List<Integer> list4 = Arrays.asList(4);
        List<Integer> list5 = Arrays.asList(5);
        List<Integer> list6 = Arrays.asList(6);
        List<Integer> list7 = Arrays.asList(7);
        nums.add(list1);
        nums.add(list2);
        nums.add(list3);
        nums.add(list4);
        nums.add(list5);
        nums.add(list6);
        nums.add(list7);

        int[] ints = smallestRange(nums);
        PrintUtils.print(ints);
    }

    /**
     * 定义一个带归属数组标签的小跟堆. 然后将每个数组的第一位数字添加到小跟堆中, 然后取出区间。找到最小区间
     *
     * @param nums
     * @return
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Info> minQueues = new PriorityQueue(new MinCom());
        PriorityQueue<Info> maxQueues = new PriorityQueue<>(new MaxCom());

        int[] lastIndex = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            Info info = new Info(i, nums.get(i).get(0));
            minQueues.add(info);
            maxQueues.add(info);
        }

        int[] smallestRanges = new int[]{
                Integer.MAX_VALUE, Integer.MIN_VALUE
        };
        boolean loop = true;
        while (loop) {
            // 如果某个数组已经遍历到最后了, 停止该循环
            int minVal = minQueues.peek().val;
            int maxVal = maxQueues.peek().val;
            if (smallestRanges[0] == Integer.MAX_VALUE) {
                // 第一次拿到最小区间, 直接填充
                smallestRanges[0] = minVal;
                smallestRanges[1] = maxVal;
            } else {
                // 第二次拿到最小区间. 比较填充
                if ((maxVal - minVal == smallestRanges[1] - smallestRanges[0] && minVal < smallestRanges[0]) || maxVal - minVal < smallestRanges[1] - smallestRanges[0]) {
                    // 找到了更小的区间, 填充
                    smallestRanges[0] = minVal;
                    smallestRanges[1] = maxVal;
                }
            }

            Info info = minQueues.poll();
            minQueues.remove(info);
            if (lastIndex[info.index] + 1 == nums.get(info.index).size()) {
                // 超过上限
                break;
            } else {
                int nextIndex = lastIndex[info.index] + 1;
                Integer nextVal = nums.get(info.index).get(nextIndex);
                Info nextInfo = new Info(info.index, nextVal);
                minQueues.add(nextInfo);
                maxQueues.add(nextInfo);
                lastIndex[info.index] = lastIndex[info.index] + 1;
            }
        }

        return smallestRanges;
    }

    class MinCom implements Comparator<Info> {
        @Override
        public int compare(Info o1, Info o2) {
            return o1.val - o2.val;
        }
    }

    class MaxCom implements Comparator<Info> {
        @Override
        public int compare(Info o1, Info o2) {
            return o2.val - o1.val;
        }
    }

    class Info {
        int index;
        int val;

        public Info(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    @Test
    public void tQueues() {
        PriorityQueue<Info> queues = new PriorityQueue(new MinCom());
        queues.add(new Info(1, 10));
        queues.add(new Info(2, 1));

        Info info = queues.poll();
        System.out.println(info.val);
    }
}
