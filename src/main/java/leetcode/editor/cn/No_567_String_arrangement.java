package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/30 23:29
 * <p>
 * 567. 字符串的排列
 */
public class No_567_String_arrangement {
    @Test
    public void test() {
        String s1 = "ab", s2 = "eidbaooo";
        s1 = "ab";
        s2 = "eidboaoo";

        boolean checkInclusion = checkInclusion(s1, s2);
        System.out.println(checkInclusion);
    }

    /**
     * 1. 首先对 s1 字符串进行计数
     * 2. 然后对比两个计数是否都相同
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int limitLen = s1.length();
        int[] _1Counts = new int[26];
        for (int i = 0; i < limitLen; i++) {
            _1Counts[s1.charAt(i) - 'a']++;
        }

        int[] _2Counts = new int[26];
        int r = 0;
        for (int i = 0; i < s2.length(); i++) {
            while (r - i < limitLen && r < s2.length()) {
                _2Counts[s2.charAt(r) - 'a']++;
                r++;
            }

            boolean match = match(_1Counts, _2Counts);
            if (match) {
                return true;
            }

            _2Counts[s2.charAt(i) - 'a']--;
        }

        return false;
    }

    boolean match(int[] _1Counts, int[] _2Counts) {
        for (int i = 0; i < _1Counts.length; i++) {
            if (_1Counts[i] != 0) {
                if (_1Counts[i] != _2Counts[i]) {
                    return false;
                }
            }
        }

        return true;
    }
}
