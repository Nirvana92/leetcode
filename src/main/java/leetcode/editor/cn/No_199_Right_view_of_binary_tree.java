package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_199_Right_view_of_binary_tree {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode lr = new TreeNode(5);
//        TreeNode rr = new TreeNode(4);
        root.left = l;
        root.right = r;
        l.right = lr;
//        r.right = rr;

        List<Integer> rsts = rightSideView(root);
        System.out.println(rsts);
    }

    // 层序遍历, 拿到每一层的最后一个节点的值放到结合中返回
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rsts = new ArrayList<>();
        if (root == null) {
            return rsts;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curNode = queue.poll();

                if (i == levelSize - 1) {
                    // 每层的最后一个节点
                    rsts.add(curNode.val);
                }

                // 当前节点的子节点放入到队列中
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }

                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }

        return rsts;
    }
}
