package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2020/11/9 9:47 上午
 * @desc: 973. 最接近原点的 K 个点
 * <p>
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * <p>
 * 提示：
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class No_973_K_points_closest_to_the_origin {
    @Test
    public void test() {
        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        int K = 1;

        points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        K = 2;

        int[][] kClosest = kClosest(points, K);
        PrintUtils.print(kClosest);
    }

    /**
     * 1. 可以维护一个长度为 K PriorityQueue 队列. 大根堆
     * 2. 快排方法
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        if (points.length == K) {
            return points;
        }

        int[][] rets = new int[K][2];
        PriorityQueue<Info> queues = new PriorityQueue(new MinCom());
        for (int i = 0; i < points.length; i++) {
//            int x = points[i][0];
//            int y = points[i][1];

            double dis = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));

            queues.add(new Info(dis, i));
        }

        for (int i = 0; i < rets.length; i++) {
            rets[i] = points[queues.poll().index];
        }

        return rets;
    }

    class MinCom implements Comparator<Info> {
        @Override
        public int compare(Info o1, Info o2) {
            return o1.dis - o2.dis > 0 ? 1 : (o1.dis - o2.dis < 0 ? -1 : 0);
        }
    }

    class Info {
        /**
         * 到原点的距离
         */
        double dis;
        /**
         * 在points 中的下标索引
         */
        int index;

        public Info(double dis, int index) {
            this.dis = dis;
            this.index = index;
        }
    }
}
