package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/1/19 2:55 下午
 * @desc: 1725. 可以形成最大正方形的矩形数目
 */
public class No_1725_The_number_of_rectangles_that_can_form_the_largest_square {
    @Test
    public void test() {
        int[][] rectangles = new int[][]{};

        int countGoodRectangles = countGoodRectangles(rectangles);
        System.out.println(countGoodRectangles);
    }

    public int countGoodRectangles(int[][] rectangles) {
        int len = rectangles.length;

        int maxSideLen = 0;
        int[] sideLens = new int[len];
        for (int i = 0; i < len; i++) {
            sideLens[i] = Math.min(rectangles[i][0], rectangles[i][1]);
            maxSideLen = Math.max(maxSideLen, sideLens[i]);
        }

        int results = 0;
        for (int i = 0; i < len; i++) {
            if (sideLens[i] == maxSideLen) {
                results++;
            }
        }

        return results;
    }
}
