package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author gzm
 * @date 2021/2/7 4:26 下午
 * @desc: 5660. 最多可以参加的会议数目 II
 */
public class No_5660_Maximum_number_of_meetings_you_can_participate_in_II {
    @Test
    public void test() {
        int[][] events = new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 1}};
        int k = 2;

        events = new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 10}};
        k = 2;

        events = new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}};
        k = 3;

        int maxValue = maxValue(events, k);
        System.out.println(maxValue);
    }

    int preEndTimeDp = 0;

    /**
     * 递归方法
     *
     * @param events
     * @param k
     * @return
     */
    public int maxValueDp(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(o -> o[1]));
        int[][] dp = new int[events.length][k];

        for (int i = events.length - 1; i >= 0; i--) {
            for (int remindK = 1; remindK <= k; remindK++) {
                // 当前选择
                int p1 = 0;
                if (events[i][0] > preEndTimeDp) {
                    int tmpPreEndTime = preEndTimeDp;
                    preEndTimeDp = events[i][1];
                    int nextVal = dp[i + 1][remindK - 1];
                    preEndTimeDp = tmpPreEndTime;
                    p1 = nextVal + events[i][2];
                }

                // 当前不选择
                int p2 = dp[i + 1][remindK];

                return Math.max(p1, p2);
            }
        }

        return dp[0][k];
    }

    int preEndTime = 0;

    /**
     * 暴利处理方法
     *
     * @param events
     * @param k
     * @return
     */
    public int maxValue(int[][] events, int k) {
        // 按照结束时间升序
        Arrays.sort(events, Comparator.comparingInt(o -> o[1]));

        return process(events, k, 0, k);
    }

    int process(int[][] events, int k, int i, int remindK) {
        // int[][] dp = new int[events.length][k];
        if (remindK == 0 || i == events.length) {
            return 0;
        }

        // 当前选择
        int p1 = 0;
        if (events[i][0] > preEndTime) {
            int tmpPreEndTime = preEndTime;
            preEndTime = events[i][1];
            int nextVal = process(events, k, i + 1, remindK - 1);
            preEndTime = tmpPreEndTime;
            p1 = nextVal + events[i][2];
        }

        // 当前不选择
        int p2 = process(events, k, i + 1, remindK);

        return Math.max(p1, p2);
    }
}
