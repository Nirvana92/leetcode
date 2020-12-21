package leetcode.editor.cn;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nirvana
 * @date 2020/10/14 22:55
 */
public class No_424_Longest_repeated_character_after_replacement {
    @Test
    public void test() {
        String s = "A";
        int k = 2;

        s = "AABABBA";
        k = 1;

//        s = "ABABBB";
//        k = 1;

        int characterReplacement = characterReplacement(s, k);
        System.out.println(characterReplacement);
    }

    /**
     * todo: 可能需要改写有序表, 当计数的值调整之后, 需要快速拿到最大的数量值
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();

        Map<Character, Integer> countMaps = new HashMap<>();
        int maxLen = 0;
        int R = 0;
        int windowMaxLen = 1;
        countMaps.put(chars[R], countMaps.getOrDefault(chars[R], 0) + 1);
        for (int i = 0; i < chars.length; i++) {
            // countMaps.put(chars[i], countMaps.getOrDefault(chars[i], 0) + 1);
            while (R < chars.length && ((R - i + 1) - windowMaxLen) <= k) {
                R++;
                if (R < chars.length) {
                    countMaps.put(chars[R], countMaps.getOrDefault(chars[R], 0) + 1);
                    windowMaxLen = Math.max(windowMaxLen, countMaps.get(chars[R]));
                }
            }

            // 统计下结果
            maxLen = Math.max(maxLen, R - i);
            countMaps.put(chars[i], countMaps.getOrDefault(chars[i], 0) - 1);
            windowMaxLen = countMaps.values().stream().max(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            }).get();
        }

        return maxLen;
    }
}
