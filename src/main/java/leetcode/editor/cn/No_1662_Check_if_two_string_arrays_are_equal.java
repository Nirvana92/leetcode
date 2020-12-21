package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/24 5:09 下午
 * @desc: 1662. 检查两个字符串数组是否相等
 */
public class No_1662_Check_if_two_string_arrays_are_equal {
    @Test
    public void test() {
        String[] w1 = new String[]{"ab", "c"};
        String[] w2 = new String[]{"a", "bc"};

        w1 = new String[]{"a", "cb"};
        w2 = new String[]{"ab", "c"};

        w1 = new String[]{"abc", "d", "defg"};
        w2 = new String[]{"abcddefg"};

        w1 = new String[]{"a", "bc", "d"};
        w2 = new String[]{"ab", "cd"};

        boolean arrayStringsAreEqual = arrayStringsAreEqual(w1, w2);
        System.out.println(arrayStringsAreEqual);
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1Len = word1.length, w2Len = word2.length;
        // word1 word2 数组的下标索引
        int w1Index = 0, w2Index = 0;
        // 具体的string 的下标索引
        int w1CurIndex = 0, w2CurIndex = 0;

        while (hasNext(w1Index, w1Len, w2Index, w2Len)) {
            if (word1[w1Index].charAt(w1CurIndex) != word2[w2Index].charAt(w2CurIndex)) {
                return false;
            }

            w1CurIndex++;
            w2CurIndex++;

            if (w1CurIndex >= word1[w1Index].length()) {
                w1Index++;
                w1CurIndex = 0;
            }

            if (w2CurIndex >= word2[w2Index].length()) {
                w2Index++;
                w2CurIndex = 0;
            }
        }

        return true;
    }

    boolean hasNext(int w1Index, int w1Len, int w2Index, int w2Len) {
        return w1Index != w1Len && w2Index != w2Len;
    }
}
