package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/19 5:55 下午
 * @desc: 1186. 删除一次得到子数组最大和
 */
public class No_1186_maximum_subarray_sum_with_one_deletion {
    @Test
    public void test() {
        int[] arr = new int[]{1, -2, 0, 3};

        arr = new int[]{1, -2, -2, 3};
        arr = new int[]{-1, -1, -1, -1};

        arr = new int[]{1};

        int maximumSum = maximumSum(arr);
        System.out.println(maximumSum);
    }

    public int maximumSum(int[] arr) {
        int N = arr.length;
        if (N == 0 || N == 1) {
            return N == 0 ? 0 : arr[0];
        }
        // 首先建立两个dp 数组
        // int[] lToRDp
        int[] lToRDp = new int[N];
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                lToRDp[i] = arr[i];
            } else {
                lToRDp[i] = Math.max(arr[i], arr[i] + lToRDp[i - 1]);
            }
        }
        // int[] rToLDp
        int[] rToLDp = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            if (i == N - 1) {
                rToLDp[i] = arr[i];
            } else {
                rToLDp[i] = Math.max(arr[i], arr[i] + rToLDp[i + 1]);
            }
        }

        // 遍历每个点可能会被删除[可删可不删]
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                maxSum = Math.max(maxSum, Math.max(rToLDp[i + 1], rToLDp[i]));
            } else if (i == N - 1) {
                maxSum = Math.max(maxSum, Math.max(lToRDp[i], lToRDp[i - 1]));
            } else {
                maxSum = Math.max(maxSum, Math.max(lToRDp[i - 1] + rToLDp[i + 1], lToRDp[i - 1] + arr[i] + rToLDp[i + 1]));
            }
        }

        return maxSum;
    }
}
