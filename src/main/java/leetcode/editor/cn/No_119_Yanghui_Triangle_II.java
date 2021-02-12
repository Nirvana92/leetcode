package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nirvana
 * @date 2021/2/12 18:48
 * 119. 杨辉三角 II
 * <p>
 * 通过dp的方法以及空间压缩的方法进行空间压缩的处理方式
 */
public class No_119_Yanghui_Triangle_II {
    @Test
    public void test() {
        int rowIndex = 3;
        rowIndex = 5;

        List<Integer> row = getRow(rowIndex);
        System.out.println(row);

        List<Integer> rowDp = getRowDp(rowIndex);
        System.out.println(rowDp);
    }

    public List<Integer> getRowDp(int rowIndex) {
        int[] dp = new int[rowIndex + 1];

        for (int row = 0; row <= rowIndex; row++) {
            for (int col = row; col >= 0; col--) {
                if (row == 0 || col == 0 || row == col) {
                    dp[col] = 1;
                } else {
                    dp[col] = dp[col - 1] + dp[col];
                }
            }
        }

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < dp.length; i++) {
            results.add(dp[i]);
        }
        return results;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> results = new ArrayList<>();

        for (int col = 0; col <= rowIndex; col++) {
            results.add(process(rowIndex, col));
        }

        return results;
    }

    int process(int rowIndex, int colIndex) {
        if (rowIndex == 0 || rowIndex == colIndex || colIndex == 0) {
            return 1;
        }

        return process(rowIndex - 1, colIndex - 1) + process(rowIndex - 1, colIndex);
    }
}
