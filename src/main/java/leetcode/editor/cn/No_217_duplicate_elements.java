package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gzm
 * @date 2020/9/22 5:29 下午
 * @desc
 */
public class No_217_duplicate_elements {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4};
        boolean containsDuplicate = containsDuplicate(nums);
        System.out.println(containsDuplicate);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            if (sets.contains(num)) {
                return true;
            }

            sets.add(num);
        }

        return false;
    }
}
