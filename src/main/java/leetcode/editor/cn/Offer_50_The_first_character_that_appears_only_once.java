package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2020/10/27 3:11 下午
 * @desc: 剑指 Offer 50. 第一个只出现一次的字符
 * <p>
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 */
public class Offer_50_The_first_character_that_appears_only_once {
    @Test
    public void test() {
        String s = "abaccdeff";
        s = "abaccdedbffe";
        char firstUniqChar = firstUniqChar(s);
        System.out.println(firstUniqChar);
    }

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }

        Map<Character, Integer> maps = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            maps.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (maps.getOrDefault(curChar, -1) != i) {
                maps.remove(curChar);
            } else {
                return curChar;
            }
        }

        return ' ';
    }
}
