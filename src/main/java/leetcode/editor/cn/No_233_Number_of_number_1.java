package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

/**
 * @author gzm
 * @date 2020/12/24 7:51 下午
 * @desc
 */
public class No_233_Number_of_number_1 {

    @Test
    public void test() {
        int n = 91;
        n = 83;
        n = 11;
        n = 10;

//        int numOfOnes = numOfOnes(n);
//        int oneNums = oneNums(n);
//        System.out.println(numOfOnes);
//        System.out.println(oneNums);

        int times = 10000;

        while (times-- > 0) {
            int tmpN = Utils.generInt(1, 100000000);
            int numOfOnes = countDigitOne(tmpN);
            int oneNums = oneNums(tmpN);
            if (numOfOnes != oneNums) {
                System.out.println(tmpN);
                System.out.println("error");
                break;
            }
        }
    }

    public int countDigitOne(int n) {
        if (n == 0) {
            return 0;
        }

        if (n < 10) {
            return 1;
        }

        int len = getNumLen(n);
        int remindNum = (int) (n % Math.pow(10, len - 1));
        // 求剩余的数量的1 的个数
        int remindOneCounts = countDigitOne(remindNum);

        // 求得了最高位的数字
        int maxBitVal = n / ((int) Math.pow(10, len - 1));


        // 需要返回的结果
        int ret = remindOneCounts;
        if (maxBitVal == 1) {
            ret += (n % Math.pow(10, len - 1)) + 1;
        } else {
            ret += Math.pow(10, len - 1);
        }

        // 求剩余位数的1的个数
        ret += (len - 1) * maxBitVal * (Math.pow(10, Math.max(len - 2, 0)));

        return ret;
    }

    int getNumLen(int n) {
        int len = 0;
        while (n > 0) {
            n /= 10;
            len++;
        }

        return len;
    }

    /**
     * 左
     *
     * @param num
     * @return
     */
    public int oneNums(int num) {
        if (num < 1) {
            return 0;
        }
        // num -> 13625
        // len = 5位数
        int len = getLenOfNum(num);
        if (len == 1) {
            return 1;
        }
        // num 13625
        // tmp1 10000
        // num 7872328738273
        // tmp1 1000000000000
        int tmp1 = powerBaseOf10(len - 1);
        // num最高位 num / tmp1
        int first = num / tmp1;
        // 最高1 N % tmp1 + 1
        // 最高位first tmp1
        int firstOneNum = first == 1 ? num % tmp1 + 1 : tmp1;
        // 除去最高位之外，剩下1的数量
        // 最高位1 10(k-2次方) * (k-1) * 1
        // 最高位first 10(k-2次方) * (k-1) * first
        int otherOneNum = first * (len - 1) * (tmp1 / 10);
        return firstOneNum + otherOneNum + oneNums(num % tmp1);
    }

    public int getLenOfNum(int num) {
        int len = 0;
        while (num != 0) {
            len++;
            num /= 10;
        }
        return len;
    }

    public int powerBaseOf10(int base) {
        return (int) Math.pow(10, base);
    }
}
