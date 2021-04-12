package leetcode.editor.cn;

import org.junit.Test;

import java.util.Stack;

/**
 * @author gzm
 * @date 2021/3/5 9:36 上午
 * @desc: 232. 用栈实现队列
 */
public class No_232_Implement_queues_with_stacks {
    @Test
    public void test() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}

class MyQueue {
    /**
     * 输入栈
     */
    private Stack<Integer> inStack;
    /**
     * 输出栈
     */
    private Stack<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outStack.isEmpty()) {
            inToOut();
        }

        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            inToOut();
        }

        return outStack.peek();
    }

    void inToOut() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}