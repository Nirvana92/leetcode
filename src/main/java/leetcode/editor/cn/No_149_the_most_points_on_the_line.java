package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. 直线上最多的点数
 */
public class No_149_the_most_points_on_the_line {
    @Test
    public void test() {
        int[][] points = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        points = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        points = new int[][]{{1, 1}, {2, 2}, {3, 3}};
//        points = new int[][]{{0, 0}, {1, 0}};
        // points = new int[][]{{-1, 5}, {2, 3}, {3, -6}, {-2, 5}, {-3, 5}};
        points = new int[][]{{0, 0}, {0, 0}};
        points = new int[][]{{0, 0}, {1, 1}, {0, 0}};
        int maxPoints = maxPoints(points);
        System.out.println(maxPoints);
    }

    /**
     * 遍历以每个点开始能落在同一条线上的点有多少个, 求遍历过程中最大的值返回即可
     *
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }

        // points的个数超过1
        // 遍历每个点为起始点
        int maxPoints = 0;
        for (int i = 0; i < points.length; i++) {
            maxPoints = Math.max(maxPoints, loadMaxPoints(points, i));
        }

        return maxPoints;
    }

    /**
     * i点必须在这条直线上, 最多能包括多少个点
     *
     * @param points
     * @param startIndex
     * @return
     */
    public int loadMaxPoints(int[][] points, int startIndex) {
        // 在同一条线上的最大点的个数
        int maxPoints = 0;
        // 同一行同一列的个数
        int sameX = 0, sameY = 0, samePoint = 0;

        // key: 斜率, 2_3 形式, values 是在这个斜率上的个数
        Map<String, Integer> pMaps = new HashMap<>();
        for (int endIndex = startIndex + 1; endIndex < points.length; endIndex++) {
            if (points[startIndex][0] == points[endIndex][0] || points[startIndex][1] == points[endIndex][1]) {
                // 需要考虑同点的问题
                if (points[startIndex][0] == points[endIndex][0] && points[startIndex][1] == points[endIndex][1]) {
                    samePoint += 1;
                } else {
                    sameX += points[startIndex][0] == points[endIndex][0] ? 1 : 0;
                    sameY += points[startIndex][1] == points[endIndex][1] ? 1 : 0;
                    maxPoints = Math.max(maxPoints, sameX);
                    maxPoints = Math.max(maxPoints, sameY);
                }
            } else {
                // 有斜率: x_y
                int diffX = points[endIndex][0] - points[startIndex][0];
                int diffY = points[endIndex][1] - points[startIndex][1];
                int greatestCommonDivisor = loadGreatestCommonDivisor(diffX, diffY);
                diffX /= greatestCommonDivisor;
                diffY /= greatestCommonDivisor;

                boolean negative = diffX * diffY < 0;
                String key = (negative ? "-" : "") + Math.abs(diffX) + "_" + Math.abs(diffY);
                pMaps.put(key, pMaps.getOrDefault(key, 0) + 1);
                maxPoints = Math.max(maxPoints, pMaps.get(key));
            }
        }

        return maxPoints + 1 + samePoint;
    }

    private int loadGreatestCommonDivisor(int firstNum, int secondNum) {
        return firstNum == 0 ? secondNum : loadGreatestCommonDivisor(secondNum % firstNum, firstNum);
    }

    @Test
    public void testCommonDivisor() {
//        int firstNum = 12;
//        int secondNum = 24;
//        System.out.println(loadGreatestCommonDivisor(firstNum, secondNum));
//
//        firstNum = -12;
//        System.out.println(String.valueOf(firstNum));

        int diffX = -12;
        int diffY = 12;
        String key = "-" + Math.abs(diffX) + "_" + diffY;
        System.out.println(key);
    }
}
