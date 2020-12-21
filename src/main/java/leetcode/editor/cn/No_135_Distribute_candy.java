package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/28 11:04 上午
 * @desc: 135. 分发糖果
 * <p>
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 */
public class No_135_Distribute_candy {
    @Test
    public void test() {
        int[] ratings = new int[]{1, 0, 2};
        ratings = new int[]{1, 2, 2};

        int candy = candy(ratings);
        System.out.println(candy);
    }

    /**
     * 1. 从右往左遍历找到每个点的最长下降长度
     * 2. 从左到右遍历好到每个点的最长递增长度
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int N = ratings.length;
        int[] right = new int[N];
        int[] left = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            if (i == N - 1 || ratings[i] <= ratings[i + 1]) {
                right[i] = 1;
            } else {
                right[i] += right[i + 1] + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i == 0 || ratings[i] <= ratings[i - 1]) {
                left[i] = 1;
            } else {
                left[i] = left[i - 1] + 1;
            }
        }

        int candyNums = 0;
        for (int i = 0; i < N; i++) {
            candyNums += Math.max(right[i], left[i]);
        }

        return candyNums;
    }
}
