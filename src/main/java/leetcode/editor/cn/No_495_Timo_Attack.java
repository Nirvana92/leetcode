package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/3 22:11
 * <p>
 * 495. 提莫攻击
 */
public class No_495_Timo_Attack {
    @Test
    public void test() {
        int[] timeSeries = new int[]{1, 4};
        int duration = 2;

        timeSeries = new int[]{1, 2};
        duration = 3;

        int poisonedDuration = findPoisonedDuration(timeSeries, duration);
        System.out.println(poisonedDuration);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (duration <= 0) {
            return 0;
        }

        int preTime = 0;
        int totalDuration = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i == 0) {
                totalDuration += duration;
            } else {
                totalDuration += preTime + duration - 1 >= timeSeries[i] ? duration - (preTime + duration - timeSeries[i]) : duration;
            }

            preTime = timeSeries[i];
        }

        return totalDuration;
    }
}
