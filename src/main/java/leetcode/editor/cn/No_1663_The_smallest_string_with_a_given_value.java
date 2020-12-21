package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/24 7:10 下午
 * @desc: 1663. 具有给定数值的最小字符串
 */
public class No_1663_The_smallest_string_with_a_given_value {
    @Test
    public void test() {
        int n = 3, k = 27;

        n = 5;
        k = 73;

        String smallestString = getSmallestString(n, k);
        System.out.println(smallestString);
    }

    public String getSmallestString(int n, int k) {
        char[] rets = new char[n];

        for (int i = n - 1; i >= 0; i--) {
            int curChar = Math.min(k - i, 26);
            rets[i] = (char) (curChar - 1 + 'a');
            k -= curChar;
        }

        return new String(rets);
    }
}
