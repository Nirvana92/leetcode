package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author gzm
 * @date 2020/11/6 10:23 上午
 * @desc: 1356. 根据数字二进制下 1 的数目排序
 */
public class No_1356_Sort_according_to_the_number_of_1s_in_digital_binary {


    public int[] sortByBits(int[] arr) {
        int[] counts = new int[10001];
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            lists.add(arr[i]);
            counts[arr[i]] = getBits(arr[i]);
        }

        Collections.sort(lists, (i1, i2) -> {
            if (counts[i1] != counts[i2]) {
                return counts[i1] - counts[i2];
            } else {
                return i1 - i2;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = lists.get(i);
        }

        return arr;
    }

    int getBits(int num) {
        int count = 0;

        while (num != 0) {
            num -= num & (~num + 1);

            count++;
        }

        return count;
    }

    @Test
    public void testGetBits() {
        // System.out.println(getBits(3));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println((byte) (1 << 7));
    }
}
