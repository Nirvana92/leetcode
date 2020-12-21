package leetcode.editor.cn;

import org.junit.Test;

import java.util.Random;

/**
 * @author gzm
 * @date 2020/9/8 7:32 下午
 * @desc: 10. 正则表达式匹配
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 */

// todo: 有测试用例没有通过
public class No_10_Regular_expression_matching {
    Random random = new Random();
    char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.', '*'};

    public static void main(String[] args) {
        No_10_Regular_expression_matching no_10 = new No_10_Regular_expression_matching();
        // String s = "mississippi", p = "mis*is*p*.";
        // String s = "aab", p = "c*a*b";
        String s = "a", p = "ab*";
        boolean match = no_10.isMatch(s, p);
        boolean matchDp = no_10.isMatchDp(s, p);
        System.out.println(match);
        System.out.println(matchDp);
    }

    @Test
    public void test() {
        Integer baseStrLen = 10;
        int times = 1000;

        for (int i = 0; i < times; i++) {
            int appendLen = random.nextInt(100);
            String str = genStr(baseStrLen + appendLen);

            // isMatchDp()
        }
    }

    String genStr(int numLen) {
        String str = "";
        for (int i = 0; i < numLen; i++) {
            str += chars[random.nextInt(chars.length) + 1];
        }

        return str;
    }

    /**
     * 通过测试用例的最终代码
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchDp(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        int sLen = sChars.length;
        int pLen = pChars.length;

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[sLen][pLen] = true;

        for (int pIndex = pLen - 1; pIndex >= 0; pIndex--) {
            for (int sIndex = sLen; sIndex >= 0; sIndex--) {
                // p[pIndex] 为字符的情况 或者 p[pIndex] == .
                // if ((p[pIndex] >= 'a' && p[pIndex] <= 'z') || p[pIndex] == '.') {
                if (sIndex < sLen && (pChars[pIndex] == '.' || pChars[pIndex] == sChars[sIndex]) && dp[sIndex + 1][pIndex + 1]) {
                    dp[sIndex][pIndex] = true;
                    continue;
                }

                // p[pIndex+1] 为 * 的情况
                if (pIndex + 1 < pLen && pChars[pIndex + 1] == '*') {
                    // pIndex 和 pIndex+1 替换成 0个 p[pIndex] 的情况
                    if (dp[sIndex][pIndex + 2]) {
                        dp[sIndex][pIndex] = true;
                        continue;
                    }

                    for (int i = 0; i < sLen - sIndex; i++) {
                        if (pChars[pIndex] == sChars[sIndex + i] || pChars[pIndex] == '.') {
                            if (dp[sIndex + i + 1][pIndex + 2]) {
                                dp[sIndex][pIndex] = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][0];
    }

    public boolean isMatch(String s, String p) {
        return process(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    /**
     * s[sIndex....]  能够满足 p[pIndex...]
     *
     * @param s
     * @param p
     * @param sIndex
     * @param pIndex
     * @return
     */
    public boolean process(char[] s, char[] p, int sIndex, int pIndex) {
        int sLen = s.length;
        int pLen = p.length;

        // s, p 均没有字符 返回true
        if (pIndex == pLen && sLen == sIndex) {
            return true;
        }
        // p 已经结束了, s 还有字符没有匹配, 返回false
        if (pIndex == pLen) {
            return false;
        }

        if (p[pIndex] == '*') {
            return false;
        }

        // p[pIndex] 为字符的情况 或者 p[pIndex] == .
        // if ((p[pIndex] >= 'a' && p[pIndex] <= 'z') || p[pIndex] == '.') {
        // pIndex + 1 == pLen ||
        if (sIndex < sLen && (p[pIndex] == '.' || p[pIndex] == s[sIndex])
                && process(s, p, sIndex + 1, pIndex + 1)) {
            return true;
        }

        // p[pIndex+1] 为 * 的情况
        if (pIndex + 1 < pLen && p[pIndex + 1] == '*') {
            // pIndex 和 pIndex+1 替换成 0个 p[pIndex] 的情况
            if (process(s, p, sIndex, pIndex + 2)) {
                return true;
            }

            for (int i = 0; i < sLen - sIndex; i++) {
                if (p[pIndex] == s[sIndex + i] || p[pIndex] == '.') {
                    if (process(s, p, sIndex + i + 1, pIndex + 2)) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }

        return false;
    }
}
