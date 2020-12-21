package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gzm
 * @date 2020/11/3 8:29 下午
 * @desc: 547. 朋友圈
 * <p>
 * 并查集
 */
public class No_547_Circle_of_friends {

    @Test
    public void test() {
        int[][] M = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

//        M = new int[][]{
//                {1, 1, 0},
//                {1, 1, 1},
//                {0, 1, 1}
//        };

        int circleNum = findCircleNum(M);
        System.out.println(circleNum);
    }

    public int findCircleNum(int[][] M) {
        int len = M.length;
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            lists.add(i);
        }

        UnionSet<Integer> unionSet = new UnionSet<>(lists);
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                if (M[row][col] == 1 && !unionSet.isSameSet(row, col)) {
                    unionSet.union(row, col);
                }
            }
        }

        return unionSet.sizes.size();
    }

    class UnionSet<V> {
        private Map<V, Node> nodes = new HashMap<>();
        private Map<Node, Node> parents = new HashMap<>();
        private Map<Node, Integer> sizes = new HashMap<>();

        public UnionSet(List<V> lists) {
            if (lists != null) {
                lists.forEach(v -> {
                    Node node = new Node(v);
                    nodes.put(v, node);
                    parents.put(node, node);
                    sizes.put(node, 1);
                });
            }
        }

        public boolean isSameSet(V x, V y) {
            if (!nodes.containsKey(x) || !nodes.containsKey(y)) {
                return false;
            }

            Node xNode = findParent(nodes.get(x));
            Node yNode = findParent(nodes.get(y));

            return xNode == yNode;
        }

        public void union(V x, V y) {
            if (!nodes.containsKey(x) || !nodes.containsKey(y)) {
                return;
            }

            Node xParentNode = findParent(nodes.get(x));
            Node yParentNode = findParent(nodes.get(y));

            if (xParentNode != yParentNode) {
                int aSetSize = sizes.get(xParentNode);
                int bSetSize = sizes.get(yParentNode);
                Node<V> big = aSetSize >= bSetSize ? xParentNode : yParentNode;
                Node<V> small = big == xParentNode ? yParentNode : xParentNode;
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
    }

    class Node<V> {
        private V val;

        public Node(V val) {
            this.val = val;
        }
    }
}
