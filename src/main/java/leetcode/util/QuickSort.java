package leetcode.util;

import org.nirvana.sort.Utils;

import java.util.Comparator;

/**
 * @author gzm
 * @date 2020/8/11 2:38 下午
 * @desc
 */
public class QuickSort<T> {

    public static <T> void quickSort(T[] arrs, Comparator<T> comparator) {
        if (arrs == null || arrs.length < 2) {
            return;
        }

        process(arrs, 0, arrs.length - 1, comparator);
    }

    private static <T> void process(T[] arrs, int l, int r, Comparator<T> comparator) {
        if (l >= r) {
            return;
        }

        // 取随机数, 总的概率能达到nlogn
        Utils.swap(arrs, l + (int) (Math.random() * (r - l + 1)), r);

        int[] ints = netherlandsFlag(arrs, l, r, comparator);

        process(arrs, l, ints[0] - 1, comparator);
        process(arrs, ints[1] + 1, r, comparator);
    }

    private static <T> int[] netherlandsFlag(T[] arrs, int l, int r, Comparator<T> comparator) {
        if (l > r) {
            return new int[]{-1, -1};
        }

        if (l == r) {
            return new int[]{l, r};
        }

        int lIndex = l - 1, index = l, rIndex = r;

        while (index < rIndex) {
            if (comparator.compare(arrs[index], arrs[r]) < 0) {
                Utils.swap(arrs, index++, ++lIndex);
            } else if (comparator.compare(arrs[index], arrs[r]) < 0) {
                index++;
            } else {
                Utils.swap(arrs, index, --rIndex);
            }
//            if (arrs[index] < arrs[r]) {
//
//            } else if (arrs[index] == arrs[r]) {
//
//            } else {
//
//            }
        }

        Utils.swap(arrs, rIndex, r);

        return new int[]{lIndex + 1, rIndex};
    }
}
