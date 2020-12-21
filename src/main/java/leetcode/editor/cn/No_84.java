package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class No_84 {

    @Test
    public void test() {
        // 65, 73, 29, 40, 55
//        int[] heights = new int[]{58, 131, 104, 29, 180, 65, 187};
//        int[] heights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        int violentSolution = violentSolution(heights);
//        System.out.println(violentSolution);
//        int maxRectangle = largestRectangleArea(heights);
//        System.out.println(maxRectangle);

        int times = 1000000;
        Random random = new Random();
        while (times-- > 0) {
            int arrLen = random.nextInt(200) + 1;
            int maxVal = random.nextInt(400) + 1;
            int[] heights = Utils.generIntArr(arrLen, maxVal);
            try {
                int violentSolution = violentSolution(heights);
                int largestRectangleArea = largestRectangleArea(heights);
                if (violentSolution != largestRectangleArea) {
                    System.out.println(Arrays.toString(heights));
                    System.out.println("error");
                }
            } catch (Exception e) {
                System.out.println(Arrays.toString(heights));
            }
        }
    }

    @Test
    public void testStack() {

    }

    // 暴力解
    public int violentSolution(int[] heights) {
        int N = heights.length;

        int maxRectangle = 0;
        for (int index = 0; index < N; index++) {
            int curHeight = heights[index];
            // 找到左边小于当前值的索引
            int leftIndex = index;
            while (leftIndex >= 0 && heights[leftIndex] >= heights[index]) {
                leftIndex--;
            }
            leftIndex++;

            // 找到右边小于当前值的索引
            int rightIndex = index;
            while (rightIndex < N && heights[rightIndex] >= heights[index]) {
                rightIndex++;
            }

            rightIndex--;

            maxRectangle = Math.max((rightIndex - leftIndex + 1) * heights[index], maxRectangle);
        }

        return maxRectangle;
    }

    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        if (heights == null || N == 0) {
            return 0;
        }

        if (N == 1) {
            return heights[0];
        }

        // 最大的矩形面积
        int maxRectangle = 0;

        // 堆中保存的数据为 大压小[栈中保存的是索引值]
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int index = 1; index < heights.length; index++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[index]) {
                // 计算堆顶数的最大高度
                Integer calHeightIndex = stack.pop();
                if (stack.isEmpty()) {
                    // 已经是堆底元素, 计算从0 开始到现在
                    maxRectangle = Math.max((index - 0) * heights[calHeightIndex], maxRectangle);
                } else {
                    // 不是堆底的元素, 从当前元素开始往后开始计算
                    Integer startIndex = stack.peek();
                    maxRectangle = Math.max((index - 1 - startIndex) * heights[calHeightIndex], maxRectangle);
                }

            }

            // 否则压栈
            stack.push(index);
        }

        // 堆中不为空, 依次计算堆中的数据
        while (stack.size() > 1) {
            Integer calHeightIndex = stack.pop();
            Integer startIndex = stack.peek();
            maxRectangle = Math.max((N - 1 - startIndex) * heights[calHeightIndex], maxRectangle);
        }

        if (!stack.isEmpty()) {
            maxRectangle = Math.max(heights[stack.pop()] * N, maxRectangle);
        }

        return maxRectangle;
    }
}
