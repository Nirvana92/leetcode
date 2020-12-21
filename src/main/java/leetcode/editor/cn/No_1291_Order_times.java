package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzm
 * @date 2020/11/6 8:46 下午
 * @desc: 1291. 顺次数
 */
public class No_1291_Order_times {
    @Test
    public void test() {
        int low = 10, high = 100;

        low = 100;
        high = 300;

        low = 1000;
        high = 13000;

        low = 124;
        high = 13000;

//        low = 10;
//        high = 300;

        List<Integer> integers = sequentialDigits(low, high);
        System.out.println(integers);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> results = new ArrayList<>();

        int curVal = low;
        while (curVal < high) {
            int nextVal = getNextVal(curVal);

            if (nextVal >= low && nextVal <= high) {
                results.add(nextVal);
            }

            String nextStr = String.valueOf(Math.abs(nextVal));
            if (nextStr.length() > curVal) {
                curVal = (int) Math.pow(10, nextStr.length() - 1);
            } else {
                curVal = Math.abs(nextVal) + (int) Math.pow(10, nextStr.length() - 1);
            }
        }

        return results;
    }

    int getNextVal(int low) {
        String lowStr = String.valueOf(low);
        int len = lowStr.length();
        int firstNum = lowStr.charAt(0) - '0';
        int preVal = firstNum;
        boolean n = false;
        for (int i = 0; i < len - 1; i++) {
            preVal = preVal + 1;
            if (preVal > 9) {
                n = true;
            }
            firstNum = firstNum * 10 + preVal;
        }

        return n ? -low : firstNum;
    }
}
