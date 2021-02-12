package leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author gzm
 * @date 2021/1/22 9:09 上午
 * @desc: 989. 数组形式的整数加法
 */
public class No_989_Integer_addition_in_array_form {
    @Test
    public void test() {
        int[] a = new int[]{1, 2, 0, 0};
        int k = 34;

        a = new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        k = 1;

        a = new int[]{2, 1, 5};
        k = 806;

        a = new int[]{0};
        k = 23;

        List<Integer> list = addToArrayForm(a, k);
        System.out.println(list);
    }

    public List<Integer> addToArrayForm(int[] a, int k) {
        int carryNum = 0;
        LinkedList<Integer> results = new LinkedList<>();

        int i = a.length - 1;
        while (k > 0 || i >= 0) {
            int curK = k % 10 + carryNum;
            if (i >= 0) {
                curK += a[i];
            }
            carryNum = curK / 10;
            results.addFirst(curK % 10);

            k = k / 10;
            i--;
        }
        if (carryNum > 0) {
            results.addFirst(carryNum);
        }

        return results;
    }
}
