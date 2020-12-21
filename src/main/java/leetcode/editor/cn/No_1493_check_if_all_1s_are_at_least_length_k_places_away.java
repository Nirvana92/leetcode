package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/19 4:54 下午
 * @desc: 1437. 是否所有 1 都至少相隔 k 个元素
 */
public class No_1493_check_if_all_1s_are_at_least_length_k_places_away {
    @Test
    public void test() {
        int[] nums = new int[]{1, 0, 0, 0, 1, 0, 0, 1};
        int k = 2;

        nums = new int[]{1, 0, 0, 1, 0, 1};
        k = 2;

        nums = new int[]{1, 1, 1, 1, 1};
        k = 0;

        nums = new int[]{0, 1, 0, 1};
        k = 1;

        nums = new int[]{1};
        k = 1;

        boolean kLengthApart = kLengthApart(nums, k);
        System.out.println(kLengthApart);
    }

    public boolean kLengthApart(int[] nums, int k) {
        int preIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (preIndex != -1 && (i - preIndex - 1) < k) {
                    return false;
                }

                preIndex = i;
            }
        }

        return true;
    }
}
