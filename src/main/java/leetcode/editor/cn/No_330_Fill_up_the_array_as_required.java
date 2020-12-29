package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/29 9:24 上午
 * @desc: 330. 按要求补齐数组
 * <p>
 * 解题思路:
 * 从数组的小到大, 比如 num
 * 先看怎么满足找到 1 ~ num-1 返回的数组, 如果满足了, 加上num 数字, 那么现在的可达成的数字范围为 1 ~ 2*num -1
 * 然后依次往后找知道达到n数字。
 */
public class No_330_Fill_up_the_array_as_required {
    @Test
    public void test() {
        int[] nums = new int[]{1, 3};
        int n = 6;

        nums = new int[]{1, 5, 10};
        n = 20;

        nums = new int[]{1, 2, 2};
        n = 5;

        int minPatches = minPatches(nums, n);
        System.out.println(minPatches);
    }

    public int minPatches(int[] nums, int n) {
        // 目前能达到的范围. 使用int 有可能会越界
        long range = 0;
        // 需要添加的数字
        int needNums = 0;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 > range) {
                range += range + 1;
                needNums++;
                if (range >= n) {
                    return needNums;
                }
            }

            range += nums[i];

            if (range >= n) {
                return needNums;
            }
        }

        while (range < n) {
            range += range + 1;
            needNums++;
        }

        return needNums;
    }
}
