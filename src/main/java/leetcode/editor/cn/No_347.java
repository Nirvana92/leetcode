package leetcode.editor.cn;

import java.util.*;

/**
 * 前 K 个高频元素
 */
public class No_347 {

    public static void main(String[] args) {
        No_347 no_347 = new No_347();
//        int[] nums = new int[]{4,1,-1,2,-1,2,3};
//        int k = 2;
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] rst = no_347.topKFrequent(nums, k);
        System.out.println(Arrays.toString(rst));
    }

    public int[] topKFrequent(int[] nums, int k) {
        // 记录了所有的数字的种类数
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0)+1);
        }

        PriorityQueue<NumCount> queue = new PriorityQueue<>(new Comparator<NumCount>() {
            @Override
            public int compare(NumCount o1, NumCount o2) {
                return o1.count-o2.count;
            }
        });
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if(queue.size() == k) {
                if(queue.peek().count < entry.getValue()) {
                    queue.poll();
                    queue.add(new NumCount(entry.getKey(), entry.getValue()));
                }
            }else {
                queue.add(new NumCount(entry.getKey(), entry.getValue()));
            }
        }

        int[] rst = new int[k];
        for (int i = 0; i < rst.length; i++) {
            rst[i] = queue.poll().num;
        }

        return rst;
    }

    class NumCount {
        int num;
        int count;

        public NumCount(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
