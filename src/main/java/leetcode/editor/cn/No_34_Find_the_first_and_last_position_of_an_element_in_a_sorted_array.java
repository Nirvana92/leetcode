package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/10/9 1:56 下午
 * @desc
 */
public class No_34_Find_the_first_and_last_position_of_an_element_in_a_sorted_array {
    @Test
    public void test() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;

        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 6;

//        nums = new int[]{2, 2};
//        target = 2;

        int[] searchRange = searchRange(nums, target);
        PrintUtils.print(searchRange);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] results = new int[2];

        results[0] = searchRangeLeft(nums, target);
        if (results[0] == -1 || results[0] == nums.length - 1) {
            results[1] = results[0];
        } else {
            results[1] = searchRangeRight(nums, target);
        }

        return results;
    }

    /**
     * 查找目标值范围内的最左的数值的索引
     *
     * @param nums
     * @param target
     * @return
     */
    int searchRangeLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;

            // 找到了, 看下左边一位数是否是不等的数
            if (nums[mid] == target) {
                if (mid - 1 < 0 || nums[mid - 1] != target) {
                    return mid;
                }

                r = mid - 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        // 没有找到合适的
        return -1;
    }

    /**
     * 查找目标值范围的最右的数值的索引
     *
     * @param nums
     * @param target
     * @return
     */
    int searchRangeRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;

            // 找到了, 看下左边一位数是否是不等的数
            if (nums[mid] == target) {
                if (mid + 1 >= nums.length || nums[mid + 1] != target) {
                    return mid;
                }

                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        // 没有找到合适的
        return -1;
    }
}
