package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/15 2:49 下午
 * @desc: 264. 丑数 II
 * <p>
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 */
public class No_264_Ugly_Number_II {
    @Test
    public void test() {
        int n = 10;
        int nthUglyNumber = nthUglyNumber(n);
        System.out.println(nthUglyNumber);
    }

    /**
     * 依次找到 2 3 5 的倍数, 数到第n个数的时候返回
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] results = new int[n];
        int _2 = 0, _3 = 0, _5 = 0;
        results[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Math.min(results[_2] * 2, Math.min(results[_3] * 3, results[_5] * 5));
            results[i] = min;

            while (results[_2] * 2 <= min) {
                _2++;
            }
            while (results[_3] * 3 <= min) {
                _3++;
            }
            while (results[_5] * 5 <= min) {
                _5++;
            }
        }

        return results[n - 1];
    }
}
