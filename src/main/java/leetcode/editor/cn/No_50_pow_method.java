package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/27 8:09 下午
 * @desc: 50. Pow(x, n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class No_50_pow_method {
    @Test
    public void test() {
        double x = 2D;
        int n = 10;

//        x = 2.1D;
//        n = 3;

        x = 2D;
        n = -2;

        x = 2D;
        n = -2147483648;

        double myPow = myPow(x, n);
        System.out.println(myPow);
    }

    public double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        // 需要考虑 Integer.MIN_VALUE 的时候, 此时如果转成正数, 会出现异常情况。
        long N = n;
        double powNum = 1D;
        boolean negative = N < 0;
        N = Math.abs(N);
        double xNum = x;
        while (N > 0) {
            if ((N & 1) == 1) {
                powNum *= xNum;
            }

            xNum = xNum * xNum;
            N = N >> 1;
        }

        return negative ? 1.0 / powNum : powNum;
    }
}
