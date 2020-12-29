package leetcode.editor.cn;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2020/12/28 11:53 上午
 * @desc: 1705. 吃苹果的最大数目
 * <p>
 */
public class No_1705_Maximum_number_of_apples_to_eat {
    @Test
    public void test() {
        int[] apples = new int[]{1, 2, 3, 5, 2};
        int[] days = new int[]{3, 2, 1, 4, 2};

        apples = new int[]{1, 3, 0, 3, 2};
        days = new int[]{3, 4, 0, 2, 2};

        apples = new int[]{9, 10, 1, 7, 0, 2, 1, 4, 1, 7, 0, 11, 0, 11, 0, 0, 9, 11, 11, 2, 0, 5, 5};
        days = new int[]{3, 19, 1, 14, 0, 4, 1, 8, 2, 7, 0, 13, 0, 13, 0, 0, 2, 2, 13, 1, 0, 3, 7};

        int eatenApples = eatenApplesFinal(apples, days);
        System.out.println(eatenApples);
    }

    public int eatenApplesFinal(int[] apples, int[] days) {
        PriorityQueue<int[]> queues = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[1]));

        int eatApples = 0;

        for (int i = 0; i < apples.length || !queues.isEmpty(); i++) {
            while (!queues.isEmpty() && queues.peek()[1] <= i) {
                queues.poll();
            }

            // 添加到队列中
            if (i < apples.length && apples[i] > 0) {
                queues.add(new int[]{apples[i], days[i] + i});
            }

            int[] info = queues.peek();
            if (info != null && info[1] > 0) {
                eatApples++;
                info[0]--;

                if (info[0] == 0) {
                    queues.poll();
                }
            }
        }

        return eatApples;
    }

    /**
     * 异常代码
     *
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {
        // 当前迭代的天数
        int curDay = 0;
        int eatApples = 0;

        for (int i = 0; i < apples.length; i++) {
            int minDays = Math.min(apples[i], days[i]);

            eatApples += Math.min(Math.max(i + minDays - curDay, 0), minDays);
            curDay += Math.max(i + minDays - curDay, 0);
        }

        return eatApples;
    }
}
