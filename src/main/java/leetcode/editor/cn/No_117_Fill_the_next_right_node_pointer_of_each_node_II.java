package leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gzm
 * @date 2020/9/28 1:45 下午
 * @desc
 */
public class No_117_Fill_the_next_right_node_pointer_of_each_node_II {
    @Test
    public void test() {

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
