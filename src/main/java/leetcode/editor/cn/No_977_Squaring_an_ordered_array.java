package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/10/16 11:12 上午
 * @desc: 977. 有序数组的平方
 * <p>
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例:
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 */
public class No_977_Squaring_an_ordered_array {
    @Test
    public void test() {
        int[] A = new int[]{-4, -1, 0, 3, 10};
        // A = new int[]{-7, -3, 2, 3, 11};
        int[] sortedSquares = sortedSquares(A);
        PrintUtils.print(sortedSquares);
    }

    public int[] sortedSquares(int[] A) {
        if (A.length == 0) {
            return new int[0];
        }
        int[] rsts = new int[A.length];
        int l = 0, r = A.length - 1, curIndex = rsts.length - 1;
        while (l <= r) {
            if (Math.abs(A[l]) > Math.abs(A[r])) {
                rsts[curIndex--] = (int) Math.pow(A[l++], 2);
            } else {
                rsts[curIndex--] = (int) Math.pow(A[r--], 2);
            }
        }

        return rsts;
    }
}
