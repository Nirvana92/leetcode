package lintcode;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/22 21:26
 * <p>
 * 设计一个算法，计算出n阶乘中尾部零的个数
 * O(logN)的时间复杂度
 */
public class No_2 {
    @Test
    public void test() {
        long n = 100000;
//        long trailingZeros = trailingZeros(n);
//        System.out.println(trailingZeros);

        for (long i = 1; i <= n; i++) {
            long trailingZeros = trailingZeros(i);
            long trailingZerosM = trailingZerosM(i);

            if (trailingZeros != trailingZerosM) {
                System.out.println("i: " + i + "; trailingZeros: " + trailingZeros + "; " + "trailingZerosM: " + trailingZerosM);
                System.out.println("error");
                break;
            }
            //System.out.println("i: " + i + "; " + trailingZeros);
        }
    }

    public long trailingZerosM(long n) {
        long ret = 0;
        while (n / 5 != 0) {
            ret += n / 5;
            n /= 5;
        }
        return ret;
    }

    public long trailingZeros(long n) {
        long val = 1;
        long ret = 0;
        for (long i = 5; i <= n; i += 5) {
            val = i;
            while (val % 5 == 0) {
                ret++;
                val /= 5;
            }
        }

        return ret;
    }
}
