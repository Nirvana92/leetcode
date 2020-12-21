package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/18 2:08 下午
 * @desc 根据给定的字符串生成有效的数字
 */
public class No_8 {
    @Test
    public void test() {
        // String str = " -91283472332";
        // String str = "  -2147483648";
        String str = " ";
        int result = myAtoi(str);
        System.out.println(result);

        // System.out.println(Integer.MAX_VALUE);
    }


    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int N = chars.length;
        // 处理开头的空格
        int startIndex = 0;
        while (startIndex < N && chars[startIndex] == ' ') {
            startIndex++;
        }

        // System.out.println(startIndex);
        // 查看第一个字符是否是 - 或 + 号
        boolean isNegative = false;
        if (startIndex < N && (chars[startIndex] == '-' || chars[startIndex] == '+')) {
            isNegative = chars[startIndex] == '-';
            startIndex++;
        }
        int resultNum = 0;
        // 是否超过负数的最大值
        boolean outOfBounds = false;
        while (startIndex < N && chars[startIndex] >= '0' && chars[startIndex] <= '9') {
            int waitAddNum = chars[startIndex++] - '0';
            if ((Integer.MIN_VALUE + waitAddNum) / 10 > resultNum) {
                outOfBounds = true;
            }
            // 判断 resultNum 和waitAddNum 的和是否超过 Integer.MIN
            resultNum = resultNum * 10 - waitAddNum;
        }

        return isNegative
                ? (outOfBounds ? Integer.MIN_VALUE : resultNum)
                : (outOfBounds || resultNum == Integer.MIN_VALUE ? Integer.MAX_VALUE : -resultNum);
    }
}
