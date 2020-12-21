package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/24 5:48 下午
 * @desc
 */
public class No_29_Divide_two_numbers {
    @Test
    public void test() {
        int dividend = Integer.MAX_VALUE, divisor = 2;
        int divide = divide(dividend, divisor);
        System.out.println(divide);

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }

    /**
     * dividend / divisor
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        boolean isNegative = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            isNegative = true;
        }

        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        if (divisor == 1) {
            return isNegative ? -dividend : dividend;
        }

        int result = 0, tmpVal = divisor;
        while (dividend <= tmpVal) {
            int tmpRst = -1;

            while (dividend <= (tmpVal << 1)) {
                if (tmpVal <= (Integer.MIN_VALUE >> 1)) {
                    break;
                }

                tmpRst = tmpRst << 1;
                tmpVal = tmpVal << 1;
            }

            dividend = dividend - tmpVal;
            tmpVal = divisor;
            result += tmpRst;
        }
        if (!isNegative) {
            // 非负数
            if (result == Integer.MIN_VALUE) {
                result = Integer.MAX_VALUE;
            } else {
                result = -result;
            }
        }

        return result;
    }
}
