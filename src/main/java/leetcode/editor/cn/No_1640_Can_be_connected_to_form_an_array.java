package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2020/11/2 12:56 下午
 * @desc: 1640. 能否连接形成数组
 */
public class No_1640_Can_be_connected_to_form_an_array {
    @Test
    public void test() {
        int[] arr = new int[]{85};
        int[][] prices = new int[][]{{85}};

        arr = new int[]{15, 88};
        prices = new int[][]{{88}, {15}};

//        arr = new int[]{49, 18, 16};
//        prices = new int[][]{{16, 18, 49}};

//        arr = new int[]{91, 4, 64, 78};
//        prices = new int[][]{{78}, {4, 64}, {91}};

        arr = new int[]{1, 3, 5, 7};
        prices = new int[][]{{2, 4, 6, 8}};

        boolean canFormArray = canFormArray(arr, prices);
        System.out.println(canFormArray);
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < pieces.length; i++) {
            maps.put(pieces[i][0], i);
        }

        int i = 0;
        while (i < arr.length) {
            if (!maps.containsKey(arr[i])) {
                return false;
            }
            int curFirstVal = arr[i];
            Integer index = maps.get(curFirstVal);
            int[] curPieces = pieces[index];
            for (int j = 0; j < curPieces.length; j++, i++) {
                if (arr[i] != curPieces[j]) {
                    return false;
                }
            }

            maps.remove(curFirstVal);
        }

        return true;
    }
}
