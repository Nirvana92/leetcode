package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/1/4 9:17 上午
 * @desc: 509. 斐波那契数
 * <p>
 * dp 简单处理 + 空间压缩
 */
public class No_509_Fibonacci_number {
    @Test
    public void test() {
        int n = 10;

        int fib = fib(n);
        System.out.println(fib);
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int ppVal = 0, pVal = 1, fibVal = 1;
        for (int i = 2; i < n; i++) {
            ppVal = pVal;
            pVal = fibVal;
            fibVal = ppVal + pVal;
        }

        return fibVal;
    }
}
