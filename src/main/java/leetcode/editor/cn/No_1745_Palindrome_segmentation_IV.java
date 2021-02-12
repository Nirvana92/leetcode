package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/2/2 5:10 下午
 * @desc: 1745. 回文串分割 IV
 * <p>
 * 1. 动态规划
 * 2. 马拉车方法
 */
public class No_1745_Palindrome_segmentation_IV {
    @Test
    public void test() {
        String s = "abcbdd";
        s = "bcbddxy";

        boolean checkPartitioning = checkPartitioning(s);
        System.out.println(checkPartitioning);
    }

    public boolean checkPartitioning(String s) {
        int len = s.length();

        /**
         * 判断 s(i... j) 字符串是否是回文
         */
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i + 1 < len) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            }
        }

        for (int l = len - 3; l >= 0; l--) {
            for (int r = l + 2; r < len; r++) {
                dp[l][r] = s.charAt(l) == s.charAt(r) && dp[l + 1][r - 1];
            }
        }

        // 然后从第二个字符到最后一个字符依次来锁定中间的字符串来进行判断是否是回文。当找到其中一个解的时候返回。
        // 依次判断中间字符串的l, r 位置
        for (int l = 1; l < len - 1; l++) {
            for (int r = l; r < len - 1; r++) {
                // 中间字符串 l... r
                if (dp[0][l - 1] && dp[l][r] && dp[r + 1][len - 1]) {
                    return true;
                }
            }
        }

        return false;
    }

//    boolean process(String s, int l, int r) {
//        if (l > r) {
//            return false;
//        }
//
//        if (l == r) {
//            return true;
//        }
//
//        if (l + 1 == r) {
//            return s.charAt(l) == s.charAt(r);
//        }
//
//        return s.charAt(l) == s.charAt(r) && process(s, l + 1, r - 1);
//    }
}
