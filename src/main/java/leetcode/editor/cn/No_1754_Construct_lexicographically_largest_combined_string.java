package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/2/9 10:35 上午
 * @desc: 1754. 构造字典序最大的合并字符串
 */
public class No_1754_Construct_lexicographically_largest_combined_string {
    @Test
    public void test() {
        String w1 = "qeqeqqeeqqq", w2 = "eqqqeeqqeeqqqqqeq";

        w1 = "qqeqeqqeeqqq";
        w2 = "qeqqqeeqqeeqqqqqeq";

        w1 = "cabaa";
        w2 = "bcaaa";

        String largestMerge = largestMerge(w1, w2);
        System.out.println(largestMerge);
    }

    public String largestMerge(String word1, String word2) {
        int w1Index = 0, w2Index = 0;
        int w1Len = word1.length(), w2Len = word2.length();

        StringBuffer buffer = new StringBuffer();
        while (w1Index < w1Len && w2Index < w2Len) {
            int len = getLen(word1, word2, w1Index, w2Index);

            if (len > 0) {
                // 从word1 中获取
                buffer.append(word1, w1Index, w1Index + len);
                w1Index += len;
            } else {
                // 从word2 中获取
                len = Math.abs(len);
                buffer.append(word2, w2Index, w2Index + len);
                w2Index += len;
            }
        }

        if (w1Index < w1Len) {
            buffer.append(word1, w1Index, w1Len);
        }

        if (w2Index < w2Len) {
            buffer.append(word2, w2Index, w2Len);
        }

        return buffer.toString();
    }

    public int getLen(String w1, String w2, int i1, int i2) {
        int w1Len = w1.length();
        int w2Len = w2.length();

        if (w1.charAt(i1) != w2.charAt(i2)) {
            return w1.charAt(i1) > w2.charAt(i2) ? 1 : -1;
        } else {
            int len = 1;

            while (i1 + len < w1Len && i2 + len < w2Len) {
                if (w1.charAt(i1 + len) == w2.charAt(i2 + len)) {
                    len++;
                } else {
                    break;
                }
            }

            if (i1 + len >= w1Len || i2 + len >= w2Len) {
                return i2 + len < w2Len ? -1 : 1;
            } else {
                return w1.charAt(i1 + len) > w2.charAt(i2 + len) ? 1 : -1;
            }
        }
    }
}
