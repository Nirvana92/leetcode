package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2021/2/24 8:57 上午
 * @desc: 832. 翻转图像
 */
public class No_832_Flip_image {
    @Test
    public void test() {
        int[][] nums = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        nums = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};

        int[][] flipAndInvertImage = flipAndInvertImage(nums);
        PrintUtils.print(flipAndInvertImage);
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int rowLen = A.length;
        int colLen = A[0].length;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col <= (colLen - 1) / 2; col++) {
                // 在进行row 行操作的时候直接操作第一个和最后一个, 一次处理两个然后取反
                int firstNumCol = col;
                int secondNumCol = colLen - col - 1;

                int firstNum = A[row][firstNumCol];
                int secondNum = A[row][secondNumCol];

                A[row][firstNumCol] = secondNum ^ 1;
                A[row][secondNumCol] = firstNum ^ 1;
            }
        }

        return A;
    }
}
