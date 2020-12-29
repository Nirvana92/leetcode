package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/28 11:31 上午
 * @desc: 1704. 判断字符串的两半是否相似
 * <p>
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 思路: 以中间的位置为分割点, 然后遍历一遍数组, 求两边的元音的个数, 最后判断是否相等即可
 */
public class No_1704_Determine_whether_the_two_halves_of_the_string_are_similar {
    @Test
    public void test() {
        String s = "book";
        s = "textbook";
        s = "MerryChristmas";
        s = "AbCdEfGh";

        boolean halvesAreAlike = halvesAreAlike(s);
        System.out.println(halvesAreAlike);
    }

    public boolean halvesAreAlike(String s) {
        int len = s.length();

        int midIndex = len >> 1;
        int leftCounts = 0, rightCounts = 0;

        for (int i = 0; i < len; i++) {
            if (isVowel(s.charAt(i))) {
                if (i < midIndex) {
                    leftCounts++;
                } else {
                    rightCounts++;
                }
            }
        }

        return leftCounts == rightCounts;
    }

    /**
     * 判断是否是元音
     *
     * @param c
     * @return
     */
    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
