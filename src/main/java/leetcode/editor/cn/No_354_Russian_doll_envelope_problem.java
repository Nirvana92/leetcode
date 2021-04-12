package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author gzm
 * @date 2020/10/21 5:03 下午
 * @desc: 354. 俄罗斯套娃信封问题
 * <p>
 * <p>
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进
 * 另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 说明:
 * 不允许旋转信封。
 * <p>
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class No_354_Russian_doll_envelope_problem {
    @Test
    public void test() {
        int[][] envelopes = new int[][]{
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };

        envelopes = new int[][]{{1, 2}};

        int maxEnvelopes = maxEnvelopes(envelopes);
        System.out.println(maxEnvelopes);
    }

    /**
     * 最长递增子序列的问题处理
     *
     * @param arr
     * @return
     */
    public static int lis(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        int maxLen = 1;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = arr[i];
            dp[i] = l + 1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }

        int N = envelopes.length;
        Envelope[] es = new Envelope[N];
        for (int i = 0; i < N; i++) {
            es[i] = new Envelope(envelopes[i][0], envelopes[i][1]);
        }

        Arrays.sort(es, new EnvelopesComparator());
        int[] hs = new int[N];
        for (int i = 0; i < es.length; i++) {
            hs[i] = es[i].h;
        }

        return lis(hs);
    }

    class EnvelopesComparator implements Comparator<Envelope> {
        @Override
        public int compare(Envelope o1, Envelope o2) {
            return o1.w == o2.w ? o2.h - o1.h : o1.w - o2.w;
        }
    }

    class Envelope {
        int w;
        int h;

        public Envelope(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }
}
