package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2020/11/10 8:48 下午
 * @desc: 1624. 两个相同字符之间的最长子字符串
 */
public class No_1624_The_longest_substring_between_two_identical_characters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);

        int maxDis = -1;
        for (int i = 0; i < s.length(); i++) {
            if (firstIndex[s.charAt(i) - 'a'] == -1) {
                firstIndex[s.charAt(i) - 'a'] = i;
            } else {
                // 计算长度
                maxDis = Math.max(maxDis, i - firstIndex[s.charAt(i) - 'a'] - 1);
            }
        }

        return maxDis;
    }
}
