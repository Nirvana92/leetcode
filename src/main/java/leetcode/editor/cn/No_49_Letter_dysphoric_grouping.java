package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

/**
 * 统计每个单词出现的次数, 然后对比次数和字符相等的情况与否
 */
public class No_49_Letter_dysphoric_grouping {
    @Test
    public void test() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupAnagrams = groupAnagrams(strs);
        System.out.println(groupAnagrams);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        Map<String, List<String>> maps = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> vals = maps.getOrDefault(new String(chars), new ArrayList<>());
            vals.add(str);
            maps.put(new String(chars), vals);
        }

        for (List<String> value : maps.values()) {
            results.add(value);
        }

        return results;
    }
}
