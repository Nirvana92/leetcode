package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/10 8:04 下午
 * @desc
 */
public class No_337_House_Robbery_III {
    @Test
    public void test() {
//        TreeNode root = new TreeNode(3);
//        TreeNode l = new TreeNode(2);
//        TreeNode r = new TreeNode(3);
//        TreeNode lr = new TreeNode(3);
//        TreeNode rr = new TreeNode(1);
//        root.left = l;
//        root.right = r;
//        l.right = lr;
//        r.right = rr;

        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(4);
        TreeNode r = new TreeNode(5);
        TreeNode ll = new TreeNode(1);
        TreeNode lr = new TreeNode(3);
        TreeNode rr = new TreeNode(1);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.right = rr;

        int rob = rob(root);
        System.out.println(rob);
    }

    public int rob(TreeNode root) {
        RobInfo robInfo = process(root);
        return Math.max(robInfo.containRootMaxVal, robInfo.noContainRootMaxVal);
    }

    RobInfo process(TreeNode root) {
        if (root == null) {
            return new RobInfo(0, 0);
        }

        if (root.left == null && root.right == null) {
            return new RobInfo(root.val, 0);
        }

        RobInfo leftRobInfo = process(root.left);
        RobInfo rightRobInfo = process(root.right);

        int containRootMaxVal = leftRobInfo.noContainRootMaxVal + rightRobInfo.noContainRootMaxVal + root.val;
        int noContainRootMaxVal = Math.max(Math.max(leftRobInfo.containRootMaxVal + rightRobInfo.containRootMaxVal,
                leftRobInfo.noContainRootMaxVal + rightRobInfo.noContainRootMaxVal),
                Math.max(leftRobInfo.containRootMaxVal + rightRobInfo.noContainRootMaxVal,
                        leftRobInfo.noContainRootMaxVal + rightRobInfo.containRootMaxVal));

        return new RobInfo(containRootMaxVal, noContainRootMaxVal);
    }

    class RobInfo {
        /**
         * 包含头结点的最大值
         */
        int containRootMaxVal;
        /**
         * 不包含头结点的最大值
         */
        int noContainRootMaxVal;

        public RobInfo(int containRootMaxVal, int noContainRootMaxVal) {
            this.containRootMaxVal = containRootMaxVal;
            this.noContainRootMaxVal = noContainRootMaxVal;
        }
    }
}
