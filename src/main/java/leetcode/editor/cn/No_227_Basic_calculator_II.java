package leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author gzm
 * @date 2020/9/23 5:26 下午
 * @desc
 */
public class No_227_Basic_calculator_II {
    @Test
    public void test() {
        String str = "  3+5 / 2 4*  3  2 -98923+34234   /2+34";
        str = "3+2*2";
        str = "0-2147483647";
        str = "1-1+1";
//        int[] num = getNum(str.toCharArray(), 7);
//        PrintUtils.print(num);

        int calculate = calculate(str);
        System.out.println(calculate);
    }

    public int calculate(String s) {
        char[] chars = s.toCharArray();
        LinkedList<String> numbers = new LinkedList<>();

        int index = 0;
        while (index < chars.length) {
            if (chars[index] == ' ') {
                index++;
                continue;
            }

            if (chars[index] >= '0' && chars[index] <= '9') {
                // 如果是数字
                // preNum = preNum * 10 + (chars[index] - '0');
                int[] num = getNum(chars, index);
                numbers.addLast(String.valueOf(num[0]));
                index = num[1];
            } else {
                // 符号: 收集前面的数字, 并添加 符号
                if (chars[index] == '*' || chars[index] == '/') {
                    // 计算
                    int[] num = getNum(chars, index + 1);
                    String firstNum = numbers.pollLast();
                    String rst = cal(firstNum, String.valueOf(num[0]), String.valueOf(chars[index]));
                    numbers.addLast(rst);
                    index = num[1];
                } else {
                    // 添加到队列中
                    numbers.addLast(String.valueOf(chars[index]));
                    index++;
                }
            }
        }

        while (numbers.size() > 1) {
            String firstNum = numbers.pollFirst();
            String operation = numbers.pollFirst();
            String secondNum = numbers.pollFirst();
            numbers.addFirst(cal(firstNum, secondNum, operation));
        }

        return Integer.parseInt(numbers.pop());
    }

    int[] getNum(char[] chars, int startIndex) {
        int tmpPreNum = 0;
        while (startIndex < chars.length && ((chars[startIndex] >= '0' && chars[startIndex] <= '9') || chars[startIndex] == ' ')) {
            if (chars[startIndex] == ' ') {
                startIndex++;
                continue;
            }

            tmpPreNum = tmpPreNum * 10 + (chars[startIndex] - '0');
            startIndex++;
        }
        return new int[]{tmpPreNum, startIndex};
    }

    String cal(String firstNum, String secondNum, String operator) {
        Integer result = 0;
        switch (operator) {
            case "+":
                result = Integer.parseInt(firstNum) + Integer.parseInt(secondNum);
                break;
            case "-":
                result = Integer.parseInt(firstNum) - Integer.parseInt(secondNum);
                break;
            case "*":
                result = Integer.parseInt(firstNum) * Integer.parseInt(secondNum);
                break;
            case "/":
                result = Integer.parseInt(firstNum) / Integer.parseInt(secondNum);
                break;
        }

        return result.toString();
    }
}
