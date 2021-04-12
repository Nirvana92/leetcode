package leetcode.editor.cn;

import org.junit.Test;

import java.util.TreeMap;

/**
 * @author gzm
 * @date 2021/4/12 1:43 下午
 * @desc: 1818. 绝对差值和
 */
public class No_1818_Sum_of_absolute_difference {

    @Test
    public void test() {
        int[] nums1 = new int[]{1, 7, 5};
        int[] nums2 = new int[]{2, 3, 5};

        nums1 = new int[]{2, 4, 6, 8, 10};
        nums2 = new int[]{2, 4, 6, 8, 10};

        nums1 = new int[]{1, 10, 4, 4, 2, 7};
        nums2 = new int[]{9, 3, 5, 1, 7, 4};

        int minAbsoluteSumDiff = minAbsoluteSumDiff(nums1, nums2);
        System.out.println(minAbsoluteSumDiff);
    }

    /**
     * 将nums1 放到treeMap 中。然后遍历nums2 中的数据一次那其中的一个元素来判断变化的元素。最后找到最小的值。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        // 测试需要加上取模。防止溢出
        int MOD = 1000000000 + 7;

        if (nums1 == null || nums2 == null || nums1.length != nums2.length) {
            // 异常返回
            return -1;
        }

        TreeMap<Integer, Integer> treeMaps = new TreeMap<>();
        // 将nums1 数组中的数据放到treeMap 中
        for (int num : nums1) {
            treeMaps.put(num, num);
        }

        // 首先可以求出不管换的绝对差的和
        int sumOfAbsDiffVals = 0;
        for (int i = 0; i < nums1.length; i++) {
            sumOfAbsDiffVals += Math.abs(nums1[i] - nums2[i]);
        }

        // 遍历nums2 中的数据, 依次判断将该元素替换成最相近的元素。看最终的最小值。
        int resultOfAbsDiffVals = sumOfAbsDiffVals;
        for (int i = 0; i < nums1.length; i++) {
            // 依次遍历i 位置的数据变更。看最后的绝对差和的大小。
            int oldAbsDiffVal = Math.abs(nums1[i] - nums2[i]);
            Integer floorVal = treeMaps.floorKey(nums2[i]);
            Integer ceilingVal = treeMaps.ceilingKey(nums2[i]);

            int newAbsDiffVal = Math.min(Math.abs(floorVal - nums2[i]), Math.abs(ceilingVal - nums2[i]));

            resultOfAbsDiffVals = Math.min(resultOfAbsDiffVals, sumOfAbsDiffVals - oldAbsDiffVal + newAbsDiffVal);
        }

        return resultOfAbsDiffVals;
    }
}
