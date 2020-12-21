package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/28 3:20 下午
 * @desc
 */
public class No_114_Binary_tree_expands_into_linked_list {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(5);
        TreeNode ll = new TreeNode(3);
        TreeNode lr = new TreeNode(4);
        TreeNode rr = new TreeNode(6);
        l.left = ll;
        l.right = lr;
        r.right = rr;
        root.left = l;
        root.right = r;

        flatten(root);
        System.out.println(root);
    }

    public void flatten(TreeNode root) {
        Info info = expandsToLinkedList(root);
        // System.out.println(info);
    }

    Info expandsToLinkedList(TreeNode root) {
        if (root == null) {
            return new Info(null, null);
        }

        Info leftInfo = expandsToLinkedList(root.left);
        root.left = null;
        Info rightInfo = expandsToLinkedList(root.right);

        TreeNode tmpHead = root;
        if (leftInfo.headNode != null) {
            tmpHead.right = leftInfo.headNode;
        }

        if (leftInfo.tailNode != null) {
            tmpHead = leftInfo.tailNode;
        }

        if (rightInfo.headNode != null) {
            tmpHead.right = rightInfo.headNode;
        }

        if (rightInfo.tailNode != null) {
            tmpHead = rightInfo.tailNode;
        }

        return new Info(root, tmpHead);
    }

    class Info {
        // 头节点
        TreeNode headNode;
        // 尾节点
        TreeNode tailNode;

        public Info(TreeNode headNode, TreeNode tailNode) {
            this.headNode = headNode;
            this.tailNode = tailNode;
        }
    }
}
