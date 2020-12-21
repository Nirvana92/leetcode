package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Nirvana
 * @date 2020/10/31 21:44
 * <p>
 * 653. 两数之和 IV - 输入 BST
 */
public class No_653_Sum_of_two_numbers_IV_Enter_BST {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> sets = new HashSet<>();

        return process(root, k, sets);
    }

    boolean process(TreeNode root, int k, Set<Integer> sets) {
        if (root == null) {
            return false;
        }

        if (sets.contains(k - root.val)) {
            return true;
        }

        sets.add(root.val);

        boolean left = process(root.left, k, sets);
        boolean right = process(root.right, k, sets);
        return left | right;
    }
}
