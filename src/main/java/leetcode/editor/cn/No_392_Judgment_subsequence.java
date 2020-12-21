package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/22 5:52 下午
 * @desc: 392. 判断子序列
 * <p>
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class No_392_Judgment_subsequence {
    @Test
    public void test() {
        String s = "abc", t = "ahbgdc";

        s = "axc";
        t = "ahbgdc";

        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);
    }

    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;

        for (int i = 0; i < t.length() && sIndex < s.length(); i++) {
            if (s.charAt(sIndex) == t.charAt(i)) {
                sIndex++;
            }
        }

        return sIndex == s.length();
    }
}
