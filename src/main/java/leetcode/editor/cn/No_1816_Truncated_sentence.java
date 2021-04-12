package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/4/12 10:01 上午
 * @desc: 1816. 截断句子
 */
public class No_1816_Truncated_sentence {

    @Test
    public void test() {
        String s = "Hello how are you Contestant";
        int k = 4;

        s = "What is the solution to this problem";
        k = 4;

        s = "chopper is not a tanuki";
        k = 5;

        String truncateSentence = truncateSentence(s, k);
        System.out.println(truncateSentence);
    }

    public String truncateSentence(String s, int k) {
        StringBuffer buffer = new StringBuffer();

        // 在s 字符串的下标位置
        int curIndex = 0;
        while (curIndex < s.length() && k > 0) {
            if (s.charAt(curIndex) == ' ') {
                k--;
            }
            if (k > 0) {
                buffer.append(s.charAt(curIndex));
            }

            curIndex++;
        }

        return buffer.toString();
    }
}
