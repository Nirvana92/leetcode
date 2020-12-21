package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class No_202_happy_number {
    @Test
    public void test() {
        boolean happy = isHappy(4);
        System.out.println(happy);
    }

    public boolean isHappy(int n) {
        Set<Integer> numSets = new HashSet<>();
        while (n != 1 && !numSets.contains(n)) {
            if (n < 0) {
                return false;
            }
            numSets.add(n);
            n = getNum(n);
        }

        return n == 1;
    }

    int getNum(int n) {
        int result = 0;
        while (n != 0) {
            int curNum = n % 10;
            result += curNum * curNum;
            n = n / 10;
        }

        return result;
    }
}
