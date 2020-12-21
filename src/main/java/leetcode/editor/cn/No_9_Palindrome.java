package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/12 8:19 下午
 * @desc: 9. 回文数
 */
public class No_9_Palindrome {
    @Test
    public void test() {
        int x = 2;
        boolean palindrome = isPalindrome(x);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        String xStr = String.valueOf(x);
        int startIndex = 0, endIndex = xStr.length() - 1;

        while (startIndex < endIndex) {
            if (xStr.charAt(startIndex) != xStr.charAt(endIndex)) {
                return false;
            }

            startIndex++;
            endIndex--;
        }

        return true;
    }
}
