package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author gzm
 * @date 2020/11/4 5:22 下午
 * @desc: 646. 最长数对链
 * <p>
 * 类似选课的题目. 选择最多的课程
 * <p>
 * 贪心算法
 */
public class No_646_Longest_pair_chain {
    @Test
    public void test() {
        int[][] pairs = new int[][]{{1, 2}, {5, 7}, {3, 4}, {10, 13}, {8, 9}};

        pairs = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        int longestChain = findLongestChain(pairs);
        System.out.println(longestChain);
    }

    /**
     * 求结束的最早的情况 然后依次统计结果
     *
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

        int maxChainLen = 0;
        int preVal = 0;
        for (int i = 0; i < pairs.length; i++) {
            if (i == 0) {
                preVal = pairs[i][1];
                maxChainLen++;
            } else {
                if (pairs[i][0] > preVal) {
                    preVal = pairs[i][1];
                    maxChainLen++;
                }
            }
        }

        return maxChainLen;
    }
}
