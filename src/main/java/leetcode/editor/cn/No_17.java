package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzm
 * @date 2020/9/9 4:11 下午
 * @desc
 */
public class No_17 {
    // 数组 2 -> 0 下标
    String[] letters = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        char[] chars = digits.toCharArray();
        char[] paths = new char[chars.length];

        process(results, paths, 0, chars);

        return results;
    }

    void process(List<String> results, char[] paths, int index, char[] digits) {
        if (index == paths.length) {
            results.add(new String(paths));
            return;
        }

        char[] chars = letters[digits[index] - '0' - 2].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            paths[index] = chars[i];
            process(results, paths, index + 1, digits);
        }
    }

    @Test
    public void test() {
        String digits = "";
        List<String> strings = letterCombinations(digits);
        System.out.println(strings);
    }
}
