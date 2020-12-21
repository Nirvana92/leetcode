package leetcode.editor.cn;

import org.junit.Test;

import java.util.Random;

/**
 * rrryyyrryyyrr
 * <p>
 * 秋叶收藏集
 */
public class No_LCP_19_Autumn_leaves_collection_set {
    Random random = new Random();

    @Test
    public void test() {
        String leaves = "yrryyyyyyyryyryryryryryyry";
//        leaves = "ryr";
        // yryryryryryryr
        leaves = "yryryryr";
//        leaves = "yry";
//        leaves = "yyy";
//        leaves = "rrr";

        int minimumOperationsDp = minimumOperationsFinalMethodDp(leaves);
        System.out.println(minimumOperationsDp);
    }

    @Test
    public void t() {
        int times = 1000;
        while (times-- > 0) {
            int charLen = (int) (Math.random() * 10) + 3;
            StringBuffer buffer = new StringBuffer();
            while (charLen-- > 0) {
                int i = random.nextInt(2);
                buffer.append(i == 0 ? 'y' : 'r');
            }
            String leaves = buffer.toString();
            // int minimumOperations = minimumOperations(leaves);
            // int minimumOperationsDp = minimumOperationsDp(leaves);
            int processDp = minimumOperationsFinalMethodDp(leaves);
            int minimumOperationsDp = minimumOperationsDp(leaves);

            if (minimumOperationsDp != processDp) {
                System.out.println(leaves);
                System.out.println(minimumOperationsDp);
                System.out.println(processDp);
                System.out.println("-----------------------------------------");
            }
        }
    }

    /**
     * 通过dp的方式求解
     * <p>
     * int[i][j]: 标识 0..i 并且 i位置换成 j(0: r; 1: y; r: r) 的最小调整次数
     *
     * @param leaves
     * @return
     */
    int minimumOperationsFinalMethodDp(String leaves) {
        int N = leaves.length();
        int[][] dp = new int[N][3];

        dp[0][0] = leaves.charAt(0) == 'r' ? 0 : 1;
        dp[0][1] = dp[1][2] = Integer.MAX_VALUE;

        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + (leaves.charAt(i) == 'r' ? 0 : 1);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (leaves.charAt(i) == 'y' ? 0 : 1);
            if (i > 1) {
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + (leaves.charAt(i) == 'r' ? 0 : 1);
            }
        }

