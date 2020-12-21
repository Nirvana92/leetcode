package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/15 23:27
 */
public class No_516_Longest_palindrome_subsequence {
    @Test
    public void test() {
        String str = "bbbab";
        int longestPalindromeSubseq = longestPalindromeSubseq(str);
        System.out.println(longestPalindromeSubseq);
    }

    public int longestPalindromeSubseq(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        // return process(s.toCharArray(), 0, s.length() - 1);
        return processDp(s.toCharArray());
    }

    int processDp(char[] chars) {
        int N = chars.length;
        int[][] dp = new int[N][N];

        // 填充对角线的值
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }
        // 填充l l+1 的值
        for (int l = 0; l < N - 1; l++) {
            dp[l][l + 1] = chars[l] == chars[l + 1] ? 2 : 1;
        }

        for (int l = N - 2; l >= 0; l--) {
            for (int r = l + 2; r < N; r++) {
                dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
                if (chars[l] == chars[r]) {
                    dp[l][r] = Math.max(dp[l][r], 2 + dp[l + 1][r - 1]);
                }
            }
        }

        return dp[0][N - 1];
    }

    /**
     * 在 chars 数组中 , l .. r 范围内的最长回文子序列长度
     *
     * @param chars
     * @param l
     * @param r
     * @return
     */
    int process(char[] chars, int l, int r) {
        if (l > r) {
            return 0;
        }

        if (l == r) {
            return 1;
        }

        int p1 = process(chars, l + 1, r);
        int p2 = process(chars, l, r - 1);
        int maxLen = Math.max(p1, p2);
        if (chars[l] == chars[r]) {
            maxLen = Math.max(maxLen, 2 + process(chars, l + 1, r - 1));
        }

        return maxLen;
    }
}
