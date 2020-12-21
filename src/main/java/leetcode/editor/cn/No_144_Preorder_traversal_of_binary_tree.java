package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 先序遍历
 * todo: 可以修改为Morris 遍历的先序遍历
 */
public class No_144_Preorder_traversal_of_binary_tree {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        TreeNode rl = new TreeNode(3);

        root.right = r;
        r.left = rl;

        List<Integer> integers = preorderTraversal(root);
        System.out.println(integers);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();

        pre(root, results);
        return results;
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    void pre(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }

        results.add(root.val);
        pre(root.left, results);
        pre(root.right, results);
    }
}
