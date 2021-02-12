package leetcode.editor.cn;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2020/12/30 9:07 上午
 * @desc: 1046. 最后一块石头的重量
 */
public class No_1046_The_weight_of_the_last_stone {
    @Test
    public void test() {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};

        int lastStoneWeight = lastStoneWeight(stones);
        System.out.println(lastStoneWeight);
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queues = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < stones.length; i++) {
            queues.add(stones[i]);
        }

        while (queues.size() > 1) {
            int firstVal = queues.poll();
            int secondVal = queues.poll();

            int diffVal = firstVal - secondVal;
            if (diffVal != 0) {
                queues.add(diffVal);
            }
        }


        return queues.size() == 0 ? 0 : queues.peek();
    }
}
