package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author gzm
 * @date 2020/10/28 9:40 上午
 * @desc: 1207. 独一无二的出现次数
 */
public class No_1207_Unique_occurrences {
    @Test
    public void test() {

    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countNums = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            countNums.put(arr[i], countNums.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> timeSets = new HashSet<>();
        for (Integer value : countNums.values()) {
            if (timeSets.contains(value)) {
                return false;
            }

            timeSets.add(value);
        }

        return true;
    }
}
