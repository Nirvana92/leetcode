package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.Stack;

/**
 * @author gzm
 * @date 2020/10/26 7:23 下午
 * @desc: 321. 拼接最大数
 * <p>
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，
 * 要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * <p>
 * todo
 * 参考: https://leetcode-cn.com/problems/create-maximum-number/solution/yi-zhao-chi-bian-li-kou-si-dao-ti-ma-ma-zai-ye-b-7/
 * <p>
 * 相同思路, 参考: {@link No_316_Remove_duplicate_letters}
 */
public class No_321_Maximum_number_of_stitching {
    @Test
    public void test() {
        int[] nums1 = new int[]{3, 4, 6, 5};
        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
        int k = 5;

        nums1 = new int[]{6, 7};
        nums2 = new int[]{6, 0, 4};
        k = 5;

        nums1 = new int[]{3, 9};
        nums2 = new int[]{8, 9};
        k = 3;

        int[] maxNumber = maxNumber(nums1, nums2, k);
        PrintUtils.print(maxNumber);
    }

    /**
     * 解题思路:
     * nums1 数组中选择 k1 个数字达到最大的值
     * nums2 数组中选择 k2 个数字达到最大的值
     * <p>
     * 其中 k1 + k2 = k
     * 遍历每种情况, 然后去最大的一种组合返回
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int _1Len = nums1.length;
        int _2Len = nums2.length;

        int[] rets = new int[k];
        if (_1Len + _2Len < k) {
            return rets;
        }

        for (int k1 = 0; k1 <= Math.min(_1Len, k); k1++) {
            if ((k - k1) <= _2Len) {
                // 数组1的长度:   k1
                int[] _1Nums = getMaxNumbers(nums1, k1);
                int k2 = k - k1;
                int[] _2Nums = getMaxNumbers(nums2, k2);

                // 合并两个数组找到最大的值,
                int[] curRets = combineNums(_1Nums, _2Nums);
                // 和之前的某个最大的的数组的最大值比较大小, 决定最终的最大组合数组
                rets = compare(rets, curRets);
            }
        }

        return rets;
    }

    /**
     * 比较当前的结果数组和之前的数组大小
     *
     * @param preRets
     * @param curRets
     * @return
     */
    int[] compare(int[] preRets, int[] curRets) {
        int N = curRets.length;

        for (int i = 0; i < N; i++) {
            if (preRets[i] > curRets[i]) {
                return preRets;
            } else if (curRets[i] > preRets[i]) {
                return curRets;
            }
        }

        return preRets;
    }

    int[] combineNums(int[] _1Nums, int[] _2Nums) {
        int[] rets = new int[_1Nums.length + _2Nums.length];

        int _1Index = 0, _2Index = 0, retIndex = 0;
        while (_1Index < _1Nums.length && _2Index < _2Nums.length) {

            if (compare(_1Nums, _1Index, _2Nums, _2Index) > 0) {
                rets[retIndex++] = _1Nums[_1Index++];
            } else {
                rets[retIndex++] = _2Nums[_2Index++];
            }
//            if (_1Nums[_1Index] > _2Nums[_2Index]) {
//                rets[retIndex++] = _1Nums[_1Index++];
//            } else if (_2Nums[_2Index] > _1Nums[_1Index]) {
//                rets[retIndex++] = _2Nums[_2Index++];
//            } else {
//                // 刚好碰到数组中的当前位置的数值相等
//            }
        }

        if (_1Index < _1Nums.length) {
            for (int i = _1Index; i < _1Nums.length; i++) {
                rets[retIndex++] = _1Nums[i];
            }
        } else if (_2Index < _2Nums.length) {
            for (int i = _2Index; i < _2Nums.length; i++) {
                rets[retIndex++] = _2Nums[i];
            }
        }

        return rets;
    }

    private int compare(int[] nums1, int index1, int[] nums2, int index2) {
        int x = nums1.length, y = nums2.length;
        while (index1 < x && index2 < y) {
            int difference = nums1[index1] - nums2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }

    /**
     * 在 nums 中不打乱原有的顺序, 选择k个元素组成的新的数组是最大的并返回
     *
     * @param nums
     * @param k
     * @return
     */
    int[] getMaxNumbers(int[] nums, int k) {
        int N = nums.length;

        int[] rets = new int[k];
        Stack<Integer> stacks = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stacks.isEmpty() && stacks.peek() < nums[i] && stacks.size() + (N - i) > k) {
                stacks.pop();
            }

            stacks.add(nums[i]);
        }
        while (!stacks.isEmpty() && stacks.size() > k) {
            stacks.pop();
        }

        for (int i = rets.length - 1; i >= 0; i--) {
            rets[i] = stacks.pop();
        }

        return rets;
    }

    @Test
    public void testGetMaxNumvers() {
        int[] nums = new int[]{9, 1, 2, 5, 8, 3};
        int k = 5;

        int[] maxNumbers = getMaxNumbers(nums, k);
        PrintUtils.print(maxNumbers);
    }
}
