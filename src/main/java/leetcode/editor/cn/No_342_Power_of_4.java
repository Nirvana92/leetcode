package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/2 8:55 下午
 * @desc: 342. 4的幂
 */
public class No_342_Power_of_4 {
    @Test
    public void test() {
        int num = 10;
        boolean powerOfFour = isPowerOfFour(num);
        System.out.println(powerOfFour);

        System.out.println(Integer.MIN_VALUE);
    }

    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }

        while (num % 4 == 0) {
            num = num / 4;
        }

        return num == 1;
    }
}
