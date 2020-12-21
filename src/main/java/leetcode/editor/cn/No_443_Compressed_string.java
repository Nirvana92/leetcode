package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * 压缩字符串
 */
public class No_443_Compressed_string {
    @Test
    public void test() {
        String str = "aaabbaa";
//        str = "aabbcccccc";
//        str = "abbbbbbbbbbbbbbbbbbbbbbb";
//        str = "a";
//        str = "ab";
        str = "aaaaba";
        char[] chars = str.toCharArray();
        int compress = compress(chars);
        System.out.println(compress);
        PrintUtils.print(chars);
    }


    public int compress(char[] chars) {
        if (chars == null || chars.length == 0 || chars.length == 1) {
            return chars == null ? 0 : chars.length;
        }
        // l 标识有效的下标点, cur 标识当前移动的下标点
        int l = 0, cur = 1;

        char preChar = chars[0];
        int preCount = 1;
        while (cur < chars.length) {
            if (chars[cur] == preChar) {
                preCount++;
                cur++;
            } else {
                // 结算
                if (preCount > 1) {
                    chars[l] = preChar;
                    int numLen = getNumLen(preCount);
                    for (int i = l + numLen; i > l; i--) {
                        chars[i] = (char) (preCount % 10 + '0');
                        preCount = preCount / 10;
                    }

                    l = l + numLen + 1;
                } else {
                    chars[l] = preChar;
                    l++;
                }

                preChar = chars[cur++];
                preCount = 1;
            }
        }

        if (preCount > 1) {
            chars[l] = preChar;
            int numLen = getNumLen(preCount);
            for (int i = l + numLen; i > l; i--) {
                chars[i] = (char) (preCount % 10 + '0');
                preCount = preCount / 10;
            }

            l = l + numLen + 1;
        } else {
            chars[l] = preChar;
            l++;
        }

        return l;
    }

    int getNumLen(int num) {
        int len = 0;
        while (num > 0) {
            len++;
            num /= 10;
        }
        return len;
    }

    @Test
    public void testGetNumLen() {
        int num = 123;
        int numLen = getNumLen(num);
        System.out.println(numLen);
    }
}
