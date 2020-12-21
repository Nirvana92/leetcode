package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

import java.util.Random;

public class No_91 {
    @Test
    public void test() {
        // String str = "226";

        int times = 1000, min = 1, max = 9, maxLen = 1000;
        Random random = new Random();
        while (times-- >= 0) {
            StringBuffer buffer = new StringBuffer();
            int nextInt = random.nextInt(maxLen);
            while (nextInt-- >= 0) {
                buffer.append(Utils.generInt(min, max));
            }

            String str = buffer.toString();
            int numDecodings = numDecodings(str);
            int processDp = processDp(str.toCharArray());
            if (numDecodings != processDp) {
                System.out.println(str);
                System.out.println("numDecodings: " + numDecodings + "; processDp: " + processDp);
                System.out.println("============error===============");
            }
        }
    }

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        return process(chars, 0);
    }

    int processDp(char[] chars) {
        int len = chars.length;
        int[] dp = new int[len + 1];
        dp[len] = 1;

        for (int index = len - 1; index >= 0; index--) {
            if (chars[index] == '0') {
                dp[index] = 0;
                continue;
            }

            int results = dp[index + 1];
            // index 位置为1 的处理方法
            if (chars[index] == '1' && index + 1 < len) {
                results += dp[index + 2];
            }
            // index 位置为2 的处理方法
            if (chars[index] == '2' && index + 1 < len && chars[index + 1] >= '0' && chars[index + 1] <= '6') {
                results += dp[index + 2];
            }
            dp[index] = results;
        }


        return dp[0];
    }

    /**
     * chars[index ...] 转换成字符的方法数
     *
     * @param chars
     * @param index
     * @return
     */
    int process(char[] chars, int index) {
        int len = chars.length;
        if (index == len) {
            return 1;
        }

        if (chars[index] == '0') {
            return 0;
        }

        int results = process(chars, index + 1);
        // index 位置为1 的处理方法
        if (chars[index] == '1' && index + 1 < len) {
            results += process(chars, index + 2);
        }
        // index 位置为2 的处理方法
        if (chars[index] == '2' && index + 1 < len && chars[index + 1] >= '0' && chars[index + 1] <= '6') {
            results += process(chars, index + 2);
        }

        return results;
    }
}
