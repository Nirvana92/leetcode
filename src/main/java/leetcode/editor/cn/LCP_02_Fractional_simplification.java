package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/10/27 5:55 下午
 * @desc: LCP 02. 分式化简
 */
public class LCP_02_Fractional_simplification {
    @Test
    public void test() {
        int[] cont = new int[]{3, 2, 0, 2};
        //cont = new int[]{3, 2};
        // cont = new int[]{3, 2, 1};

        int[] fraction = fraction(cont);
        PrintUtils.print(fraction);
    }

    public int[] fraction(int[] cont) {
        int N = cont.length;

        if (N == 1) {
            return new int[]{cont[0], 1};
        }

        int[] fract = new int[]{
                cont[N - 2] * cont[N - 1] + 1, cont[N - 1]
        };
        for (int i = N - 3; i >= 0; i--) {
            // 每次计算一下分子分母进行位置变换下
            int fz = cont[i] * fract[0] + fract[1];
            int fm = fract[0];
            fract[0] = fz;
            fract[1] = fm;
        }

        int gcd = gcd(fract[0], fract[1]);
        // System.out.println(gcd);
        fract[0] = fract[0] / gcd;
        fract[1] = fract[1] / gcd;
        return fract;
    }

    private int gcd(int firstNum, int secondNum) {
        return firstNum == 0 ? secondNum : gcd(secondNum % firstNum, firstNum);
    }
}
