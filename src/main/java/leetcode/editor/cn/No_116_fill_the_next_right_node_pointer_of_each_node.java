package leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 */
public class No_116_fill_the_next_right_node_pointer_of_each_node {
    @Test
    public void test() {
        Node root = new Node(1);
        Node l = new Node(2);
        Node r = new Node(3);
        Node ll = new Node(4);
        Node lr = new Node(5);
        Node rl = new Node(6);
        Node rr = new Node(7);

        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;
        root.left = l;
        root.right = r;

        Node result = connect(root);
        System.out.println(result);
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queues = new LinkedList<>();
        queues.add(root);
        while (!queues.isEmpty()) {
            // 记录需要层级遍历的值
            int size = queues.size();
            // List<Integer> levelResults = new ArrayList<>();
            Node preNode = null;
            while (size-- > 0) {
                Node curNode = queues.poll();
                if (preNode == null) {
                    preNode = curNode;
                } else {
                    preNode.next = curNode;
                    preNode = curNode;
                }

                // levelResults.add(node.val);
                // 将node 的左右节点添加到队列中
                if (curNode.left != null) {
                    queues.add(curNode.left);
                }

                if (curNode.right != null) {
                    queues.add(curNode.right);
                }
            }
        }

        return root;
    }
}
