package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Nirvana
 * @date 2021/1/16 22:04
 * <p>
 * 803. 打砖块
 */
public class No_803_Brick_Break {
    @Test
    public void test() {
        int[][] grid = new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}};
        int[][] hits = new int[][]{{1, 0}};

        grid = new int[][]{{1, 0, 0, 0}, {1, 1, 0, 0}};
        hits = new int[][]{{1, 1}, {1, 0}};

        grid = new int[][]{{1, 0, 0, 1, 0}, {1, 0, 0, 1, 1}, {1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 1, 1, 0}};
        hits = new int[][]{{2, 0}, {1, 3}, {1, 4}, {0, 3}};

//        grid = new int[][]{{1, 0, 1}, {1, 1, 1}};
//        hits = new int[][]{{0, 0}, {0, 2}, {1, 1}};

        int[] hitBricks = hitBricks(grid, hits);
        PrintUtils.print(hitBricks);
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        // 将需要打掉的位置数上如果是1, 将里面的值变成2
        for (int i = 0; i < hits.length; i++) {
            int row = hits[i][0];
            int col = hits[i][1];

            if (grid[row][col] == 1) {
                grid[row][col] = 2;
            }
        }

        // 将处理之后的信息中还是1 的位置作为一个单独的位置放到并查集中
        int rowLen = grid.length;
        int colLen = grid[0].length;
        UnionSet unionSet = new UnionSet();
        Dot[][] dots = new Dot[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                // || grid[i][j] == 2
                if (grid[i][j] == 1) {
                    if (dots[i][j] == null) {
                        dots[i][j] = new Dot(i, j);
                    }

                    unionSet.add(dots[i][j], i == 0);

                    // 判断左和上方向是否可以合并
                    if (i - 1 >= 0 && grid[i - 1][j] == 1
                            && !unionSet.isSameSet(dots[i][j], dots[i - 1][j])) {
                        unionSet.union(dots[i - 1][j], dots[i][j]);
                    }

                    if (j - 1 >= 0 && grid[i][j - 1] == 1
                            && !unionSet.isSameSet(dots[i][j], dots[i][j - 1])) {
                        unionSet.union(dots[i][j], dots[i][j - 1]);
                    }
                }
            }
        }

        // 按照打掉的倒序依次添加到并查集中
        int[] results = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int preNums = unionSet.numberOfConnectionsToTheCeiling();

            int row = hits[i][0];
            int col = hits[i][1];

            if (grid[row][col] == 2) {
                grid[row][col] = 1;
                if (dots[row][col] == null) {
                    dots[row][col] = new Dot(row, col);
                }

                unionSet.add(dots[row][col], row == 0);

                // 判断当前位置的前后左右是否有1 , 有则关联
                if (row - 1 >= 0 && grid[row - 1][col] == 1
                        && !unionSet.isSameSet(dots[row - 1][col], dots[row][col])) {
                    unionSet.union(dots[row - 1][col], dots[row][col]);
                }

                if (col - 1 >= 0 && grid[row][col - 1] == 1 && !unionSet.isSameSet(dots[row][col - 1], dots[row][col])) {
                    unionSet.union(dots[row][col - 1], dots[row][col]);
                }

                if (row + 1 < rowLen && grid[row + 1][col] == 1 &&
                        !unionSet.isSameSet(dots[row + 1][col], dots[row][col])) {
                    unionSet.union(dots[row + 1][col], dots[row][col]);
                }

                if (col + 1 < colLen && grid[row][col + 1] == 1 && !unionSet.isSameSet(dots[row][col + 1], dots[row][col])) {
                    unionSet.union(dots[row][col + 1], dots[row][col]);
                }

                int curNums = unionSet.numberOfConnectionsToTheCeiling();
                results[i] = Math.max(0, curNums - preNums - 1);
            }
        }
        return results;
    }

    class UnionSet {
        int allCellingSizes = 0;
        private Map<Dot, Node> nodes = new HashMap<>();
        private Map<Node, Node> parents = new HashMap<>();
        private Map<Node, Integer> sizes = new HashMap<>();
        private Set<Dot> cellingSizes = new HashSet<>();

        public UnionSet() {
        }

        public void add(Dot dot, boolean addCellingSize) {
            Node node = new Node(dot);
            nodes.put(dot, node);
            parents.put(node, node);
            sizes.put(node, 1);

            if (addCellingSize) {
                cellingSizes.add(dot);
                allCellingSizes++;
            }
        }

        public boolean isSameSet(Dot x, Dot y) {
            if (!nodes.containsKey(x) || !nodes.containsKey(y)) {
                return false;
            }

            Node xNode = findParent(nodes.get(x));
            Node yNode = findParent(nodes.get(y));

            return xNode == yNode;
        }

        public void union(Dot x, Dot y) {
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

                if (cellingSizes.contains(xParentNode.val) && !cellingSizes.contains(yParentNode.val)) {
                    cellingSizes.add(yParentNode.val);

                    allCellingSizes += bSetSize;
                }

                if (!cellingSizes.contains(xParentNode.val) && cellingSizes.contains(yParentNode.val)) {
                    cellingSizes.add(xParentNode.val);

                    allCellingSizes += aSetSize;
                }
            }
        }

        Node findParent(Node cur) {
            while (cur != parents.get(cur)) {
                cur = parents.get(cur);
            }

            return cur;
        }

        // 返回连接到天花板的数量
        int numberOfConnectionsToTheCeiling() {
            return allCellingSizes;
        }

        class Node {
            private Dot val;

            public Node(Dot val) {
                this.val = val;
            }
        }
    }

    class Dot {
        int row;
        int col;

        public Dot(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
