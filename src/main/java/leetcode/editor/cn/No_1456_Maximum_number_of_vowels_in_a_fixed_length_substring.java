package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/31 19:42
 * <p>
 * 1456. 定长子串中元音的最大数目
 */
public class No_1456_Maximum_number_of_vowels_in_a_fixed_length_substring {
    @Test
    public void test() {
        String s = "abciiidef";
        int k = 3;

        s = "aeiou";
        k = 2;

        s = "leetcode";
        k = 3;

        s = "rhythms";
        k = 3;

        s = "tryhard";
        k = 4;

        int maxVowels = maxVowels(s, k);
        System.out.println(maxVowels);
    }

    public int maxVowels(String s, int k) {
        int maxLen = 0;
        int N = s.length();
        int r = 0, tmpLen = 0;
        for (int i = 0; i < N; i++) {
            while (r < N && r - i < k) {
                if (s.charAt(r) == 'a' || s.charAt(r) == 'e' || s.charAt(r) == 'i' || s.charAt(r) == 'o' || s.charAt(r) == 'u') {
                    tmpLen++;
                }
                r++;
            }

            maxLen = Math.max(maxLen, tmpLen);

            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                tmpLen--;
            }
        }

        return maxLen;
    }
}
