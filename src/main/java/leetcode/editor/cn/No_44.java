package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/18 7:23 下午
 * @desc: ? 可以匹配任何一个单字符, * 可以匹配任意字符串[包括空字符串]
 */
public class No_44 {
    @Test
    public void test() {
        String s = "acdcb";
        String p = "a*c?b";
        boolean match = isMatch(s, p);
        boolean matchDp = isMatchDp(s, p);
        System.out.println("match: " + match);
        System.out.println("matchDp: " + matchDp);
    }

    public boolean isMatch(String s, String p) {
        char[] strs = s.toCharArray();
        char[] patterns = p.toCharArray();

        return process(strs, patterns, 0, 0);
    }

    public boolean isMatchDp(String s, String p) {
        return process(s.toCharArray(), p.toCharArray());
    }

    /**
     * 暴利递归改为动态规划
     *
     * @param strs
     * @param patterns
     * @return
     */
    boolean process(char[] strs, char[] patterns) {
        int sLen = strs.length;
        int pLen = patterns.length;

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        // sIndex 和pIndex 都到了结束的位置, 返回true
        dp[sLen][pLen] = true;

        // s 没结束, p 结束 匹配不成功
        // 默认就是false, 不需要单独赋值

        // s结束, p没结束
        for (int index = pLen - 1; index >= 0; index--) {
            dp[sLen][index] = patterns[index] == '*' && dp[sLen][index + 1];
        }

        // s 和 p 都没有到结束位置
        // p 当前位置是字符[非 ? *]
        for (int pIndex = pLen - 1; pIndex >= 0; pIndex--) {
            for (int sIndex = sLen - 1; sIndex >= 0; sIndex--) {
                if (patterns[pIndex] >= 'a' && patterns[pIndex] <= 'z') {
                    dp[sIndex][pIndex] = patterns[pIndex] == strs[sIndex] && dp[sIndex + 1][pIndex + 1];
                    continue;
                }

                // pIndex 位置是 ?
                if (patterns[pIndex] == '?') {
                    dp[sIndex][pIndex] = dp[sIndex + 1][pIndex + 1];
                    continue;
                }

                // pIndex 位置是 *
                // 从strs 的sIndex 往后遍历, 匹配空字符串到结束字符串
                // 最大的增幅数 sLen - 1 - sIndex
                if (patterns[pIndex] == '*') {
                    for (int i = 0; i <= sLen - sIndex; i++) {
                        if (dp[sIndex + i][pIndex + 1]) {
                            dp[sIndex][pIndex] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][0];
    }

    /**
     * strs[sIndex ...] 是否能被 patterns[pIndex ...] 匹配出来
     *
     * @param strs
     * @param patterns
     * @param sIndex
     * @param pIndex
     */
    boolean process(char[] strs, char[] patterns, int sIndex, int pIndex) {
        int sLen = strs.length;
        int pLen = patterns.length;
        // sIndex 和pIndex 都到了结束的位置, 返回true
        if (sIndex == sLen && pIndex == pLen) {
            return true;
        }
        // s 没结束, p 结束 匹配不成功
        if (pIndex == pLen) {
            return false;
        }

        // s结束, p没结束
        if (sIndex == sLen) {
            return patterns[pIndex] == '*' && process(strs, patterns, sIndex, pIndex + 1);
        }

        // s 和 p 都没有到结束位置
        // p 当前位置是字符[非 ? *]
        if (patterns[pIndex] >= 'a' && patterns[pIndex] <= 'z') {
            return patterns[pIndex] == strs[sIndex] && process(strs, patterns, sIndex + 1, pIndex + 1);
        }

        // pIndex 位置是 ?
        if (patterns[pIndex] == '?') {
            return process(strs, patterns, sIndex + 1, pIndex + 1);
        }

        // pIndex 位置是 *
        // 从strs 的sIndex 往后遍历, 匹配空字符串到结束字符串
        // 最大的增幅数 sLen - 1 - sIndex
        if (patterns[pIndex] == '*') {
            for (int i = 0; i <= sLen - sIndex; i++) {
                if (process(strs, patterns, sIndex + i, pIndex + 1)) {
                    return true;
                }
            }
        }

        return false;
    }
}
