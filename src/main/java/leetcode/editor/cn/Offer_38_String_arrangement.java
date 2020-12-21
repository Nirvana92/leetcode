package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

/**
 * @author gzm
 * @date 2020/11/6 4:57 下午
 * @desc: 剑指 Offer 38. 字符串的排列
 * <p>
 * dfs
 * 全排列的代码解法
 * 参考: {@link No_47_Full_arrangement_II}
 */
public class Offer_38_String_arrangement {
    @Test
    public void test() {
        String s = "abcc";
        String[] permutation = permutation(s);
        System.out.println(Arrays.toString(permutation));
    }

    List<String> results = new ArrayList<>();

    public String[] permutation(String s) {
        process(s.toCharArray(), 0);
        return results.toArray(new String[results.size()]);
    }

    void process(char[] strs, int index) {
        if (index == strs.length) {
            results.add(new String(strs));
            return;
        }

        Set<Character> sets = new HashSet<>();
        for (int i = index; i < strs.length; i++) {
            if (sets.contains(strs[i])) {
                continue;
            }
            sets.add(strs[i]);
            swap(strs, i, index);
            process(strs, index + 1);
            swap(strs, i, index);
        }
    }

    void swap(char[] arrs, int i, int j) {
        char temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}
