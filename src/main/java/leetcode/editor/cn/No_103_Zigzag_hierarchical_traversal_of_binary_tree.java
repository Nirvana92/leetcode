package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gzm
 * @date 2020/9/28 1:59 下午
 * @desc: 二叉树的锯齿形层次遍历
 */
public class No_103_Zigzag_hierarchical_traversal_of_binary_tree {
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

        List<List<Integer>> lists = zigzagLevelOrder(root);
        System.out.println(lists);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        if (root == null) {
            return results;
        }

        LinkedList<TreeNode> queues = new LinkedList<>();
        queues.add(root);

        boolean leftToRight = true;
        while (!queues.isEmpty()) {
            int size = queues.size();
            List<Integer> tmpRst = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    // 从左往右弹出
                    TreeNode treeNode = queues.pollFirst();
                    tmpRst.add(treeNode.val);
                    if (treeNode.left != null) {
                        queues.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queues.add(treeNode.right);
                    }
                } else {
                    // 从右往左弹出
                    TreeNode treeNode = queues.pollLast();
                    tmpRst.add(treeNode.val);
                    if (treeNode.right != null) {
                        queues.addFirst(treeNode.right);
                    }

                    if (treeNode.left != null) {
                        queues.addFirst(treeNode.left);
                    }
                }
            }
            results.add(tmpRst);
            leftToRight = !leftToRight;
        }

        return results;
    }
}
