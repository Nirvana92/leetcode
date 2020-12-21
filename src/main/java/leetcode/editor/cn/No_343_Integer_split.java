package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/15 4:57 下午
 * @desc: 343. 整数拆分
 * <p>
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */
public class No_343_Integer_split {
    @Test
    public void test() {
        int n = 8;
//        n = 10;
//        n = 3;
        n = 4;
        n = 11;
        int integerBreak = integerBreak(n);
        System.out.println(integerBreak);
    }

    public int integerBreak(int n) {
        int maxVal = 1;
        // 最大的分割数
        int maxBreakNum = n / 2;
        // 遍历普遍拆分的数为 i
        for (int i = 1; i <= maxBreakNum; i++) {
            // 遍历的最大个数
            int tmpVal = 1;
            int breakNumCount = n / i;
            for (int j = 1; j <= breakNumCount; j++) {
                tmpVal = Math.max(tmpVal, (int) (Math.pow(i, j) * (n - i * j)));
            }

            // 最终拿到一个最大的累乘积
            maxVal = Math.max(maxVal, tmpVal);
        }

        return maxVal;
    }
}
