package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/15 3:31 下午
 * @desc
 */
public class No_263_Ugly_Number {
    @Test
    public void test() {
        int num = -1;
        boolean ugly = isUgly(num);
        System.out.println(ugly);
    }

    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }

        while (num % 3 == 0) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }
}
