package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/4/7 5:11 下午
 * @desc: 1813. 句子相似性 III-[提交未通过的代码 ]
 */
public class No_1813_Sentence_similarity_III {
    @Test
    public void test() {
        String s1 = "My name is Haley", s2 = "My Haley";

        s1 = "of";
        s2 = "A lot of words";

        s1 = "Eating right now";
        s2 = "Eating";

        s1 = "Luky";
        s2 = "Lucccky";

        s1 = "right now Eating";
        s2 = "Eating";

        s1 = "hello";
        s2 = "hello";

        s1 = "aa";
        s2 = "a Aa";

        s1 = "x";
        s2 = "y";

        boolean areSentencesSimilar = areSentencesSimilar(s1, s2);
        System.out.println(areSentencesSimilar);
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // 判断两个字符串的长度然后保证短的在 s2, 长的在s1
        if (sentence2.length() > sentence1.length()) {
            String tmp = sentence1;
            sentence1 = sentence2;
            sentence2 = tmp;
        }

        // sentence1 的左右指针
        int s1L = 0, s1R = sentence1.length() - 1;
        // sentence2 的左右指针
        int s2L = 0, s2R = sentence2.length() - 1;

        while (s2L <= s2R) {
            // 如果短的字符串还没有遍历完
            // 如果字符串的左边相等
            if (sentence1.charAt(s1L) == sentence2.charAt(s2L)) {
                s1L++;
                s2L++;
            } else if (sentence1.charAt(s1R) == sentence2.charAt(s2R)) {
                // 如果字符串的右边相等
                s1R--;
                s2R--;
            } else {
                // 两边都不能移动.
                break;
            }
        }

        if (s2L < s2R) {
            return false;
        } else {
            // 判断s2 的左右是否有移动。
            return s1L == sentence1.length()
                    || (s1L == 0 && sentence1.charAt(s1R) == ' ')
                    || (s1R == sentence1.length() - 1 && sentence1.charAt(s1L) == ' ')
                    || (sentence1.charAt(s1L - 1) == ' ' && sentence1.charAt(s1R) == ' ');
        }

    }
}
