package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/30 21:45
 * <p>
 * 1052. 爱生气的书店老板
 */
public class No_1052_Angry_bookstore_owner {
    @Test
    public void test() {
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int x = 3;

        customers = new int[]{35, 21, 44, 3, 33, 2, 402};
        grumpy = new int[]{0, 1, 0, 1, 0, 1, 0};

        int maxSatisfied = maxSatisfied(customers, grumpy, x);
        System.out.println(maxSatisfied);
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int notUsePowerMaxVals = 0;
        // 首先计算不使用能力的情况下, 能获得的最大的满意数量
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                notUsePowerMaxVals += customers[i];
            }
        }

        int usePowerMaxVals = 0, r = 0, tmpMoreVals = 0;
        // 通过滑动窗口, 来确定哪些额外的满意数量可以在规定的范围[X] 之内获得满意的数量
        for (int i = 0; i < customers.length; i++) {
            while ((r - i) < X && r < customers.length) {
                if (grumpy[r] == 1) {
                    tmpMoreVals += customers[r];
                }
                r++;
            }

            usePowerMaxVals = Math.max(usePowerMaxVals, tmpMoreVals);

            if (grumpy[i] == 1) {
                tmpMoreVals -= customers[i];
            }
        }

        // 最终返回最大的满意数量
        return usePowerMaxVals + notUsePowerMaxVals;
    }
}
