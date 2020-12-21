package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author gzm
 * @date 2020/10/26 8:31 下午
 * @desc: 515. 在每个树行中找最大值
 * <p>
 * 您需要在二叉树的每一行中找到最大的值。
 */
public class No_515_Find_the_maximum_value_in_each_tree_row {
    @Test
    public void test() {

    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> rsts = new ArrayList<>();
        if (root == null) {
            return rsts;
        }

        Queue<TreeNode> queues = new LinkedList<>();
        queues.add(root);

        while (!queues.isEmpty()) {
            int size = queues.size();

            // 有可能是负值
            int tmpVal = queues.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = queues.poll();
                tmpVal = Math.max(tmpVal, tmpNode.val);

                if (tmpNode.left != null) {
                    queues.add(tmpNode.left);
                }

                if (tmpNode.right != null) {
                    queues.add(tmpNode.right);
                }
            }

            rsts.add(tmpVal);
        }

        return rsts;
    }
}
