package leetcode.editor.cn;

/**
 * @author gzm
 * @date 2020/9/30 3:02 下午
 * @desc
 */
public class No_222_The_number_of_nodes_in_a_complete_binary_tree {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
