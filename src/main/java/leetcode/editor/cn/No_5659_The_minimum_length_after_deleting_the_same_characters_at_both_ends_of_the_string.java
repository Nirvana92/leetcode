package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/2/7 10:25 上午
 * @desc: 5659. 删除字符串两端相同字符后的最短长度
 */
public class No_5659_The_minimum_length_after_deleting_the_same_characters_at_both_ends_of_the_string {
    @Test
    public void test() {
        String s = "ca";
        // s = "cabaabac";
        // s = "aabccabba";
        s = "bbbbbbbbbbbbbbbbbbb";

        int minimumLength = minimumLength(s);
        System.out.println(minimumLength);
    }

    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        char tChar = 0;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            tChar = s.charAt(l);

            l++;
            r--;
            while (l <= r && s.charAt(l) == tChar) {
                l++;
            }

            while (r >= l && s.charAt(r) == tChar) {
                r--;
            }
        }

        return r - l + 1;
    }
}
