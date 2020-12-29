package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2020/12/22 2:58 下午
 * @desc: 1608. 特殊数组的特征值
 */
public class No_1608_special_arrays {
    @Test
    public void test() {
        int[] nums = new int[]{3, 5};
        nums = new int[]{0, 0};
        nums = new int[]{0, 4, 3, 0, 4};
        nums = new int[]{3, 6, 7, 7, 0};
        nums = new int[]{1, 2, 3, 3, 5};

        int specialArray = specialArray(nums);
        System.out.println(specialArray);
    }

    public int specialArray(int[] nums) {
        int ret = -1;
        int N = nums.length;

        Arrays.sort(nums);
        if (nums[0] >= N) {
            ret = N;
        }

        for (int i = 1; i < N; i++) {
            int numbers = N - i;
            if (nums[i] >= numbers && numbers > nums[i - 1]) {
                if (ret == -1) {
                    ret = numbers;
                } else {
                    return -1;
                }
            }
        }

        return ret;
    }
}
