package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/27 4:08 下午
 * @desc: 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class Offer_33_Post_order_traversal_sequence_of_binary_search_tree {
    @Test
    public void test() {
        int[] postorder = new int[]{1, 6, 3, 2, 5};
        postorder = new int[]{1, 3, 2, 6, 5};
        postorder = new int[]{4, 8, 6, 12, 16, 14, 10};

        boolean verifyPostorder = verifyPostorder(postorder);
        System.out.println(verifyPostorder);
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }

        return verifyPostOrder(postorder, 0, postorder.length - 1);
    }

    boolean verifyPostOrder(int[] postOrders, int l, int r) {
        if (l == r) {
            return true;
        }
        // 头结点
        int curHead = postOrders[r];

        int rLeftIndex = r;
        for (int i = r - 1; i >= l; i--) {
            if (postOrders[i] > curHead) {
                rLeftIndex = i;
            } else {
                break;
            }
        }

        // 验证下 l ~ rLeftIndex - 1 是否都是 < curHead 的
        for (int i = l; i < rLeftIndex - 1; i++) {
            if (postOrders[i] > curHead) {
                return false;
            }
        }

        // 左孩子的下标 l ~ rLeftIndex-1
        // l == rLeftIndex 没有左孩子; 不用管
        boolean left = true;
        if (l < rLeftIndex) {
            left = verifyPostOrder(postOrders, l, rLeftIndex - 1);
        }
        // 右孩子的下标 rLeftIndex ~ r-1
        // rLeftIndex == r 没有右孩子; 不用管
        boolean right = true;
        if (rLeftIndex < r) {
            // System.out.println("rLeftIndex: " + rLeftIndex + "; r: " + r);
            right = verifyPostOrder(postOrders, rLeftIndex, r - 1);
        }

        return left && right;
    }
}
