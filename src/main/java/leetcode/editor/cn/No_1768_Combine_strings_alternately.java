package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2021/3/1 22:00
 * <p>
 * <p>
 * 1768. 交替合并字符串
 */
public class No_1768_Combine_strings_alternately {
    @Test
    public void test() {
        String w1 = "abc", w2 = "pqr";
        w1 = "ab";
        w2 = "pqrs";

        String mergeAlternately = mergeAlternately(w1, w2);
        System.out.println(mergeAlternately);
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuffer buffer = new StringBuffer();
        int w1Index = 0, w2Index = 0;

        while (w1Index < word1.length() && w2Index < word2.length()) {
            buffer.append(word1.charAt(w1Index));
            buffer.append(word2.charAt(w2Index));

            w1Index++;
            w2Index++;
        }

        while (w1Index < word1.length()) {
            buffer.append(word1.charAt(w1Index++));
        }

        while (w2Index < word2.length()) {
            buffer.append(word2.charAt(w2Index++));
        }

        return buffer.toString();
    }
}
