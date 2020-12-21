package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class No_387_first_uniq_char {
    @Test
    public void test() {

    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            countMap.put(chars[i], countMap.getOrDefault(chars[i], 0) + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            if (countMap.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }
}
