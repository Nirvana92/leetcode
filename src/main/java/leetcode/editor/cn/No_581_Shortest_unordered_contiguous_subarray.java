package leetcode.editor.cn;

import org.junit.Test;

/**
 * 581. 最短无序连续子数组
 */

// todo: [1,3,2,2,2]   输出: 2; 预期结果: 4
public class No_581_Shortest_unordered_contiguous_subarray {
    @Test
    public void test() {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
//        nums = new int[]{1, 4, 3, 2};
//        nums = new int[]{1, 3, 2, 2, 2};
//        nums = new int[]{1, 2, 7, 4, 5, 2, 3}
        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        nums = new int[]{7, 6, 5, 4, 3, 2, 1};
        nums = new int[]{1, 6, 2, 3, 4, 5, 7};
        nums = new int[]{1, 7, 2, 3, 4, 5, 6};
        int unsortedSubarray = findUnsortedSubarray(nums);
        System.out.println(unsortedSubarray);
    }


    /**
     * 找最大值和最小值的小表索引
     *
     * @param
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int lToRStartIndex = -1, lToREndIndex = -1, rToLStartIndex = -1, rToLEndIndex = -1;
        // 从左到右找到第一个和最后一个不满足升序的下标索引
        int lToRMaxVal = nums[0], rToLMinVal = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (lToRMaxVal > nums[i]) {
                if (lToRStartIndex == -1) {
                    lToRStartIndex = i;
                }
                lToREndIndex = i;
            }
            lToRMaxVal = Math.max(lToRMaxVal, nums[i]);
        }

        // 从右往左找到第一个和最后一个不满足升序的下标索引
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > rToLMinVal) {
                if (rToLEndIndex == -1) {
                    rToLEndIndex = i;
                }
                rToLStartIndex = i;
            }
            rToLMinVal = Math.min(rToLMinVal, nums[i]);
        }

        // 找到开始索引的最小值, 结束索引的最大值 然后计算出长度返回
        int minLen = Math.max(lToREndIndex, rToLEndIndex) - Math.min(lToRStartIndex, rToLStartIndex);
        return minLen > 0 ? minLen + 1 : 0;
    }
}
