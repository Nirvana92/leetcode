package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/16 3:15 下午
 * @desc: 1672. 最富有客户的资产总量
 * <p>
 * 有点枯燥, 就是求每行和的最大值
 */
public class No_1672_Total_assets_of_the_richest_customers {
    @Test
    public void test() {
        int[][] accounts = new int[][]{{1, 2, 3}, {3, 2, 1}};
        accounts = new int[][]{{1, 5}, {7, 3}, {3, 5}};
        accounts = new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};

        int maximumWealth = maximumWealth(accounts);
        System.out.println(maximumWealth);
    }

    public int maximumWealth(int[][] accounts) {
        int rowLen = accounts.length;
        int colLen = accounts[0].length;

        int maxRet = 0;
        int perTotals = 0;
        for (int row = 0; row < rowLen; row++) {
            perTotals = 0;

            for (int col = 0; col < colLen; col++) {
                perTotals += accounts[row][col];
            }

            maxRet = Math.max(maxRet, perTotals);
        }

        return maxRet;
    }
}
