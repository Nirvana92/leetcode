package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/13 9:47 上午
 * @desc: 97. 交错字符串
 */
public class No_97_Interleaved_string {
    @Test
    public void test() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbbaccc";

//        s1 = "";
//        s2 = "";
//        s3 = "";
//
//        s1 = "";
//        s2 = "";
//        s3 = "";

//        s1 = "a";
//        s2 = "";
//        s3 = "a";

//        s1 = "aa";
//        s2 = "ab";
//        s3 = "abaa";

        boolean interleave = isInterleave(s1, s2, s3);
        System.out.println("interleave: " + interleave);
        boolean interleaveBaoli = isInterleaveBaoli(s1, s2, s3);
        System.out.println("interleaveBaoli: " + interleaveBaoli);
    }

    /**
     * 改写的动态规划版本
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int s3Len = s3.length();
        if (s1Len + s2Len != s3Len) {
            return false;
        }

        if (s3Len == 0) {
            return true;
        }

        boolean[][] dp = new boolean[s1Len + 1][s2Len + 1];
        dp[s1Len][s2Len] = true;

        for (int s1Index = s1Len - 1; s1Index >= 0; s1Index--) {
            boolean curEquals = s1.charAt(s1Index) == s3.charAt(s2Len + s1Index);
            if (s1Index == s1Len - 1) {
                dp[s1Index][s2Len] = curEquals;
            } else {
                dp[s1Index][s2Len] = curEquals && dp[s1Index + 1][s2Len];
            }
        }

        for (int s2Index = s2Len - 1; s2Index >= 0; s2Index--) {
            boolean curEquals = s2.charAt(s2Index) == s3.charAt(s1Len + s2Index);
            if (s2Index == s2Len - 1) {
                dp[s1Len][s2Index] = curEquals;
            } else {
                dp[s1Len][s2Index] = curEquals && dp[s1Len][s2Index + 1];
            }
        }


        for (int s1Index = s1Len - 1; s1Index >= 0; s1Index--) {
            for (int s2Index = s2Len - 1; s2Index >= 0; s2Index--) {
                boolean p1 = false, p2 = false;
                if (s1.charAt(s1Index) == s3.charAt(s1Index + s2Index)) {
                    p1 = dp[s1Index + 1][s2Index];
                }

                if (s2Index < s2Len && s2.charAt(s2Index) == s3.charAt(s1Index + s2Index)) {
                    p2 = dp[s1Index][s2Index + 1];
                }

                dp[s1Index][s2Index] = p1 | p2;
            }
        }

        return dp[0][0];
    }

    public boolean isInterleaveBaoli(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        if (s3.length() == 0) {
            return true;
        }

        return process(s1, s2, s3, 0, 0);
    }

    boolean process(String s1, String s2, String s3, int s1Index, int s2Index) {
        if (s1Index + s2Index == s3.length()) {
            return true;
        }

        boolean p1 = false, p2 = false;
        if (s1Index < s1.length() && s1.charAt(s1Index) == s3.charAt(s1Index + s2Index)) {
            p1 = process(s1, s2, s3, s1Index + 1, s2Index);
        }

        if (s2Index < s2.length() && s2.charAt(s2Index) == s3.charAt(s1Index + s2Index)) {
            p2 = process(s1, s2, s3, s1Index, s2Index + 1);
        }

        return p1 | p2;
    }

    /**
     * 在相同字符的选取的时候有可能相同字符的选择不同导致结果不同[错误的方法]
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleaveError(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int s3Index = s3.length() - 1, s1Index = s1.length() - 1, s2Index = s2.length() - 1;

        while (s1Index >= 0 && s2Index >= 0) {
            if (s3.charAt(s3Index) == s1.charAt(s1Index)) {
                s3Index--;
                s1Index--;
            } else if (s3.charAt(s3Index) == s2.charAt(s2Index)) {
                s3Index--;
                s2Index--;
            } else {
                return false;
            }
        }

        if (s3Index >= 0) {
            if (s1Index >= 0) {
                for (int i = s1Index; i >= 0; i--) {
                    if (s1.charAt(i) == s3.charAt(s3Index)) {
                        s3Index--;
                    } else {
                        return false;
                    }
                }
            } else {
                for (int i = s2Index; i >= 0; i--) {
                    if (s2.charAt(i) == s3.charAt(s3Index)) {
                        s3Index--;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
