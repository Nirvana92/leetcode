package leetcode.editor.cn;

/**
 * 136. 只出现一次的数字
 *
 * 遍历整个数组, 直接异或
 */
public class No_136 {
    public static void main(String[] args) {
        No_136 no_136 = new No_136();
        int[] nums = new int[]{4,1,2,1,2};
        int result = no_136.singleNumber(nums);
        System.out.println(result);
    }

    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }
}
