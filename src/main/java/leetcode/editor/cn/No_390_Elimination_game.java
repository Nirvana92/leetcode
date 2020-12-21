package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/11/7 10:37
 * <p>
 * 类约瑟夫换问题
 */
public class No_390_Elimination_game {
    @Test
    public void test() {
        int n = 6;
        //n = 4;

        int lastRemaining = lastRemaining(n);
        System.out.println(lastRemaining);
    }

    @Test
    public void baoli() {
        int totalNum = 1000000;

        for (int i = 1; i <= totalNum; i++) {
            int lastRemaining = lastRemaining(i);
            int lastRemainingDp = lastRemainingDp(i);
            if (lastRemaining != lastRemainingDp) {
                System.out.println(i);
                System.out.println("error");
                break;
            }
        }
    }

    public int lastRemaining(int n) {
        return getNo(n, true);
    }

    int getNo(int n, boolean lToR) {
        if (n == 1) {
            return 1;
        }

        int preNo = getNo(n / 2, !lToR);

        if (lToR) {
            return 2 * preNo;
        } else {
            int addNum = n % 2;
            return 2 * (preNo - 1) + 1 + addNum;
        }
    }


    int lastRemainingDp(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemainingDp(n / 2));
    }
}
