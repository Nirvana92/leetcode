package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_102_binary_tree_sequence_traversal {
    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20);
        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);

        r.left = rl;
        r.right = rr;
        root.left = l;
        root.right = r;

        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resutls = new ArrayList<>();
        if (root == null) {
            return resutls;
        }

        Queue<TreeNode> queues = new LinkedList<>();
        queues.add(root);
        while (!queues.isEmpty()) {
            // 记录需要层级遍历的值
            int size = queues.size();
            List<Integer> levelResults = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queues.poll();
                levelResults.add(node.val);
                // 将node 的左右节点添加到队列中
                if (node.left != null) {
                    queues.add(node.left);
                }

                if (node.right != null) {
                    queues.add(node.right);
                }
            }

            resutls.add(levelResults);
        }

        return resutls;
    }
}
