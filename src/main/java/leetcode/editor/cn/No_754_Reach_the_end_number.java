package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/6 8:50 下午
 * @desc: 754. 到达终点数字
 * <p>
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * 每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
 * 返回到达终点需要的最小移动次数。
 * <p>
 * target是在[-10^9, 10^9]范围中的非零整数。
 * <p>
 * todo
 * 打表找规律
 */
public class No_754_Reach_the_end_number {
    @Test
    public void test() {
        int target = 3;

        target = 2;

        int reachNumber = reachNumber(target);
        System.out.println(reachNumber);
    }

    public int reachNumberFinal(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            target -= ++k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

    /**
     * 从 0 开始移步到target 需要的最小的移动步数
     *
     * @param target
     * @return
     */
    public int reachNumber(int target) {
        return process(target, 1, 0);
    }

    int process(int target, int numOfStep, int curIndex) {
        if (curIndex == target) {
            return 0;
        }

        int minStep = Integer.MAX_VALUE;

        // 当前位置和目标位置的间隔
        int disVal = Math.abs(target - curIndex);
        if (disVal >= numOfStep) {
            if (target > curIndex) {
                // 目标在当前位置右边, 执行 +numOfStep
                if (Integer.MAX_VALUE - numOfStep >= curIndex) {
                    int process = process(target, numOfStep + 1, curIndex + numOfStep);
                    if (process != Integer.MAX_VALUE) {
                        minStep = Math.min(minStep, process + 1);
                    }
                }
            } else {
                // 目标在当前位置左边, 执行 -numOfStep
                if (Integer.MIN_VALUE + numOfStep <= curIndex) {
                    int process = process(target, numOfStep + 1, curIndex - numOfStep);
                    if (process != Integer.MAX_VALUE) {
                        minStep = Math.min(minStep, process + 1);
                    }
                }
            }
        } else {
            // 两种都尝试执行
            if (Integer.MAX_VALUE - numOfStep >= curIndex) {
                int process = process(target, numOfStep + 1, curIndex + numOfStep);
                if (process != Integer.MAX_VALUE) {
                    minStep = Math.min(minStep, process + 1);
                }
            }

            if (Integer.MIN_VALUE + numOfStep <= curIndex) {
                int process = process(target, numOfStep + 1, curIndex - numOfStep);
                if (process != Integer.MAX_VALUE) {
                    minStep = Math.min(minStep, process + 1);
                }
            }
        }

        return minStep;
    }
}
