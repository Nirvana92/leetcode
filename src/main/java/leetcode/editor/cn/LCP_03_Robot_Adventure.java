package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Nirvana
 * @date 2020/10/24 21:48
 * <p>
 * LCP 03. 机器人大冒险
 * <p>
 * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
 * <p>
 * U: 向y轴正方向移动一格
 * R: 向x轴正方向移动一格。
 * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
 * <p>
 * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
 */
public class LCP_03_Robot_Adventure {
    @Test
    public void test() {
        String command = "URR";
        int[][] obstacles = new int[][]{};
        int x = 3, y = 2;

//        command = "URR";
//        obstacles = new int[][]{
//                {2, 2}};
//        x = 3;
//        y = 2;

//        command = "URR";
//        obstacles = new int[][]{
//                {4, 2}};
//        x = 3;
//        y = 2;

//        command = "RRRUUU";
//        obstacles = new int[][]{{3, 0}, {3, 1}, {3, 1}};
//        x = 3;
//        y = 3;

        command = "UURRUUU";
        obstacles = new int[][]{
                {4, 5}, {6, 1}, {7, 10}, {9, 1}, {1, 1}, {5, 0}, {2, 8}
        };
        x = 946;
        y = 2365;

        boolean robot = robot(command, obstacles, x, y);
        System.out.println(robot);

        boolean robotOpti = robotOpti(command, obstacles, x, y);
        System.out.println(robotOpti);
    }

    public boolean robotOpti(String command, int[][] obstacles, int x, int y) {
        int firstMoveX = 0, firstMoveY = 0;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'U') {
                firstMoveY++;
            } else {
                firstMoveX++;
            }
        }

        boolean passEndPoint = passPoint(command, firstMoveX, firstMoveY, x, y);
        if (!passEndPoint) {
            return false;
        }

        for (int i = 0; i < obstacles.length; i++) {
            // obstacles[i]
            if (obstacles[i][0] > x || obstacles[i][1] > y) {
                continue;
            }

            if (passPoint(command, firstMoveX, firstMoveY, obstacles[i][0], obstacles[i][1])) {
                return false;
            }
        }

        return true;
    }

    boolean passPoint(String command, int firstMoveX, int firstMoveY, int x, int y) {
        // 直接从开始点跳到循环loopNum 次的位置上
        int loopNum = Math.min(x / firstMoveX, y / firstMoveY);
        int curX = loopNum * firstMoveX, curY = loopNum * firstMoveY;

        while (curX + curY < x + y) {
            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == 'U') {
                    curY++;
                } else {
                    curX++;
                }

                if (curX > x || curY > y) {
                    return false;
                }

                if (curX == x && curY == y) {
                    return true;
                }
            }
        }

        return curX == x && curY == y;
    }

    /**
     * 超时
     *
     * @param command
     * @param obstacles
     * @param x
     * @param y
     * @return
     */
    public boolean robot(String command, int[][] obstacles, int x, int y) {

        Set<String> sets = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            sets.add(obstacles[i][0] + "_" + obstacles[i][1]);
        }

        // 需要轮询的次数
        int curX = 0, curY = 0;
        int loopNums = (x + y) / command.length() + 1;

        while (loopNums-- > 0) {
            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == 'U') {
                    curY++;
                } else {
                    curX++;
                }

                if (sets.contains(curX + "_" + curY)) {
                    return false;
                }

                if (curX == x && curY == y) {
                    return true;
                }
            }
        }

        return false;
    }
}
