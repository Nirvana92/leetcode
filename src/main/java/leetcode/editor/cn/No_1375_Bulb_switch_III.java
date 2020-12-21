package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/24 20:06
 * <p>
 * 1375. 灯泡开关 III
 * <p>
 * 房间中有 n 枚灯泡，编号从 1 到 n，自左向右排成一排。最初，所有的灯都是关着的。
 * 在 k  时刻（ k 的取值范围是 0 到 n - 1），我们打开 light[k] 这个灯。
 * 灯的颜色要想 变成蓝色 就必须同时满足下面两个条件：
 * 灯处于打开状态。
 * 排在它之前（左侧）的所有灯也都处于打开状态。
 * 请返回能够让 所有开着的 灯都 变成蓝色 的时刻 数目 。
 */
public class No_1375_Bulb_switch_III {
    @Test
    public void test() {
        int[] light = new int[]{2, 1, 3, 5, 4};
        light = new int[]{3, 2, 4, 1, 5};
        light = new int[]{4, 1, 2, 3};
        light = new int[]{2, 1, 4, 3, 6, 5};
        light = new int[]{1, 2, 3, 4, 5, 6};

        int numTimesAllBlue = numTimesAllBlue(light);
        System.out.println(numTimesAllBlue);
    }

    public int numTimesAllBlue(int[] light) {
        int N = light.length;

        int maxBulbNo = 0, numTimes = 0;
        for (int L = 0; L < N; L++) {
            maxBulbNo = Math.max(maxBulbNo, light[L]);

            if (maxBulbNo == L + 1) {
                numTimes++;
            }
        }

        return numTimes;
    }
}
