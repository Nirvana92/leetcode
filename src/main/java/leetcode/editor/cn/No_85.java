package leetcode.editor.cn;

import org.junit.Test;

public class No_85 {

    @Test
    public void test() {
        char[][] matrix = new char[][]{
                {'1'}
        };
        int maximalRectangle = maximalRectangle(matrix);
        System.out.println(maximalRectangle);
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        // 表示 row, col 位置往右最长连续为1 的长度
        int[][] maxLenRecords = new int[row][col];
        for (int rowIndex = row - 1; rowIndex >= 0; rowIndex--) {
            if (matrix[rowIndex][col - 1] == '1') {
                maxLenRecords[rowIndex][col - 1] = 1;
            }
        }

        for (int rowIndex = row - 1; rowIndex >= 0; rowIndex--) {
            for (int colIndex = col - 2; colIndex >= 0; colIndex--) {
                if (matrix[rowIndex][colIndex] == '1') {
                    maxLenRecords[rowIndex][colIndex] = 1 + maxLenRecords[rowIndex][colIndex + 1];
                }
            }
        }

        // 遍历每个位置, 看是否能找到最大的矩形, 求最大矩形面积
        int maxRectangularArea = 0;
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            for (int colIndex = 0; colIndex < col; colIndex++) {

                int minLen = maxLenRecords[rowIndex][colIndex];
                int rowLen = 0;
                while ((rowIndex + rowLen) < row && maxLenRecords[rowIndex + rowLen][colIndex] >= 1) {
                    maxRectangularArea = Math.max(minLen * (rowLen + 1), maxRectangularArea);
                    rowLen++;
                    if (rowIndex + rowLen < row) {
                        minLen = Math.min(minLen, maxLenRecords[rowIndex + rowLen][colIndex]);
                    }
                }
            }
        }

        return maxRectangularArea;
    }
}
