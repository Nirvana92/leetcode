package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/25 22:41
 * <p>
 * 1370. 上升下降字符串
 */
public class No_1370_Rising_and_falling_string {
    @Test
    public void test() {
        String s = "aaaabbbbcccc";
        s = "rat";
        s = "leetcode";
        s = "ggggggg";
        s = "spo";

        String sortString = sortString(s);
        System.out.println(sortString);
    }

    public String sortString(String s) {
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        StringBuffer buffer = new StringBuffer();
        boolean lToR = true;
        while (buffer.length() != s.length()) {
            loop(chars, buffer, lToR);

            lToR = !lToR;
        }

        return buffer.toString();
    }

    public void loop(int[] chars, StringBuffer buffer, boolean lToR) {
        if (lToR) {
            // 从左往右的遍历
            for (int i = 0; i < 26; i++) {
                if (chars[i] > 0) {
                    buffer.append((char) (i + 'a'));
                    chars[i]--;
                }
            }
        } else {
            // 从右往左的遍历
            for (int i = 25; i >= 0; i--) {
                if (chars[i] > 0) {
                    buffer.append((char) (i + 'a'));
                    chars[i]--;
                }
            }
        }
    }
}
