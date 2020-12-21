package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/14 20:57
 * <p>
 * 650. 只有两个键的键盘[动态规划]
 * <p>
 * 动态规划不是最优解. 贪心+ 分析可以得到最优解。
 * 参考: https://leetcode-cn.com/problems/2-keys-keyboard/solution/zhi-you-liang-ge-jian-de-jian-pan-by-leetcode/
 */
public class No_650_Keyboard_with_only_two_keys {
    @Test
    public void test() {
//        int n = 14;
//        int minSteps = minSteps(n);
//        System.out.println(minSteps);
//        int minStepsDp = minStepsDp(n);
//        System.out.println(minStepsDp);

        int n = 1001;
        while (n-- > 0) {
            int minSteps = minSteps(n);
            int minStepsDp = minStepsDp(n);

            // System.out.println(n);
            if (minSteps != minStepsDp) {
                System.out.println("n: " + n);
                System.out.println("error");
            }
        }

    }

    public int minStepsDp(int n) {
        if (n < 2) {
            return 0;
        }

        int copyNums = (n >> 1) + 1;
        int targetNums = n - 1;
        int[][] dp = new int[copyNums][n];

        for (int copyNum = copyNums - 1; copyNum > 0; copyNum--) {
            for (int remindNum = 1; remindNum <= targetNums; remindNum++) {
                if (remindNum < copyNum) {
                    dp[copyNum][remindNum] = Integer.MAX_VALUE;
                } else {
                    // dp[copyNum][remindNum] = Integer.MAX_VALUE;
                    int p1 = dp[copyNum][remindNum - copyNum];
                    if (p1 != Integer.MAX_VALUE) {
                        // 需要加上当前的粘贴操作
                        p1++;
                    }

                    // 执行复制操作
                    // 当前笔记本上的字母的数量
                    int curNum = n - remindNum;
                    int p2 = Integer.MAX_VALUE;
                    if (curNum < copyNums) {
                        p2 = dp[curNum][remindNum - curNum];
                        if (p2 != Integer.MAX_VALUE) {
                            p2 += 2;
                        }
                    }

                    dp[copyNum][remindNum] = Math.min(p1, p2);
                }
            }

        }

        return dp[1][targetNums] + 1;
    }

    public int minSteps(int n) {
        if (n < 2) {
            return 0;
        }

        int ret = process(n, 1, n - 1);
        if (ret != Integer.MAX_VALUE) {
            // 当前值的复制操作一次需要加上
            ret++;
        }

        return ret;
    }

    int process(int n, int curCopyNum, int remindNum) {
        // 粘贴
        if (remindNum == 0) {
            return 0;
        }

        if (remindNum < 0) {
            return Integer.MAX_VALUE;
        }

        // 粘贴当前的数字
        int p1 = process(n, curCopyNum, remindNum - curCopyNum);
        if (p1 != Integer.MAX_VALUE) {
            // 需要加上当前的粘贴操作
            p1++;
        }

        // 执行复制操作
        // 当前笔记本上的字母的数量
        int curNum = n - remindNum;
        int p2 = Integer.MAX_VALUE;
        if (curNum > 0) {
            p2 = process(n, curNum, remindNum - curNum);
            if (p2 != Integer.MAX_VALUE) {
                p2 += 2;
            }
        }

        return Math.min(p1, p2);
    }
}
