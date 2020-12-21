package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2020/9/18 8:48 下午
 * @desc
 */
public class No_66 {

    @Test
    public void test() {
        int[] digits = new int[]{1, 2, 3};
        int[] ints = plusOne(digits);
        System.out.println(Arrays.toString(ints));
    }

    public int[] plusOne(int[] digits) {
        int[] results = new int[digits.length + 1];
        int preNum = 1;
        for (int index = digits.length - 1; index >= 0; index--) {
            int tmpSum = digits[index] + preNum;
            results[index + 1] = tmpSum % 10;
            preNum = tmpSum / 10;
        }

        if (preNum > 0) {
            results[0] = preNum;
        } else {
            results = Arrays.copyOfRange(results, 1, results.length);
        }

        return results;
    }
}
