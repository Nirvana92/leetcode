package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2020/11/16 3:37 下午
 * @desc: 面试题 16.06. 最小差
 * <p>
 * 双指针
 */
public class Interview_question_16_06_Minimum_difference {
    @Test
    public void test() {
        int[] a = new int[]{1, 3, 15, 11, 2};
        int[] b = new int[]{23, 127, 235, 19, 8};

        a = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        b = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};

        int smallestDifference = smallestDifference(a, b);
        System.out.println(smallestDifference);
    }

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int aIndex = 0, bIndex = 0;

        long smallestVal = (long) Integer.MAX_VALUE - (long) Integer.MIN_VALUE;
        System.out.println(smallestVal);
        while (aIndex < a.length && bIndex < b.length) {
            smallestVal = Math.min(smallestVal, Math.abs((long) a[aIndex] - (long) b[bIndex]));

            if (a[aIndex] > b[bIndex]) {
                bIndex++;
            } else {
                aIndex++;
            }
        }

        return (int) smallestVal;
    }
}
