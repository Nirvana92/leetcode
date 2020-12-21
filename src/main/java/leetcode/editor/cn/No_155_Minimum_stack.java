package leetcode.editor.cn;

import org.junit.Test;

import java.util.Stack;

/**
 * @author gzm
 * @date 2020/10/9 2:36 下午
 * @desc: 最小栈
 */
public class No_155_Minimum_stack {
    @Test
    public void test() {
//        MinStack obj = new MinStack();
//        obj.push(-2);
//        obj.push(0);
//        obj.push(-3);
//        int param_4 = obj.getMin();
//        System.out.println(param_4);
//
//        obj.pop();
//        int param_3 = obj.top();
//        System.out.println(param_3);
//
//        int minVal = obj.getMin();
//        System.out.println(minVal);

        // 测试用例 2
//        MinStack minStack = new MinStack();
//        minStack.push(-1);
//        minStack.top();
//        int min = minStack.getMin();
//        System.out.println(min);

        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.top();
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        min = minStack.getMin();
        System.out.println(min);
        minStack.top();
    }

    class MinStack {
        // 存值的堆
        Stack<Integer> values = null;
        // 存最小值的堆
        Stack<Integer> minVals = null;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            values = new Stack<>();
            minVals = new Stack<>();
        }

        // 将元素 x 推入栈中。
        public void push(int x) {
            values.push(x);
            if (minVals.isEmpty()) {
                minVals.push(x);
            } else {
                if (minVals.peek() >= x) {
                    minVals.push(x);
                } else {
                    minVals.push(minVals.peek());
                }
            }
        }

        // 删除栈顶的元素。
        public void pop() {
            if (values.isEmpty()) {
                return;
            }
            values.pop();
            minVals.pop();
        }

        // 获取栈顶元素。
        public int top() {
            if (values.isEmpty()) {
                return -1;
            }
            return values.peek();
        }

        // 检索栈中的最小元素。
        public int getMin() {
            if (minVals.isEmpty()) {
                return -1;
            }
            return minVals.peek();
        }
    }
}
