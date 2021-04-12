package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author gzm
 * @date 2021/4/12 10:10 上午
 * @desc: 1817. 查找用户活跃分钟数
 */
public class No_1817_Find_user_active_minutes {
    @Test
    public void test() {
        int[][] logs = new int[][]{{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        int k = 5;

        logs = new int[][]{{1, 1}, {2, 2}, {2, 3}};
        k = 4;

        int[] findingUsersActiveMinutes = findingUsersActiveMinutes(logs, k);
        PrintUtils.print(findingUsersActiveMinutes);
    }

    /**
     * 题目的意思也就是统计每个用户的活跃数。然后统计每个活跃时间的用户个数
     * <p>
     * 通过map + set 方法来统计
     *
     * @param logs
     * @param k
     * @return
     */
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] results = new int[k];
        Map<Integer, Set<Integer>> maps = new HashMap<>();

        for (int[] log : logs) {
            Set<Integer> times = maps.get(log[0]);
            if (times == null) {
                times = new HashSet<>();
            }

            times.add(log[1]);
            maps.put(log[0], times);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : maps.entrySet()) {
            results[entry.getValue().size() - 1]++;
        }

        return results;
    }
}
