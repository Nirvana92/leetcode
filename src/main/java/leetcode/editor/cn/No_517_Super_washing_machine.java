package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/22 7:17 下午
 * @desc: 517. 超级洗衣机
 * <p>
 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 * 在每一步操作中，你可以选择任意 m （1 ≤ m ≤ n） 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 * 给定一个非负整数数组代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的最少的操作步数。
 * 如果不能使每台洗衣机中衣物的数量相等，则返回 -1。
 * <p>
 * 示例:
 * 输入: [1,0,5]
 * 输出: 3
 * 解释:
 * 第一步:    1     0 <-- 5    =>    1     1     4
 * 第二步:    1 <-- 1 <-- 4    =>    2     1     3
 * 第三步:    2     1 <-- 3    =>    2     2     2
 */
public class No_517_Super_washing_machine {
    @Test
    public void test() {
        int[] machines = new int[]{1, 0, 5};
        machines = new int[]{0, 3, 0};
        machines = new int[]{0, 2, 0};

        int minMoves = findMinMoves(machines);
        System.out.println(minMoves);
    }

    public int findMinMoves(int[] machines) {
        int sum = 0;
        int N = machines.length;
        for (int i = 0; i < N; i++) {
            sum += machines[i];
        }

        if (sum % N != 0) {
            return -1;
        }

        // 每台机器应该保留的衣服件数
        int numOfMachine = sum / N, minMoves = 0, preSum = 0;
        for (int i = 0; i < N; i++) {
            // 左边多 右边少
            int leftNeed = i == 0 ? 0 : (preSum - numOfMachine * i);
            int rightNeed = i == N - 1 ? 0 : (sum - preSum - machines[i] - (N - i - 1) * numOfMachine);
            if ((leftNeed >= 0 && rightNeed >= 0) || (leftNeed >= 0 && rightNeed <= 0) ||
                    (leftNeed <= 0 && rightNeed >= 0)) {
                minMoves = Math.max(minMoves, Math.max(Math.abs(leftNeed), Math.abs(rightNeed)));
            } else if (leftNeed < 0 && rightNeed < 0) {
                minMoves = Math.max(minMoves, Math.abs(leftNeed + rightNeed));
            }

            preSum += machines[i];
        }

        return minMoves;
    }
}
