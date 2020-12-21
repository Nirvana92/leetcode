package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author gzm
 * @date 2020/11/2 9:40 上午
 * @desc: 349. 两个数组的交集
 */
public class No_349_The_intersection_of_two_arrays {
    @Test
    public void test() {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};

        int[] ints = intersection(nums1, nums2);
        PrintUtils.print(ints);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> sets = new HashSet<>();
        Set<Integer> rsts = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            sets.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (sets.contains(nums2[i])) {
                rsts.add(nums2[i]);
            }
        }

        int resultIndex = 0;
        int[] results = new int[rsts.size()];
        Iterator<Integer> iterator = rsts.iterator();
        while (iterator.hasNext()) {
            results[resultIndex++] = iterator.next();
        }

        return results;
    }
}
