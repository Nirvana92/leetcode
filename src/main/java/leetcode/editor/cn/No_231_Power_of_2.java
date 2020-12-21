package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/5 9:43 上午
 * @desc: 231. 2的幂
 */
public class No_231_Power_of_2 {
    @Test
    public void test() {
        int n = 15;
        boolean powerOfTwo = isPowerOfTwo(n);
        System.out.println(powerOfTwo);
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int lastOne = (~n + 1) & n;
        return lastOne == n;
    }
}
