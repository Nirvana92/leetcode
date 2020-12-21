package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/10/20 8:43 下午
 * @desc: 1033. 移动石子直到连续
 */
public class No_1033_Move_stones_until_continuous {
    @Test
    public void test() {
        int a = 2, b = 5, c = 6;
        int[] numMovesStones = numMovesStones(a, b, c);
        PrintUtils.print(numMovesStones);
    }

    public int[] numMovesStones(int a, int b, int c) {
        int[] rsts = new int[2];

//        int abDis = Math.abs(b - a);
//        int cbDis = Math.abs(c - b);
        int[] minDiffs = getMinDiffs(a, b, c);

        int maxNumMoves = minDiffs[0] + minDiffs[1];
        rsts[0] = minDiffs[0] == 2 || minDiffs[1] == 2 ? 1 : (minDiffs[0] > 1 ? 1 : 0) + (minDiffs[1] > 1 ? 1 : 0);
        rsts[1] = maxNumMoves - 2;
        return rsts;
    }

    int[] getMinDiffs(int a, int b, int c) {
        int[] rsts = new int[2];
        if (a > b && a > c) {
            // a 最大
            if (b > c) {
                // b 第二大
                rsts[0] = Math.abs(a - b);
                rsts[1] = Math.abs(b - c);
            } else {
                // c 第二大
                rsts[0] = Math.abs(a - c);
                rsts[1] = Math.abs(c - b);
            }
        } else if (b > a && b > c) {
            // b 最大
            if (a > c) {
                rsts[0] = Math.abs(b - a);
                rsts[1] = Math.abs(a - c);
            } else {
                rsts[0] = Math.abs(b - c);
                rsts[1] = Math.abs(c - a);
            }
        } else {
            // c 最大
            if (a > b) {
                rsts[0] = Math.abs(c - a);
                rsts[1] = Math.abs(a - b);
            } else {
                rsts[0] = Math.abs(c - b);
                rsts[1] = Math.abs(b - a);
            }
        }

        return rsts;
    }
}
