package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/18 10:59
 */
public class No_813_Grouping_of_maximum_mean_sum {
    @Test
    public void test() {
        int[] A = new int[]{9, 1, 2, 3, 9, 10};
        int K = 3;

        A = new int[]{1};

        double largestSumOfAverages = largestSumOfAverages(A, K);
        System.out.println(largestSumOfAverages);

        double processDp = processDp(A, K);
        System.out.println(processDp);
    }

    public double largestSumOfAverages(int[] A, int K) {
        return process(A, 0, K);
    }

    double processDp(int[] A, int K) {
        int N = A.length;
        if (N == 0) {
            return 0;
        }
        double[][] dp = new double[N][K + 1];

        double preSumVal = 0;
        for (int i = N - 1; i >= 0; i--) {
            preSumVal += A[i];

            dp[i][1] = preSumVal / (A.length - i);
        }

        if (K >= N) {
            return preSumVal;
        }

        // todo: 还可以进行斜率优化
        for (int k = 2; k <= K; k++) {
            // k=2 的时候, 0 ~ endIndex
            // 遍历当前节点得到开始位置
            for (int startIndex = N - k; startIndex >= 0; startIndex--) {

                dp[startIndex][k] = A[startIndex] + dp[startIndex + 1][k - 1];
                double tmpSumVal = A[startIndex];
                // 然后依次遍历 startIndex 节点到 N-k 位置的最大值填充
                for (int i = startIndex + 1; i <= N - k; i++) {
                    tmpSumVal += A[i];

                    dp[startIndex][k] = Math.max(dp[startIndex][k], tmpSumVal / (i - startIndex + 1) + dp[i + 1][k - 1]);
                }
            }

        }

        return dp[0][K];
    }

    double process(int[] A, int i, int K) {
        if (K == 1) {
            double sumVal = 0;
            for (int startIndex = i; startIndex < A.length; startIndex++) {
                sumVal += A[startIndex];
            }

            return sumVal / (A.length - i);
        }

        double maxVal = 0;

        double preValSum = 0;
        for (int startIndex = i; startIndex <= A.length - K; startIndex++) {
            preValSum += A[startIndex];

            double nextVal = process(A, startIndex + 1, K - 1);
            double curVal = preValSum / (startIndex - i + 1);
            maxVal = Math.max(nextVal + curVal, maxVal);
        }

        return maxVal;
    }
}

