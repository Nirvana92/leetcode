package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/20 2:40 下午
 * @desc: 剑指 Offer 26. 树的子结构
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class Offer_26_Tree_substructure {
    @Test
    public void test() {
        TreeNode a = new TreeNode(3), b = new TreeNode(4);
        TreeNode l = new TreeNode(4);
        TreeNode r = new TreeNode(5);
        a.left = l;
        a.right = r;
        TreeNode ll = new TreeNode(1);
        TreeNode lr = new TreeNode(2);
        l.left = ll;
        l.right = lr;

//        TreeNode bl = new TreeNode(1);
//        b.left = bl;

//        a = new TreeNode(1);
//        l = new TreeNode(2);
//        r = new TreeNode(3);
//        a.left = l;
//        a.right = r;
//
//        b = new TreeNode(3);
//        TreeNode bl = new TreeNode(1);
//        b.left = bl;

        a = new TreeNode(4);
        TreeNode al = new TreeNode(2);
        TreeNode ar = new TreeNode(3);
        TreeNode all = new TreeNode(4);
        TreeNode alr = new TreeNode(5);
        al.left = all;
        al.right = alr;

        a.left = al;
        a.right = ar;

        TreeNode arl = new TreeNode(6);
        TreeNode arr = new TreeNode(7);
        ar.left = arl;
        ar.right = arr;

        TreeNode alll = new TreeNode(8);
        TreeNode allr = new TreeNode(9);
        all.left = alll;
        all.right = allr;

        b = new TreeNode(4);
        TreeNode bl = new TreeNode(8);
        TreeNode br = new TreeNode(9);
        b.left = bl;
        b.right = br;

        boolean subStructure = isSubStructure(a, b);
        System.out.println(subStructure);
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSubStru(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean isSubStru(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }

        if (a == null) {
            return false;
        }

        return (a.val == b.val) && isSubStru(a.left, b.left) && isSubStru(a.right, b.right);
    }
}
