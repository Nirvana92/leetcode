package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gzm
 * @date 2021/3/8 5:44 下午
 * @desc: 1780. 判断一个数字是否可以表示成三的幂的和
 */
public class No_1780_Determine_whether_a_number_can_be_expressed_as_a_sum_of_powers_of_three {
    @Test
    public void test() {
        int n = 12;
        n = 91;
        n = 21;

        boolean checkPowersOfThree = checkPowersOfThree(n);
        System.out.println(checkPowersOfThree);
    }

    /**
     * 通过贪心的方法依次扣除最大的3 的幂次数
     *
     * @param n
     * @return
     */
    public boolean checkPowersOfThree(int n) {
        // 如果不是3 的倍数或者对3 求余数 不为1 直接返回false
//        if (n % 3 != 0 && n % 3 != 1) {
//            return false;
//        }

        Set<Integer> sets = new HashSet<>();
        while (n > 0) {
            int tmpNum = 1;
            int times = 0;
            while (tmpNum * 3 <= n) {
                tmpNum *= 3;
                times++;
            }

            if (sets.contains(times)) {
                return false;
            }
            n -= tmpNum;
            sets.add(times);
        }

        return true;
    }
}
