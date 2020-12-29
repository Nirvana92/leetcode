package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/29 5:25 下午
 * @desc: 557. 反转字符串中的单词 III
 */
public class No_557_Reverse_words_in_a_string_III {
    @Test
    public void test() {
        String s = "Let's take LeetCode contest";

        String reverseWords = reverseWords(s);
        System.out.println(reverseWords);
    }

    public String reverseWords(String s) {
        String[] strs = s.split(" ");

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            buffer.append(reverseWord(strs[i])).append(" ");
        }

        return buffer.substring(0, buffer.length() - 1);
    }

    String reverseWord(String word) {
        char[] ws = word.toCharArray();

        int l = 0, r = ws.length - 1;

        while (l < r) {
            char tmpChar = ws[l];
            ws[l] = ws[r];
            ws[r] = tmpChar;

            l++;
            r--;
        }

        return new String(ws);
    }
}
