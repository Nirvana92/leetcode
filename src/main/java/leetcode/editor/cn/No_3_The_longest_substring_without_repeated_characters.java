package leetcode.editor.cn;

/**
 * @author Nirvana
 * @date 2020/10/30 23:46
 * <p>
 * 3. 无重复字符的最长子串
 * <p>
 * 没有使用滑动窗口, 使用的双重循环处理可以优化为滑动窗口
 * 参考滑动窗口版本: {@link Offer_48_The_longest_substring_without_repeated_characters}
 */
public class No_3_The_longest_substring_without_repeated_characters {
    public int lengthOfLongestSubstring(String s) {
        String rstStr = "";
        if (s != null) {
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                String tempStr = "";
                tempStr += String.valueOf(chars[i]);
                /*
                if(i == 0) {
                    rstStr = tempStr;
                }
                */
                //System.out.println("tempStr.length: "+tempStr.length());

                for (int j = i + 1; j < chars.length; j++) {
                    if (tempStr.contains(String.valueOf(chars[j]))) {

                        break;
                    } else {
                        tempStr += String.valueOf(chars[j]);
                    }
                }

                if (tempStr.length() > rstStr.length()) {
                    rstStr = tempStr;
                }

                //System.out.println("rstStr: "+rstStr);
            }
        }


        return rstStr.length();
    }
}
