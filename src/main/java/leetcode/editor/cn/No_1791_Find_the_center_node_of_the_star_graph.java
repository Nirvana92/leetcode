package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2021/3/15 10:20 上午
 * @desc: 1791. 找出星型图的中心节点
 */
public class No_1791_Find_the_center_node_of_the_star_graph {
    @Test
    public void test() {
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {4, 2}};
        edges = new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}};

        int center = findCenter(edges);
        System.out.println(center);
    }

    public int findCenter(int[][] edges) {
        int len = edges.length;

        int centerDot = -1, centerEdges = 0;
        Map<Integer, Integer> dotCounts = new HashMap<>();
        for (int i = 0; i < len; i++) {
            dotCounts.put(edges[i][0], dotCounts.getOrDefault(edges[i][0], 0) + 1);
            dotCounts.put(edges[i][1], dotCounts.getOrDefault(edges[i][1], 0) + 1);

            if (dotCounts.get(edges[i][0]) > centerEdges) {
                centerDot = edges[i][0];
                centerEdges = dotCounts.get(centerDot);
            }

            if (dotCounts.get(edges[i][1]) > centerEdges) {
                centerDot = edges[i][1];
                centerEdges = dotCounts.get(centerDot);
            }
        }

        return centerDot;
    }
}
