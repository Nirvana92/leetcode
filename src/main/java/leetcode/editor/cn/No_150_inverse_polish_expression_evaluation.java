package leetcode.editor.cn;

import org.junit.Test;

import java.util.Stack;

/**
 * @author gzm
 * @date 2020/9/22 10:36 上午
 * @desc
 */
public class No_150_inverse_polish_expression_evaluation {
    @Test
    public void test() {
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int result = evalRPN(tokens);
        System.out.println(result);
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                // 碰到运算符, 从栈中弹出最上层的两个数进行运算然后压栈
                String secondNum = stack.pop();
                String firstNum = stack.pop();
                stack.push(cal(firstNum, secondNum, tokens[i]));
            } else {
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    /**
     * 根据给定的数字和运算符号, 进行算术运算
     *
     * @param firstNum
     * @param secondNum
     * @param calSigns
     * @return
     */
    String cal(String firstNum, String secondNum, String calSigns) {
        String result = "";
        switch (calSigns) {
            case "+":
                result = String.valueOf(Integer.parseInt(firstNum) + Integer.parseInt(secondNum));
                break;
            case "-":
                result = String.valueOf(Integer.parseInt(firstNum) - Integer.parseInt(secondNum));
                break;
            case "*":
                result = String.valueOf(Integer.parseInt(firstNum) * Integer.parseInt(secondNum));
                break;
            case "/":
                result = String.valueOf(Integer.parseInt(firstNum) / Integer.parseInt(secondNum));
                break;
        }

        return result;
    }
}
