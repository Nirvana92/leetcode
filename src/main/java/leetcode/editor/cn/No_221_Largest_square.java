package leetcode.editor.cn;

/**
 * 力扣 221 题: 求最大正方形
 */
public class No_221_Largest_square {
    public static void main(String[] args) {
        No_221_Largest_square no_221 = new No_221_Largest_square();

        char[][] matrix = new char[][]{
                {'0', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}};

        matrix = new char[][]{{'1'}};
        int area = no_221.maximalSquare(matrix);
        System.out.println("最大的正方形面积: " + area);
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        // 预处理数组
        // 1. row[row][col]: 表示row行到结尾最长的连续为1 的长度
        int[][] rows = new int[rowLen][colLen];

        for (int row = 0; row < rowLen; row++) {
            for (int col = colLen - 1; col >= 0; col--) {
                if (matrix[row][col] == '0') {
                    rows[row][col] = 0;
                } else {
                    rows[row][col] = 1 + (col + 1 < colLen ? rows[row][col + 1] : 0);
                }
            }
        }

        // 2. col[row][col]: 表示col列到结尾最长的连续为1 的长度
        int[][] cols = new int[rowLen][colLen];
        for (int col = 0; col < colLen; col++) {
            for (int row = rowLen - 1; row >= 0; row--) {
                if (matrix[row][col] == '0') {
                    cols[row][col] = 0;
                } else {
                    cols[row][col] = 1 + (row + 1 < rowLen ? cols[row + 1][col] : 0);
                }
            }
        }

        int maxSideLen = 0;
        int[][] square = new int[rowLen + 1][colLen + 1];
        // square[row][col]: 表示已row, col 为左上角点, 可以组成的最大以1 为正方形的边长
        // 从下往上遍历, 从右往左遍历二维数组判断是否有满足条件的结果
        for (int row = rowLen - 1; row >= 0; row--) {
            for (int col = colLen - 1; col >= 0; col--) {
                if (matrix[row][col] == '0') {
                    square[row][col] = 0;
                } else {
                    // 行都为1 能到的最大长度
                    int maxRow = rows[row][col];
                    // 列都为1 能到的最大长度
                    int maxCol = cols[row][col];

                    // 根据长宽最大能到达的最大的边长
                    int sideLen = Math.min(maxRow, maxCol);
                    sideLen = Math.min(sideLen, square[row + 1][col + 1] + 1);

                    square[row][col] = sideLen;
                    maxSideLen = Math.max(maxSideLen, sideLen);
                }
            }
        }

        //System.out.println("===maxSideLen: "+maxSideLen);
        return maxSideLen * maxSideLen;
    }
}
