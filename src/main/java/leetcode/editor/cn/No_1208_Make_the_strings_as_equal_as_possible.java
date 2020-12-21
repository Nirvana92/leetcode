package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/31 19:55
 * <p>
 * 1208. 尽可能使字符串相等
 */
public class No_1208_Make_the_strings_as_equal_as_possible {
    @Test
    public void test() {
        String s = "abcd", t = "bcdf";
        int maxCost = 3;

        s = "abcd";
        t = "cdef";
        maxCost = 3;

        s = "abcd";
        t = "acde";
        maxCost = 1;

        int equalSubstring = equalSubstring(s, t, maxCost);
        System.out.println(equalSubstring);
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int N = s.length();

        int r = 0, maxEqualSubStrs = 0;
        int tmpCost = 0;
        for (int i = 0; i < N; i++) {
            while (r < N && tmpCost <= maxCost) {
                tmpCost += Math.abs(s.charAt(r) - t.charAt(r));
                r++;
            }
            if (tmpCost <= maxCost) {
                maxEqualSubStrs = Math.max(maxEqualSubStrs, r - i);
            } else {
                maxEqualSubStrs = Math.max(maxEqualSubStrs, r - 1 - i);
            }

            tmpCost -= Math.abs(s.charAt(i) - t.charAt(i));
        }

        return maxEqualSubStrs;
    }
}
