package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/27 7:14 下午
 * @desc: LCP 18. 早餐组合
 */
public class LCP_18_Breakfast_combo {
    @Test
    public void test() {
        int[] staple = new int[]{10, 20, 5};
        int[] drinks = new int[]{5, 5, 2};
        int x = 15;

        staple = new int[]{2, 1, 1};
        drinks = new int[]{8, 9, 5, 1};
        x = 9;

        int breakfastNumber = breakfastNumber(staple, drinks, x);
        System.out.println(breakfastNumber);
    }

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int[] staplePriceCounts = new int[x + 1];

        for (int i = 0; i < staple.length; i++) {
            if (staple[i] <= x) {
                staplePriceCounts[staple[i]]++;
            }
        }

        for (int i = 1; i < staplePriceCounts.length; i++) {
            staplePriceCounts[i] = staplePriceCounts[i - 1] + staplePriceCounts[i];
        }

        int numbers = 0;
        int mod = 1000000007;
        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i] <= x) {
                numbers = (numbers + staplePriceCounts[x - drinks[i]]) % mod;
            }
        }

        return numbers;
    }
}
