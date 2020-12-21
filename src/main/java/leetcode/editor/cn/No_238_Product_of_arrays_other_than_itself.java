package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

public class No_238_Product_of_arrays_other_than_itself {
    @Test
    public void test() {
        int[] nums = {1, 0, 0, 4};
        int[] ints = productExceptSelf(nums);
        PrintUtils.print(ints);
    }

    public int[] productExceptSelf(int[] nums) {
        int allProduct = 1;
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                continue;
            }

            allProduct *= nums[i];
        }

        int[] output = new int[nums.length];
        if (zeroCount > 1) {
            return output;
        }

        for (int i = 0; i < output.length; i++) {
            if (nums[i] == 0) {
                output[i] = allProduct;
            } else {
                output[i] = zeroCount == 1 ? 0 : allProduct / nums[i];
            }
        }

        return output;
    }
}
