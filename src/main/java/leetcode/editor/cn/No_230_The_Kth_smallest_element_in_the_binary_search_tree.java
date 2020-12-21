package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzm
 * @date 2020/10/9 3:55 下午
 * @desc
 */
public class No_230_The_Kth_smallest_element_in_the_binary_search_tree {
    @Test
    public void test() {

    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> lists = new ArrayList<>();

        process(root, lists);
        return lists.get(k - 1);
    }

    void process(TreeNode root, List<Integer> lists) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            lists.add(root.val);
            return;
        }

        process(root.left, lists);
        lists.add(root.val);
        process(root.right, lists);
    }
}
