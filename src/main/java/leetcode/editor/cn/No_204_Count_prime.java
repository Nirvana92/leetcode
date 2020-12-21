package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/3 10:06 上午
 * @desc: 204. 计数质数
 */
public class No_204_Count_prime {
    @Test
    public void test() {
        int n = 100;
//        n = 0;
//        n = 1;

        n = 101;

        int countPrimes = countPrimes(n);
        System.out.println(countPrimes);
    }

    @Test
    public void t() {
        int n = 5000000;
        n = 1000000;

        for (int i = n; i > 0; i--) {
            int countPrimes = countPrimes(i);
            int countPrimesMethod = countPrimesMethod(i);
            if (countPrimes != countPrimesMethod) {
                System.out.println("i: " + i);
                System.out.println("error");
            }
        }
    }

    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] rets = new boolean[n];
        int ret = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (rets[i]) {
                continue;
            }

            for (int j = i; i * j < n; j += 2) {
                if (!rets[i * j]) {
                    rets[i * j] = true;
                    ret--;
                }
            }
        }

        return ret;
    }

    public int countPrimesMethod(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] f = new boolean[n];
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (f[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }
}
