package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gzm
 * @date 2021/2/1 2:58 下午
 * @desc: 1743. 从相邻元素对还原数组
 */
public class No_5665_Restore_array_from_adjacent_element_pairs {
    @Test
    public void test() {
        int[][] adjacentPairs = new int[][]{{2, 1}, {3, 4}, {3, 2}};
        adjacentPairs = new int[][]{{4, -2}, {1, 4}, {-3, 1}};

        int[] restoreArray = restoreArray(adjacentPairs);
        PrintUtils.print(restoreArray);
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        int len = adjacentPairs.length;

        Map<Integer, List<Integer>> maps = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int firstNum = adjacentPairs[i][0];
            int secondNum = adjacentPairs[i][1];

            List<Integer> firstList = maps.getOrDefault(firstNum, new ArrayList<>());
            firstList.add(secondNum);
            maps.put(firstNum, firstList);

            List<Integer> secondList = maps.getOrDefault(secondNum, new ArrayList<>());
            secondList.add(firstNum);
            maps.put(secondNum, secondList);
        }

        // size == 1 的时候
        int[] results = new int[maps.size()];
        int lIndex = 0;
        for (Map.Entry<Integer, List<Integer>> entry : maps.entrySet()) {
            if (entry.getValue().size() == 1) {
                results[lIndex++] = entry.getKey();
                int nextVal = entry.getValue().get(0);
                results[lIndex++] = nextVal;
                maps.get(nextVal).remove(entry.getKey());
                maps.remove(entry.getKey());
                break;
            }
        }
        while (lIndex <= len) {
            Integer preVal = results[lIndex - 1];
            List<Integer> lists = maps.get(preVal);
            results[lIndex++] = lists.get(0);

            maps.get(lists.get(0)).remove(preVal);
            maps.remove(preVal);
        }

        return results;
    }
}
