package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/30 2:25 下午
 * @desc: 767. 重构字符串
 * <p>
 * 解题方式可以参考: {@link No_621}
 */
public class No_767_Refactor_string {
    @Test
    public void test() {
        String str = "aaab";
        str = "aab";
        str = "abababababcccccc";
        str = "bfrbs";

        String reorganizeString = reorganizeString(str);
        System.out.println(reorganizeString);
    }

    public String reorganizeString(String S) {
        int[] counts = new int[26];

        int maxLen = 0;
        Character maxChar = null;
        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            counts[index]++;
            if (counts[index] > maxLen) {
                maxLen = Math.max(maxLen, counts[index]);
                maxChar = (char) (index + 'a');
            }
        }

        // 如果超过一半的个数, 那么不能满足条件
        if (maxLen > ((S.length() + 1) >> 1)) {
            return "";
        }

        char[] rets = new char[S.length()];
        int curIndex = 0;
        for (int i = 0; i < maxLen; i++) {
            rets[curIndex] = maxChar;
            curIndex += 2;
            counts[maxChar - 'a']--;
        }

        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                if (curIndex >= S.length()) {
                    curIndex = 1;
                }

                rets[curIndex] = (char) (i + 'a');
                curIndex += 2;
                counts[i]--;
            }
        }

        return new String(rets);
    }
}
