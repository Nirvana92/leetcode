package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gzm
 * @date 2020/9/28 5:46 下午
 * @desc
 */
public class No_120_Triangle_minimum_path_sum {
    @Test
    public void test() {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(2);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<Integer> list3 = Arrays.asList(6, 5, 7);
        List<Integer> list4 = Arrays.asList(4, 1, 8, 3);

        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);

        int minimumTotal = minimumTotal(triangle);
        int i = minimumTotalDp(triangle);
        System.out.println(minimumTotal);
        System.out.println(i);
    }

    public int minimumTotalDp(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }

        int rowLen = triangle.size();
        int colLen = triangle.get(rowLen - 1).size();
        int[][] dp = new int[rowLen][colLen];

        for (int col = 0; col < colLen; col++) {
            dp[rowLen - 1][col] = triangle.get(rowLen - 1).get(col);
        }

        for (int row = rowLen - 2; row >= 0; row--) {
            int curColLen = triangle.get(row).size();

            for (int col = 0; col < curColLen; col++) {
                int curVal = triangle.get(row).get(col);
                dp[row][col] = Math.min(curVal + dp[row + 1][col], curVal + dp[row + 1][col + 1]);
            }
        }

        return dp[0][0];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        return process(triangle, 0, 0);
    }

    /**
     * 第row 层往下的最大最小路径和
     *
     * @param triangle
     * @param row
     * @param col
     * @return
     */
    int process(List<List<Integer>> triangle, int row, int col) {
        int rowLen = triangle.size();

        if (row == rowLen - 1) {
            return triangle.get(row).get(col);
        }

        // 下面不是最底一层
        int directlyBelowSum = triangle.get(row).get(col) + process(triangle, row + 1, col);
        int bottomRightSum = triangle.get(row).get(col) + process(triangle, row + 1, col + 1);

        return Math.min(directlyBelowSum, bottomRightSum);
    }
}
