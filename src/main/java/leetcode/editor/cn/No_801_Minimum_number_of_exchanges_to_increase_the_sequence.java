package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/17 16:31
 */
public class No_801_Minimum_number_of_exchanges_to_increase_the_sequence {
    @Test
    public void test() {
        int[] A = new int[]{1, 3, 5, 4};
        int[] B = new int[]{1, 2, 3, 7};

        A = new int[]{1, 5, 5, 8, 11};
        B = new int[]{2, 3, 6, 6, 10};

        int minSwap = minSwap(A, B);
        int processDp = processDp(A, B);
        System.out.println("minSwap: " + minSwap);
        System.out.println("processDp: " + processDp);
    }

    public int minSwap(int[] A, int[] B) {
        return process(A, B, 0);
    }

    /**
     * 动态规划最终版本的解题思路
     *
     * @param A
     * @param B
     * @return
     */
    int processDp(int[] A, int[] B) {
        if (A.length <= 1) {
            return A.length;
        }

        int N = A.length;
        // preChangeNum: 0 ... i-1, i-1 位置交换需要满足条件的最小交换次数
        // preNoChangeNum: o ... i-1, i-1 位置没有交换满足条件的最小交换次数
        int preChangeNum = 1, preNoChangeNum = 0;
        for (int i = 1; i < N; i++) {
            // 1. 本次不改变
            // 1.1. 前面没改变的
            // 1.2. 前面改变了
            int curChangeNum = Integer.MAX_VALUE, curNoChangeNum = Integer.MAX_VALUE;
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                // 当前没交换能够正常满足条件, 可以计算当前没有交换的统计
                curNoChangeNum = Math.min(curNoChangeNum, preNoChangeNum);
                // 当前没有交换, 如果前面交换了, 则可以计算本次交换的最小次数, 等同于两边都交换了
                curChangeNum = Math.min(curChangeNum, 1 + preChangeNum);
            }

            // 2. 本次改变
            // 2.1. 前面没改变
            // 2.2. 前面改变了
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                curNoChangeNum = Math.min(curNoChangeNum, preChangeNum);
                curChangeNum = Math.min(curChangeNum, 1 + preNoChangeNum);
            }

            // 求得最后的值, 迭代
            preChangeNum = curChangeNum;
            preNoChangeNum = curNoChangeNum;
        }

        // 然后返回哪次最少返回
        return Math.min(preNoChangeNum, preChangeNum);
    }

    int process(int[] A, int[] B, int index) {
        if (index == A.length) {
            return 0;
        }

        // 不交换当前位置
        int p1 = process(A, B, index + 1);
        if (index > 0) {
            // 验证是否递增
            if (!(A[index] > A[index - 1] && B[index] > B[index - 1])) {
                p1 = Integer.MAX_VALUE;
            }
        }
        // 交换当前位置
        // swap(A, B, index);
        int p2 = process(A, B, index + 1);
        p2 = (p2 == Integer.MAX_VALUE) ? Integer.MAX_VALUE : (p2 + 1);
        if (index > 0) {
            // 验证是否递增
            if (!(A[index] > A[index - 1] && B[index] > B[index - 1])) {
                p2 = Integer.MAX_VALUE;
            }
        }
        swap(A, B, index);

        return Math.min(p1, p2);
    }

    void swap(int[] A, int[] B, int index) {
        int tmp = A[index];
        A[index] = B[index];
        B[index] = tmp;
    }
}
