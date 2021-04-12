package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/3/8 5:28 下午
 * @desc: 1779. 找到最近的有相同 X 或 Y 坐标的点
 */
public class No_1779_Find_the_nearest_point_with_the_same_X_or_Y_coordinate {
    @Test
    public void test() {
        int x = 3, y = 4;
        int[][] points = new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};

        points = new int[][]{{3, 4}};
        points = new int[][]{{2, 3}};

        int nearestValidPoint = nearestValidPoint(x, y, points);
        System.out.println(nearestValidPoint);
    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int result = -1;
        int dis = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                // 满足有效点的条件
                int tmpDis = Math.max(Math.abs(points[i][0] - x), Math.abs(points[i][1] - y));
                if (tmpDis < dis) {
                    dis = tmpDis;
                    result = i;
                }
            }
        }

        return result;
    }
}
