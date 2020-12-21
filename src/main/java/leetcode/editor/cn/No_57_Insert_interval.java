package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gzm
 * @date 2020/11/4 10:10 上午
 * @desc: 57. 插入区间
 */
public class No_57_Insert_interval {
    @Test
    public void test() {
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};

        intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        newInterval = new int[]{4, 8};

        int[][] insert = insert(intervals, newInterval);
        PrintUtils.print(insert);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (end < newInterval[0] || start > newInterval[1]) {
                lists.add(Arrays.asList(start, end));
            } else {
                newInterval[0] = Math.min(newInterval[0], start);
                newInterval[1] = Math.max(newInterval[1], end);
            }
        }

        int insertIndex = -1;
        for (int i = 0; i < lists.size(); i++) {
            if (newInterval[0] > lists.get(i).get(1)) {
                insertIndex = i;
            } else {
                break;
            }
        }

        insertIndex += 1;
        lists.add(insertIndex, Arrays.asList(newInterval[0], newInterval[1]));

        int[][] results = new int[lists.size()][2];
        for (int i = 0; i < lists.size(); i++) {
            results[i][0] = lists.get(i).get(0);
            results[i][1] = lists.get(i).get(1);
        }

        return results;
    }
}
