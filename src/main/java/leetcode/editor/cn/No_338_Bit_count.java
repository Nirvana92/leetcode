package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2020/10/15 5:46 下午
 * @desc: 338. 比特位计数
 * <p>
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class No_338_Bit_count {
    @Test
    public void test() {
        int num = 48372938;
        int[] countBits = countBits(num);
        PrintUtils.print(countBits);
    }

    public int[] countBits(int num) {
        int[] rsts = new int[num + 1];
        rsts[0] = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == i) {
                rsts[i] = rsts[i - 1] + 1;
            } else {
                rsts[i] = countTheOneBitCount(i);
            }
        }

        return rsts;
    }

    public int countTheOneBitCount(int num) {
        int numOf_1 = 0;
        while (num > 0) {
            num ^= (num & -num);
            numOf_1++;
        }

        return numOf_1;
    }

    private int popcount(int x) {
        int count;
        for (count = 0; x != 0; ++count) {
            x &= x - 1;
        }
        return count;
    }


    @Test
    public void t() {
        // 打标
//        int countTheOneBitCount = countTheOneBitCount(7);
//        System.out.println(countTheOneBitCount);


        int n = 999999999;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            countTheOneBitCount(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("countTheOneBitCount耗时: " + (endTime - startTime));

        long sTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            popcount(i);
        }
        long eTime = System.currentTimeMillis();
        System.out.println("popcount耗时: " + (eTime - sTime));
    }
}
