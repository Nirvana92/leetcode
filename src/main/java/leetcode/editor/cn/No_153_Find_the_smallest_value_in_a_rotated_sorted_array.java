package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/26 10:13 上午
 * @desc: 153. 寻找旋转排序数组中的最小值
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 */
public class No_153_Find_the_smallest_value_in_a_rotated_sorted_array {
    @Test
    public void test() {
        int[] nums = new int[]{3, 4, 5, 1, 2};
        nums = new int[]{2, 3, 4, 5, 1};
        nums = new int[]{4, 5, 1, 2, 3};
        nums = new int[]{5, 1, 2, 3, 4};
        nums = new int[]{1, 2, 3, 4, 5};
        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        nums = new int[]{1, 2, 4, 5, 6, 7, 0};
        nums = new int[]{2, 4, 5, 6, 7, 0, 1};
        nums = new int[]{5, 6, 7, 0, 1, 2, 4};
        nums = new int[]{6, 7, 0, 1, 2, 4, 5};
        nums = new int[]{7, 0, 1, 2, 4, 5, 6};
        nums = new int[]{1, 2, 3, 4, 5, 6};
        nums = new int[]{2, 3, 4, 5, 6, 1};
        nums = new int[]{3, 4, 5, 6, 1, 2};
        nums = new int[]{4, 5, 6, 1, 2, 3};
        nums = new int[]{5, 6, 1, 2, 3, 4};
        nums = new int[]{6, 1, 2, 3, 4, 5};
        nums = new int[]{1, 2};
        nums = new int[]{2, 1};
        nums = new int[]{1};

        int min = findMin(nums);
        System.out.println(min);
    }

    /**
     * 拿实例情况去具体分析什么场景需要左移右移
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == nums[l] || nums[mid] == nums[r]) {
                return Math.min(nums[l], nums[r]);
            }

            if (nums[mid] > nums[l] && nums[mid] > nums[r]) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }
}
