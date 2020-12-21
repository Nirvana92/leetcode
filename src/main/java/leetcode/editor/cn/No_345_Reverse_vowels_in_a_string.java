package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/17 8:10 下午
 * @desc: 345. 反转字符串中的元音字母
 */
public class No_345_Reverse_vowels_in_a_string {
    @Test
    public void test() {
        String s = "hello";
        s = "leetcode";
        s = "lEEtcOdE";

        String reverseVowels = reverseVowels(s);
        System.out.println(reverseVowels);
    }

    public String reverseVowels(String s) {
        int N = s.length();
        int startIndex = 0, endIndex = N - 1;

        char[] chars = s.toCharArray();
        while (startIndex < endIndex) {
            while (startIndex < N && !check(s.charAt(startIndex))) {
                startIndex++;
            }

            while (endIndex >= 0 && !check(s.charAt(endIndex))) {
                endIndex--;
            }

            if (startIndex < endIndex) {
                swap(chars, startIndex, endIndex);
                startIndex++;
                endIndex--;
            }
        }

        return new String(chars);
    }

    void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    /**
     * 判断是否是元音字符
     *
     * @param c
     * @return
     */
    boolean check(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
