package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/12/15 10:01 上午
 * @desc
 */
public class No_738_Monotonically_increasing_numbers {
    @Test
    public void test() {
        int n = 1000;
        n = 1234;
        n = 332;
        n = 103434342;
        n = 14793424;
        n = 10;
        n = 120;
        n = 332;

        int monotoneIncreasingDigits = monotoneIncreasingDigits(n);
        System.out.println(monotoneIncreasingDigits);
    }


    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int N = chars.length;
        int curIndex = 1;
        while (curIndex < N && chars[curIndex - 1] <= chars[curIndex]) {
            curIndex++;
        }

        // 当前的curIndex 是第一个 < 之前的一位的数字
        if (curIndex < N) {
            while (curIndex > 0 && chars[curIndex - 1] > chars[curIndex]) {
                chars[curIndex - 1] -= 1;
                curIndex--;
            }

            for (int i = curIndex + 1; i < N; i++) {
                chars[i] = '9';
            }
        }

        return Integer.parseInt(String.valueOf(chars));
    }
}
