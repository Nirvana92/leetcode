package leetcode.editor.cn;

/**
 * @author gzm
 * @date 2020/9/14 8:36 下午
 * @desc
 */
public class No_104_maximum_depth_of_binary_tree {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
