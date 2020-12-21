package leetcode.editor.cn;

import org.junit.Test;

import java.util.Stack;

/**
 * @author gzm
 * @date 2020/10/27 5:00 下午
 * @desc: 剑指 Offer 31. 栈的压入、弹出序列
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
public class Offer_31_Stack_push_and_pop_sequence {
    @Test
    public void test() {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        popped = new int[]{4, 3, 5, 1, 2};

        pushed = new int[]{2, 1, 0};
        popped = new int[]{1, 2, 0};

        boolean validateStackSequences = validateStackSequences(pushed, popped);
        System.out.println(validateStackSequences);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < pushed.length; i++) {
            stack.add(pushed[i]);

            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                popIndex++;
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
                continue;
            }
            break;
        }

        return stack.isEmpty();
    }
}
