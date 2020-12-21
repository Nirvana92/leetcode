package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/14 22:14
 * <p>
 * leetcode 664. 奇怪的打印机
 * <p>
 * 尝试的方法难想[动态规划]
 */
public class No_664_Strange_printer {
    @Test
    public void test() {
        String s = "";
        int strangePrinter = strangePrinter(s);
        System.out.println(strangePrinter);
    }

    /**
     * 思路: 假设第一次翻转的是根据第一个字符来规定的。然后依次往后遍历
     * 遍历第一次能扩展到的位置
     * <p>
     * 注意: 分成两段的时候需要判断下第一段的开始字符和第二段开始的字符是否相等。如果相等，总的打印次数需要 -1
     *
     * @param s
     * @return
     */
    public int strangePrinter(String s) {
        int N = s.length();
        if (N == 0) {
            return 0;
        }
        int[][] dp = new int[N][N];

        dp[N - 1][N - 1] = 1;
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 1 : 2;
        }

        for (int l = N - 3; l > 0; l--) {
            for (int r = l + 2; r < N; r++) {
                // 默认的值
                dp[l][r] = r - l + 1;

                for (int k = l; k < r; k++) {
                    int nextVal = dp[l][k] + dp[k + 1][r] - (s.charAt(l) == s.charAt(k + 1) ? 1 : 0);
                    dp[l][r] = Math.min(dp[l][r], nextVal);
                }
            }
        }

        return dp[0][N - 1];
    }
}
