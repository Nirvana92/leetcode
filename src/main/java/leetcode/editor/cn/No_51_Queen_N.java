package leetcode.editor.cn;

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 480 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// NQueens
public class No_51_Queen_N {
    @Test
    public void test() {
        int rst = numOfNQueens(4);
        System.out.println(rst);
        printInfo();
    }

    List<List<String>> printInfos = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        numOfNQueens(n);
        return printInfos;
    }

    /**
     * 皇后的多少种放置方法
     *
     * @param n
     * @return
     */
    int numOfNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        return process(n, new int[n + 1], 1);
    }

    /**
     * @param n:      总的皇后数[不包括0, 默认下表从1~n]
     * @param queens: 前row 行已经放置的皇后的位置
     * @param row:    当前需要摆放的皇后行
     */
    int process(int n, int[] queens, int row) {
        if (row > n) {
            // 填充printInfos 信息
            fillPrintInfos(n, queens);
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

    /**
     * 是否跟之前摆放的皇后冲突
     *
     * @param queens
     * @param curRow
     * @param curCol
     * @return
     */
    boolean conflictWithPre(int[] queens, int curRow, int curCol) {
        for (int i = 1; i < curRow; i++) {
            if (queens[i] == curCol || Math.abs(curRow - i) == Math.abs(curCol - queens[i])) {
                return true;
            }
        }

        return false;
    }

    /**
     * 填充n皇后解的地图信息
     *
     * @param n
     * @param queens
     */
    void fillPrintInfos(int n, int[] queens) {
        List<String> printInfo = new ArrayList<>();
        for (int row = 1; row <= n; row++) {
            StringBuffer rowBuffer = new StringBuffer();
            for (int col = 1; col <= n; col++) {
                if (queens[row] == col) {
                    rowBuffer.append("Q");
                } else {
                    rowBuffer.append(".");
                }
            }

            printInfo.add(rowBuffer.toString());
        }

        printInfos.add(printInfo);
    }

    void printInfo() {
        printInfos.forEach(printInfo -> {
            printInfo.forEach(System.out::println);
            System.out.println("------------------");
        });
    }
}