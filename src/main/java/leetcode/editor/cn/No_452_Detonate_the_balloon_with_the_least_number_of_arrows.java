package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2020/11/23 9:49 上午
 * @desc: 452. 用最少数量的箭引爆气球
 */
public class No_452_Detonate_the_balloon_with_the_least_number_of_arrows {
    @Test
    public void test() {
        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        // points = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        points = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        // points = new int[][]{{1, 2}};
        // points = new int[][]{{2, 3}, {2, 3}};
        // points = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};

        int minArrowShots = findMinArrowShots(points);
        System.out.println(minArrowShots);
        int minArrowShotsOpt = findMinArrowShotsOpt(points);
        System.out.println(minArrowShotsOpt);
    }

    public int findMinArrowShotsOpt(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        Arrays.sort(points, (p1, p2) -> p1[1] < p2[1] ? -1 : 1);

        int ret = 1;
        int pre = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pre) {
                ret++;
                pre = points[i][1];
            }
        }

        return ret;
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p1[1] > p2[1] ? 1 : (p1[1] == p2[1] ? 0 : -1);
            } else {
                return p1[0] > p2[0] ? 1 : (p1[0] == p2[0] ? 0 : -1);
            }
        });

        PriorityQueue<int[]> queues = new PriorityQueue<>((i1, i2) -> i2[0] - i1[0]);
        for (int i = 0; i < points.length; i++) {
            if (!queues.isEmpty() && (queues.peek()[1] >= points[i][0])) {
                int[] pollInfo = queues.poll();
                pollInfo[0] = Math.max(pollInfo[0], points[i][0]);
                pollInfo[1] = Math.min(pollInfo[1], points[i][1]);

                queues.add(pollInfo);
            } else {
                queues.add(points[i]);
            }
        }

        return queues.size();
    }
}
