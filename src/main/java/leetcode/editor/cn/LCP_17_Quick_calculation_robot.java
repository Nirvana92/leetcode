package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/27 7:10 下午
 * @desc: LCP 17. 速算机器人
 */
public class LCP_17_Quick_calculation_robot {
    @Test
    public void test() {
        String s = "AA";
        int calculate = calculate(s);
        System.out.println(calculate);
    }

    public int calculate(String s) {
        int x = 1, y = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                x = 2 * x + y;
            } else {
                y = 2 * y + x;
            }
        }

        return x + y;
    }
}
