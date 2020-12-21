package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

public class No_371_sum_of_two_integers {
    @Test
    public void test() {
        int a = -2, b = -2;

        int times = 100000;
        while (times-- > 0) {
            a = Utils.generInt(-1000, 1000);
            b = Utils.generInt(-1000, 1000);

            int result = getSum(a, b);
            if (a + b != result) {
                System.out.println(a + "; " + b);
                System.out.println(result);
            }
        }


    }

    public int getSum(int a, int b) {
        int aa = a ^ b;
        int bb = a & b;
        bb <<= 1;

        if (aa == 0 || bb == 0) {
            return aa ^ bb;
        }

        return getSum(aa, bb);
    }
}
