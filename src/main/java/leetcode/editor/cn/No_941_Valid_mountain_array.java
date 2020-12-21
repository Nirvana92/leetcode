package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/3 9:41 上午
 * @desc: 941. 有效的山脉数组
 */
public class No_941_Valid_mountain_array {
    @Test
    public void test() {
        int[] A = new int[]{2, 1};
        A = new int[]{3, 5, 5};
        A = new int[]{0, 3, 2, 1};
        A = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        boolean validMountainArray = validMountainArray(A);
        System.out.println(validMountainArray);
    }

    public boolean validMountainArray(int[] A) {
        int N = A.length;
        if (N < 3) {
            return false;
        }

        int startIndex = 0, endIndex = N - 1;
        for (int i = 1; i < N; i++) {
            if (A[i] > A[i - 1]) {
                startIndex = i;
            } else {
                break;
            }
        }

        for (int i = N - 2; i > 0; i--) {
            if (A[i] > A[i + 1]) {
                endIndex = i;
            } else {
                break;
            }
        }


        return (startIndex != 0 && endIndex != N - 1) && startIndex == endIndex;
    }
}
