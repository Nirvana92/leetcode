package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;
import org.nirvana.util.Utils;

import java.util.Objects;

/**
 * @author gzm
 * @date 2020/10/20 5:07 下午
 * @desc: 1406. 石子游戏 III
 * <p>
 * <p>
 * Alice 和 Bob 用几堆石子在做游戏。几堆石子排成一行，每堆石子都对应一个得分，由数组 stoneValue 给出。
 * Alice 和 Bob 轮流取石子，Alice 总是先开始。在每个玩家的回合中，该玩家可以拿走剩下石子中的的前 1、2 或 3 堆石子 。比赛一直持续到所有石头
 * 都被拿走。
 * 每个玩家的最终得分为他所拿到的每堆石子的对应得分之和。每个玩家的初始分数都是 0 。比赛的目标是决出最高分，得分最高的选手将会赢得比赛，比赛
 * 也可能会出现平局。
 * 假设 Alice 和 Bob 都采取 最优策略 。如果 Alice 赢了就返回 "Alice" ，Bob 赢了就返回 "Bob"，平局（分数相同）返回 "Tie" 。
 */
public class No_1406_Stone_Game_III {
    @Test
    public void test() {
        int[] stoneValue = new int[]{1, 2, 3, 7};

//        stoneValue = new int[]{1, 2, 3, -9};
//        stoneValue = new int[]{1, 2, 3, 6};
//        stoneValue = new int[]{1, 2, 3, -1, -2, -3, 7};
//        stoneValue = new int[]{-1, -2, -3};

        String stoneGameIII = stoneGameIII(stoneValue);
        System.out.println(stoneGameIII);
        String stoneGameIIIDp = stoneGameIIIDp(stoneValue);
        System.out.println(stoneGameIIIDp);
    }

    @Test
    public void t() {
        int times = 1000000;
        while (times-- > 0) {
            int[] stoneValue = Utils.generIntArr(1, 10, -5, 10);
            String stoneGameIII = stoneGameIII(stoneValue);
//            System.out.println(stoneGameIII);
            String stoneGameIIIDp = stoneGameIIIDp(stoneValue);
//            System.out.println(stoneGameIIIDp);

            if (!Objects.equals(stoneGameIII, stoneGameIIIDp)) {
                System.out.println("stoneGameIII: " + stoneGameIII + "; stoneGameIIIDp: " + stoneGameIIIDp);
                PrintUtils.print(stoneValue);
            }
        }
    }

    public String stoneGameIII(int[] stoneValue) {
        int k = 3;

        int first = first(stoneValue, 0, k);
        int last = last(stoneValue, 0, k);
        // System.out.println("first: " + first + "; last: " + last);
        return first == last ? "Tie" : first > last ? "Alice" : "Bob";
    }

    String stoneGameIIIDp(int[] stoneVals) {
        int N = stoneVals.length;
        int k = 3;
        int[][] first = new int[N + 1][k + 1];
        int[][] last = new int[N + 1][k + 1];

        for (int i = N - 1; i >= 0; i--) {
            // m 从大到小
            for (int m = k; m > 0; m--) {
                // 填充 first 的数组
                int maxIndex = Math.min(N, k + i);

                int preSumVals = 0;
                Integer maxVals = null, minVals = null;
                for (int index = i; index < maxIndex; index++) {
                    preSumVals += stoneVals[index];
                    int max = Math.max(index - i + 1, m);
                    if (maxVals == null) {
                        maxVals = preSumVals + last[index + 1][max];
                    } else {
                        maxVals = Math.max(maxVals, preSumVals + last[index + 1][max]);
                    }

                    if (minVals == null) {
                        minVals = first[index + 1][max];
                    } else {
                        minVals = Math.min(minVals, first[index + 1][max]);
                    }
                }

                // 填充first 数组
                first[i][m] = maxVals == null ? 0 : maxVals;
                last[i][m] = minVals == null ? 0 : minVals;
            }
        }

        return first[0][k] == last[0][k] ? "Tie" : (first[0][k] > last[0][k] ? "Alice" : "Bob");
    }

    int first(int[] stoneVals, int i, int k) {
        int maxIndex = Math.min(stoneVals.length, k + i);
        Integer maxVals = null;
        int preSumVals = 0;
        for (int index = i; index < maxIndex; index++) {
            preSumVals += stoneVals[index];

            if (maxVals == null) {
                maxVals = preSumVals + last(stoneVals, index + 1, k);
            } else {
                maxVals = Math.max(maxVals, preSumVals + last(stoneVals, index + 1, k));
            }
        }

        return maxVals == null ? 0 : maxVals;
    }

    int last(int[] stoneVals, int i, int k) {
        int maxIndex = Math.min(stoneVals.length, k + i);
        Integer minVals = null;
        for (int index = i; index < maxIndex; index++) {
            if (minVals == null) {
                minVals = first(stoneVals, index + 1, k);
            } else {
                minVals = Math.min(minVals, first(stoneVals, index + 1, k));
            }
        }

        return minVals == null ? 0 : minVals;
    }
}
