package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/4 4:11 下午
 * @desc: 647. 回文子串
 * <p>
 * 动态规划
 */
public class No_647_Palindrome_substring {
    @Test
    public void test() {
        String s = "abc";
        s = "aaa";
        s = "asdkfaskdfsjdlaksjdflajdfksjdfjasdfjsldjflsjdf";

        int countSubstrings = countSubstrings(s);
        System.out.println(countSubstrings);
    }

    public int countSubstrings(String s) {
        int N = s.length();
        int totalPalindrome = 0;

        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
            totalPalindrome += dp[i][i];
            if (i + 1 < N && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                totalPalindrome += dp[i][i + 1];
            }
        }

        for (int row = N - 3; row >= 0; row--) {
            for (int col = row + 2; col < N; col++) {
                dp[row][col] = s.charAt(row) == s.charAt(col) ? dp[row + 1][col - 1] : 0;
                totalPalindrome += dp[row][col];
            }
        }

        return totalPalindrome;
    }
}
