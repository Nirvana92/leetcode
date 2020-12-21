package leetcode.editor.cn;

/**
 * @author Nirvana
 * @date 2020/10/31 21:55
 * <p>
 * 680. 验证回文字符串 Ⅱ
 */
public class No_680_Verify_palindrome_string_Ⅱ {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;


        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }

            l++;
            r--;
        }

        return true;
    }

    boolean isPalindrome(String s, int l, int r) {

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
