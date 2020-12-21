package leetcode.editor.cn;

import org.junit.Test;

public class No_151_Reverse_words_in_a_string {
    @Test
    public void test() {
        String str = "a good   example";
        String result = reverseWords(str);
        System.out.println(result);
    }

    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        StringBuffer buffer = new StringBuffer();

        for (int i = split.length - 1; i >= 0; i--) {
            if ("".equals(split[i])) {
                continue;
            }
            if (i != 0) {
                buffer.append(split[i]).append(" ");
            } else {
                buffer.append(split[i]);
            }
        }

        return buffer.toString();
    }
}
