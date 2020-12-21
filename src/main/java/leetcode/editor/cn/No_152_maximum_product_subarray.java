package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2020/9/22 10:49 上午
 * @desc
 */
public class No_152_maximum_product_subarray {

    @Test
    public void test() {
        int times = 100000;

        while (times-- > 0) {
            int arrLenBase = 5, arrLenMax = 10, arrValBase = -8, arrValMax = 10;
            int[] nums = Utils.generIntArr(arrLenBase, arrLenMax, arrValBase, arrValMax);
            int result = violentMethodMaxProduct(nums);
            int maxProduct = maxProduct(nums);
            if (result != maxProduct) {
                System.out.println(Arrays.toString(nums));
                System.out.println(result);
                System.out.println(maxProduct);
                System.out.println("-------------------------------------------");
            }
        }
//        int[] nums = new int[]{-8, -7, -5, -6, -10};
//        int result = violentMethodMaxProduct(nums);
//        int maxProduct = maxProduct(nums);
//        System.out.println(result);
//        System.out.println(maxProduct);
    }

    public int maxProduct(int[] nums) {
        int N = nums.length;

        int[] maxVal = new int[nums.length];
        int[] minVal = new int[nums.length];
        maxVal[N - 1] = nums[N - 1];
        minVal[N - 1] = nums[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            // 需要保证是连续的子数组, 所以每一个可能都应该是包含 num[i] 的结果比较, 得到最终的结果值
            maxVal[i] = Math.max(nums[i], Math.max(nums[i] * maxVal[i + 1], nums[i] * minVal[i + 1]));
            minVal[i] = Math.min(nums[i], Math.min(nums[i] * minVal[i + 1], nums[i] * maxVal[i + 1]));
        }
        int result = maxVal[0];
        for (int i = 1; i < N; i++) {
            result = Math.max(result, maxVal[i]);
        }
        return result;
    }

    public int violentMethodMaxProduct(int[] nums) {
        // 遍历从 i 开始往后累乘的集合
        Integer maxVal = null;
        for (int i = 0; i < nums.length; i++) {
            Integer tmpVal = null;
            for (int j = i; j < nums.length; j++) {
                if (maxVal == null) {
                    maxVal = nums[j];
                }
                if (tmpVal == null) {
                    tmpVal = nums[j];
                } else {
                    tmpVal *= nums[j];
                }

                maxVal = Math.max(maxVal, tmpVal);
            }
        }

        return maxVal;
    }
}
