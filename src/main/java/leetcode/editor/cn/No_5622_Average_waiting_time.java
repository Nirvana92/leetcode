package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/28 9:34 上午
 * @desc: 5622. 平均等待时间
 * <p>
 * 依次计算每次的等待时间, 然后求取平均值
 */
public class No_5622_Average_waiting_time {
    @Test
    public void test() {
        int[][] customers = new int[][]{{1, 2}, {2, 5}, {4, 3}};

        customers = new int[][]{{5, 2}, {5, 4}, {10, 3}, {20, 1}};

        double averageWaitingTime = averageWaitingTime(customers);
        System.out.println(averageWaitingTime);
    }

    public double averageWaitingTime(int[][] customers) {
        int countOfCustomer = customers.length;

        double totalWaitTime = 0;
        // 最开始的时间点
        int curTime = -1;

        for (int i = 0; i < countOfCustomer; i++) {
            if (curTime < customers[i][0]) {
                curTime = customers[i][0];
            }

            totalWaitTime += curTime + customers[i][1] - customers[i][0];

            curTime = curTime + customers[i][1];
        }

        return totalWaitTime / countOfCustomer;
    }
}
