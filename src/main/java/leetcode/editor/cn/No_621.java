package leetcode.editor.cn;

import org.junit.Test;

/**
 * 621. 任务调度器
 * <p>
 * 贪心: 使得暂停的时间最短
 */
public class No_621 {
    @Test
    public void test() {
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        int leastInterval = leastInterval(tasks, n);
        System.out.println(leastInterval);
    }

    /**
     * 找到相同的字符最多的个数。然后首先填充好最长的位置。每次中间留有空格。
     * 然后依次填充往后的位置
     * <p>
     * 首先按照最长的定义好数据空格
     * 比如 A 最长有 3 个
     * A _ _ _ A _ _ _ A
     * 然后将剩余的字符都填充进去。
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int[] counts = new int[26];
        int maxCounts = 0;
        for (char task : tasks) {
            counts[task - 'A']++;

            maxCounts = Math.max(maxCounts, counts[task - 'A']);
        }

        int maxKinds = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] == maxCounts) {
                maxKinds++;
            }
        }

        // 减去最后一个长度开头的数量
        int restTasks = tasks.length - maxKinds;
        int space = (n + 1) * (maxCounts - 1);

        int restSpace = Math.max(0, space - restTasks);

        return tasks.length + restSpace;
    }
}
