package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nirvana
 * @date 2020/10/24 20:47
 * <p>
 * 1481. 不同整数的最少数目
 * <p>
 * 给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
 */
public class No_1481_Minimum_number_of_different_integers {
    @Test
    public void test() {

    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int num : arr) {
            maps.put(num, maps.getOrDefault(num, 0) + 1);
        }

        // counts 中村某个数出现的个数
        int index = 0;
        int[] counts = new int[maps.size()];
        for (Integer key : maps.keySet()) {
            counts[index++] = maps.get(key);
        }

        Arrays.sort(counts);

        int minNumOfDiffVal = maps.size();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] <= k) {
                minNumOfDiffVal--;
                k -= counts[i];
            } else {
                break;
            }
        }

        return minNumOfDiffVal;
    }
}
