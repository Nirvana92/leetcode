package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/18 9:47 上午
 * @desc
 */
public class No_389_find_difference {
    @Test
    public void test() {
        String s = "abcd", t = "abcde";

        s = "a";
        t = "aa";

        s = "";
        t = "y";

        s = "ae";
        t = "aea";


        char theDifference = findTheDifference(s, t);
        System.out.println(theDifference);
    }

    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            int curIndex = t.charAt(i) - 'a';
            if (chars[curIndex] == 0) {
                return t.charAt(i);
            }

            chars[curIndex]--;
        }

        return ' ';
    }
}
