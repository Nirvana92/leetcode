package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/22 5:11 下午
 * @desc: 486. 预测赢家
 * <p>
 * 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，
 * 然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和
 * 最多的玩家获胜。
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 * <p>
 * 类同石子游戏: {@link leetcode.editor.cn.No_877_Stone_game}
 */
public class No_486_Predict_winner {
    @Test
    public void test() {
        int[] nums = new int[]{1, 5, 2};
        nums = new int[]{1, 5, 233, 7};

        boolean predictTheWinner = PredictTheWinner(nums);
        System.out.println(predictTheWinner);
    }

    public boolean PredictTheWinner(int[] nums) {
        int N = nums.length;
        if (N < 2) {
            return true;
        }
        int[][] first = new int[N][N];
        int[][] last = new int[N][N];

        for (int i = 0; i < N; i++) {
            first[i][i] = nums[i];
        }

        // r
        for (int i = 1; i < N; i++) {
            // l
            int l = 0, r = i;
            while (l < N && r < N) {
                first[l][r] = Math.max(last[l + 1][r] + nums[l], last[l][r - 1] + nums[r]);
                last[l][r] = Math.min(first[l + 1][r], first[l][r - 1]);
                l++;
                r++;
            }
        }

        return first[0][N - 1] > last[0][N - 1];
    }
}
