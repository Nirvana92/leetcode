package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/11/16 4:54 下午
 * @desc: 面试题 10.01. 合并排序的数组
 * <p>
 * 双指针
 */
public class Interview_question_10_01_Merge_sorted_array {

    @Test
    public void test() {
        int[] a = new int[]{1, 2, 3, 0, 0, 0};
        int[] b = new int[]{2, 5, 6};
        int m = 3, n = 3;

        merge(a, m, b, n);
        PrintUtils.print(a);
    }

    public void merge(int[] A, int m, int[] B, int n) {
        m -= 1;
        n -= 1;

        int index = A.length - 1;
        while (m >= 0 && n >= 0) {
            if (A[m] > B[n]) {
                A[index--] = A[m--];
            } else {
                A[index--] = B[n--];
            }
        }

        if (m >= 0) {
            for (int i = m; i >= 0; i--) {
                A[index--] = A[i];
            }
        } else {
            for (int i = n; i >= 0; i--) {
                A[index--] = B[i];
            }
        }
    }
}
