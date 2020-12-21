package leetcode.editor.cn;

import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @author gzm
 * @date 2020/10/19 9:41 上午
 * @desc: 844. 比较含退格的字符串
 */
public class No_844_Compare_strings_with_backspace {
    @Test
    public void test() {
        String S = "ab#c", T = "ad#c";

//        S = "ab##";
//        T = "c#d#";

        S = "a##c";
        T = "#a#c";

        S = "a#c";
        T = "b";

        S = "bxj##tw";
        T = "bxj###tw";

        S = "nzp#o#g";
        T = "b#nzp#o#g";

        boolean backspaceCompare = backspaceCompare(S, T);
        System.out.println(backspaceCompare);
    }

    public boolean backspaceCompare(String S, String T) {
        int sIndex = S.length() - 1, tIndex = T.length() - 1;

        while (sIndex >= 0 && tIndex >= 0) {
            // 找到s 的下一个有用的下标索引
            int sBackspaceNum = 0, tBackspaceNum = 0;
            while (sIndex >= 0 && (sBackspaceNum != 0 || S.charAt(sIndex) == '#')) {
                if (S.charAt(sIndex) == '#') {
                    sBackspaceNum++;
                } else {
                    sBackspaceNum--;
                }

                sIndex--;
            }

            // 找到t 的下一个有用的下标索引
            while (tIndex >= 0 && (tBackspaceNum != 0 || T.charAt(tIndex) == '#')) {
                if (T.charAt(tIndex) == '#') {
                    tBackspaceNum++;
                } else {
                    tBackspaceNum--;
                }

                tIndex--;
            }

            if (sIndex < 0 && tIndex < 0) {
                return true;
            }

            if (sIndex < 0 || tIndex < 0) {
                break;
            }

            if (S.charAt(sIndex) != T.charAt(tIndex)) {
                return false;
            }

            sIndex--;
            tIndex--;
        }

        int sBackspaceNum = 0, tBackspaceNum = 0;
        while (sIndex >= 0 && (S.charAt(sIndex) == '#' || sBackspaceNum != 0)) {
            if (S.charAt(sIndex) == '#') {
                sBackspaceNum++;
            } else {
                sBackspaceNum--;
            }
            sIndex--;
        }

        while (tIndex >= 0 && (T.charAt(tIndex) == '#' || tBackspaceNum != 0)) {
            if (T.charAt(tIndex) == '#') {
                tBackspaceNum++;
            } else {
                tBackspaceNum--;
            }
            tIndex--;
        }

        return sIndex < 0 && tIndex < 0;
    }

    @Test
    public void testDate() {
        int dayOfMonth = LocalDateTime.now().getDayOfMonth();
        System.out.println(dayOfMonth);
    }
}
