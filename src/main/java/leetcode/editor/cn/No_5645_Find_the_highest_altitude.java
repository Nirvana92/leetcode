package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/1/25 1:48 下午
 * @desc
 */
public class No_5645_Find_the_highest_altitude {
    @Test
    public void test() {
        int[] gain = new int[]{-5, 1, 5, 0, -7};
        gain = new int[]{-4, -3, -2, -1, 4, 3, 2};

        int largestAltitude = largestAltitude(gain);
        System.out.println(largestAltitude);
    }

    public int largestAltitude(int[] gain) {
        int preNum = 0;
        int maxAltitude = 0;

        for (int i = 0; i < gain.length; i++) {
            preNum += gain[i];
            maxAltitude = Math.max(maxAltitude, preNum);
        }

        return maxAltitude;
    }
}
