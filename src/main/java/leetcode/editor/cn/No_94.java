package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class No_94 {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        TreeNode rl = new TreeNode(3);

        root.right = r;
        r.left = rl;

        List<Integer> paths = inorderTraversal(root);
        System.out.println(paths);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> paths = new ArrayList<>();

        process(root, paths);

        return paths;
    }

    public void process(TreeNode root, List<Integer> paths) {
        if (root == null) {
            return;
        }

        process(root.left, paths);
        paths.add(root.val);
        process(root.right, paths);
    }
}
