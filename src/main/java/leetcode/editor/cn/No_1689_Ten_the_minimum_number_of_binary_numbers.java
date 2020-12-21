package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/12/17 22:41
 * <p>
 * 1689. 十-二进制数的最少数目
 */
public class No_1689_Ten_the_minimum_number_of_binary_numbers {
    @Test
    public void test() {
        String n = "";
        int minPartitions = minPartitions(n);
        System.out.println(minPartitions);
    }

    public int minPartitions(String n) {
        int minRet = 0;

        for (int i = 0; i < n.length(); i++) {
            minRet = Math.max(minRet, n.charAt(i) - '0');
        }

        return minRet;
    }
}
