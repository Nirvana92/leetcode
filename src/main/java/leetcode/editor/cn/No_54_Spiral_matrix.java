package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class No_54_Spiral_matrix {
    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        List<Integer> integers = spiralOrder(matrix);
        System.out.println(integers);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if (matrix.length == 0) {
            return results;
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int startRow = 0, startCol = 0;
        int endRow = rowLen - 1, endCol = colLen - 1;

        while (startRow <= endRow && startCol <= endCol) {
            process(matrix, startRow, startCol, endRow, endCol, results);

            startRow += 1;
            startCol += 1;
            endRow -= 1;
            endCol -= 1;
        }

        return results;
    }


    void process(int[][] matrix, int startRow, int startCol, int endRow, int endCol, List<Integer> results) {

        // 打印外圈的最上面一层
        for (int col = startCol; col <= endCol; col++) {
            results.add(matrix[startRow][col]);
        }

        // 打印外圈的最右边一层
        for (int row = startRow + 1; row <= endRow; row++) {
            results.add(matrix[row][endCol]);
        }

        // 打印外圈的最下面一层
        // 打印下面一层需要保证下面一层和上面一层不在同一层
        for (int col = endCol - 1; col >= startCol && startRow != endRow; col--) {
            results.add(matrix[endRow][col]);
        }

        // 打印外圈的最左边一层
        for (int row = endRow - 1; row > startRow && startCol != endCol; row--) {
            results.add(matrix[row][startCol]);
        }
    }
}
