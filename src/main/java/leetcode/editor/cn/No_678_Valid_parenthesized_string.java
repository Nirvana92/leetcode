package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/29 9:03 下午
 * @desc: 678. 有效的括号字符串
 */
public class No_678_Valid_parenthesized_string {
    @Test
    public void test() {
        String s = "((*)))";
        s = "()";
        s = "()*";
        s = "(*)";
        s = "(*))";
        s = "((**)";
        s = "()()((*)";
        s = "(())*)";
        s = "(())(*";
        s = "(()))*";
        s = "()()*)";
        s = "*";
        s = "";
        s = "(*()";
        s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        s = "(())((*)(*)())((*";
        s = "((*)(*)((*";

        boolean checkValidString = checkValidString(s);
        System.out.println(checkValidString);
    }

    public boolean checkValidString(String s) {
        // 左括号, 右括号, 星号
        int leftNums = 0, leftAsteriskNums = 0, rightNums = 0, rightAsteriskNums = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 左括号
                leftNums++;
            } else if (s.charAt(i) == ')') {
                // 右括号
                leftNums--;
            } else {
                // 星号
                leftAsteriskNums++;
            }
            if (leftNums < 0) {
                leftAsteriskNums -= Math.abs(leftNums);
                leftNums = 0;
            }

            if (leftNums < 0 || leftAsteriskNums < 0) {
                return false;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                // 左括号
                rightNums++;
            } else if (s.charAt(i) == '(') {
                // 右括号
                rightNums--;
            } else {
                // 星号
                rightAsteriskNums++;
            }
            if (rightNums < 0) {
                rightAsteriskNums -= Math.abs(rightNums);
                rightNums = 0;
            }

            if (rightNums < 0 || rightAsteriskNums < 0) {
                return false;
            }
        }

        return leftAsteriskNums >= leftNums && rightAsteriskNums >= rightNums;
    }
}
