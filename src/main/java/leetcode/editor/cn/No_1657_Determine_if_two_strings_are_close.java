package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2020/11/16 8:05 下午
 * @desc: 1657. 确定两个字符串是否接近
 * <p>
 */
public class No_1657_Determine_if_two_strings_are_close {
    @Test
    public void test() {
        String w1 = "abc", w2 = "bca";
//        w1 = "cabbba";
//        w2 = "aabbss";

        w1 = "uau";
        w2 = "ssx";

        w1 = "a";
        w2 = "aa";

        boolean closeStrings = closeStrings(w1, w2);
        System.out.println(closeStrings);
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        // 记录字符的个数
        int[] counts1 = new int[26], counts2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            counts1[word1.charAt(i) - 'a']++;
            counts2[word2.charAt(i) - 'a']++;
        }

        // 判断两个字符串的字符种类是否相同
        for (int i = 0; i < 26; i++) {
            if ((counts1[i] > 0 && counts2[i] == 0) || (counts1[i] == 0 && counts2[i] > 0)) {
                return false;
            }
        }

        Map<Integer, Integer> w1Maps = new HashMap<>(), w2Maps = new HashMap<>();
        for (int i = 0; i < counts1.length; i++) {
            if (counts1[i] != 0) {
                w1Maps.put(counts1[i], w1Maps.getOrDefault(counts1[i], 0) + 1);
            }
        }

        for (int i = 0; i < counts1.length; i++) {
            if (counts2[i] != 0) {
                w2Maps.put(counts2[i], w2Maps.getOrDefault(counts2[i], 0) + 1);
            }
        }

        // 判断相同个数的字符是否相同
        for (Map.Entry<Integer, Integer> entry : w1Maps.entrySet()) {
            if (!entry.getValue().equals(w2Maps.getOrDefault(entry.getKey(), 0))) {
                return false;
            } else {
                w2Maps.remove(entry.getKey());
            }
        }

        return w2Maps.size() == 0;
    }
}
