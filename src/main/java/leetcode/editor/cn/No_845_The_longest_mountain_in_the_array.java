package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/25 00:01
 * <p>
 * 845. 数组中的最长山脉
 * <p>
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * <p>
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * <p>
 * 如果不含有 “山脉” 则返回 0。
 */
public class No_845_The_longest_mountain_in_the_array {
    @Test
    public void test() {
        int[] a = new int[]{2, 1, 4, 7, 3, 2, 5};
        a = new int[]{2, 2, 2};

        int longestMountain = longestMountain(a);
        System.out.println(longestMountain);
    }

    public int longestMountain(int[] A) {
        int N = A.length;
        // right[i]: 标识 i 开始递减的连续子数组的长度
        int[] right = new int[N];

        // 初始化right 数组
        for (int i = N - 1; i >= 0; i--) {
            if (i == N - 1) {
                right[i] = 1;
            } else {
                if (A[i] > A[i + 1]) {
                    right[i] = right[i + 1] + 1;
                } else {
                    right[i] = 1;
                }
            }
        }

        // 遍历以每个位置为中点找到最长的位置返回
        int preLen = 1, maxLen = 0;
        for (int i = 1; i < N - 1; i++) {
            if (A[i] > A[i - 1]) {
                preLen = preLen + 1;

                // 此时才能满足左边条件
                if (right[i] > 1) {
                    maxLen = Math.max(maxLen, preLen + right[i] - 1);
                }
            } else {
                preLen = 1;
            }
        }

        return maxLen;
    }
}
