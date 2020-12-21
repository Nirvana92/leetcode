package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/17 2:44 下午
 * @desc: 1684. 统计一致字符串的数目
 */
public class No_1684_Count_the_number_of_consistent_strings {
    @Test
    public void test() {
        String allowed = "ab";
        String[] words = new String[]{"ad", "bd", "aaab", "baa", "badab"};

        allowed = "abc";
        words = new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"};

        allowed = "cad";
        words = new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};

        int countConsistentStrings = countConsistentStrings(allowed, words);
        System.out.println(countConsistentStrings);
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int[] alloweds = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            alloweds[allowed.charAt(i) - 'a']++;
        }

        int ret = 0;
        for (int i = 0; i < words.length; i++) {
            boolean addRet = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (alloweds[words[i].charAt(j) - 'a'] == 0) {
                    addRet = false;
                    break;
                }
            }

            ret += addRet ? 1 : 0;
        }

        return ret;
    }
}
