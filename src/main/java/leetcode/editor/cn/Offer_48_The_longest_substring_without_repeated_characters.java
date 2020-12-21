package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/30 23:48
 * <p>
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * <p>
 * 通过滑动窗口处理
 */
public class Offer_48_The_longest_substring_without_repeated_characters {
    @Test
    public void test() {
        String s = "abcabcbb";
        s = "bbbbb";
        s = "pwwkew";
        s = "";
        s = "au";
        s = " ";
//        s = "aabaab!bb";


        int lengthOfLongestSubstring = lengthOfLongestSubstring(s);
        System.out.println(lengthOfLongestSubstring);
    }

    public int lengthOfLongestSubstring(String s) {
        int N = s.length();
        if (N == 0) {
            return 0;
        }

        int maxLen = 0;
        int[] counts = new int[256];
        int r = 0;
        for (int i = 0; i < N; i++) {
            while (r < N && counts[s.charAt(r)] == 0) {
                counts[s.charAt(r)]++;
                r++;
            }

            maxLen = Math.max(maxLen, r - i);
            counts[s.charAt(i)]--;
        }

        return maxLen;
    }

    @Test
    public void t() {
        char c = ' ';
        System.out.println((int) c);
        System.out.println((int) 'a');
    }
}
