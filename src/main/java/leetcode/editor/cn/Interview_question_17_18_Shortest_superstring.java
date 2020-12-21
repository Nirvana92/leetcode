package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nirvana
 * @date 2020/10/31 19:08+
 * <p>
 * 面试题 17.18. 最短超串
 */
public class Interview_question_17_18_Shortest_superstring {
    @Test
    public void test() {
        int[] big = new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] small = new int[]{1, 5, 9};

        big = new int[]{1, 2, 3};
        small = new int[]{4};

        int[] shortestSeq = shortestSeq(big, small);
        PrintUtils.print(shortestSeq);
    }


    public int[] shortestSeq(int[] big, int[] small) {
        int targetLen = small.length;
        int bigLen = big.length;
        Map<Integer, Integer> smallMaps = new HashMap<>();
        for (int i = 0; i < targetLen; i++) {
            smallMaps.put(small[i], smallMaps.getOrDefault(small[i], 0) + 1);
        }

        Map<Integer, Integer> windowMaps = new HashMap<>();
        // 窗口右边的位置索引
        int r = 0, windowLen = 0, leftIndex = -1, rightIndex = bigLen;
        for (int i = 0; i < bigLen; i++) {
            // 窗口右边界的下标索引没有超过总长度, 窗口的大小没有达到目标长度
            while (r < bigLen && windowLen < targetLen) {
                if (smallMaps.containsKey(big[r]) && !windowMaps.containsKey(big[r])) {
                    windowLen++;
                }

                windowMaps.put(big[r], windowMaps.getOrDefault(big[r], 0) + 1);
                r++;
            }

            if (windowLen == targetLen) {
                // 统计长度
                if (r - i < rightIndex - leftIndex) {
                    leftIndex = i;
                    rightIndex = r;
                }
            }

            // int removeVal = big[i];
            int curNumCounts = windowMaps.getOrDefault(big[i], 0);
            if (curNumCounts == 1) {
                // 次数只有一个, 需要删除, 并将windowLen --
                windowMaps.remove(big[i]);
                if (smallMaps.containsKey(big[i])) {
                    windowLen--;
                }
            } else if (curNumCounts > 1) {
                // 次数超过1. 只需要次数减一就好
                windowMaps.put(big[i], curNumCounts - 1);
            }
        }

        if (leftIndex == -1) {
            return new int[]{};
        }

        return new int[]{leftIndex, rightIndex - 1};
    }
}
