package leetcode.editor.cn;

/**
 * @author gzm
 * @date 2020/10/12 8:16 下午
 * @desc: todo: 是否也可以改为 morris 遍历的方法求解
 */
public class No_100_The_same_tree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
