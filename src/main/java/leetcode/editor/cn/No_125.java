package leetcode.editor.cn;

/**
 * 125. 验证回文串
 *
 *给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No_125 {

    public boolean isPalindrome(String s) {
        if(s == null || "".equals(s)) {
            return true;
        }

        char[] chars = s.toCharArray();
        int headIndex = 0, tailIndex = s.length()-1;

        boolean rst = true;
        while (headIndex < tailIndex) {
            while (headIndex <= s.length()-1 && !Character.isLetterOrDigit(chars[headIndex])) {
                headIndex ++;
            }

            while (tailIndex >= 0 && !Character.isLetterOrDigit(chars[tailIndex])) {
                tailIndex --;
            }

            if(headIndex > s.length()-1 || tailIndex < 0) {
                break;
            }

            if(Character.toLowerCase(chars[headIndex]) != Character.toLowerCase(chars[tailIndex])) {
                rst = false;
                break;
            }

            headIndex ++;
            tailIndex --;
        }

        return rst;
    }

    public static void main(String[] args) {
        // System.out.println(Character.toLowerCase('A'));
//        System.out.println(Character.isLetterOrDigit(','));

        //String str = "A man, a plan, a canal: Panama";
//        String str = "raca a car";
        String str = ".,";

        No_125 no_125 = new No_125();
        System.out.println(no_125.isPalindrome(str));
    }
}
