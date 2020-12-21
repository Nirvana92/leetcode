package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author gzm
 * @date 2020/10/26 5:22 下午
 * @desc: 429. N叉树的层序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
public class No_429_N_ary_tree_traversal {
    @Test
    public void test() {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> rsts = new ArrayList<>();
        if (root == null) {
            return null;
        }

        Queue<Node> queues = new LinkedList<>();
        queues.add(root);

        while (!queues.isEmpty()) {
            int curLevelSize = queues.size();

            List<Integer> tmpRst = new ArrayList<>();
            for (int i = 0; i < curLevelSize; i++) {
                Node curNode = queues.poll();
                tmpRst.add(curNode.val);

                for (Node child : curNode.children) {
                    queues.add(child);
                }
            }

            rsts.add(tmpRst);
        }

        return rsts;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
