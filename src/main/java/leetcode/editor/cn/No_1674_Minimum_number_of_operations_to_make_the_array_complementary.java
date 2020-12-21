package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/16 5:11 下午
 * @desc: 1674. 使数组互补的最少操作次数
 * <p>
 * 差分数组; 树状数组; 线段树
 * <p>
 * todo: 复习
 * 参考: https://leetcode-cn.com/problems/minimum-moves-to-make-array-complementary/solution/jie-zhe-ge-wen-ti-xue-xi-yi-xia-chai-fen-shu-zu-on/
 */
public class No_1674_Minimum_number_of_operations_to_make_the_array_complementary {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 4, 3};
        int limit = 4;

        int minMoves = minMoves(nums, limit);
        System.out.println(minMoves);
    }

    /**
     * ret[i]: 标识 nums[i] + nums[N-i+1] == i 的时候的最小操作数
     * <p>
     * i 的取值范围: 2 ~ 2 * limit
     * <p>
     * 差分数组:  diff[i] = ret[i] - ret[i-1]
     * diff[0...i] 的和就是结果 ret[i] 的值
     *
     * @param nums
     * @param limit
     * @return
     */
    public int minMoves(int[] nums, int limit) {
        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < nums.length / 2; i++) {
            int firstNum = nums[i];
            int secondNum = nums[nums.length - i - 1];

            // 最大的范围一开始进行2的操作
            int l = 2, r = 2 * limit;
            diff[l] += 2;
            diff[r + 1] -= 2;

            l = 1 + Math.min(firstNum, secondNum);
            r = limit + Math.max(firstNum, secondNum);
            diff[l] += -1;
            diff[r + 1] -= -1;

            l = firstNum + secondNum;
            r = firstNum + secondNum;
            diff[l] += -1;
            diff[r + 1] -= -1;
        }


        int ret = nums.length, sum = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            sum += diff[i];
            if (sum < ret) {
                ret = sum;
            }
        }

        return ret;
    }
}
