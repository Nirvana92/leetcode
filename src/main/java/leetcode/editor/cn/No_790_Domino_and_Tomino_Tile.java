package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/17 00:08
 * <p>
 * 参考: 1240 题
 */
public class No_790_Domino_and_Tomino_Tile {
    int modNum = 1_000_000_007;

    @Test
    public void test() {
        int N = 10;
        int numTilings = numTilings(N);
        int processDp = processDp(N);
        System.out.println(numTilings);
        System.out.println(processDp);
    }

    public int numTilings(int N) {
        return process(1, N);
    }

    /**
     * 考虑可能性:
     * 1. 使用一个 2*1 竖着填充 process(i+1)
     * 2. 使用两个 2*1 横躺着 process(i+2)
     * 3. 开头使用一个L 结尾使用一个 L 中间通过 2*1 填充的方式
     * 2(process(i+3) + process(i+4) + process(i+5) ,,, process(N))
     * <p>
     * 然后通过斜率优化, 将后面的一坨通过 process(i+1) 抵消掉, 然后得到最后的公式
     * <p>
     * f(i) = 2*(i+1) + f(i+3)
     *
     * @param N
     * @return
     */
    int processDp(int N) {
        if (N <= 2) {
            return N;
        }

        int modNum = 1_000_000_007;
        int f1 = 1, f2 = 2, f3 = 5;
        for (int i = 4; i <= N; i++) {
            int tmp = (f1 + 2 * f3 % modNum) % modNum;

            f1 = f2;
            f2 = f3;
            f3 = tmp;
        }

        return f3;
    }

    /**
     * 从1开始往后一次平铺瓷砖有多少种平铺的方法
     *
     * @param i
     * @param N
     * @return
     */
    int process(int i, int N) {
        if (i > N + 1) {
            return 0;
        }
        if (i == N + 1) {
            return 1;
        }

        //  2*1 竖着放
        int p1 = process(i + 1, N);
        // 两个 2*1 横着放
        int p2 = process(i + 2, N);
        // 两个L 交错放
        int p3 = process(i + 3, N) * 2;
        // 两个l 并排中间放一个横躺的 2*1
        int p4 = process(i + 4, N) * 2;
        return p1 + p2 + p3 + p4;
    }
}
