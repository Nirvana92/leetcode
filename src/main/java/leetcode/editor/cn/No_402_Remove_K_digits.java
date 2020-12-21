package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author gzm
 * @date 2020/11/2 8:34 下午
 * @desc: 402. 移掉K位数字
 */
public class No_402_Remove_K_digits {
    @Test
    public void test() {
        String num = "1432219";
        int k = 3;

        num = "10200";
        k = 1;

//        num = "10";
//        k = 2;

        num = "947236413472190340023294245345234";
        k = 3;

        num = "112";
        k = 1;

        String removeKdigits = removeKdigits(num, k);
        System.out.println(removeKdigits);
    }

    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        Set<Integer> removeIndexs = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            if (removeIndexs.size() == k) {
                break;
            }
            while (!stack.isEmpty() && num.charAt(i) < num.charAt(stack.peek()) && removeIndexs.size() < k) {
                removeIndexs.add(stack.pop());
            }

            stack.add(i);
        }
        int endIndex = num.length() - 1;
        while (removeIndexs.size() != k) {
            removeIndexs.add(endIndex);

            endIndex--;
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < num.length(); i++) {
            if (!removeIndexs.contains(i)) {
                if (buffer.length() == 0 && num.charAt(i) == '0') {
                    continue;
                }
                buffer.append(num.charAt(i));
            }
        }

        return buffer.length() == 0 ? "0" : buffer.toString();
    }
}
