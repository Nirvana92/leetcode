package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/14 23:49
 */
public class No_258_Add_up_everyone {
    @Test
    public void test() {
        int num = 38;
        num = 1;
        num = 110;
        num = 354661316;
        int addDigits = addDigits(num);
        System.out.println(addDigits);
    }

    public int addDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum / 10 == 0 ? sum : addDigits(sum);
    }
}
