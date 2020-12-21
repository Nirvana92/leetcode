package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 315. 计算右侧小于当前元素的个数
 *
 * @desc 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 可以参考小和问题处理这道题
 * <p>
 * 小和问题: 给定一个数组, 返回数组中每个数左边小于当前数的累加和放到新数组中并返回
 */
public class No_315_Calculate_the_number_of_elements_on_the_right_side_that_are_less_than_the_current_element {
    @Test
    public void test() {
        // int[] nums = new int[]{5, 2, 6, 1};
        int times = 1000000;
        while (times-- > 0) {
            int[] nums = Utils.generIntArr(10, 50);
            List<Integer> countSmaller = countSmaller(nums);
            List<Integer> countSmallerBaoli = countSmallerBaoli(nums);
            for (int i = 0; i < countSmallerBaoli.size(); i++) {
                if (!Objects.equals(countSmallerBaoli.get(i), countSmaller.get(i))) {
                    System.out.println(countSmaller);
                    System.out.println(countSmallerBaoli);
                }
            }

        }
    }

    /**
     * 参考和使用小和问题的解法出来本问题
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> rsts = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return rsts;
        }

        int[] result = new int[nums.length];
        Info[] infos = new Info[nums.length];
        for (int i = 0; i < nums.length; i++) {
            infos[i] = new Info(nums[i], i);
        }

        process(infos, 0, nums.length - 1, result);
        for (int rst : result) {
            rsts.add(rst);
        }
        return rsts;
    }

    Info[] process(Info[] nums, int l, int r, int[] result) {
        if (l == r) {
            return new Info[]{nums[l]};
        }

        // 找到中间点
        int mid = (r - l) / 2 + l;

        // 然后整体排序
        Info[] left = process(nums, l, mid, result);
        Info[] right = process(nums, mid + 1, r, result);
        // 拿到左右两边的排序, 再进行merge 操作
        return merge(left, right, result);
    }

    /**
     * 将两个数组进行merge 操作
     *
     * @param left
     * @param right
     * @return
     */
    Info[] merge(Info[] left, Info[] right, int[] result) {
        Info[] infos = new Info[left.length + right.length];

        int resultIndex = infos.length - 1;
        int leftIndex = left.length - 1, rightIndex = right.length - 1;
        while (leftIndex >= 0 && rightIndex >= 0) {
            if (left[leftIndex].val > right[rightIndex].val) {
                result[left[leftIndex].index] += rightIndex + 1;
                infos[resultIndex--] = left[leftIndex--];
            } else {
                // left.val == right.val || left.val < right.val
                infos[resultIndex--] = right[rightIndex--];
            }
        }

        while (leftIndex >= 0) {
            infos[resultIndex--] = left[leftIndex--];
        }

        while (rightIndex >= 0) {
            infos[resultIndex--] = right[rightIndex--];
        }

        return infos;
    }

    class Info {
        // 对应索引的值
        int val;
        // 对应的索引
        int index;

        public Info(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public List<Integer> countSmallerBaoli(int[] nums) {
        List<Integer> countSmallers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int cs = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    cs++;
                }
            }
            countSmallers.add(cs);
        }

        return countSmallers;
    }
}
