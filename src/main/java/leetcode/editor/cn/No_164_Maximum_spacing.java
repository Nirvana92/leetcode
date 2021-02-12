package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;
import org.nirvana.util.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2020/10/28 11:37 上午
 * @desc: 164. 最大间距
 * <p>
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 * <p>
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 * <p>
 * todo: review 某次看到该问题还是没想到解题思路
 */
public class No_164_Maximum_spacing {
    @Test
    public void test() {
        int[] nums = new int[]{10};
        nums = new int[]{3, 6, 9, 1};
        nums = new int[]{16, 17, 8, 13, 15, 8, 14, 1};
        nums = new int[]{1, 13, 6, 8, 2};
        nums = new int[]{11, 8, 15, 2, 17, 10, 14, 16, 3, 18};
        // nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int maximumGap = maximumGap(nums);
        System.out.println(maximumGap);
        int baoli = baoli(nums);
        System.out.println(baoli);
    }

    @Test
    public void t() {
        int times = 10000000;

        while (times-- > 0) {
            int[] nums = Utils.generIntArr(1, 20, 1, 20);
            int[] newNums = removeDup(nums);
            int[] copyNums = Arrays.copyOf(newNums, newNums.length);
            int maximumGap = maximumGap(newNums);
            int baoli = baoli(copyNums);
            if (maximumGap != baoli) {
                PrintUtils.print(newNums);
                System.out.println("maximumGap: " + maximumGap + "; baoli: " + baoli);
                System.out.println("error");
            }
        }
    }

    /**
     * 取 nums 数组中的最大值和最小值. 根据最大值和最小值给nums 分为 nums.len-1 个区间。
     * 然后判断每个区间的末尾值和下一个区间的开头值的差值, 然后找到所有差值的最大值
     *
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        int N = nums.length;
        if (nums == null || N < 2) {
            return 0;
        }

        // 找到最大值和最小值
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < N; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // 每个桶装的数据的范围
        int barrelNumRange = (max - min + N) / N;
        // barrels[i][0]: 第i 个桶的最小值
        // barrels[i][1]: 第i 个桶的最大值
        int[][] barrels = new int[N + 1][2];
        // 给每个桶初始化数据
        for (int i = 0; i < barrels.length; i++) {
            Arrays.fill(barrels[i], -1);
        }

        for (int i = 0; i < nums.length; i++) {
            // 桶编号
            int barrelIndex = (nums[i] - min) / barrelNumRange;
            if (barrels[barrelIndex][0] == -1) {
                // 没有初始化过
                barrels[barrelIndex][0] = nums[i];
                barrels[barrelIndex][1] = nums[i];
            } else {
                // 已经有数据了, 进行数据对比
                barrels[barrelIndex][0] = Math.min(barrels[barrelIndex][0], nums[i]);
                barrels[barrelIndex][1] = Math.max(barrels[barrelIndex][1], nums[i]);
            }
        }

        // 遍历桶数据, 找到最大差值
        int maxDiffVal = 0, preIndex = -1;
        for (int i = 0; i < barrels.length; i++) {
            if (barrels[i][0] != -1) {
                // 往前走一个
//                maxDiffVal = Math.max(maxDiffVal, barrels[i][0] - barrels[i - 2][1]);
//            } else {
                if (preIndex != -1) {
                    maxDiffVal = Math.max(maxDiffVal, barrels[i][0] - barrels[preIndex][1]);
                }
                preIndex = i;
            }
        }

        return maxDiffVal;
    }

    /**
     * 暴利求解方法
     *
     * @param nums
     */
    public int baoli(int[] nums) {
        Arrays.sort(nums);

        int maxDiffVal = 0;
        for (int i = 1; i < nums.length; i++) {
            maxDiffVal = Math.max(maxDiffVal, nums[i] - nums[i - 1]);
        }

        return maxDiffVal;
    }

    int[] removeDup(int[] nums) {
        Map<Integer, Integer> countMaps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMaps.put(nums[i], countMaps.getOrDefault(nums[i], 0) + 1);
        }

        int rstIndex = 0;
        int[] rsts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (countMaps.containsKey(nums[i])) {
                rsts[rstIndex++] = nums[i];
                countMaps.remove(nums[i]);
            }
        }

        return Arrays.copyOf(rsts, rstIndex);
    }

    @Test
    public void tRemove() {
        int[] nums = new int[]{3, 5, 18, 17, 5, 19, 19, 7, 19};
        nums = new int[]{19, 3, 5, 7, 10, 18, 15, 1, 4, 9, 9, 8, 19, 3, 6};
        int[] ints = removeDup(nums);
        PrintUtils.print(ints);
    }
}
