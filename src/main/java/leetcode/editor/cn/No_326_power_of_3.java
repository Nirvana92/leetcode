package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/22 6:49 下午
 * @desc
 */
public class No_326_power_of_3 {
    @Test
    public void test() {
        int n = 45;
        boolean powerOfThree = isPowerOfThree(n);
        System.out.println(powerOfThree);
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
