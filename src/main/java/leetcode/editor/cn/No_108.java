package leetcode.editor.cn;

import org.junit.Test;

public class No_108 {
    @Test
    public void test() {
//        TreeNode root = new TreeNode(0);
//        TreeNode l = new TreeNode(-3);
//        TreeNode r = new TreeNode(9);
//        TreeNode ll = new TreeNode(-10);
//        l.left = ll;
//        TreeNode rl = new TreeNode(5);
//        r.left = rl;
//        root.left = l;
//        root.right = r;

        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return generateNode(nums, 0, nums.length - 1);
    }

    TreeNode generateNode(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        if (l == r) {
            return new TreeNode(nums[l]);
        }

        int midIndex = (r - l + 1) / 2 + l;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = generateNode(nums, l, midIndex - 1);
        root.right = generateNode(nums, midIndex + 1, r);

        return root;
    }
}
