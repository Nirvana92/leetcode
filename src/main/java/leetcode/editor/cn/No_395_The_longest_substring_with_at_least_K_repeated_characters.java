package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nirvana
 * @date 2021/2/28 00:27
 * <p>
 * 395. 至少有 K 个重复字符的最长子串
 * <p>
 * 滑动窗口的处理方法可以固定字符的种类。比如1 种字符。 2 中字符。。。。
 * 一次往后遍历26 中字符的种类求得最后的最大值。返回结果
 */
public class No_395_The_longest_substring_with_at_least_K_repeated_characters {
    @Test
    public void test() {
        String s = "aaabb";
        int k = 3;

        int longestSubstring = longestSubstring(s, k);
        System.out.println(longestSubstring);
    }

    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
        }


        for (Character c : counts.keySet()) {
            if (counts.get(c) < k) {
                int result = 0;
                for (String str : s.split(String.valueOf(c))) {
                    result = Math.max(result, longestSubstring(str, k));
                }
                return result;
            }
        }

        return s.length();
    }
}
