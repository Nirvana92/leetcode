package leetcode.editor.cn;

import org.junit.Test;

/**
 * Brian Kernighan 算法
 */
public class No_201_Bitwise_AND {
    @Test
    public void test() {
        int m = 700000000, n = 2147483641;

        int rangeBitwiseAnd = rangeBitwiseAnd(m, n);
        System.out.println(rangeBitwiseAnd);
    }

    /**
     * 其实是求两个范围数的第一个相同的值
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }

        return m << shift;
    }
}
