package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

/**
 * @author gzm
 * @date 2020/9/21 7:09 下午
 * @desc
 */
public class No_350_intersection_of_two_arrays_II {
    @Test
    public void test() {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        int[] result = intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> mideds = new ArrayList<>();
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            maps.put(nums2[i], maps.getOrDefault(nums2[i], 0) + 1);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (maps.containsKey(nums1[i])) {
                mideds.add(nums1[i]);

                Integer count = maps.get(nums1[i]);
                if (count <= 1) {
                    maps.remove(nums1[i]);
                } else {
                    maps.put(nums1[i], count - 1);
                }
            }
        }

        int[] result = new int[mideds.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = mideds.get(i);
        }

        return result;
    }
}
