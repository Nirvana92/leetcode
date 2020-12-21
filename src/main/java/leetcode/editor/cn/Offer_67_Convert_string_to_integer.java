package leetcode.editor.cn;

/**
 * @author Nirvana
 * @date 2020/10/24 22:43
 * <p>
 * 剑指 Offer 67. 把字符串转换成整数
 * <p>
 * 参考: leetcode_8 题
 */
public class Offer_67_Convert_string_to_integer {
    public int strToInt(String str) {
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
