package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gzm
 * @date 2020/11/2 7:02 下午
 * @desc: 318. 最大单词长度乘积
 */
public class No_318_Maximum_word_length_product {
    @Test
    public void test() {
        String[] words = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        int maxProduct = maxProduct(words);
        System.out.println(maxProduct);

        int maxProductBit = maxProductBit(words);
        System.out.println(maxProductBit);
    }

    /**
     * 通过位运算优化的方法
     *
     * @param words
     * @return
     */
    public int maxProductBit(String[] words) {
        int[] bits = new int[words.length];

        // 通过位运算来记录一个字符串的信息, 然后通过 & 运算判断是否有重复的字符
        int maxLen = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                bits[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    maxLen = Math.max(maxLen, words[i].length() * words[j].length());
                }
            }
        }

        return maxLen;
    }

    /**
     * 暴利方法
     *
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        Set<Character> sets = new HashSet<>();

        int maxLen = 0;
        for (int i = 0; i < words.length; i++) {
            for (int wIndex = 0; wIndex < words[i].length(); wIndex++) {
                sets.add(words[i].charAt(wIndex));
            }

            for (int j = i + 1; j < words.length; j++) {
                boolean contain = false;
                for (char c : words[j].toCharArray()) {
                    if (sets.contains(c)) {
                        contain = true;
                        break;
                    }
                }

                if (!contain) {
                    maxLen = Math.max(maxLen, words[i].length() * words[j].length());
                }
            }

            sets.clear();
        }

        return maxLen;
    }
}
