package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.chart.ChartEdge;
import org.nirvana.chart.ChartGraph;
import org.nirvana.chart.ChartNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Nirvana
 * @date 2020/10/17 00:06
 * <p>
 * 787. K 站中转内最便宜的航班
 * <p>
 * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 * <p>
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
 * <p>
 * todo: 通过使用缓存, 可以通过测试用例, 但是效率还是不太好, 还可以考虑优化的方案
 */
public class No_787_Cheapest_flight_within_K_stop {
    @Test
    public void test() {
        int n = 3, src = 0, dst = 2, K = 1;
        int[][] flights = new int[][]{
                {0, 1, 100}, {1, 2, 100}, {0, 2, 500}
        };

        n = 4;
        src = 0;
        dst = 3;
        K = 1;
        flights = new int[][]{
                {0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}
        };

        n = 4;
        src = 3;
        dst = 0;
        K = 1;
        flights = new int[][]{{1, 0, 1}, {2, 0, 5}, {2, 1, 1}, {3, 2, 1}};

        int cheapestPrice = findCheapestPrice(n, flights, src, dst, K);
        System.out.println(cheapestPrice);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        ChartGraph graph = createGraph(flights);
        ChartNode node = graph.nodes.get(src);
        //暴力解法
        Map<String, Integer> dp = new HashMap<>();
        int minCost = process(node, dst, K + 1, dp);
        return minCost == Integer.MAX_VALUE ? -1 : minCost;

        // 从目的地找起始地
//        ChartNode startNode = graph.nodes.get(dst);
//        Map<ChartNode, Info> distanceMaps = new HashMap<>();
//        distanceMaps.put(startNode, new Info(0, 0));
//
//        Set<ChartNode> selectedNodes = new HashSet<>();
//        // 在距离表中选择没有被选择过的最小距离的node 节点
//        ChartNode minNode = getNoSelectedMinNode(distanceMaps, selectedNodes);
//        while (minNode != null) {
//            Info minNodeInfo = distanceMaps.get(minNode);
//            for (ChartEdge edge : minNode.edges) {
//                if (!distanceMaps.containsKey(edge.to)) {
//                    // 没有to节点的信息, 直接添加
//                    Info curInfo = new Info(edge.weight + minNodeInfo.distance, minNodeInfo.K + 1);
//                    distanceMaps.put(edge.to, curInfo);
//                } else {
//                    // 如果有to节点的信息, 选择最小的添加
//                    Info curInfo = distanceMaps.get(edge.to);
//                    if (curInfo.distance > edge.weight + minNodeInfo.distance && minNodeInfo.K <= K) {
//                        // 有消费更小的路径
//                        curInfo.distance = edge.weight + minNodeInfo.distance;
//                        curInfo.K = minNodeInfo.K + 1;
//                        distanceMaps.put(edge.to, curInfo);
//                    }
//                }
//            }
//
//            selectedNodes.add(minNode);
//            minNode = getNoSelectedMinNode(distanceMaps, selectedNodes);
//        }
//
//        Info info = distanceMaps.get(graph.nodes.get(src));
//        if (info == null || info.distance == Integer.MAX_VALUE) {
//            return -1;
//        }
//
//        return info.distance;
    }

    ChartNode getNoSelectedMinNode(Map<ChartNode, Info> distanceMaps, Set<ChartNode> selectedNodes) {
        ChartNode minNode = null;
        for (ChartNode node : distanceMaps.keySet()) {
            if (!selectedNodes.contains(node)) {
                if (minNode == null) {
                    minNode = node;
                } else if (distanceMaps.get(node).distance < distanceMaps.get(minNode).distance) {
                    minNode = node;
                }
            }
        }

        return minNode;
    }

    int process(ChartNode startNode, int dst, int K, Map<String, Integer> dp) {
        if (K <= 0 && startNode.value != dst) {
            return Integer.MAX_VALUE;
        }

        if (startNode.value == dst) {
            return 0;
        }

        if (dp.containsKey(startNode.value + "_" + K)) {
            return dp.get(startNode.value + "_" + K);
        }

        int minCost = Integer.MAX_VALUE;
        for (ChartEdge edge : startNode.edges) {
            int nextMinCost = process(edge.to, dst, K - 1, dp);
            // int nextMinCost = Math.min(+edge.weight, minCost);
            if (nextMinCost != Integer.MAX_VALUE) {
                minCost = Math.min(edge.weight + nextMinCost, minCost);
            }
        }

        dp.put(startNode.value + "_" + K, minCost);

        return minCost;
    }

    ChartGraph createGraph(int[][] matrix) {
        ChartGraph graph = new ChartGraph();
        for (int i = 0; i < matrix.length; i++) {
            int from = matrix[i][0];
            int to = matrix[i][1];
            int weight = matrix[i][2];

            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new ChartNode(from));
            }

            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new ChartNode(to));
            }

            ChartNode fromNode = graph.nodes.get(from);
            ChartNode toNode = graph.nodes.get(to);

            // 添加 fromNode 的nexts 集合
            fromNode.nexts.add(toNode);
            // 添加 fromNode -> toNode 的edge
            ChartEdge fromToEdge = new ChartEdge(weight, fromNode, toNode);
            fromNode.edges.add(fromToEdge);
            // 增加fromNode 的出度
            fromNode.out++;
            // 增加toNode 的入度
            toNode.in++;

            // 并且将边放入到graph的edges集合中
            graph.edges.add(fromToEdge);
        }

        return graph;
    }

    class Info {
        int distance;
        int K;

        public Info(int distance, int k) {
            this.distance = distance;
            K = k;
        }
    }

}
