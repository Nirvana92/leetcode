package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2020/11/17 9:47 上午
 * @desc: 1030. 距离顺序排列矩阵单元格
 */
public class No_1030_Arrange_matrix_cells_in_distance_order {
    @Test
    public void test() {
        int R = 1, C = 2, r0 = 0, c0 = 0;

        R = 2;
        C = 2;
        r0 = 0;
        c0 = 1;

        R = 2;
        C = 3;
        r0 = 1;
        c0 = 2;

        int[][] ints = allCellsDistOrder(R, C, r0, c0);
        PrintUtils.print(ints);
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] rets = new int[R * C][2];

        int curIndex = 0;

        PriorityQueue<int[]> queues = new PriorityQueue<>((i1, i2) -> (Math.abs(i1[0] - r0) + Math.abs(i1[1] - c0))
                - (Math.abs(i2[0] - r0) + Math.abs(i2[1] - c0)));
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                queues.add(new int[]{row, col});
            }
        }

        while (!queues.isEmpty()) {
            rets[curIndex++] = queues.poll();
        }

        return rets;
    }
}
