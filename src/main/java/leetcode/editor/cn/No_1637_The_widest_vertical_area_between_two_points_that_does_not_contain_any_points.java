package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2020/11/12 7:23 下午
 * @desc: 1637. 两点之间不包含任何点的最宽垂直面积
 */
public class No_1637_The_widest_vertical_area_between_two_points_that_does_not_contain_any_points {
    @Test
    public void test() {
        int[][] points = new int[][]{};
        int maxWidthOfVerticalArea = maxWidthOfVerticalArea(points);
        System.out.println(maxWidthOfVerticalArea);
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        int[] xNums = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            xNums[i] = points[i][0];
        }

        Arrays.sort(xNums);
        int maxWidth = 0;
        for (int i = 1; i < xNums.length; i++) {
            maxWidth = Math.max(maxWidth, xNums[i] - xNums[i - 1]);
        }

        return maxWidth;
    }
}
