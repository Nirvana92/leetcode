package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2021/1/19 3:11 下午
 * @desc: 1726. 同积元组
 * <p>
 * a * b = c * d
 */
public class No_1726_Homologous_tuples {
    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 4, 6};
        nums = new int[]{1, 2, 4, 5, 10};
        nums = new int[]{2, 3, 4, 6, 8, 12};
        // nums = new int[]{2, 3, 5, 7};

        nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = Utils.generInt(1, 2000);
        }

        Arrays.sort(nums);

        long startTime = System.currentTimeMillis();
        int tupleSameProduct = tupleSameProduct(nums);
        long endTime = System.currentTimeMillis();
        System.out.println("cost time: " + (endTime - startTime));
        System.out.println(tupleSameProduct);
    }

    public int tupleSameProduct(int[] nums) {
        int resultTypes = 0;
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            // 遍历第一个数[a]

            for (int j = 3; j < len; j++) {
                // 遍历第二个数 [b]
                int multiplyNum = nums[i] * nums[j];

                // 然后通过双指针求c, d 满足条件的
                // 数值范围: i + 1,  j - 1
                int typeNum = productOfTwoNumbers(nums, i + 1, j - 1, multiplyNum);

                resultTypes += typeNum * 8;
            }
        }

        return resultTypes;
    }

    int productOfTwoNumbers(int[] nums, int i, int j, int targetNum) {
        int typeNum = 0;

        while (i < j) {
            if (nums[i] * nums[j] < targetNum) {
                i++;
            } else if (nums[i] * nums[j] == targetNum) {
                typeNum++;
                i++;
            } else {
                j--;
            }
        }

        return typeNum;
    }
}
