package leetcode.editor.cn;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2020/11/10 5:55 下午
 * @desc: 1631. 最小体力消耗路径
 */
public class No_1631_Path_of_minimum_physical_exertion {
    @Test
    public void test() {
        int[][] heights = new int[][]{
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

//        heights = new int[][]{
//                {1, 2, 3},
//                {3, 8, 4},
//                {5, 3, 5}
//        };

//        heights = new int[][]{
//                {1, 2, 1, 1, 1},
//                {1, 2, 1, 2, 1},
//                {1, 2, 1, 2, 1},
//                {1, 2, 1, 2, 1},
//                {1, 1, 1, 2, 1}
//        };

        int minimumEffortPath = minimumEffortPath(heights);
        System.out.println(minimumEffortPath);
    }

    /**
     * 改版的 Dijkstra 方法
     *
     * @param heights
     * @return
     */
    public int minimumEffortPath(int[][] heights) {
        int rowLen = heights.length;
        int colLen = heights[0].length;

        boolean[][] seen = new boolean[rowLen][colLen];
        int[][] diss = new int[rowLen][colLen];
        PriorityQueue<int[]> queues = new PriorityQueue<>((h1, h2) -> h1[2] - h2[2]);
        queues.add(new int[]{0, 0, 0});

        while (!queues.isEmpty()) {
            int[] info = queues.poll();
            int row = info[0];
            int col = info[1];
            int dis = info[2];

            if (seen[row][col]) {
                continue;
            }
            seen[row][col] = true;
            diss[row][col] = dis;

            if (row - 1 >= 0 && !seen[row - 1][col]) {
                queues.add(new int[]{row - 1, col, Math.max(dis, Math.abs(heights[row][col] - heights[row - 1][col]))});
            }

            if (row + 1 < rowLen && !seen[row + 1][col]) {
                queues.add(new int[]{row + 1, col, Math.max(dis, Math.abs(heights[row][col] - heights[row + 1][col]))});
            }

            if (col - 1 >= 0 && !seen[row][col - 1]) {
                queues.add(new int[]{row, col - 1, Math.max(dis, Math.abs(heights[row][col] - heights[row][col - 1]))});
            }

            if (col + 1 < colLen && !seen[row][col + 1]) {
                queues.add(new int[]{row, col + 1, Math.max(dis, Math.abs(heights[row][col] - heights[row][col + 1]))});
            }
        }

        return diss[rowLen - 1][colLen - 1];
    }

    /**
     * 超出时间限制: 未通过
     *
     * @param heights
     * @return
     */
    public int minimumEffortPathBaoli(int[][] heights) {
        heights[0][0] = -heights[0][0];
        return process(heights, 0, 0);
    }

    int process(int[][] heights, int r, int l) {
        int row = heights.length;
        int col = heights[0].length;

        if (l == col - 1 && r == row - 1) {
            return 0;
        }

        int power = Integer.MAX_VALUE;
        if (r - 1 >= 0 && heights[r - 1][l] > 0) {
            int curPower = Math.abs(heights[r][l] + heights[r - 1][l]);
            heights[r - 1][l] = -heights[r - 1][l];
            int nextMinPower = process(heights, r - 1, l);
            curPower = Math.max(curPower, nextMinPower);

            power = Math.min(power, curPower);

            heights[r - 1][l] = -heights[r - 1][l];
        }

        if (r + 1 < row && heights[r + 1][l] > 0) {
            int curPower = Math.abs(heights[r][l] + heights[r + 1][l]);
            heights[r + 1][l] = -heights[r + 1][l];
            int nextMinPower = process(heights, r + 1, l);
            curPower = Math.max(curPower, nextMinPower);
            power = Math.min(power, curPower);
            heights[r + 1][l] = -heights[r + 1][l];
        }

        if (l - 1 >= 0 && heights[r][l - 1] > 0) {
            int curPower = Math.abs(heights[r][l] + heights[r][l - 1]);
            heights[r][l - 1] = -heights[r][l - 1];
            int nextMinPower = process(heights, r, l - 1);
            curPower = Math.max(curPower, nextMinPower);
            power = Math.min(power, curPower);
            heights[r][l - 1] = -heights[r][l - 1];
        }

        if (l + 1 < col && heights[r][l + 1] > 0) {
            int curPower = Math.abs(heights[r][l] + heights[r][l + 1]);
            heights[r][l + 1] = -heights[r][l + 1];
            int nextMinPower = process(heights, r, l + 1);
            curPower = Math.max(curPower, nextMinPower);
            power = Math.min(power, curPower);
            heights[r][l + 1] = -heights[r][l + 1];
        }

        return power;
    }
}
