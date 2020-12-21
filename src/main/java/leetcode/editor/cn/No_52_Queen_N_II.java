package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/10 3:17 下午
 * @desc: n皇后有几种摆法
 */
public class No_52_Queen_N_II {
    @Test
    public void test() {
        int n = 20;
        int totalNQueens = totalNQueens(n);
        System.out.println(totalNQueens);
    }

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        return process(n, new int[n + 1], 1);
    }

    int process(int n, int[] queens, int row) {
        if (row > n) {
            return 1;
        }

        int rst = 0;
        for (int col = 1; col <= n; col++) {
            if (!conflictWithPre(queens, row, col)) {
                // 跟之前的不冲突, 继续向下尝试下面行的情况
                queens[row] = col;
                rst += process(n, queens, row + 1);
                queens[row] = 0;
            }
        }

        return rst;
    }

    boolean conflictWithPre(int[] queens, int curRow, int curCol) {
        for (int i = 1; i < curRow; i++) {
            if (queens[i] == curCol || Math.abs(curRow - i) == Math.abs(curCol - queens[i])) {
                return true;
            }
        }

        return false;
    }
}
