package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/12/17 22:29
 * <p>
 * 1688. 比赛中的配对次数
 */
public class No_1688_Matches_in_the_match {
    @Test
    public void test() {
        int n = 7;
        n = 14;
        n = 1;

        int numberOfMatches = numberOfMatches(n);
        System.out.println(numberOfMatches);
    }

    public int numberOfMatches(int n) {
        int ret = 0;
        while (n > 1) {
            ret += n >> 1;

            if (n % 2 == 1) {
                n++;
            }

            n >>= 1;
        }

        return ret;
    }
}
