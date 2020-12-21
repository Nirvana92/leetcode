package leetcode.editor.cn;

/**
 * 41. 缺失的第一个正数
 */
public class No_41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 将小于等于的数设置为 n+1, 即刚好超过数组的长度
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        // 遍历数组, 当数组中的数 <= n, 则将 数为下标的数置为相反数
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);

            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // 再次遍历数组, 找到第一个大于 0的数, 下标值即为最小的数
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // 否则, 是数组长度 +1
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, -3, -4, -5};
        No_41 no_41 = new No_41();
        int rst = no_41.firstMissingPositive(nums);
        System.out.println(rst);
    }
}
