package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2020/11/11 9:45 上午
 * @desc: 514. 自由之路
 */
public class No_514_the_road_of_freedom {
    @Test
    public void test() {
        String ring = "godding", key = "gd";
        ring = "jalsdjflajdflsdjfashdoenlskdfjosadfadnflasdflsadfs";
        key = "lkasdlfdf";

        int rotateSteps = findRotateSteps(ring, key);
        System.out.println(rotateSteps);
    }

    public int findRotateStepsDp(String ring, String key) {
        int rLen = ring.length();
        int keyLen = key.length();
        int[][] dp = new int[rLen][keyLen + 1];
        for (int i = 0; i < rLen; i++) {
            Arrays.fill(dp[i], -1);
        }


        return -1;
    }

    /**
     * 记忆化搜索: todo: 可以考虑改写成动态规划
     *
     * @param ring
     * @param key
     * @return
     */
    public int findRotateSteps(String ring, String key) {
        int rLen = ring.length();
        int keyLen = key.length();
        int[][] dp = new int[rLen][keyLen + 1];
        for (int i = 0; i < rLen; i++) {
            Arrays.fill(dp[i], -1);
        }

        return process(ring, key, 0, 0, dp);
    }

    int process(String ring, String key, int rIndex, int keyIndex, int[][] dp) {
        int rLen = ring.length();

        if (dp[rIndex][keyIndex] != -1) {
            return dp[rIndex][keyIndex];
        }
        if (keyIndex == key.length()) {
            dp[rIndex][keyIndex] = 0;
            return 0;
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i < rLen; i++) {
            if (ring.charAt(i) == key.charAt(keyIndex)) {
                int curStep = Math.min(Math.abs(rIndex - i), rLen - Math.max(i, rIndex) + Math.min(i, rIndex)) + 1;
                // 计算
                int nextSteps = process(ring, key, i, keyIndex + 1, dp);

                minSteps = Math.min(minSteps, curStep + nextSteps);
            }
        }

        dp[rIndex][keyIndex] = minSteps;

        return minSteps;
    }
}
