package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class No_22 {
    public static void main(String[] args) {
        No_22 no_22 = new No_22();
        List<String> strings = no_22.generateParenthesis(3);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();

        char[] chars = new char[2 * n];
        process(0, 0, chars, results);
        return results;
    }

    private void process(int index, int count, char[] chars, List<String> results) {
        if (count < 0) {
            return;
        }

        if (index == chars.length) {
            if (count == 0) {
                System.out.println(new String(chars));
                results.add(new String(chars));
            }
            return;
        }

        if (count == 0) {
            chars[index] = '(';
            process(index + 1, count + 1, chars, results);
            return;
        }

        // 尝试使用 (
        chars[index] = '(';
        process(index + 1, count + 1, chars, results);

        // 尝试位子使用 )
        chars[index] = ')';
        process(index + 1, count - 1, chars, results);
    }
}
