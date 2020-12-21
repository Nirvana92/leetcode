package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2020/11/13 1:52 下午
 * @desc: 205. 同构字符串
 */
public class No_205_Isomorphic_string {
    @Test
    public void test() {
        String s = "egg", t = "add";
        s = "foo";
        t = "bar";

        s = "paper";
        t = "title";

        s = "abcde";
        t = "abbde";

        boolean isomorphic = isIsomorphic(s, t);
        System.out.println(isomorphic);
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sToTMaps = new HashMap<>();
        Map<Character, Character> tToSMaps = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sToTMaps.containsKey(s.charAt(i)) && sToTMaps.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }

            if (tToSMaps.containsKey(t.charAt(i)) && tToSMaps.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }

            sToTMaps.put(s.charAt(i), t.charAt(i));
            tToSMaps.put(t.charAt(i), s.charAt(i));
        }

        return true;
    }
}
