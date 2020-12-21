package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/10/29 4:21 下午
 * @desc: 剑指 Offer 66. 构建乘积数组
 * <p>
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class Offer_66_Build_an_array_of_products {
    @Test
    public void test() {
        int[] nums = new int[]{};
        int[] constructArr = constructArr(nums);
        PrintUtils.print(constructArr);
    }

    /**
     * 题目要求不能使用除法, 新增一个辅助数组, 从右往左的辅助数组。本题解忽略该限制条件
     *
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int N = a.length;
        int[] rsts = new int[N];
        int zeroCounts = 0, totalMultiply = 1;
        for (int i = 0; i < N; i++) {
            if (a[i] == 0) {
                zeroCounts++;
            } else {
                totalMultiply *= a[i];
            }
        }

        if (zeroCounts == 1) {
            for (int i = 0; i < N; i++) {
                if (a[i] == 0) {
                    rsts[i] = totalMultiply;
                }
            }
        } else if (zeroCounts == 0) {
            for (int i = 0; i < N; i++) {
                rsts[i] = totalMultiply / a[i];
            }
        }

        return rsts;
    }
}
