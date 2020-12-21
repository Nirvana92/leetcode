package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/19 20:51
 * <p>
 * 最长公共子序列
 */
public class No_1143_Longest_common_subsequence {
    @Test
    public void test() {
        String text1 = "abcde", text2 = "ace";

//        text1 = "abc";
//        text2 = "abc";

//        text1 = "abc";
//        text2 = "def";

        text1 = "aklsfjhaklsdhfkasdhfkasdhkasdfhj";
        text2 = "iwuerohnxcklsnicayhseroqwndfklshdfiopasd";

        text1 = "doasooahs";
        text2 = "asdhasdhohds";

        int longestCommonSubsequence = longestCommonSubsequence(text1, text2);
        System.out.println(longestCommonSubsequence);

        int process = process(text1, text2, 0, 0);
        System.out.println(process);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int t1N = text1.length();
        int t2N = text2.length();

        int[][] dp = new int[t1N][t2N];
        dp[t1N - 1][t2N - 1] = text1.charAt(t1N - 1) == text2.charAt(t2N - 1) ? 1 : 0;

        // 还需要初始化 t1N-1 的时候合 t2N-1 的时候
        for (int i = t1N - 2; i >= 0; i--) {
            if (dp[i + 1][t2N - 1] == 1 || text1.charAt(i) == text2.charAt(t2N - 1)) {
                dp[i][t2N - 1] = 1;
            }
        }

        for (int i = t2N - 2; i >= 0; i--) {
            if (dp[t1N - 1][i + 1] == 1 || text1.charAt(t1N - 1) == text2.charAt(i)) {
                dp[t1N - 1][i] = 1;
            }
        }

        for (int t1Index = t1N - 2; t1Index >= 0; t1Index--) {
            for (int t2Index = t2N - 2; t2Index >= 0; t2Index--) {
                int p1 = dp[t1Index + 1][t2Index + 1];
                int p2 = dp[t1Index][t2Index + 1];
                int p3 = dp[t1Index + 1][t2Index];

                int rst = Math.max(p1, Math.max(p2, p3));
                if (text1.charAt(t1Index) == text2.charAt(t2Index)) {
                    rst = Math.max(rst, dp[t1Index + 1][t2Index + 1] + 1);
                }

                dp[t1Index][t2Index] = rst;
            }
        }

        return dp[0][0];
        // 暴利递归求解
        // return process(text1, text2, 0, 0);
    }

    int process(String t1, String t2, int t1Index, int t2Index) {
        if (t1Index == t1.length() || t2Index == t2.length()) {
            return 0;
        }

        int p1 = process(t1, t2, t1Index + 1, t2Index + 1);
        int p2 = process(t1, t2, t1Index, t2Index + 1);
        int p3 = process(t1, t2, t1Index + 1, t2Index);

        int rst = Math.max(p1, Math.max(p2, p3));
        if (t1.charAt(t1Index) == t2.charAt(t2Index)) {
            rst = Math.max(rst, process(t1, t2, t1Index + 1, t2Index + 1) + 1);
        }

        return rst;
    }
}
