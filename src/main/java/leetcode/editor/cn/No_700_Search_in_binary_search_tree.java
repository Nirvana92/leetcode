package leetcode.editor.cn;

import java.util.LinkedList;

/**
 * @author Nirvana
 * @date 2020/11/10 23:37
 * <p>
 * 700. 二叉搜索树中的搜索
 */
public class No_700_Search_in_binary_search_tree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        LinkedList<TreeNode> queues = new LinkedList<>();
        queues.add(root);
        while (!queues.isEmpty()) {
            TreeNode node = queues.pollFirst();

            if (node.val == val) {
                return node;
            }

            if (node.left != null) {
                queues.addLast(node.left);
            }

            if (node.right != null) {
                queues.addLast(node.right);
            }
        }

        return null;
    }
}
