package leetcode.editor.cn;

/**
 * 67. 二进制求和
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No_67 {

    public String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        char[] rst = new char[maxLen+1];
        char[] as = a.toCharArray(), bs = b.toCharArray();
        int aIndex = a.length()-1, bIndex = b.length()-1, rstIndex = rst.length-1;

        int preVal = 0;
        while (aIndex >= 0 && bIndex >= 0) {
            int tmpRst = as[aIndex--] - '0' + bs[bIndex--] - '0';

            rst[rstIndex--] = (char) ((tmpRst+preVal) % 2 + '0');
            preVal = (tmpRst+preVal) / 2;
        }

        as = aIndex > bIndex ? as : bs;
        aIndex = aIndex > bIndex ? aIndex : bIndex;

        while (aIndex >= 0) {
            int tmpRst = as[aIndex--] - '0';
            rst[rstIndex--] = (char) ((tmpRst + preVal) % 2 + '0');
            preVal = (tmpRst+preVal) / 2;
        }

        if(preVal > 0) {
            rst[rstIndex] = (char) (preVal + '0');
        }

        return new String(rst);
    }

    public static void main(String[] args) {
//        String a = "11", b = "1";
        String a = "1010", b = "1011";
        No_67 no_67 = new No_67();
        String s = no_67.addBinary(a, b);
        System.out.println(s);
    }
}
