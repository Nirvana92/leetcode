package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/14 10:45
 * <p>
 * 1122. 数组的相对排序
 */
public class No_1122_Relative_ordering_of_arrays {
    @Test
    public void test() {

    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upperNum = 0;
        for (int i : arr1) {
            upperNum = Math.max(upperNum, i);
        }

        int[] counts = new int[upperNum + 1];
        for (int i : arr1) {
            counts[i]++;
        }

        int[] rets = new int[arr1.length];
        int index = 0;
        for (int i : arr2) {
            for (int j = 0; j < counts[i]; j++) {
                rets[index++] = i;
            }

            counts[i] = 0;
        }

        for (int i = 0; i <= upperNum; i++) {
            for (int j = 0; j < counts[i]; j++) {
                rets[index++] = i;
            }
        }

        return rets;
    }
}
