package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2020/10/10 8:22 下午
 * @desc
 */
public class No_319_Light_bulb_switch {
    @Test
    public void test() {
//        int n = 4;
//        int bulbSwitch = bulbSwitch(n);
//        System.out.println(bulbSwitch);

        for (int i = 1; i <= 100; i++) {
            int bulbSwitch = bulbSwitch(i);
            int bulbSwitchDb = bulbSwitchDb(i);
            if (bulbSwitch != bulbSwitchDb) {
                System.out.println("i: " + i + ", bulb: " + bulbSwitch);
            }
        }

    }

    /**
     * 平方根
     *
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    /**
     * 打标法
     *
     * @param n
     * @return
     */
    public int bulbSwitchDb(int n) {
        // 打表法试一下
        int[] bulbs = new int[n + 1];
        Arrays.fill(bulbs, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j = j + i) {
                if (bulbs[j] == 0) {
                    bulbs[j] = 1;
                } else {
                    bulbs[j] = 0;
                }
            }
        }

        int len = 0;
        for (int i = 1; i <= n; i++) {
            if (bulbs[i] == 1) {
                len++;
            }
        }

        return len;
    }
}
