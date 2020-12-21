package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author gzm
 * @date 2020/12/18 11:31 上午
 * @desc: 1691. 堆叠长方体的最大高度
 */
public class No_1691_Maximum_height_of_stacked_cuboid {
    @Test
    public void test() {
        int[][] cuboids = new int[][]{
                {50, 45, 20},
                {95, 37, 53},
                {45, 23, 12}};

//        cuboids = new int[][]{
//                {38, 25, 45},
//                {76, 35, 3}
//        };

        // cuboids = new int[][]{{7, 11, 17}, {7, 17, 11}, {11, 7, 17}, {11, 17, 7}, {17, 7, 11}, {17, 11, 7}};

        cuboids = new int[][]{
                {10, 11, 12},
                {11, 12, 13},
                {3, 4, 14},
                {2, 3, 15}
        };

        int maxHeight = maxHeight(cuboids);
        System.out.println(maxHeight);
    }

    /**
     * 先对每个方块的信息进行排序, 从小到大的排序.
     * 然后整个方块按照
     * 1. 第一维度的数据进行从大到小的排序
     * 2. 然后第二维度的从大到小的排序
     * 3. 第三维度的从大到小
     *
     * @param cuboids
     * @return
     */
    public int maxHeight(int[][] cuboids) {
        int rowLen = cuboids.length;

        for (int i = 0; i < rowLen; i++) {
            Arrays.sort(cuboids[i]);
        }

        Arrays.sort(cuboids, new ArrComparator());

        // 然后依次取出数据判断, 获取到最大的高度
        int maxRet = 0;
        int[] dp = new int[rowLen];

        // dp 求最大的
        for (int i = rowLen - 1; i >= 0; i--) {
            // 标识以  i 结尾的最大的值
            dp[i] = cuboids[i][2];
            for (int j = rowLen - 1; j > i; j--) {
                if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
        }

        maxRet = Arrays.stream(dp).max().getAsInt();

        return maxRet;
    }

    class ArrComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    return o2[2] - o1[2];
                } else {
                    return o2[1] - o1[1];
                }
            } else {
                return o2[0] - o1[0];
            }
        }
    }
}
