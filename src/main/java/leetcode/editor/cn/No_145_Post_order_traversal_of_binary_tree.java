package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 * todo: 可以修改为Morris 后序遍历
 */
public class No_145_Post_order_traversal_of_binary_tree {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();

        post(root, results);
        return results;
    }

    void post(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }

        post(root.left, results);
        post(root.right, results);

        results.add(root.val);
    }
}
