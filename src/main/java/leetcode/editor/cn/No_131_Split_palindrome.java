package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gzm
 * @date 2020/9/28 8:19 下午
 * @desc
 */
public class No_131_Split_palindrome {
    @Test
    public void test() {
        String str = "aab";
        List<List<String>> partition = partition(str);
        System.out.println(partition);
    }

    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();

        List<List<String>> results = new ArrayList<>();
        List<String> tmpRst = new ArrayList<>();
        process(chars, 0, tmpRst, results);
        return results;
    }

    void process(char[] chars, int l, List<String> tmpRst, List<List<String>> results) {
        if (l == chars.length) {
            // 收集答案
            results.add(copyLists(tmpRst));
            return;
        }

        for (int end = l; end < chars.length; end++) {
            if (isPalindrome(chars, l, end)) {
                tmpRst.add(new String(Arrays.copyOfRange(chars, l, end + 1)));
                process(chars, end + 1, tmpRst, results);
                tmpRst.remove(tmpRst.size() - 1);
            }
        }


    }

    boolean isPalindrome(char[] chars, int l, int r) {
        if (l > r) {
            return false;
        }

        if (l == r) {
            return true;
        }

        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    public static List<String> copyLists(List<String> paths) {
        List<String> copyList = new ArrayList<>();
        for (String num : paths) {
            copyList.add(num);
        }

        return copyList;
    }
}
