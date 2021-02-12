package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

/**
 * @author gzm
 * @date 2021/1/11 9:26 上午
 * @desc: 1202. 交换字符串中的元素
 * <p>
 * 并查集找出键值对的关系
 */
public class No_1202_Exchange_elements_in_a_string {
    @Test
    public void test() {
        String str = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));

        str = "dcab";
        pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));
        pairs.add(Arrays.asList(0, 2));

//        str = "cba";
//        pairs.add(Arrays.asList(0, 1));
//        pairs.add(Arrays.asList(1, 2));

        String smallestStringWithSwaps = smallestStringWithSwaps(str, pairs);
        System.out.println(smallestStringWithSwaps);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Set<Integer> indexs = new HashSet<>();
        for (List<Integer> pair : pairs) {
            indexs.addAll(pair);
        }

        UnionSet unionSet = new UnionSet(indexs);
        for (List<Integer> pair : pairs) {
            unionSet.union(pair.get(0), pair.get(1));
        }

        // 可以连通在一起的下标已经联合在一起了
        Map<Integer, LinkedList<Character>> maps = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer parentVal = unionSet.findParent(i);
            if (!maps.containsKey(parentVal)) {
                maps.put(parentVal, new LinkedList<>());
            }

            maps.get(parentVal).add(s.charAt(i));
        }
        for (List<Character> value : maps.values()) {
            Collections.sort(value);
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            LinkedList<Character> lists = maps.get(unionSet.findParent(i));
            buffer.append(lists.get(0));
            lists.removeFirst();
        }

        return buffer.toString();
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
