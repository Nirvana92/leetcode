package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/17 6:00 下午
 * @desc: 1234. 替换子串得到平衡字符串
 * <p>
 * 滑动窗口
 */
public class No_1234_Replace_substring_to_get_balanced_string {
    @Test
    public void test() {
        String s = "QWER";
        s = "QQWE";
        s = "QQQW";
        s = "QQQQ";

        int balancedString = balancedString(s);
        System.out.println(balancedString);
    }

    public int balancedString(String s) {
        int N = s.length();
        int qNums = 0, wNums = 0, eNums = 0, rNums = 0;
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'Q') {
                qNums++;
            } else if (s.charAt(i) == 'W') {
                wNums++;
            } else if (s.charAt(i) == 'E') {
                eNums++;
            } else {
                rNums++;
            }
        }

        int everyCharNums = N / 4, R = 0, minLen = Integer.MAX_VALUE;
        int curQNums = qNums, curWNums = wNums, curENums = eNums, curRNums = rNums;
        for (int i = 0; i < N; i++) {
            while (R < N && !check(curQNums, curWNums, curENums, curRNums, everyCharNums)) {
                if (s.charAt(R) == 'Q') {
                    curQNums--;
                } else if (s.charAt(R) == 'W') {
                    curWNums--;
                } else if (s.charAt(R) == 'E') {
                    curENums--;
                } else {
                    curRNums--;
                }

                R++;
            }

            if (check(curQNums, curWNums, curENums, curRNums, everyCharNums)) {
                minLen = Math.min(minLen, R - i);
            }

            if (s.charAt(i) == 'Q') {
                curQNums++;
            } else if (s.charAt(i) == 'W') {
                curWNums++;
            } else if (s.charAt(i) == 'E') {
                curENums++;
            } else {
                curRNums++;
            }
        }

        return minLen;
    }

    public boolean check(int qNums, int wNums, int eNums, int rNums, int everyCharNums) {
        return qNums <= everyCharNums && wNums <= everyCharNums && eNums <= everyCharNums && rNums <= everyCharNums;
    }
}
