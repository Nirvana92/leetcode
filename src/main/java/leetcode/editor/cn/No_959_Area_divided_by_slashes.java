package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gzm
 * @date 2021/1/25 10:23 上午
 * @desc
 */
public class No_959_Area_divided_by_slashes {
    @Test
    public void test() {
        String[] grid = new String[]{"\\/", "/\\"};
        grid = new String[]{" /", "/ "};
        grid = new String[]{" /", "  "};
        grid = new String[]{"/\\", "\\/"};
        grid = new String[]{"//", "/ "};

        int regionsBySlashes = regionsBySlashes(grid);
        System.out.println(regionsBySlashes);
    }

    /**
     * 将每个小方块的边分为四个. 然后依次联通每个边。 最终求联通的边有多少个联通区
     *
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid) {
        int len = grid.length;
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                lists.add(4 * (j + i * len) + 1);
                lists.add(4 * (j + i * len) + 2);
                lists.add(4 * (j + i * len) + 3);
                lists.add(4 * (j + i * len) + 4);
            }
        }

        UnionSet unionSet = new UnionSet(lists);
        for (int i = 0; i < len; i++) {
            String colStrs = grid[i];
            for (int j = 0; j < colStrs.length(); j++) {
                char curChar = colStrs.charAt(j);

                int firstNum = 4 * (j + i * len) + 1;
                int secondNum = 4 * (j + i * len) + 2;
                int thirdNum = 4 * (j + i * len) + 3;
                int fourNum = 4 * (j + i * len) + 4;

                if (curChar == ' ') {
                    // 四边均联通在一起
                    unionSet.union(firstNum, secondNum);
                    unionSet.union(secondNum, thirdNum);
                    unionSet.union(thirdNum, fourNum);
                } else if (curChar == '/') {
                    // 1, 2 联通在一起。 3, 4  联通在一起
                    unionSet.union(firstNum, secondNum);
                    unionSet.union(thirdNum, fourNum);
                } else if (curChar == '\\') {
                    // 2, 3 联通在一起。 1, 4 联通在一起
                    unionSet.union(secondNum, thirdNum);
                    unionSet.union(firstNum, fourNum);
                }

                // 上下左右需要联通
                if (i > 0) {
                    // 上
                    int upNum = 4 * (j + (i - 1) * len) + 4;
                    unionSet.union(secondNum, upNum);
                }
                // 下
                if (i < len - 1) {
                    int downNum = 4 * (j + (i + 1) * len) + 2;
                    unionSet.union(fourNum, downNum);
                }
                // 左
                if (j > 0) {
                    int leftNum = 4 * (j - 1 + i * len) + 3;
                    unionSet.union(firstNum, leftNum);
                }
                // 右
                if (j < len - 1) {
                    int rightNum = 4 * (j + 1 + i * len) + 1;
                    unionSet.union(thirdNum, rightNum);
                }
            }
        }

        return unionSet.unionSize();
    }

    class UnionSet {
        private Map<Integer, Node> nodes = new HashMap<>();
        private Map<Node, Node> parents = new HashMap<>();
        private Map<Node, Integer> sizes = new HashMap<>();

        public UnionSet(List<Integer> lists) {
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
