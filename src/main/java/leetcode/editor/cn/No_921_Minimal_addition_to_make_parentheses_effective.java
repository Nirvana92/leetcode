package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/15 22:58
 * <p>
 * 921. 使括号有效的最少添加
 */
public class No_921_Minimal_addition_to_make_parentheses_effective {
    @Test
    public void test() {
        String s = "())";
        s = "(((";
        s = "()";
        s = "()))((";

        int minAddToMakeValid = minAddToMakeValid(s);
        System.out.println(minAddToMakeValid);
    }

    public int minAddToMakeValid(String s) {
        int leftNums = 0, ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftNums++;
            } else {
                leftNums--;
            }

            if (leftNums < 0) {
                ret += -leftNums;
                leftNums = 0;
            }
        }

        ret += leftNums;

        return ret;
    }
}
