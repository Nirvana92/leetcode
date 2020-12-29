package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gzm
 * @date 2020/12/29 7:32 下午
 * @desc: 60. 排列序列
 */
public class No_60_Permutation_sequence {
    @Test
    public void test() {
        int n = 3;
        int k = 3;

        n = 4;
        k = 9;

//        n = 3;
//        k = 1;

        n = 5;
        k = 12;

        String permutation = getPermutation(n, k);
        System.out.println(permutation);
    }

    public String getPermutation(int n, int k) {
        // n-1 的排雷种数
        int numOfRanges = 1;

        // 先计算 (n-1)! 的阶乘结果存放到 numOfRanges 中
        for (int i = 1; i <= n - 1; i++) {
            numOfRanges *= i;
        }

        StringBuffer buffer = new StringBuffer();
        // sets 存放的数字. 用于过滤
        Set<Integer> sets = new HashSet<>();
        // 超过的数字范围累加到preSum 中后续做判断使用
        int preSum = 0;
        // 计算的位数
        for (int bit = 0; bit < n; bit++) {
            // 一次判断在哪个范围内
            int curNum = 0;
            for (int i = 1; i <= n; i++) {
                if (sets.contains(i)) {
                    continue;
                }
                curNum++;
                if (k <= numOfRanges * curNum + preSum) {
                    sets.add(i);
                    buffer.append(i);
                    preSum += numOfRanges * (curNum - 1);
                    // 避免 / 0 的情况发生
                    if (n != bit + 1) {
                        numOfRanges /= (n - bit - 1);
                    }
                    break;
                }
            }
        }

        return buffer.toString();
    }
}
