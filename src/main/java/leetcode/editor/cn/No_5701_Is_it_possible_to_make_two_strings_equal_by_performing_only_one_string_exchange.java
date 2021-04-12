package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/3/15 9:53 上午
 * @desc: 5701. 仅执行一次字符串交换能否使两个字符串相等
 */
public class No_5701_Is_it_possible_to_make_two_strings_equal_by_performing_only_one_string_exchange {
    @Test
    public void test() {
        String s1 = "bank", s2 = "kanc";
        s1 = "attack";
        s2 = "defend";

        s1 = "kelb";
        s2 = "kelb";

        s1 = "abcd";
        s2 = "dcba";

        boolean areAlmostEqual = areAlmostEqual(s1, s2);
        System.out.println(areAlmostEqual);
    }

    /**
     * 处理思路: 判断s1 和s2 的位置不相同的个数. 如果两个不相同, 并且字符串都相等那么可以交换。否则不行
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean areAlmostEqual(String s1, String s2) {
        // 不同的字符个数
        int diffNums = 0;
        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffNums++;
            }
            chars[s1.charAt(i) - 'a']++;
        }

        if (diffNums == 0) {
            return true;
        }

        // 如果diffNums == 2: 判断下两个不同的位置是否相同的字符
        if (diffNums == 2) {
            for (int i = 0; i < s2.length(); i++) {
                chars[s2.charAt(i) - 'a']--;
                if (chars[s2.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
