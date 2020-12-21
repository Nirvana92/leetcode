package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 这题的突破点: 1<= nums[i] <=n
 * 遍历数组找到将每个数组上的值转换为负数, 然后看下转换过后的数字是否已经转换过，转换过就是重复出现的数字
 */
public class No_442_Repeated_data_in_the_array {
    @Test
    public void test() {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int tranIndex = Math.abs(nums[i]) - 1;
            if (nums[tranIndex] < 0) {
                results.add(Math.abs(nums[i]));
            }

            nums[tranIndex] = -nums[tranIndex];
        }

        return results;
    }
}
