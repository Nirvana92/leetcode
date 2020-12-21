package leetcode.editor.cn;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2020/10/22 8:27 下午
 * @desc: 1289. 下降路径最小和  II
 * <p>
 * 给你一个整数方阵 arr ，定义「非零偏移下降路径」为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 * 请你返回非零偏移下降路径数字和的最小值。
 */
public class No_1289_Minimum_descent_path_sum_II {
    @Test
    public void test() {
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int minFallingPathSum = minFallingPathSum(arr);
        System.out.println(minFallingPathSum);

        int minFallingPathSumDp = minFallingPathSumDp(arr);
        System.out.println(minFallingPathSumDp);
    }

    /**
     * 貌似这个也处理不了重复值的问题
     *
     * @param arr
     * @return
     */
    int minFallingPathSumDp(int[][] arr) {
        if (arr.length == 0 || arr[0].length == 0) {
            return 0;
        }
        int rowLen = arr.length;
        int colLen = arr[0].length;
        // int[][] dp = new int[rowLen][colLen];
        int first = Integer.MAX_VALUE, firstPosition = 0, second = Integer.MIN_VALUE;
        for (int col = colLen - 1; col >= 0; col--) {
            // dp[rowLen - 1][col] = arr[rowLen - 1][col];
            if (first > arr[rowLen - 1][col]) {
                second = first;
                first = arr[rowLen - 1][col];
                firstPosition = col;
            } else if (arr[rowLen - 1][col] < second) {
                second = arr[rowLen - 1][col];
            }
        }

        for (int row = rowLen - 2; row >= 0; row--) {
            int tmpFirst = Integer.MAX_VALUE, tmpFirstP = -1, tmpSecond = 0;
            for (int col = 0; col < colLen; col++) {
                // dp[row][col] = (col == firstPosition ? second : first) + arr[row][col];
                int curNum = (col == firstPosition ? second : first) + arr[row][col];
                if (tmpFirst > curNum) {
                    tmpSecond = tmpFirst;
                    tmpFirstP = col;
                    tmpFirst = curNum;
                } else if (curNum < tmpSecond) {
                    tmpSecond = curNum;
                }
            }

            first = tmpFirst;
            second = tmpSecond;
            firstPosition = tmpFirstP;
        }

        return first;
    }


    /**
     * 改用堆的处理方法, 但是不能处理重复值的问题
     *
     * @param arr
     * @return
     */
    int minFallingPathSumHeap(int[][] arr) {
        if (arr.length == 0 || arr[0].length == 0) {
            return 0;
        }
        int rowLen = arr.length;
        int colLen = arr[0].length;
        PriorityQueue<Info> queues = new PriorityQueue<>(new MaxCom());
        for (int col = colLen - 1; col >= 0; col--) {
            queues.add(new Info(col, arr[rowLen - 1][col]));
            if (queues.size() > 2) {
                queues.poll();
            }
        }

        PriorityQueue<Info> tmpQueues = null;
        PriorityQueue<Info> nextQueues = new PriorityQueue<>(new MaxCom());
        for (int row = rowLen - 2; row >= 0; row--) {
            for (int col = 0; col < colLen; col++) {
                Info pollInfo = queues.poll();
                nextQueues.add(new Info(col, pollInfo.index == col ? (arr[row][col] + queues.peek().val) : (arr[row][col] + pollInfo.val)));
                if (nextQueues.size() > 2) {
                    nextQueues.poll();
                }
                queues.add(pollInfo);
            }

            tmpQueues = queues;
            queues = nextQueues;
            nextQueues = tmpQueues;
            nextQueues.clear();
        }

        queues.poll();
        return queues.peek().val;
    }

    class MaxCom implements Comparator<Info> {
        @Override
        public int compare(Info o1, Info o2) {
            return o2.val - o1.val;
        }
    }

    class Info {
        int index;
        int val;

        public Info(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public int minFallingPathSum(int[][] arr) {
        int colLen = arr[0].length;

        Integer minPathSum = null;
        for (int colIndex = 0; colIndex < colLen; colIndex++) {
            if (minPathSum == null) {
                minPathSum = process(arr, 0, colIndex);
            } else {
                minPathSum = Math.min(minPathSum, process(arr, 0, colIndex));
            }
        }

        return minPathSum;
    }

    int process(int[][] arr, int row, int col) {
        int rowLen = arr.length;
        int colLen = arr[0].length;
        if (row == rowLen - 1) {
            return arr[row][col];
        }

        Integer minPathSum = null;
        for (int colIndex = 0; colIndex < colLen; colIndex++) {
            if (colIndex != col) {
                if (minPathSum == null) {
                    minPathSum = process(arr, row + 1, colIndex);
                } else {
                    minPathSum = Math.min(minPathSum, process(arr, row + 1, colIndex));
                }
            }
        }

        return minPathSum + arr[row][col];
    }
}
