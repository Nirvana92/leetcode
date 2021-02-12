package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

/**
 * @author gzm
 * @date 2021/2/2 9:19 上午
 * @desc: 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 * <p>
 * 前缀和问题.
 */
public class No_1744_Can_you_eat_your_favorite_candy_on_your_favorite_day {
    @Test
    public void test() {
        int[] candiesCount = new int[]{7, 4, 5, 3, 8};
        int[][] queries = new int[][]{{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}};

        candiesCount = new int[]{5, 2, 6, 4, 1};
        queries = new int[][]{{3, 1, 2}, {4, 10, 3}, {3, 10, 100}, {4, 100, 30}, {1, 3, 1}};

        boolean[] canEat = canEat(candiesCount, queries);
        PrintUtils.print(canEat);
    }

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] ret = new boolean[queries.length];

        /**
         * 初始化糖果的前缀和
         */
        long[] cands = new long[candiesCount.length + 1];
        for (int i = 1; i <= candiesCount.length; i++) {
            cands[i] = candiesCount[i - 1] + cands[i - 1];
        }

        for (int i = 0; i < queries.length; i++) {
            int favoriteType = queries[i][0];
            // 需要使用long 类型。
            long favoriteDay = queries[i][1];
            long dailyCap = queries[i][2];

            ret[i] = cands[favoriteType] < (favoriteDay + 1) * dailyCap && cands[favoriteType + 1] >= (favoriteDay + 1);
        }

        return ret;
    }
}

//            int min = favoriteDay + 1;
//            int max = (favoriteDay + 1) * dailyCap;

//            long candMin = cands[favoriteType] - candiesCount[favoriteType] + 1;
//            long candMax = cands[favoriteType];

// ret[i] = (min >= candMin && min <= candMax) || (max >= candMin && max <= candMax);
//            ret[i] = (candMin >= min && candMin <= max)
//                    || (candMax >= min && candMax <= max)
//                    || (candMin <= min && candMax >= max);