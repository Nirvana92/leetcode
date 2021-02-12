package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2021/1/4 9:23 上午
 * @desc: 5641. 卡车上的最大单元数
 */
public class No_5641_Maximum_number_of_units_on_the_truck {
    @Test
    public void test() {
        int[][] boxTypes = new int[][]{{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;

        boxTypes = new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        truckSize = 10;

        int maximumUnits = maximumUnits(boxTypes, truckSize);
        System.out.println(maximumUnits);
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int maxUnits = 0, restTrucks = truckSize;
        for (int i = 0; i < boxTypes.length && restTrucks > 0; i++) {
            int boxs = Math.min(boxTypes[i][0], restTrucks);

            maxUnits += boxs * boxTypes[i][1];
            restTrucks -= boxs;
        }

        return maxUnits;
    }
}
