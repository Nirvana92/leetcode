package leetcode.editor.cn;

import org.junit.Test;

import java.util.Objects;

/**
 * @author gzm
 * @date 2020/9/27 7:00 下午
 * @desc
 */
public class Interview_questions_01_05_Edit_once {

    @Test
    public void test() {
        String first = "pales", second = "ple";
        // second = "pale";
        boolean oneEditAway = oneEditAway(first, second);
        System.out.println(oneEditAway);
    }

    // todo: 改写dp的方法
    public boolean oneEditAway(String first, String second) {
        if (Objects.equals(first, second)) {
            return true;
        }

        int rowLen = first.length();
        int colLen = second.length();
        if (Math.abs(rowLen - colLen) > 1) {
            return false;
        }

        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();

        // dp[i][j]: secondChars[0...j] 通过最少的变换次数能够变成 firstChars[0....i]
        boolean[][][] dp = new boolean[rowLen + 1][colLen + 1][2];


        // return dp[rowLen][colLen][1];
        return process(firstChars, 0, secondChars, 0, 1);
    }

    /**
     * secondChars[sIndex...] 通过remind 次变换 变成 firstChars[fIndex...] 是否成功
     *
     * @param firstChars
     * @param fIndex
     * @param secondChars
     * @param sIndex
     * @param remind
     * @return
     */
    boolean process(char[] firstChars, int fIndex, char[] secondChars, int sIndex, int remind) {
        if (remind < 0) {
            return false;
        }
        if (fIndex == firstChars.length && sIndex == secondChars.length) {
            return true;
        }

        if (fIndex == firstChars.length) {
            return remind >= (secondChars.length - sIndex);
        }

        if (sIndex == secondChars.length) {
            return remind >= (firstChars.length - fIndex);
        }


        boolean result = false;
        if (firstChars[fIndex] == secondChars[sIndex]) {
            // 不变
            result |= process(firstChars, fIndex + 1, secondChars, sIndex + 1, remind);
        } else {
            // 替换
            result |= process(firstChars, fIndex + 1, secondChars, sIndex + 1, remind - 1);
        }

        // 删除
        result |= process(firstChars, fIndex, secondChars, sIndex + 1, remind - 1);

        // 新增
        result |= process(firstChars, fIndex + 1, secondChars, sIndex, remind - 1);

        return result;
    }
}
