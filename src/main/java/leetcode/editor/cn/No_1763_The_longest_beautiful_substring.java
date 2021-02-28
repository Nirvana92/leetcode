package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2021/2/28 01:49
 * <p>
 * 1763. 最长的美好子字符串
 * <p>
 * 本题的数据范围是 100 , 所以其实可以直接暴利求解的方法处理
 * 优化的方法通过确定多少种字符串一次遍历, 1,2....26 通过滑动窗口处理
 */
public class No_1763_The_longest_beautiful_substring {
    @Test
    public void test() {
        String s = "YazaAay";
        s = "Bb";

        String longestNiceSubstring = longestNiceSubstring(s);
        System.out.println(longestNiceSubstring);
    }

    // 暴利求解处理
    public String longestNiceSubstring(String s) {
        String result = "";
        for (int startIndex = 0; startIndex < s.length(); startIndex++) {
            int lower = 0, uppper = 0;

            for (int i = startIndex; i < s.length(); i++) {
                if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    lower |= 1 << (s.charAt(i) - 'a');
                } else {
                    uppper |= 1 << (s.charAt(i) - 'A');
                }

                if (lower == uppper && i - startIndex + 1 > result.length()) {
                    result = s.substring(startIndex, i + 1);
                }
            }
        }

        return result;
    }
}
