package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/29 7:23 下午
 * @desc: 856. 括号的分数
 * <p>
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 */
public class No_856_Bracketed_score {
    @Test
    public void test() {
        String s = "()";
        s = "(())";
        s = "()()";
        s = "(()(()))";
        s = "(((())))";

        int scoreOfParentheses = scoreOfParentheses(s);
        System.out.println(scoreOfParentheses);
    }

    public int scoreOfParentheses(String S) {
        int score = 0;

        int leftNums = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                leftNums++;
            } else {
                leftNums--;
                if (S.charAt(i - 1) == '(') {
                    score += (1 << leftNums);
                }
            }
        }

        return score;
    }
}
