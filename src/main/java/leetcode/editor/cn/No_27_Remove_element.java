package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/10/10 2:54 下午
 * @desc
 */
public class No_27_Remove_element {
    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;

        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        val = 2;

        nums = new int[]{1, 1, 1, 1, 1, 1};
        val = 2;

        nums = new int[]{1};
        val = 1;

        int removeElement = removeElement(nums, val);
        PrintUtils.print(nums);
        System.out.println(removeElement);
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int removeIndex = nums.length - 1, curIndex = 0;

        while (curIndex < removeIndex) {
            if (nums[curIndex] == val) {
                swap(nums, curIndex, removeIndex--);
            } else {
                curIndex++;
            }
        }

        return nums[curIndex] == val ? curIndex : curIndex + 1;
    }

    public void swap(int[] arrs, int i, int j) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}
