package leetcode.editor.cn;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2020/11/2 10:36 上午
 * @desc: 1642. 可以到达的最远建筑
 */
public class No_1642_The_farthest_building_that_can_be_reached {
    @Test
    public void test() {
        int[] heights = new int[]{4, 2, 7, 6, 9, 14, 12};
        int bricks = 5;
        int ladders = 1;

        heights = new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19};
        bricks = 10;
        ladders = 2;

        heights = new int[]{14, 3, 19, 3};
        bricks = 17;
        ladders = 0;

        int furthestBuilding = furthestBuilding(heights, bricks, ladders);
        System.out.println(furthestBuilding);
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // 小跟堆. 将所有的需要用砖块或者梯子的差值放入到小跟堆中
        PriorityQueue<Integer> queues = new PriorityQueue<>();

        int N = heights.length;
        for (int i = 1; i < N; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                queues.add(diff);

                // 当小跟堆中的size 大小超过梯子的大小。需要使用砖块, 此时从小跟堆中弹出最小高度差的值进行砖块的扣除
                if (queues.size() > ladders) {
                    bricks -= queues.poll();
                }

                if (bricks < 0) {
                    return i - 1;
                }
            }
        }

        return N - 1;
    }
}
