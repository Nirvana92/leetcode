package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/12 23:44
 * <p>
 * <p>
 * 给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
 * 你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分。
 * 当你将所有盒子都去掉之后，求你能获得的最大积分和。
 * <p>
 * 输入：boxes = [1,3,2,2,2,3,4,3,1]
 * 输出：23
 * 解释：
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * ----> [1, 3, 3, 4, 3, 1] (3*3=9 分)
 * ----> [1, 3, 3, 3, 1] (1*1=1 分)
 * ----> [1, 1] (3*3=9 分)
 * ----> [] (2*2=4 分)
 * <p>
 * <p>
 * 1 <= boxes.length <= 100
 * 1 <= boxes[i] <= 100
 */
public class No_546_Remove_box {
    @Test
    public void test() {
        int[] boxes = new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1};
        int removeBoxes = removeBoxes(boxes);
        System.out.println(removeBoxes);
    }

    public int removeBoxes(int[] boxes) {
        int N = boxes.length;
        int[][][] dp = new int[N][N][N];
        return process(boxes, 0, N - 1, 0, dp);
    }

    /**
     * l ... k 范围内消除盒子得到的最大得分是多少
     * <p>
     * k : 标识前面还有k个 boxes[l] 个盒子没有消除掉
     *
     * @param boxes
     * @param l
     * @param r
     * @param k
     * @return
     */
    int process(int[] boxes, int l, int r, int k, int[][][] dp) {
        if (l > r) {
            return 0;
        }

        if (dp[l][r][k] != 0) {
            return dp[l][r][k];
        }

        if (l == r) {
            dp[l][r][k] = (k + 1) * (k + 1);
            return dp[l][r][k];
        }

        for (int i = l + 1; i <= r; i++) {
            if (boxes[l] != boxes[i]) {
                break;
            }

            l++;
            k++;
        }

        // 前面的k个 boxes[l] 和当前找到的boxes[l] 一起计算的结果
        int ret = (k + 1) * (k + 1) + process(boxes, l + 1, r, 0, dp);

        // 看后续中是否还有其他的等于 boxes[l] 的值
        for (int i = l + 1; i <= r; i++) {
            if (boxes[l] == boxes[i]) {
                ret = Math.max(ret, process(boxes, l + 1, i - 1, 0, dp) + process(boxes, i, r, k + 1, dp));
            }
        }

        //System.out.printf("l=%d; r=%d; k=%d", l, r, k);
        dp[l][r][k] = ret;
        return dp[l][r][k];
    }
}
