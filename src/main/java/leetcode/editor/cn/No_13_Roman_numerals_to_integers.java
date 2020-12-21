package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class No_13_Roman_numerals_to_integers {
    @Test
    public void test() {
        String str = "III";
        str = "IV";
        str = "IX";
        str = "LVIII";
        str = "MCMXCIV";
        int romanToInt = romanToInt(str);
        System.out.println(romanToInt);
    }

    public int romanToInt(String s) {
        Map<String, Integer> maps = new HashMap<>();
        maps.put("M", 1000);
        maps.put("CM", 900);
        maps.put("D", 500);
        maps.put("CD", 400);
        maps.put("C", 100);
        maps.put("XC", 90);
        maps.put("L", 50);
        maps.put("XL", 40);
        maps.put("X", 10);
        maps.put("IX", 9);
        maps.put("V", 5);
        maps.put("IV", 4);
        maps.put("I", 1);

        char[] chars = s.toCharArray();

        int N = chars.length;
        int curIndex = 0, numeral = 0;
        while (curIndex < N) {
            if (curIndex + 1 < N && maps.containsKey(chars[curIndex] + "" + chars[curIndex + 1])) {
                numeral += maps.get(chars[curIndex] + "" + chars[curIndex + 1]);
                curIndex += 2;
            } else {
                numeral += maps.get(chars[curIndex] + "");
                curIndex += 1;
            }
        }

        return numeral;
    }
}
