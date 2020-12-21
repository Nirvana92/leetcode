package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/24 17:09
 * <p>
 * 1513. 仅含 1 的子串数
 */
public class No_1513_Number_of_substrings_containing_only_1 {
    @Test
    public void test() {
        String s = "0110111";
        s = "101";
        s = "111111";
        s = "000";
        s = "1";

        int numSub = numSub(s);
        System.out.println(numSub);
    }

    public int numSub(String s) {
        long numSubStrs = 0, _1Len = 0;
        int sIndex = 0, mod = 1000000007;
        while (sIndex < s.length()) {
            if (s.charAt(sIndex) == '1') {
                _1Len++;
            } else {
                // 当前字符为 0
                if (_1Len != 0) {
                    numSubStrs += (_1Len * (_1Len + 1) >> 1);
                    numSubStrs %= mod;
                    _1Len = 0;
                }
            }

            sIndex++;
        }

        if (_1Len != 0) {
            numSubStrs += (_1Len * (_1Len + 1) >> 1);
            numSubStrs %= mod;
        }

        return (int) numSubStrs;
    }

//    int getSubStrs(int n) {
//        return (n * (n + 1) / 2) % 1000000007;
//    }
}
