package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

/**
 * @author gzm
 * @date 2020/11/3 7:52 下午
 * @desc: 1162. 地图分析
 * <p>
 * bfs
 */
public class No_1162_Map_analysis {
    @Test
    public void test() {
        int[][] grid = new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        grid = new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int maxDistance = maxDistance(grid);
        System.out.println(maxDistance);
    }

    public int maxDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int rowLen = grid.length;
        int colLen = grid[0].length;

        List<ChartNode> chartNodes = new ArrayList<>();

        ChartNode[][] nodes = new ChartNode[rowLen][colLen];
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                nodes[row][col] = new ChartNode(row, col, grid[row][col]);
            }
        }

        Set<ChartNode> sets = new HashSet<>();
        Queue<ChartNode> queues = new LinkedList<>();
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                ChartNode chartNode = nodes[row][col];
                if (row - 1 >= 0) {
                    chartNode.nexts.add(nodes[row - 1][col]);
                }
                if (col - 1 >= 0) {
                    chartNode.nexts.add(nodes[row][col - 1]);
                }
                if (row + 1 < rowLen) {
                    chartNode.nexts.add(nodes[row + 1][col]);
                }
                if (col + 1 < colLen) {
                    chartNode.nexts.add(nodes[row][col + 1]);
                }
                chartNodes.add(chartNode);

                if (chartNode.value == 1) {
                    queues.add(chartNode);
                    sets.add(chartNode);
                }
            }
        }

        if (queues.size() == rowLen * colLen || queues.size() == 0) {
            return -1;
        }

        int dis = 0;
        while (!queues.isEmpty()) {
            dis++;
            int size = queues.size();
            for (int i = 0; i < size; i++) {
                ChartNode node = queues.poll();
                for (ChartNode nextNode : node.nexts) {
                    if (!sets.contains(nextNode)) {
                        queues.add(nextNode);
                        sets.add(nextNode);
                    }
                }
            }
        }

        return dis == 0 ? -1 : dis - 1;
    }

    class ChartNode {
        // 点的编号, 可以是int也可以是string
        public int value;
        public int row;
        public int col;
        // 出度的点集合
        public List<ChartNode> nexts;

        public ChartNode(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
            nexts = new ArrayList<>();
        }
    }
}
