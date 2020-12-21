package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class No_513_Find_the_value_in_the_lower_left_corner_of_the_tree {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxLefeVal = 0;
        while (!queue.isEmpty()) {
            maxLefeVal = queue.peek().val;
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();

                if (node.right != null) {
                    queue.add(node.right);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }

        return maxLefeVal;
    }
}
