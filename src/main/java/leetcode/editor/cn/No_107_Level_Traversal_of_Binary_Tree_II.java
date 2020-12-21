package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Nirvana
 * @date 2020/12/18 21:43
 * <p>
 * 107. 二叉树的层次遍历 II
 */
public class No_107_Level_Traversal_of_Binary_Tree_II {
    @Test
    public void test() {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<TreeNode> queues = new LinkedList<>();
        List<List<Integer>> rets = new ArrayList<>();

        if (root == null) {
            return rets;
        }

        queues.add(root);

        while (!queues.isEmpty()) {
            int curSize = queues.size();

            List<Integer> curLists = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = queues.pollFirst();
                curLists.add(curNode.val);

                if (curNode.left != null) {
                    queues.addLast(curNode.left);
                }

                if (curNode.right != null) {
                    queues.addLast(curNode.right);
                }
            }

            rets.add(curLists);
        }

        int l = 0, r = rets.size() - 1;
        while (l < r) {
            List<Integer> lVal = rets.get(l);
            List<Integer> rVal = rets.get(r);
            List<Integer> tmpVal = lVal;
            rets.set(l, rVal);
            rets.set(r, tmpVal);
//            lVal = rVal;
//            rVal = tmpVal;

            l++;
            r--;
        }

        return rets;
    }
}
