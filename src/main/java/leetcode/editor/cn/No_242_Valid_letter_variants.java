package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class No_242_Valid_letter_variants {
    @Test
    public void test() {
        String s = "anagram", t = "nagaram";
        s = "rat";
        t = "car";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        if (s.length() == 0 && t.length() == 0) {
            return true;
        }

        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();

        Map<Character, Integer> countMaps = new HashMap<>();
        for (char c : ss) {
            countMaps.put(c, countMaps.getOrDefault(c, 0) + 1);
        }

        for (char c : ts) {
            Integer count = countMaps.getOrDefault(c, 0);
            if (count <= 0) {
                return false;
            }

            countMaps.put(c, count - 1);
        }

        return true;
    }
}
