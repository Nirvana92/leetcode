package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.violence.ChangeNumberToLetter;

/**
 * @author gzm
 * @date 2020/11/5 7:10 下午
 * @desc: 剑指 Offer 46. 把数字翻译成字符串
 * <p>
 * 动态规划
 * <p>
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 参考: {@link ChangeNumberToLetter}
 */
public class Offer_46_Translate_numbers_into_strings {
    @Test
    public void test() {
        int num = 12211;
        int translateNum = translateNum(num);
        System.out.println(translateNum);

        int translateNumDp = translateNumDp(num);
        System.out.println(translateNumDp);
    }

    /**
     * 递归方法
     *
     * @param num
     * @return
     */
    public int translateNumDp(int num) {
        String numStr = String.valueOf(num);
        int N = numStr.length();
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            int p1 = dp[i + 1];
            // 尝试i 和i+1 组成一个字符
            if (i + 1 < N && (numStr.charAt(i) == '1' || (numStr.charAt(i) == '2' && numStr.charAt(i + 1) <= '5'))) {
                int p2 = dp[i + 2];
                p1 += p2;
            }
            dp[i] = p1;
        }

        return dp[0];
    }

    public int translateNum(int num) {
        return process(String.valueOf(num), 0);
    }

    /**
     * 转换成字符的方法数[暴力递归方法]
     *
     * @param num
     * @return
     */
    int process(String num, int i) {
        if (i == num.length()) {
            return 1;
        }

        // i 位置单独转换成一个字符
        int p1 = process(num, i + 1);

        // 尝试i 和i+1 组成一个字符
        if (i + 1 < num.length() && (num.charAt(i) == '1' || (num.charAt(i) == '2' && num.charAt(i + 1) <= '5'))) {
            int p2 = process(num, i + 2);
            p1 += p2;
        }

        return p1;
    }


}
