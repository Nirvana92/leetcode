package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author gzm
 * @date 2020/12/16 10:02 上午
 * @desc
 */
public class No_290_Word_law {
    @Test
    public void test() {
        String pattern = "abba", s = "dog cat cat dog";
        pattern = "abba";
        s = "dog cat cat fish";

        pattern = "aaaa";
        s = "dog cat cat dog";

        pattern = "abba";
        s = "dog dog dog dog";

        boolean wordPattern = wordPattern(pattern, s);
        System.out.println(wordPattern);
    }

    public boolean wordPattern(String pattern, String s) {
        // int patternIndex = 0, int sIndex = 0;
        String[] ss = s.split(" ");

        if (pattern.length() != ss.length) {
            return false;
        }

        Map<String, String> relationMaps = new HashMap<>();
        Set<String> sets = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (relationMaps.containsKey(String.valueOf(pattern.charAt(i)))) {
                // 如果已经有映射关系了。直接查询对应关系是否正确
                if (!relationMaps.get(String.valueOf(pattern.charAt(i))).equals(ss[i])) {
                    return false;
                }
            } else {
                if (sets.contains(ss[i])) {
                    return false;
                }
                relationMaps.put(String.valueOf(pattern.charAt(i)), ss[i]);
            }

            sets.add(ss[i]);
        }

        return true;
    }
}
