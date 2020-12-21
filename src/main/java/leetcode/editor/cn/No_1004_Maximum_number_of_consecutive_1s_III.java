package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/19 11:36 上午
 * @desc: 1004. 最大连续1的个数 III
 * <p>
 * 使用滑动窗口处理该问题
 */
public class No_1004_Maximum_number_of_consecutive_1s_III {
    @Test
    public void test() {
        int[] A = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int K = 2;

//        A = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
//        K = 3;

        A = new int[]{0, 1, 1, 1, 0, 0, 1, 1, 1};
        K = 2;

        int longestOnes = longestOnes(A, K);
        System.out.println(longestOnes);
    }

    public int longestOnes(int[] A, int K) {
        int fill1Nums = 0;
        int N = A.length;

        int r = 0, longest1Nums = 0;
        for (int i = 0; i < N; i++) {
            while (r < N) {
                if (fill1Nums < K || A[r] == 1) {
                    if (A[r] == 0) {
                        fill1Nums++;
                    }
                    r++;

                    continue;
                }
                break;
            }

            // 退出上面的循环 fill1Nums >= K 或者 r>=N
            longest1Nums = Math.max(longest1Nums, r - i);
            if (A[i] == 0) {
                fill1Nums--;
            }
        }

        return longest1Nums;
    }
}
