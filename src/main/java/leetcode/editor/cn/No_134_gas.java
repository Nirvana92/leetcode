package leetcode.editor.cn;

import org.junit.Test;

/**
 * 134. 加油站
 */
public class No_134_gas {
    @Test
    public void test() {
        int[] gos = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};

        gos = new int[]{2, 3, 4};
        cost = new int[]{3, 4, 3};

        int canCompleteCircuit = canCompleteCircuit(gos, cost);
        System.out.println(canCompleteCircuit);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 遍历尝试每个位子是否可以作为起点
        // 当 i 位置的汽油数 >= i 位置的汽油消耗数的时候可以作为起点
        for (int index = 0; index < gas.length; index++) {
            if (gas[index] >= cost[index] && canToEnd(gas, cost, index)) {
                return index;
            }
        }
        return -1;
    }

    boolean canToEnd(int[] gas, int[] cost, int startIndex) {
        int preRemainingGasoline = 0;
        for (int index = 0; index < gas.length; index++) {
            int tmpIndex = (startIndex + index) % gas.length;
            preRemainingGasoline = preRemainingGasoline + gas[tmpIndex] - cost[tmpIndex];
            if (preRemainingGasoline < 0) {
                return false;
            }
        }

        return true;
    }
}
