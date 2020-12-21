package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/24 21:36
 * <p>
 * 1525. 字符串的好分割数目
 * <p>
 * 给你一个字符串 s ，一个分割被称为 「好分割」 当它满足：将 s 分割成 2 个字符串 p 和 q ，它们连接起来等于 s 且 p 和 q 中不同字符的数目相同。
 * <p>
 * 请你返回 s 中好分割的数目。
 */
public class No_1525_Number_of_good_divisions_of_the_string {
    @Test
    public void test() {
        String s = "aacaba";
        s = "abcd";
        s = "aaaaa";
        s = "acbadbaada";

        int numSplits = numSplits(s);
        System.out.println(numSplits);
    }

    public int numSplits(String s) {
        int leftTypes = 0, rightTypes = 0;
        int[] left = new int[26];
        int[] right = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (right[index] == 0) {
                rightTypes++;
            }
            right[index]++;
        }

        // 遍历每个分割点 0 ~ i 为左边, i+1 ~ len 为右边
        int numSplits = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int index = s.charAt(i) - 'a';
            if (left[index] == 0) {
                leftTypes++;
            }
            left[index]++;

            right[index]--;
            if (right[index] == 0) {
                rightTypes--;
            }

            if (leftTypes == rightTypes) {
                numSplits++;
            }
        }

        return numSplits;
    }
}
