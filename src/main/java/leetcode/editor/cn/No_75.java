package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class No_75 {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1, cur = 0;

        while (cur <= r) {
            if (nums[cur] < 1) {
                swap(nums, l++, cur++);
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(nums, cur, r--);
            }
        }
    }

    // 交换
    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{0, 1, 2, 1, 2, 0, 1, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testSortColors() {
        Random random = new Random();
        int maxVal = 100;
        for (int i = 100; i > 0; i--) {
            int[] nums = genNums(random.nextInt(maxVal) + 1);
            System.out.println("nums: " + Arrays.toString(nums));
            sortColors(nums);
            System.out.println(Arrays.toString(nums));
        }

//        int[] nums = new int[]{2, 0, 1};
//        sortColors(nums);
//        System.out.println(Arrays.toString(nums));
    }

    public int[] genNums(int numbers) {
        Random random = new Random();
        int[] nums = new int[numbers];
        for (int i = numbers - 1; i >= 0; i--) {
            nums[i] = random.nextInt(3);
        }

        return nums;
    }
}
