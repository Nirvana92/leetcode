package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/31 21:12
 * <p>
 * 623. 在二叉树中增加一行
 */
public class No_623_Add_a_row_to_the_binary_tree {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode ll = new TreeNode(4);
        root.left = l;
        root.right = r;
        l.left = ll;

        TreeNode treeNode = addOneRow(root, 5, 4);
        System.out.println(treeNode);
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode head = new TreeNode(v);
            head.left = root;

            return head;
        }

        process(root, v, d, 1);

        return root;
    }

    void process(TreeNode root, int v, int d, int curLevel) {
        if (curLevel == d - 1) {
            // 到达的d-1 层, 根据左右子树的状况创建当前层的数值

            TreeNode leftNode = new TreeNode(v);
            if (root.left != null) {
                leftNode.left = root.left;
            }
            root.left = leftNode;

            TreeNode rightNode = new TreeNode(v);
            if (root.right != null) {
                rightNode.right = root.right;
            }
            root.right = rightNode;
            return;
        }

        if (root.left != null) {
            process(root.left, v, d, curLevel + 1);
        }

        if (root.right != null) {
            process(root.right, v, d, curLevel + 1);
        }
    }
}
