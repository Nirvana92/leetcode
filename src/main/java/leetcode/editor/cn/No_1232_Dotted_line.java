package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2021/1/17 11:38
 * <p>
 * 1232. 缀点成线
 */
public class No_1232_Dotted_line {
    @Test
    public void test() {
        int[][] coordinates = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};

        coordinates = new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}};

        coordinates = new int[][]{{0, 0}, {0, 1}, {0, 5}};

        boolean checkStraightLine = checkStraightLine(coordinates);
        System.out.println(checkStraightLine);
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        if (len == 2) {
            return true;
        }

        int targetX = coordinates[0][0], targetY = coordinates[0][1];

        int diffX = coordinates[1][0] - targetX;
        int diffY = coordinates[1][1] - targetY;
        boolean isNeg = (diffX ^ diffY) < 0;
        // 不是同x 轴, 同y 轴
        if (!(diffX == 0) && !(diffY == 0)) {
            int commonDivisor = loadGreatestCommonDivisor(diffX, diffY);
            diffX /= commonDivisor;
            diffY /= commonDivisor;
        }

        for (int i = 2; i < len; i++) {
            int tmpDiffX = coordinates[i][0] - targetX;
            int tmpDiffY = coordinates[i][1] - targetY;

            if ((diffX == 0 && tmpDiffX == 0) || (diffY == 0 && tmpDiffY == 0)) {
                continue;
            } else {
                int commonDivisor = loadGreatestCommonDivisor(tmpDiffX, tmpDiffY);
                tmpDiffX /= commonDivisor;
                tmpDiffY /= commonDivisor;

                if (tmpDiffX == diffX && tmpDiffY == diffY && isNeg == ((tmpDiffX ^ tmpDiffY) < 0)) {
                    continue;
                }
            }

            return false;
        }

        return true;
    }

    private int loadGreatestCommonDivisor(int firstNum, int secondNum) {
        return firstNum == 0 ? secondNum : loadGreatestCommonDivisor(secondNum % firstNum, firstNum);
    }
}
