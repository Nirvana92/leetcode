package leetcode.editor.cn;

/**
 * @author gzm
 * @date 2020/10/28 4:17 下午
 * @desc: 剑指 Offer 13. 机器人的运动范围
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 */
public class Offer_13_Robots_range_of_motion {


    /**
     * 遍历就好了
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {


//        for (int row = 0; row < m; row++) {
//            for (int col = 0; col < n; col++) {
//
//            }
//        }

        return 1;
    }

    int getRowAndColSum(int row, int col) {
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row /= 10;
        }

        while (col > 0) {
            sum += col % 10;
            col /= 10;
        }

        return sum;
    }
}
