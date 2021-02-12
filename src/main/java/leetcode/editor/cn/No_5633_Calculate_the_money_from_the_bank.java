package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/1/11 10:48 上午
 * @desc: 5633. 计算力扣银行的钱
 */
public class No_5633_Calculate_the_money_from_the_bank {
    @Test
    public void test() {
        int n = 4;
        // n = 10;
        // n = 20;

        int totalMoney = totalMoney(n);
        System.out.println(totalMoney);
    }

    public int totalMoney(int n) {
        int weeks = n / 7;
        int baseWeek = 28;

        int remindDays = n - weeks * 7;
        int tMoney = 0;
        for (int i = 0; i < weeks; i++) {
            tMoney += baseWeek + i * 7;
        }

        int bws = Math.max(weeks, 0);
        for (int i = 1; i <= remindDays; i++) {
            tMoney += bws + i;
        }

        return tMoney;
    }
}
