package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/7 22:11
 * <p>
 * 849. 到最近的人的最大距离
 */
public class No_849_Maximum_distance_to_the_nearest_person {
    @Test
    public void test() {
        int[] seats = new int[]{1, 0, 0, 0, 1, 0, 1};
        seats = new int[]{1, 0, 0, 0};
        seats = new int[]{0, 0, 0, 1};

        int maxDistToClosest = maxDistToClosest(seats);
        System.out.println(maxDistToClosest);
    }

    public int maxDistToClosest(int[] seats) {
        int maxDis = 0;
        int curLen = 0;
        boolean curFirstIsOne = false;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                // 统计下结果
                if (curFirstIsOne) {
                    maxDis = Math.max(maxDis, (curLen + 1) >> 1);
                } else {
                    maxDis = Math.max(maxDis, curLen);
                }

                curLen = 0;
                curFirstIsOne = true;
            } else {
                curLen++;
            }
        }

        if (seats[seats.length - 1] == 0) {
            maxDis = Math.max(maxDis, curLen);
        }

        return maxDis;
    }
}
