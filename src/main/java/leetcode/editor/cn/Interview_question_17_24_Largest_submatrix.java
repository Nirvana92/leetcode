package leetcode.editor.cn;

import org.classic_interview_questions.traincamp._6._6_2;
import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/10/29 11:54 上午
 * @desc: 面试题 17.24. 最大子矩阵
 * <p>
 * 参考: {@link _6_2}: 该题与 {@link _6_2} 不同的地方在于需要返回开始点的坐标和结束点的坐标
 */
public class Interview_question_17_24_Largest_submatrix {
    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {-1, 0},
                {0, -1}
        };
        matrix = new int[][]{
                {9, -8, 1, 3, -2},
                {-3, 7, 6, -2, 4},
                {6, -4, -4, 8, -7}
        };

        int[] maxMatrix = getMaxMatrix(matrix);
        PrintUtils.print(maxMatrix);
    }

    public int[] getMaxMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1, -1};
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        // 最大的子矩阵的累加和
        int maxMatrix = Integer.MIN_VALUE;
        // 结果的左上角点, 右上角点
        int firstRow = -1, firstCol = -1, lastRow = -1, lastCol = -1;
        // 从 startRow 开始, 到 endRow 结束的矩阵中的最大子矩阵
        for (int startRow = 0; startRow < rowLen; startRow++) {
            int[] tmpArr = new int[colLen];
            int tmpMaxMatrix = Integer.MIN_VALUE, tmpFirstCol = 0, tmpLastCol = 0, preVal = 0, preCol = 0;

            for (int endRow = startRow; endRow < rowLen; endRow++) {
                for (int col = 0; col < colLen; col++) {
                    tmpArr[col] = tmpArr[col] + matrix[endRow][col];
                    if (col == 0) {
                        tmpMaxMatrix = tmpArr[col];
                        preVal = tmpArr[col];
                        preCol = 0;
                        tmpFirstCol = 0;
                        tmpLastCol = 0;
                    } else {
                        // int curMaxMatrix = Math.max(preVal + tmpArr[col], tmpArr[col]);
                        if (preVal + tmpArr[col] > tmpArr[col]) {
                            // tmpMaxMatrix = preVal + tmpArr[col];
                            preVal = preVal + tmpArr[col];

                            // 更新 tmpMaxMatrix tmpFirstCol tmpLastCol
                            if (preVal > tmpMaxMatrix) {
                                tmpMaxMatrix = preVal;
                                tmpFirstCol = preCol;
                                tmpLastCol = col;
                            }
                        } else {
                            // tmpArr[col] >= preVal + tmpArr[col]
                            // 更新preVal[前面连续的最大值] preCol, 连续最大值的最开始的col
                            preVal = tmpArr[col];
                            preCol = col;

                            // 更新 tmpMaxMatrix tmpFirstCol tmpLastCol
                            if (preVal > tmpMaxMatrix) {
                                tmpMaxMatrix = preVal;
                                tmpFirstCol = preCol;
                                tmpLastCol = col;
                            }
                        }
                    }
                }

                // 收集一下答案
                if (tmpMaxMatrix > maxMatrix) {
                    firstRow = startRow;
                    firstCol = tmpFirstCol;
                    lastRow = endRow;
                    lastCol = tmpLastCol;
                    maxMatrix = tmpMaxMatrix;
                }
            }
        }

        return new int[]{firstRow, firstCol, lastRow, lastCol};
    }
}
