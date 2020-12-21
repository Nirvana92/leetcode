package leetcode.editor.cn;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2020/11/9 2:07 下午
 * @desc: 1648. 销售价值减少的颜色球[二分]
 */
public class No_1648_Color_balls_with_reduced_sales_value {
    @Test
    public void test() {
        // 14
        int[] inventory = new int[]{2, 5};
        int orders = 4;

        // 19
//        inventory = new int[]{3, 5};
//        orders = 6;

        // 110
//        inventory = new int[]{2, 8, 4, 10, 6};
//        orders = 20;

        inventory = new int[]{1000000000};
        orders = 1000000000;

        inventory = new int[]{1, 3, 6, 3};
        orders = 5;

        inventory = new int[]{497978859, 167261111, 483575207, 591815159};
        orders = 836556809;

        int maxProfit = maxProfit(inventory, orders);
        System.out.println(maxProfit);
    }

    /**
     * 使用二分方法
     *
     * @param inventory
     * @param orders
     * @return
     */
    public int maxProfit(int[] inventory, int orders) {
        int MOD = (int) 1e9 + 7;
        int l = 0, r = (int) 1e9;
        // 二分找到中间数
        while (l < r) {
            int mid = (l + r) / 2;
            long total = 0;
            for (int val : inventory) {
                if (val > mid) {
                    total += val - mid;
                }
            }
            if (total > orders) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // 超过target 的数需要减少到target 才能满足 orders
        long t = l, rest = 0;
        long maxProfit = 0;
        for (int val : inventory) {
            if (val > t) {
                // 次数
                long count = val - t;
                maxProfit = (maxProfit + (val + t + 1) * count / 2) % MOD;
                rest += count;
            }
        }
        // 还需要计算多少个target 的数
        maxProfit = (maxProfit + ((orders - rest) * t) % MOD) % MOD;
        return (int) maxProfit;
    }


    /**
     * 依旧超时[大根堆的方法]
     *
     * @param inventory
     * @param orders
     * @return
     */
    public int maxProfitWithHeap(int[] inventory, int orders) {
        int MOD = 1000000007;

        PriorityQueue<Long> queues = new PriorityQueue<>((i1, i2) -> i2 > i1 ? 1 : (i1 > i2 ? -1 : 0));
        for (int i = 0; i < inventory.length; i++) {
            queues.add((long) inventory[i]);
        }
        long maxProfit = 0;

        while (orders > 0) {
            Long poll = queues.poll();
            if (queues.isEmpty()) {
                // 只有弹出的当前数直接返回
                // long startNum = poll - orders + 1;
                maxProfit += ((2 * poll - orders + 1) * orders / 2) % MOD;

                break;
            } else {
                if (orders == 1) {
                    maxProfit += poll;
                    orders--;
                } else {
                    if (poll > queues.peek()) {
                        if (poll > queues.peek() + 1) {
                            long min = Math.min(poll - queues.peek(), orders);
                            maxProfit += ((2 * poll - min + 1) * min / 2) % MOD;

                            orders = (int) (orders - min);
                            queues.add(poll - min);
                        } else {
                            maxProfit += (2 * poll - 1) % MOD;
                            orders -= 2;
                            poll -= 2;
                            queues.add(poll);
                        }
                    } else {
                        // 相等
                        maxProfit += (2 * poll) % MOD;
                        queues.poll();
                        orders -= 2;
                        queues.add(poll - 1);
                        queues.add(poll - 1);
                    }
                }
            }
        }

        return (int) maxProfit;
    }


    @Test
    public void t() {
//        int num = 10;
//        int orders = 5;
//        int ret = (2 * num - orders + 1) * orders / 2;
//        System.out.println(ret);

        int MOD = 1000000007;
        int target = 245604139;
        int[] inventory = new int[]{497978859, 167261111, 483575207, 591815159};
        int orders = 836556809;

        int rest = orders;
        long maxProfit = 0, calCount = 0;

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] > target) {
                // 次数
                long count = inventory[i] - target;
                long addNum = (((2 * inventory[i] - count + 1) * count) % MOD / 2) % MOD;
                System.out.println(addNum);
                maxProfit += addNum;
                rest -= count;
                calCount += count;
            }
        }

        // 还需要计算多少个target 的数
        maxProfit = (maxProfit + (rest * target) % MOD) % MOD;

        System.out.println(calCount);
        System.out.println(maxProfit);
    }

//    @Test
//    public void testMethod() {
//        long endNum = 497978859;
//        long target = 245604139;
//
//        long sumMehtod = getSumMehtod(endNum, target);
//        long sums = getSums(target, endNum);
//        System.out.println("sumMehtod: " + sumMehtod + "; sums: " + sums + "; " + (sums == sumMehtod));
//    }
//
//    //
//    public long getSumMehtod(long endNum, long target) {
//        long x = endNum - target + 1;
//        // x = nums;
//        long addNum = (target + endNum) * x / 2;
//        return addNum;
//    }
}
