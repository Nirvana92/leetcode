package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2020/12/10 9:52 上午
 * @desc: 860. 柠檬水找零
 */
public class No_860_Lemonade_change {
    @Test
    public void test() {
        int[] bills = new int[]{5, 5, 5, 10, 20};
        bills = new int[]{5, 5, 10};
        bills = new int[]{10, 10};
        bills = new int[]{5, 5, 10, 10, 20};

        boolean lemonadeChange = lemonadeChange(bills);
        System.out.println(lemonadeChange);
    }

    public boolean lemonadeChange(int[] bills) {
        int N = bills.length;

        if (bills == null || N == 0) {
            return true;
        }

        Map<Integer, Integer> coinMaps = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (bills[i] == 10) {
                if (coinMaps.containsKey(5)) {
                    int fiveCounts = coinMaps.get(5);
                    fiveCounts -= 1;
                    if (fiveCounts == 0) {
                        coinMaps.remove(5);
                    } else {
                        coinMaps.put(5, fiveCounts);
                    }
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                if (coinMaps.containsKey(10) && coinMaps.containsKey(5)) {
                    Integer tenCounts = coinMaps.get(10);
                    Integer fiveCounts = coinMaps.get(5);

                    if (tenCounts == 1) {
                        coinMaps.remove(10);
                    } else {
                        coinMaps.put(10, tenCounts - 1);
                    }

                    if (fiveCounts == 1) {
                        coinMaps.remove(5);
                    } else {
                        coinMaps.put(5, fiveCounts - 1);
                    }

                } else if (coinMaps.containsKey(5) && coinMaps.get(5) >= 3) {
                    int fiveCounts = coinMaps.get(5);

                    if (fiveCounts == 3) {
                        coinMaps.remove(5);
                    } else {
                        coinMaps.put(5, fiveCounts - 3);
                    }
                } else {
                    return false;
                }
            }
            coinMaps.put(bills[i], coinMaps.getOrDefault(bills[i], 0) + 1);
        }

        return true;
    }
}
