package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/17 2:29 下午
 * @desc: 1680. 连接连续二进制数字
 */
public class No_1680_Connect_consecutive_binary_numbers {
    @Test
    public void test() {
        int n = 1;
        n = 3;
        n = 12;

        int concatenatedBinary = concatenatedBinary(n);
        System.out.println(concatenatedBinary);
    }

    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;

        long ret = 0;
        for (int i = 1; i <= n; i++) {
            int bitLen = getBitLen(i);
            ret <<= bitLen;

            ret += i;
            ret %= MOD;
        }

        return (int) ret;
    }

    int getBitLen(int n) {
        int len = 0;
        while (n > 0) {
            len++;
            n >>= 1;
        }

        return len;
    }

    @Test
    public void t() {
        int n = 4;
        System.out.println(getBitLen(n));
    }
}
