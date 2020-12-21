package leetcode.editor.cn;

import org.nirvana.util.Utils;

import java.util.Arrays;
import java.util.Random;

/**
 * @author gzm
 * @date 2020/7/1 9:25 上午
 */
public class No_11 {

    /***
     * 两个指针的算法. 一个指针指头, 一个指针指尾. 哪个边小哪个往中间移动.
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        int startIndex = 0, endIndex = height.length-1;
        while (startIndex != endIndex) {
            maxArea = Math.max(maxArea, (endIndex-startIndex) * Math.min(height[startIndex], height[endIndex]));

            if(height[startIndex] > height[endIndex]) {
                endIndex --;
            }else {
                startIndex ++;
            }
        }

        return maxArea;
    }

    /**
     * 暴力解
     * @param height
     * @return
     */
    public int maxAreaWithViolence(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            // 开始边
            for (int j = i+1; j < height.length; j++) {
                maxArea = Math.max(maxArea,(j-i) * Math.min(height[i], height[j]));
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        Random random = new Random();
        int times = 100, arrLen = 0, maxVal = 0;

        while (times-- > 0) {
            arrLen = random.nextInt(1000) + 30;
            maxVal = random.nextInt(1000) + 30;

            int[] height = Utils.generIntArr(arrLen, maxVal);

            No_11 no_11 = new No_11();
            int maxAreaWithViolence = no_11.maxAreaWithViolence(height);
            int maxArea = no_11.maxArea(height);

            if(maxAreaWithViolence != maxArea) {
                System.out.println("heights: "+Arrays.toString(height));
                System.out.printf(" maxAreaWithViolence = %d ", maxAreaWithViolence);
                System.out.printf(" maxArea = %d ", maxArea);
            }
        }

    }
}
