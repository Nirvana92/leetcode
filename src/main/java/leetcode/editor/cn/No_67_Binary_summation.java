package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Nirvana
 * @date 2020/10/14 22:35
 * 67. 二进制求和
 */
public class No_67_Binary_summation {
    @Test
    public void test() {
        String a = "11", b = "1";
        a = "1010";
        b = "1011";

        a = "0";
        b = "1";

        String addBinary = addBinary(a, b);
        System.out.println(addBinary);
    }

    public String addBinary(String a, String b) {
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        char[] results = new char[Math.max(as.length, bs.length) + 1];

        int preVal = 0;

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int rstIndex = results.length - 1;

        while (aIndex >= 0 && bIndex >= 0) {
            int sum = (as[aIndex--] - '0') + (bs[bIndex--] - '0') + preVal;
            results[rstIndex--] = (char) (sum % 2 + '0');
            preVal = sum / 2;
        }

        while (aIndex >= 0) {
            int sum = (as[aIndex--] - '0') + preVal;
            results[rstIndex--] = (char) (sum % 2 + '0');
            preVal = sum / 2;
        }

        while (bIndex >= 0) {
            int sum = (bs[bIndex--] - '0') + preVal;
            results[rstIndex--] = (char) (sum % 2 + '0');
            preVal = sum / 2;
        }

        results[0] = (char) (preVal + '0');

        return results[0] == '0' ? new String(Arrays.copyOfRange(results, 1, results.length)) : new String(results);
    }
}
