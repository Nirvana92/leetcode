package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/11/5 5:21 下午
 * @desc: 374. 猜数字大小
 * <p>
 * 二分法
 */
public class No_374_Guess_the_size_of_the_number {

    int pick = 1702766719;

    @Test
    public void test() {
        int n = 2126753390;
        int guessNumber = guessNumber(n);
        System.out.println(guessNumber);

    }

    public int guessNumber(int n) {
        int l = 1, r = n;

        while (l < r) {
            int mid = l + ((r - l) >> 1);

            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            } else if (guess > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    int guess(int num) {
        if (num == pick) {
            return 0;
        } else if (pick > num) {
            return 1;
        }
        return -1;
    }
}
