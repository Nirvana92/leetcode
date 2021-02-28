package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2021/2/28 01:04
 * <p>
 * 1759. 统计同构子字符串的数目
 */
public class No_1759_Count_the_number_of_isomorphic_substrings {
    @Test
    public void test() {
        String s = "abbcccaa";

        int countHomogenous = countHomogenous(s);
        System.out.println(countHomogenous);

//        int sums = getSums(100001L);
//        System.out.println(sums);
    }

    int MOD = 1000000007;

    public int countHomogenous(String s) {
        long nums = 0;

        int r = 0;
        int i = 0;
        while (i < s.length()) {
            while (r < s.length() && s.charAt(r) == s.charAt(i)) {
                r++;
            }

            // 此时 r 位置的数据不等于i 位置的数据, 或者超出长度
            // 计算这个子字符串的同构种数
            nums += getSums(r - i);
            nums %= MOD;
            i = r;
        }

        return (int) nums;
    }

    // 求解 1+2+...+num 的和
    int getSums(long num) {
        long sum = (1 + num) * (num / 2);
        sum %= MOD;
        if (num % 2 == 1) {
            sum += num / 2 + 1;
        }

        sum %= MOD;

        return (int) sum;
    }
}
