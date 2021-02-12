package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

/**
 * @author gzm
 * @date 2021/1/15 9:27 上午
 * @desc: 947. 移除最多的同行或同列石头
 */
public class No_947_Remove_the_most_peers_or_stones_in_the_same_row {
    @Test
    public void test() {
        int[][] stones = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        stones = new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};

        int removeStones = removeStones(stones);
        System.out.println(removeStones);
    }

    public int removeStones(int[][] stones) {
        int len = stones.length;
        List<Integer> infos = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            infos.add(i);
        }
        UnionSet unionSet = new UnionSet(infos);
        /**
         * 这边其实不用双重循环. 将x 定义为: 0~ 10000 . y 定义为 -y .
         * 然后联合每个点的x, y 左边的int值。最后求有多少个联通区域即可
         */
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    // 相同的, 合并
                    unionSet.union(i, j);
                }
            }
        }

        return len - unionSet.unionSize();
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
        int unionSize() {
            return sizes.size();
        }

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
