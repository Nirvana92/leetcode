package leetcode.editor.cn;

import org.junit.Test;

import java.util.TreeMap;

/**
 * @author Nirvana
 * @date 2020/11/7 21:28
 * <p>
 * 846. 一手顺子
 */
public class No_846_A_straight_hand {
    @Test
    public void test() {
        int[] hand = new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8};
        int W = 3;

        hand = new int[]{1, 2, 3, 4, 5};
        W = 4;

        hand = new int[]{1};
        W = 1;

        boolean nStraightHand = isNStraightHand(hand, W);
        System.out.println(nStraightHand);
    }

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }

        TreeMap<Integer, Integer> maps = new TreeMap<>();

        for (int i = 0; i < hand.length; i++) {
            maps.put(hand[i], maps.getOrDefault(hand[i], 0) + 1);
        }

        while (!maps.isEmpty()) {
            Integer startNum = maps.firstKey();

            for (int i = 0; i < W; i++) {
                if (maps.containsKey(startNum + i)) {
                    Integer counts = maps.get(startNum + i);
                    if (counts == 1) {
                        maps.remove(startNum + i);
                    } else {
                        maps.put(startNum + i, counts - 1);
                    }
                } else {
                    return false;
                }
            }
        }


        return true;
    }
}
