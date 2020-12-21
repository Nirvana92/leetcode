package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/18 2:52 下午
 * @desc
 */
public class No_26 {
    @Test
    public void test() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int removeDuplicates = removeDuplicates(nums);
        System.out.println(removeDuplicates);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }

        int effectiveIndex = 0, curIndex = 1;

        while (curIndex < nums.length) {
            // 判断curIndex 和 effectiveIndex 的值是否相等,
            // 不等: 拷贝curIndex 到 effectiveIndex, 然后 两个下标同时往后移动
            // 相等: curIndex 往后移动
            if (nums[curIndex] != nums[effectiveIndex]) {
                swap(nums, curIndex, effectiveIndex + 1);
                effectiveIndex++;
            }

            curIndex++;
        }

        return effectiveIndex + 1;
    }

    void swap(int[] nums, int oldIndex, int newIndex) {
        int N = nums.length;
        if (oldIndex == newIndex || oldIndex >= N || newIndex >= N || oldIndex < 0 || newIndex < 0) {
            return;
        }

        int tmpNum = nums[oldIndex];
        nums[oldIndex] = nums[newIndex];
        nums[newIndex] = tmpNum;
    }
}
