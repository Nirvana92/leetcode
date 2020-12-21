package leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Nirvana
 * @date 2020/10/18 21:19
 */
public class No_1423_Maximum_points_available {
    @Test
    public void test() {
        int[] cardPoints = new int[]{1, 2, 3, 4, 5, 6, 1};
        int k = 3;

//        cardPoints = new int[]{9, 7, 7, 9, 7, 7, 9};
//        k = 7;

//        cardPoints = new int[]{1, 1000, 1};
//        k = 1;

//        cardPoints = new int[]{1, 79, 80, 1, 1, 1, 200, 1};
//        k = 3;

//        cardPoints = new int[]{1, 156, 456, 15, 231, 4};
//        k = 3;

        int maxScore = maxScore(cardPoints, k);
        System.out.println(maxScore);

        int processDp = processDp(cardPoints, k);
        System.out.println(processDp);

        int processWindow = processWindow(cardPoints, k);
        System.out.println(processWindow);
    }

    /**
     * 滑动窗口求解方法
     *
     * @param cardPoints
     * @param k
     * @return
     */
    int processWindow(int[] cardPoints, int k) {
        // 维持一个 len -k 的窗口, 求最小值
        int N = cardPoints.length;
        if (N == 0 || k == 0) {
            return 0;
        }
        // 返回数组之和
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += cardPoints[i];
        }

        if (k >= N) {
            return sum;
        }

        // 使用窗口
        int windowMinVal = Integer.MAX_VALUE, windowLen = N - k, tmpWindowMinVal = 0;
        LinkedList<Integer> windowQueues = new LinkedList<>();

        for (int r = 0; r < N; r++) {
            if (windowQueues.size() < windowLen - 1) {
                windowQueues.addLast(r);
                tmpWindowMinVal += cardPoints[r];
            } else {
                // 刚好等于窗口大小
                windowQueues.addLast(r);
                tmpWindowMinVal += cardPoints[r];
                windowMinVal = Math.min(windowMinVal, tmpWindowMinVal);

                // 移除前面一个
                Integer removeNumIndex = windowQueues.pollFirst();
                tmpWindowMinVal -= cardPoints[removeNumIndex];
            }
        }

        return sum - windowMinVal;
    }

    /**
     * 这道题减了一阶的内存使用, 最后还是提示超出时间限制, 数据量太大
     *
     * @param cardPoints
     * @param k
     * @return
     */
    int processDp(int[] cardPoints, int k) {
        int N = cardPoints.length;
        if (N == 0 || k == 0) {
            return 0;
        }
        if (k >= N) {
            // 返回数组之和
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += cardPoints[i];
            }
            return sum;
        }

        int[][] preDp = new int[N][N];
        // 求 l == r 时候的值
        for (int i = 0; i < N; i++) {
            preDp[i][i] = cardPoints[i];
        }

        // 初始化只拿1 次的时候的最大值
        for (int lNum = 0; lNum < N; lNum++) {
            for (int rNum = lNum + 1; rNum < N; rNum++) {
                preDp[lNum][rNum] = Math.max(cardPoints[lNum], cardPoints[rNum]);
            }
        }

        int[][] curDp = new int[N][N];
        //curDp = preDp;
        for (int kNum = 2; kNum <= k; kNum++) {
            for (int lNum = N - 1; lNum >= 0; lNum--) {
                for (int rNum = lNum + 1; rNum < N; rNum++) {
                    // 先拿左边
                    int maxVal = Math.max(preDp[lNum + 1][rNum] + cardPoints[lNum], preDp[lNum][rNum - 1] + cardPoints[rNum]);
                    curDp[lNum][rNum] = maxVal;
                }
            }

            int[][] tmpDp = preDp;
            preDp = curDp;
            curDp = tmpDp;
        }

        return preDp[0][N - 1];
    }

    public int maxScore(int[] cardPoints, int k) {
        if (k >= cardPoints.length) {
            // 返回数组之和
            int sum = 0;
            for (int i = 0; i < cardPoints.length; i++) {
                sum += cardPoints[i];
            }
            return sum;
        }

        return process(cardPoints, k, 0, cardPoints.length - 1);
    }

    int process(int[] cardPoints, int k, int l, int r) {
        if (k == 0) {
            return 0;
        }

        // 先拿左边
        int leftRst = process(cardPoints, k - 1, l + 1, r) + cardPoints[l];
        // 再拿右边
        int rightRst = process(cardPoints, k - 1, l, r - 1) + cardPoints[r];

        return Math.max(leftRst, rightRst);
    }
}
