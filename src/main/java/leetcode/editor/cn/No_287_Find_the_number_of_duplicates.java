package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * todo: 有没有空间复杂度 O(1) 的方法找到重复数
 */
public class No_287_Find_the_number_of_duplicates {
    public int findDuplicate(int[] nums) {
        Set<Integer> sets = new HashSet<>();

        for (int num : nums) {
            if (sets.contains(num)) {
                return num;
            }

            sets.add(num);
        }

        return 0;
    }
}
