package leetcode.editor.cn;

import java.util.Random;

/**
 * @author gzm
 * @date 2020/9/8 5:58 下午
 * @desc: 32. 最长有效括号
 */
public class No_32 {

    public static void main(String[] args) {
        No_32 no_32 = new No_32();
        // String str = ")(()())()()(((((()()))()()))()()))()()()))))()()(((()()((()()()()((((())()))))))()()()()()()((";

        int loopTimes = 100;
        Random random = new Random();
        while (loopTimes-- >= 0) {
            int tmp = random.nextInt(1000) + 1;
            String str = genStr(tmp);
            int longestValid = no_32.longestValidParentheses(str);
            int dpResult = no_32.longestValidParenthesesDp(str);

            if (longestValid != dpResult) {
                System.out.println("str: " + str);
                System.out.println(longestValid);
                System.out.println(dpResult);
            }
        }
    }

    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();

        int maxResult = 0;
        for (int i = 0; i < chars.length; i++) {
            maxResult = Math.max(process(chars, i), maxResult);
        }
        return maxResult;
    }

    public int longestValidParenthesesDp(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];

        int maxResult = 0;
        for (int i = 0; i < chars.length; i++) {
            processDp(chars, i, dp);
            maxResult = Math.max(dp[i], maxResult);
        }
        return maxResult;
    }

    private void processDp(char[] chars, int index, int[] dp) {
        if (index == 0 || chars[index] == '(') {
            return;
        }

        // 前一个位子的最远的有效位子
        // index 需要和他匹配的位子的下标
        int waitComIndex = index - dp[index - 1] - 1;
        int maxLen = 0;
        if (waitComIndex >= 0 && chars[waitComIndex] == '(') {
            maxLen = dp[index - 1] + 2;

            // 再往前看下
            if (index - maxLen >= 0) {
                maxLen += dp[index - maxLen];
            }
        }

        dp[index] = maxLen;

        return;
    }

    /**
     * chars[0....index] 中最长的有效括号数
     *
     * @param chars: 括号的字符串
     * @param index:
     * @return
     */
    private int process(char[] chars, int index) {
        if (index == 0) {
            return 0;
        }

        if (chars[index] == '(') {
            return 0;
        }

        // 前一个位子的最远的有效位子
        int preMaxDis = process(chars, index - 1);
        // index 需要和他匹配的位子的下标
        int waitComIndex = index - preMaxDis - 1;
        int maxLen = 0;
        if (waitComIndex >= 0 && chars[waitComIndex] == '(') {
            maxLen = preMaxDis + 2;

            // 再往前看下
            if (index - maxLen >= 0) {
                maxLen += process(chars, index - maxLen);
            }
        }

        return maxLen;
    }

    public static String genStr(int strLen) {
        String str = "";
        Random random = new Random();
        for (int i = 0; i < strLen; i++) {
            str += random.nextInt(2) == 1 ? ")" : "(";
        }

        return str;
    }
}
