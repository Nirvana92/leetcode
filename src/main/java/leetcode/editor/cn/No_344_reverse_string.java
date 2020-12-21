package leetcode.editor.cn;

import org.junit.Test;

public class No_344_reverse_string {
    @Test
    public void test() {

    }

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        Character tmp = null;
        while (l < r) {
            tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;

            l++;
            r--;
        }
    }
}
