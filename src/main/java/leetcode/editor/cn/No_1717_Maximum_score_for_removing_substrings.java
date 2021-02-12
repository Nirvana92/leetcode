package leetcode.editor.cn;

import org.junit.Test;

import java.util.Stack;

/**
 * @author gzm
 * @date 2021/1/11 11:00 上午
 * @desc: 1717. 删除子字符串的最大得分
 */
public class No_1717_Maximum_score_for_removing_substrings {
    @Test
    public void test() {
        String s = "cdbcbbaaabab";
        int x = 4, y = 5;

        s = "aabbaaxybbaabb";
        x = 5;
        y = 4;

        s = "aabbabkbbbfvybssbtaobaaaabataaadabbbmakgabbaoapbbbbobaabvqhbbzbbkapabaavbbeghacabamdpaaqbqabbjbababmbakbaabajabasaabbwabrbbaabbafubayaazbbbaababbaaha";
        x = 1926;
        y = 4320;

        int maximumGain = maximumGain(s, x, y);
        System.out.println(maximumGain);
    }

    public int maximumGain(String s, int x, int y) {
        // x: ab
        // y: ba
        Stack<Character> stacks = new Stack<>();

        int maxGain = 0;
        for (int i = 0; i < s.length(); i++) {
            if (x > y) {
                // 先处理 ab
                if (s.charAt(i) == 'b' && !stacks.isEmpty() && stacks.peek() == 'a') {
                    maxGain += x;
                    stacks.pop();
                } else {
                    stacks.add(s.charAt(i));
                }
            } else {
                if (s.charAt(i) == 'a' && !stacks.isEmpty() && stacks.peek() == 'b') {
                    maxGain += y;
                    stacks.pop();
                } else {
                    stacks.add(s.charAt(i));
                }
            }
        }

        // 必须重新使用一个堆栈, 因为前面消除的字符后面有可能重新拼接成一个可以消耗的字符
        Stack<Character> ss = new Stack<>();
        // 倒序找到
        if (x > y) {
            // 倒序找 ba 的倒序.
            while (!stacks.isEmpty()) {
                Character curVal = stacks.pop();
                if (curVal != 'b') {
                    ss.add(curVal);
                } else {
                    if (!ss.isEmpty() && ss.peek() == 'a') {
                        maxGain += y;
                        ss.pop();
                    } else {
                        ss.add(curVal);
                    }
                }
            }
        } else {
            // 倒序找 ab 的倒序.
            while (!stacks.isEmpty()) {
                Character curVal = stacks.pop();
                if (curVal != 'a') {
                    ss.add(curVal);
                } else {
                    if (!ss.isEmpty() && ss.peek() == 'b') {
                        maxGain += x;
                        ss.pop();
                    } else {
                        ss.add(curVal);
                    }
                }
            }
        }

        return maxGain;
    }
}
