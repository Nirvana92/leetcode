package leetcode.editor.cn;

import org.nirvana.util.Utils;

import java.util.Arrays;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No_718 {

    public static void main(String[] args) {
//        int[] A = new int[]{1,2,3,2,1};
//        int[] B = new int[]{3,2,1,4,7};

        No_718 no_718 = new No_718();
        int times = 1000, arrLenBase = 1, arrLenMax = 10, arrValBase = 0, arrValMax = 100;

        while (times-- > 0) {
            int[] A = Utils.generIntArr(arrLenBase, arrLenMax, arrValBase, arrValMax);
            int[] B = Utils.generIntArr(arrLenBase, arrLenMax, arrValBase, arrValMax);

            int length = no_718.findLength(A, B);
            int lengthWithViolence = no_718.findLengthWithViolence(A, B);

            if(length != lengthWithViolence) {
                System.out.println("--------------------------");
                System.out.println(Arrays.toString(A));
                System.out.println(Arrays.toString(B));
                System.out.printf(" with dp len: %d ", length);
                System.out.printf(" with violence len: %d \n", lengthWithViolence);

            }
        }



    }

    /**
     * 压缩空间的方法 [动态规划]
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int maxLen = 0;

        int[] dp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if(A[i] == B[0]) {
                dp[i] = 1;
                maxLen = Math.max(dp[i], maxLen);
            }
        }

        int preDp = 0, tmp = 0;
        for (int j = 1; j < B.length; j++) {
            preDp = 0;
            for (int i = 0; i < A.length; i++) {
                tmp = A[i] == B[j] ? (1 + preDp) : 0;
                preDp = dp[i];
                dp[i] = tmp;

                maxLen = Math.max(dp[i], maxLen);
            }
        }

        return maxLen;
    }

    /**
     * 未压缩空间的方法. [动态规划]
     * @param A
     * @param B
     * @return
     */
    public int findLengthWithNoCompressedSpace(int[] A, int[] B) {
        int maxLen = 0;

        int[][] dp = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            if(A[i] == B[0]) {
                dp[i][0] = 1;
                maxLen = Math.max(dp[i][0], maxLen);
            }
        }

        for (int i = 1; i < B.length; i++) {
            if(A[0] == B[i]) {
                dp[0][i] = 1;
                maxLen = Math.max(dp[0][i], maxLen);
            }
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if(A[i] == B[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;

                    maxLen = Math.max(dp[i][j], maxLen);
                }
            }
        }

        return maxLen;
    }

    /**
     * 暴力解法
     * @param A
     * @param B
     * @return
     */
    public int findLengthWithViolence(int[] A, int[] B) {
        int maxLen = 0;
        for (int i = 0; i < A.length; i++) {
            int tmpMaxLen = 0;
            for (int j = 0; j < B.length; j++) {
                int tmpLen = 0, indexI = i, indexJ = j;
                while (indexI<A.length && indexJ<B.length && A[indexI++] == B[indexJ++]) {
                    tmpLen ++;
                }

                tmpMaxLen = Math.max(tmpMaxLen, tmpLen);
            }

            maxLen = Math.max(maxLen, tmpMaxLen);
        }

        return maxLen;
    }
}