        return dp[N - 1][2];
    }

    /**
     * 最终方法
     *
     * @param leaves
     * @return
     */
    int minimumOperationsFinalMethod(String leaves) {
        int len = leaves.length();
        if (len < 3) {
            return 0;
        }

        /**
         * 0...i 为r, i...j 位置为y, j ...len 为r
         *
         * 第一部分: i - sum[i] ; 第二部分: sum[j]-sum[i] ; 第三部分: (len-j) - (sum[len]-sum[j])
         * 最小操作数为: len-sum[len] + i-2*sum[i] - (j-2*sum[j])
         */
        // sumR[i]: 0...i 位置上的总的r的个数
        int[] sumR = new int[len + 1];
        // min[i]: 0...i 位置上 i-2*sum[i] 最小值
        int[] min = new int[len + 1];

        int tmpMin = len;
        for (int i = 0; i < len; i++) {

            sumR[i] = (i > 0 ? sumR[i - 1] : 0) + (leaves.charAt(i) == 'r' ? 1 : 0);

            tmpMin = Math.min(tmpMin, i - 2 * sumR[i]);
            min[i] = tmpMin;
        }

        int minOperation = len;
        for (int i = 1; i < len - 1; i++) {
            minOperation = Math.min(minOperation, len - sumR[len - 1] + min[i - 1] - (i - 2 * sumR[i]));
        }

        return minOperation;
    }

    int minimumOperationsDp(String leaves) {
        char[] chars = leaves.toCharArray();

        int minOpera = 0;
        minOpera += chars[0] == 'r' ? 0 : 1;
        minOpera += chars[chars.length - 1] == 'r' ? 0 : 1;

        minOpera += process(chars, 1, chars.length - 2, 1, 1);

        return minOpera;
    }

    /**
     * @param chars
     * @param l
     * @param r
     * @param preLColor:  l 前面的一个字符的颜色: 1=r, 2=y
     * @param lastRColor: r 前面的一个字符的颜色: 1=r, 2=y
     * @return
     */
    int process(char[] chars, int l, int r, int preLColor, int lastRColor) {
        if (l == r) {
            return chars[l] == 'y' ? 0 : 1;
        }

        int minOpera = Integer.MAX_VALUE;
        if (preLColor == 1) {
            int lToR = (chars[l] == 'r' ? 0 : 1) + process(chars, l + 1, r, 1, lastRColor);
            minOpera = Math.min(minOpera, lToR);
        }
        int lToY = (chars[l] == 'r' ? 1 : 0) + process(chars, l + 1, r, 2, lastRColor);
        minOpera = Math.min(minOpera, lToY);

        if (lastRColor == 1) {
            int rToR = (chars[r] == 'r' ? 0 : 1) + process(chars, l, r - 1, preLColor, 1);
            minOpera = Math.min(minOpera, rToR);
        }
        int rToY = (chars[r] == 'r' ? 1 : 0) + process(chars, l, r - 1, preLColor, 2);
        minOpera = Math.min(minOpera, rToY);

        return minOpera;
    }

    int processDp(char[] chars) {
        int N = chars.length;

        int minOpera = 0;
        minOpera += chars[0] == 'r' ? 0 : 1;
        minOpera += chars[N - 1] == 'r' ? 0 : 1;

        int[][][] dp = new int[N][N][2];
        for (int i = 1; i < N; i++) {
            dp[i][i][0] = dp[i][i][1] = chars[i] == 'y' ? 0 : 1;
        }

        minOpera += dp[1][N - 1][1];
        return minOpera;
    }

    // todo: 这个方法还是超出时间限制. 需要想办法改成dp
    public int minimumOperations(String leaves) {
        // 尝试r开头的结束位置和 后一段r 开始的位置
        char[] chars = leaves.toCharArray();
        int N = chars.length;

        int[] changeToYs = new int[N];
        int[] changeToRs = new int[N];
        changeToRs[0] = chars[0] == 'y' ? 1 : 0;
        changeToYs[0] = chars[0] == 'r' ? 1 : 0;

        for (int i = 1; i < chars.length; i++) {
            changeToRs[i] = changeToRs[i - 1] + (chars[i] == 'y' ? 1 : 0);
            changeToYs[i] = changeToYs[i - 1] + (chars[i] == 'r' ? 1 : 0);
        }

        int minOperation = Integer.MAX_VALUE;
        for (int yStartIndex = 1; yStartIndex < N - 1; yStartIndex++) {
            for (int yEndIndex = yStartIndex; yEndIndex < N - 1; yEndIndex++) {
                // otherOpera = Math.min(process(chars, yStartIndex, yEndIndex), otherOpera);
                // l ... r 标记变成 y 需要的操作数
                // 变成r的值需要的操作
                int curOperation = changeToRs[yStartIndex - 1] + (changeToRs[N - 1] - changeToRs[yEndIndex])
                        + changeToYs[yEndIndex] - changeToYs[yStartIndex - 1];
                // 变成y的值需要的操作
                minOperation = Math.min(curOperation, minOperation);
            }
        }

        return minOperation;
    }

    // 暴力解, 注释
//    public int minimumOperations(String leaves) {
//        // 尝试r开头的结束位置和 后一段r 开始的位置
//        char[] chars = leaves.toCharArray();
//        int N = chars.length;
//        int minOperations = 0;
//        if (chars[0] == 'y') {
//            minOperations++;
//        }
//
//        if (chars[N - 1] == 'y') {
//            minOperations++;
//        }
//
//        int otherOpera = Integer.MAX_VALUE;
//        // 遍历 i, j 未
//        for (int yStartIndex = 1; yStartIndex < N - 1; yStartIndex++) {
//            for (int yEndIndex = yStartIndex; yEndIndex < N - 1; yEndIndex++) {
//                otherOpera = Math.min(process(chars, yStartIndex, yEndIndex), otherOpera);
//            }
//        }
//
//        return minOperations + otherOpera;
//    }
//
//    /**
//     * chars[l ... r] 都为y 的情况下需要变动多少次
//     *
//     * @param chars
//     * @param l
//     * @param r
//     * @return
//     */
//    int process(char[] chars, int l, int r) {
//        int N = chars.length;
//
//        // 操作的次数
//        int numOfOpera = 0;
//        // 0 ... l-1  和 r +1 ... len-1 都要换成 r
//        for (int i = 1; i <= l - 1; i++) {
//            if (chars[i] == 'y') {
//                numOfOpera++;
//            }
//        }
//
//        for (int i = r + 1; i < N - 1; i++) {
//            if (chars[i] == 'y') {
//                numOfOpera++;
//            }
//        }
//
//        // l ... r 都要换成y
//        for (int i = l; i <= r; i++) {
//            if (chars[i] == 'r') {
//                numOfOpera++;
//            }
//        }
//
//        return numOfOpera;
//    }
}
