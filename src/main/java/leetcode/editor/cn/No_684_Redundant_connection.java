package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.*;

/**
 * @author gzm
 * @date 2021/1/13 9:42 上午
 * @desc: 684. 冗余连接
 */
public class No_684_Redundant_connection {
    @Test
    public void test() {
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};

        int[] redundantConnection = findRedundantConnection(edges);
        PrintUtils.print(redundantConnection);
    }

    public int[] findRedundantConnection(int[][] edges) {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            sets.add(edges[i][0]);
            sets.add(edges[i][1]);
        }

        int[] results = new int[2];
        UnionSet unionSet = new UnionSet(sets);
        for (int i = 0; i < edges.length; i++) {
            if (!unionSet.isSameSet(edges[i][0], edges[i][1])) {
                unionSet.union(edges[i][0], edges[i][1]);
            } else {
                // 已经在一个集合中了, 记录下结果.
                results[0] = edges[i][0];
                results[1] = edges[i][1];
            }
        }

        return results;
    }

    class UnionSet {
        private Map<Integer, Node> nodes = new HashMap<>();
        private Map<Node, Node> parents = new HashMap<>();
        private Map<Node, Integer> sizes = new HashMap<>();

        public UnionSet(Collection<Integer> lists) {
            if (lists != null) {
                lists.forEach(v -> {
                    Node node = new Node(v);
                    nodes.put(v, node);
                    parents.put(node, node);
                    sizes.put(node, 1);
                });
            }
        }

        public boolean isSameSet(Integer x, Integer y) {
            if (!nodes.containsKey(x) || !nodes.containsKey(y)) {
                return false;
            }

            Node xNode = findParent(nodes.get(x));
            Node yNode = findParent(nodes.get(y));

            return xNode == yNode;
        }

        public void union(Integer x, Integer y) {
            if (!nodes.containsKey(x) || !nodes.containsKey(y)) {
                return;
            }

            Node xParentNode = findParent(nodes.get(x));
            Node yParentNode = findParent(nodes.get(y));

            if (xParentNode != yParentNode) {
                int aSetSize = sizes.get(xParentNode);
                int bSetSize = sizes.get(yParentNode);
                Node big = aSetSize >= bSetSize ? xParentNode : yParentNode;
                Node small = big == xParentNode ? yParentNode : xParentNode;
                parents.put(small, big);
                sizes.put(big, aSetSize + bSetSize);
                sizes.remove(small);
            }
        }

        Node findParent(Node cur) {
            while (cur != parents.get(cur)) {
                cur = parents.get(cur);
            }

            return cur;
        }

        /**
         * 返回当前有多少个集合
         *
         * @return
         */
//        int unionSize() {
//            return sizes.size();
//        }

        /**
         * 根据给定的curVal 的值找到最高层的父节点, 如果没有相同的集合, 则直接返回当前值
         *
         * @param curVal
         * @return
         */
        public Integer findParent(Integer curVal) {
            if (!nodes.containsKey(curVal)) {
                return curVal;
            } else {
                return findParent(nodes.get(curVal)).val;
            }
        }

        class Node {
            private Integer val;

            public Node(Integer val) {
                this.val = val;
            }
        }
    }
}
