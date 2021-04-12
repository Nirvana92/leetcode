package leetcode.editor.cn;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2021/3/15 2:31 下午
 * @desc: 1792. 最大平均通过率
 */
public class No_1792_Maximum_average_pass_rate {
    @Test
    public void test() {
        int[][] classes = new int[][]{{1, 2}, {3, 5}, {2, 2}};
        int extraStudents = 2;

        classes = new int[][]{{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        extraStudents = 4;

        double maxAverageRatio = maxAverageRatio(classes, extraStudents);
        System.out.println(maxAverageRatio);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<float[]> queues = new PriorityQueue<>(new FloatComparator());
        double totalPassRate = 0D;
        for (int[] clazz : classes) {
            queues.add(new float[]{clazz[0], clazz[1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            float[] tmpClazz = queues.poll();
            tmpClazz[0] += 1;
            tmpClazz[1] += 1;
            queues.add(tmpClazz);
        }

        while (!queues.isEmpty()) {
            float[] tmpClazz = queues.poll();
            totalPassRate += tmpClazz[0] / tmpClazz[1];
        }

        return totalPassRate / classes.length;
    }

    class FloatComparator implements Comparator<float[]> {
        @Override
        public int compare(float[] o1, float[] o2) {
            // 通过判断在哪个上面添加通过生进行大小判断
            float x = ((o2[0] + 1) / (o2[1] + 1) - o2[0] / o2[1]);
            float y = ((o1[0] + 1) / (o1[1] + 1) - o1[0] / o1[1]);
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
            return 0;
        }
    }
}
