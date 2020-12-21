package leetcode.editor.cn;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2020/10/28 10:01 上午
 * @desc: 407. 接雨水 II
 * <p>
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 */
public class No_407_Rainwater_II {
    @Test
    public void test() {
        int[][] heightMap = new int[][]{
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };
        int trapRainWater = trapRainWater(heightMap);
        System.out.println(trapRainWater);
    }

    /**
     * 创建一个小跟堆, 然后将二维数组的周边数据放入小跟堆, 然后依次从小到大弹出数据, 弹出的时候计算周边的雨水量
     *
     * @param heightMap
     * @return
     */
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }

        int rowLen = heightMap.length;
        int colLen = heightMap[0].length;

        boolean[][] seen = new boolean[rowLen][colLen];
        PriorityQueue<Info> queues = new PriorityQueue<>(new MinCom());

        // 将二维数组的周边数据放入到小跟堆中
        for (int row = 0; row < rowLen; row++) {
            seen[row][0] = true;
            seen[row][colLen - 1] = true;
            queues.add(new Info(row, 0, heightMap[row][0]));
            queues.add(new Info(row, colLen - 1, heightMap[row][colLen - 1]));
        }

        for (int col = 1; col < colLen - 1; col++) {
            seen[0][col] = true;
            seen[rowLen - 1][col] = true;
            queues.add(new Info(0, col, heightMap[0][col]));
            queues.add(new Info(rowLen - 1, col, heightMap[rowLen - 1][col]));
        }

        int waterNums = 0;
        while (!queues.isEmpty()) {
            // 弹出的最小高度的值
            Info info = queues.poll();

            // 找四周的没有看过的高度, 然后顺便计算下可以装水量
            // 上
            if (info.row - 1 >= 0 && !seen[info.row - 1][info.col]) {
                int curRow = info.row - 1, curCol = info.col;

                seen[curRow][curCol] = true;

                int height = heightMap[curRow][curCol];
                if (height < info.height) {
                    waterNums += info.height - height;
                    height = info.height;
                }

                queues.add(new Info(info.row - 1, info.col, height));
            }

            // 下
            if (info.row + 1 < rowLen && !seen[info.row + 1][info.col]) {
                int curRow = info.row + 1, curCol = info.col;
                seen[curRow][curCol] = true;

                int height = heightMap[curRow][curCol];
                if (height < info.height) {
                    waterNums += info.height - height;
                    height = info.height;
                }

                queues.add(new Info(info.row + 1, info.col, height));
            }

            // 左
            if (info.col - 1 >= 0 && !seen[info.row][info.col - 1]) {
                int curRow = info.row, curCol = info.col - 1;
                seen[curRow][curCol] = true;

                int height = heightMap[curRow][curCol];
                if (height < info.height) {
                    waterNums += info.height - height;
                    height = info.height;
                }

                queues.add(new Info(info.row, info.col - 1, height));
            }

            // 右
            if (info.col + 1 < colLen && !seen[info.row][info.col + 1]) {
                int curRow = info.row, curCol = info.col + 1;
                seen[curRow][curCol] = true;

                int height = heightMap[curRow][curCol];
                if (height < info.height) {
                    waterNums += info.height - height;
                    height = info.height;
                }

                queues.add(new Info(info.row, info.col + 1, height));
            }
        }

        return waterNums;
    }

    class Info {
        int row;
        int col;
        int height;

        public Info(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    class MinCom implements Comparator<Info> {
        @Override
        public int compare(Info o1, Info o2) {
            return o1.height - o2.height;
        }
    }

    @Test
    public void testQueue() {
        PriorityQueue<Info> queues = new PriorityQueue<>(new MinCom());
        queues.add(new Info(0, 0, 10));
        queues.add(new Info(0, 0, 1));

        Info poll = queues.poll();
        System.out.println(poll.height);
    }
}
