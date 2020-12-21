package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/25 22:18
 * <p>
 * 477. 汉明距离总和
 * <p>
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * <p>
 * 思路: 计算每一位的1 的个数. 然后通过公式计算在这个位上组合的结果数
 * 公式: 1的个数 i, 0 的个数 j. 则汉明距离: i*j
 */
public class No_477_Sum_of_hamming_distance {
    @Test
    public void test() {
        int[] nums = new int[]{4, 14, 2};
        int totalHammingDistance = totalHammingDistance(nums);
        System.out.println(totalHammingDistance);
    }

    public int totalHammingDistance(int[] nums) {
        int totalDis = 0;

        for (int i = 0; i < 32; i++) {
            int _1Nums = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    _1Nums++;
                }
            }

            totalDis += _1Nums * (nums.length - _1Nums);
        }

        return totalDis;
    }
}
