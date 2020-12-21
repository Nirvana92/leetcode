package leetcode.editor.cn;

import org.nirvana.util.Utils;

import java.util.Random;

/**
 * 5. 最长回文子串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No_5_Longest_palindrome_substring {

    public static void main(String[] args) {
        String str = "babad";

        Random random = new Random();
        int times = 50000;
        int len = random.nextInt(10000);

        for (int i = 0; i < times; i++) {
            len = random.nextInt(1000);
            str = Utils.generStr('a', 'z', len);
            //System.out.println("====genStr: " + str);

            No_5_Longest_palindrome_substring no_5 = new No_5_Longest_palindrome_substring();
            String s = no_5.longestPalindrome(str);
            // System.out.println("最长回文: "+s.replace("#", ""));

            String rst = no_5.longestPalindromeByManacher2(str);
            // System.out.println(rst);

            if (!s.replace("#", "").equals(rst.replace("#", ""))) {
                System.out.println("==递归方法: " + s.replace("#", ""));
                System.out.println("==马拉车: " + rst);
                System.out.println("==马拉车: " + rst.replace("#", ""));
            }

            System.out.println("---------------------------------------------------------------");
        }

    }

    /**
     * 查找最长回文通过遍历每个字符
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String preparedStr = prepareForManacher(s);
//        System.out.println(preparedStr);

        int maxPalindromeIndex = 0;
        // 以每个字符为中点便利数组找到最长的回文
        int[] palidromes = new int[preparedStr.length()];
        for (int index = 0; index < palidromes.length; index++) {
            palidromes[index] = process(preparedStr.toCharArray(), index);

            if (palidromes[index] > palidromes[maxPalindromeIndex]) {
                maxPalindromeIndex = index;
            }
        }

//        System.out.println(Arrays.toString(palidromes));
        return preparedStr.substring(maxPalindromeIndex - palidromes[maxPalindromeIndex],
                maxPalindromeIndex + palidromes[maxPalindromeIndex] + 1);
    }

    /**
     * 通过Manacher 方法找到最长回文
     *
     * @param s
     * @return
     */
    public String longestPalindromeByManacher(String s) {
        String preparedStr = prepareForManacher(s);

        int maxLenIndex = 0;
        // 以每个字符为中点便利数组找到最长的回文
        int[] palidromes = new int[preparedStr.length()];
        char[] chars = preparedStr.toCharArray();
        for (int index = 0; index < palidromes.length; index++) {
            palidromes[index] = process(chars, index);

            // 更新最大回文长度的index
            if (palidromes[index] > palidromes[maxLenIndex]) {
                maxLenIndex = index;
            }

            int tmpIndex = index;
            while (tmpIndex + palidromes[tmpIndex] - 1 > index + 1) {
                if ((2 * tmpIndex - index) - palidromes[2 * tmpIndex - index] > tmpIndex - palidromes[tmpIndex]) {
                    palidromes[++index] = palidromes[2 * tmpIndex - index];
                } else {
                    palidromes[++index] = process(chars, index);
                }
                // palidromes[++index] = palidromes[2 * tmpIndex - index];
            }
        }

        return s.substring(maxLenIndex - palidromes[maxLenIndex] / 2,
                maxLenIndex + palidromes[maxLenIndex] / 2 + 1);
    }

    public String longestPalindromeByManacher2(String s) {
        String preparedStr = prepareForManacher(s);

        int[] palidromes = new int[preparedStr.length()];

        int maxIndex = 0, maxLen = Integer.MIN_VALUE;
        int c = -1, r = -1;
        char[] chars = preparedStr.toCharArray();
        for (int i = 0; i < preparedStr.length(); i++) {
            palidromes[i] = r > i ? Math.min(palidromes[2 * c - i], r - i) : 1;

            while (i + palidromes[i] < preparedStr.length() && i - palidromes[i] > -1) {
                if (chars[i + palidromes[i]] == chars[i - palidromes[i]]) {
                    palidromes[i]++;
                } else {
                    break;
                }
            }

            if (i + palidromes[i] > r) {
                r = i + palidromes[i];
                c = i;
            }

            if (palidromes[i] > maxLen) {
                maxLen = palidromes[i];
                maxIndex = i;
            }
        }

        return preparedStr.substring(maxIndex - maxLen + 1, maxIndex + maxLen).replace("#", "");
    }

    /**
     * 求出以index为中点, 找到最长的回文长度
     *
     * @param strs
     * @param index
     * @return
     */
    public int process(char[] strs, int index) {
        int l = index, r = index;

        while (l >= 0 && r < strs.length && strs[l] == strs[r]) {
            l--;
            r++;
        }

        return index - (l < 0 ? 0 : ++l);
    }

    /**
     * 准备字符串
     *
     * @param s
     * @return
     */
    public String prepareForManacher(String s) {
        StringBuffer buffer = new StringBuffer();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            buffer.append("#").append(chars[i]);
        }

        buffer.append("#");

        return buffer.toString();
    }
}
