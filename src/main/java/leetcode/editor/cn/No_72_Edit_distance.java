package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/21 11:49 上午
 * @desc: 72. 编辑距离
 * <p>
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class No_72_Edit_distance {
    @Test
    public void test() {
        String word1 = "horse", word2 = "ros";

//        word1 = "intention";
//        word2 = "execution";

        int minDistance = minDistance(word1, word2);
        System.out.println(minDistance);

        int minDistanceDp = minDistanceDp(word1, word2);
        System.out.println(minDistanceDp);
    }

    /**
     * 改写的dp版本
     *
     * @param w1
     * @param w2
     * @return
     */
    int minDistanceDp(String w1, String w2) {
        int w1Len = w1.length();
        int w2Len = w2.length();
        int[][] dp = new int[w1Len + 1][w2Len + 1];
        for (int i = 0; i <= w1Len; i++) {
            dp[i][w2Len] = w1Len - i;
        }
        for (int i = 0; i <= w2Len; i++) {
            dp[w1Len][i] = w2Len - i;
        }

        for (int w1Index = w1Len - 1; w1Index >= 0; w1Index--) {
            for (int w2Index = w2Len - 1; w2Index >= 0; w2Index--) {
                int p1 = dp[w1Index][w2Index + 1] + 1;
                // 2.2 删除
                int p2 = dp[w1Index + 1][w2Index] + 1;
                // 2.3 替换
                int p3 = 0;
                if (w1.charAt(w1Index) == w2.charAt(w2Index)) {
                    p3 = dp[w1Index + 1][w2Index + 1];
                } else {
                    // 不相等的时候
                    p3 = dp[w1Index + 1][w2Index + 1] + 1;
                }
                dp[w1Index][w2Index] = Math.min(Math.min(p1, p2), p3);
            }
        }

        return dp[0][0];
    }

    public int minDistance(String word1, String word2) {
        return process(word1, word2, 0, 0);
    }

    int process(String w1, String w2, int w1Index, int w2Index) {
        if (w1Index == w1.length() && w2Index == w2.length()) {
            return 0;
        }

        if (w1Index == w1.length() || w2Index == w2.length()) {
            return w1Index == w1.length() ? w2.length() - w2Index : w1.length() - w1Index;
        }

        // w1Index w2Index 都没有到边界地点
        // 一次判断 插入 删除 替换操作求最小值
        // 1. w1Index w2Index 位置上的字符相等
        // 2. w1Index w2Index 位置上的字符不相等
        // 2.1 插入
        int p1 = process(w1, w2, w1Index, w2Index + 1) + 1;
        // 2.2 删除
        int p2 = process(w1, w2, w1Index + 1, w2Index) + 1;
        // 2.3 替换
        int p3 = 0;
        if (w1.charAt(w1Index) == w2.charAt(w2Index)) {
            p3 = process(w1, w2, w1Index + 1, w2Index + 1);
        } else {
            // 不相等的时候
            p3 = process(w1, w2, w1Index + 1, w2Index + 1) + 1;
        }
        int minDiss = Math.min(Math.min(p1, p2), p3);

        return minDiss;
    }
}
