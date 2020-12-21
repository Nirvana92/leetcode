package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/19 5:08 下午
 * @desc: 1493. 删掉一个元素以后全为 1 的最长子数组
 */
public class No_1493_longest_subarray_of_1s_after_deleting_one_element {
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 0, 1};
        int longestSubarray = longestSubarray(nums);
        System.out.println(longestSubarray);
    }

    public int longestSubarray(int[] nums) {
        int fill1Nums = 0;
        int N = nums.length;

        int r = 0, longest1Nums = 0;
        for (int i = 0; i < N; i++) {
            while (r < N) {
                if (fill1Nums < 1 || nums[r] == 1) {
                    if (nums[r] == 0) {
                        fill1Nums++;
                    }
                    r++;

                    continue;
                }
                break;
            }

            // 退出上面的循环 fill1Nums >= K 或者 r>=N
            longest1Nums = Math.max(longest1Nums, r - i);
            if (nums[i] == 0) {
                fill1Nums--;
            }
        }

        return longest1Nums - 1;
    }
}
