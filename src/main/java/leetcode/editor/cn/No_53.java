package leetcode.editor.cn;

/**
 * 53. 最大子序和
 * 思路: 以 index 位置上的数字结尾的最大累加和
 */
public class No_53 {
    public static void main(String[] args) {
        No_53 no_53 = new No_53();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int maxSubArray = no_53.maxSubArray(nums);
        System.out.println(maxSubArray);
    }

    public int maxSubArray(int[] nums) {
        int maxVal = nums[0], preMaxVal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 只包含当前位置上的元素; nums[i];
            // 包含当前位置上的元素和前面的元素; nums[i] + preMaxVal;
            int curMaxVal = Math.max(nums[i], preMaxVal + nums[i]);

            // 重新赋值
            preMaxVal = curMaxVal;
            maxVal = Math.max(maxVal, curMaxVal);
        }

        return maxVal;
    }
}
