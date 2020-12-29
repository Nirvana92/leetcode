package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/25 5:35 下午
 * @desc: 1503. 所有蚂蚁掉下来前的最后一刻
 * <p>
 * 脑经急转弯的题目
 */
public class No_1503_The_last_moment_before_all_the_ants_fall {
    @Test
    public void test() {
        int n = 4;
        int[] left = new int[]{4, 3};
        int[] right = new int[]{0, 1};

        n = 7;
        left = new int[]{};
        right = new int[]{0, 1, 2, 3, 4, 5, 6, 7};

        n = 7;
        left = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        right = new int[]{};

        n = 9;
        left = new int[]{5};
        right = new int[]{4};

        n = 6;
        left = new int[]{6};
        right = new int[]{0};

        int lastMoment = getLastMoment(n, left, right);
        System.out.println(lastMoment);
    }

    /**
     * 想象两个蚂蚁相撞的时候不是掉头, 各自走各自的路线
     *
     * @param n
     * @param left
     * @param right
     * @return
     */
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTime = 0;
        for (int i = 0; i < left.length; i++) {
            maxTime = Math.max(maxTime, left[i] - 0);
        }

        for (int i = 0; i < right.length; i++) {
            maxTime = Math.max(maxTime, n - right[i]);
        }

        return maxTime;
    }
}
