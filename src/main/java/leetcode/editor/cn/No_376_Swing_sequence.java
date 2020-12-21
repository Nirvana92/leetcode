package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;
import org.nirvana.util.Utils;

/**
 * @author Nirvana
 * @date 2020/12/12 11:10
 */
public class No_376_Swing_sequence {
    @Test
    public void test() {
        int[] nums = new int[]{1, 7, 4, 9, 2, 5};
        nums = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        int wiggleMaxLength = wiggleMaxLength(nums);
        System.out.println(wiggleMaxLength);
    }

    @Test
    public void t() {
        int times = 1000000;
        while (times-- > 0) {
            int[] nums = Utils.generIntArr(1, 30, 1, 30);
            int wiggleMaxLength = wiggleMaxLength(nums);
            int dd = dd(nums);
            if (wiggleMaxLength != dd) {
                PrintUtils.print(nums);

                System.out.println("error");
                break;
            }
        }
    }

    public int wiggleMaxLength(int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return 0;
        }

        int ret = 1;
        boolean init = true;
        boolean preMore = false;
        for (int i = 0; i < N - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }

            if (init) {
                preMore = nums[i + 1] > nums[i] ? true : false;
                ret++;

                init = false;
            } else {
                if ((preMore && nums[i] > nums[i + 1]) || (!preMore && nums[i] < nums[i + 1])) {
                    ret++;
                    preMore = !preMore;
                }
            }
        }

        return ret;
    }

    public int dd(int[] nums) {
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return nums.length == 0 ? 0 : Math.max(down, up);
    }
}
