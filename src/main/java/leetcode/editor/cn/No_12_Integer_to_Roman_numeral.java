package leetcode.editor.cn;

import org.junit.Test;

public class No_12_Integer_to_Roman_numeral {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @Test
    public void test() {
        int num = 90;
        String toRoman = intToRoman(num);
        System.out.println(toRoman);
    }

    public String intToRoman(int num) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                buffer.append(symbols[i]);
                num -= values[i];
            }
        }

        return buffer.toString();
    }
}
