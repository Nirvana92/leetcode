package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/22 7:00 下午
 * @desc: 并查集结构和图相关
 */
public class No_968_monitoring_binary_tree {
    @Test
    public void test() {
//        TreeNode root = new TreeNode(0);
//        TreeNode l = new TreeNode(0);
//        TreeNode ll = new TreeNode(0);
//        TreeNode lr = new TreeNode(0);
//        l.left = ll;
//        l.right = lr;
//        root.left = l;

        TreeNode root = new TreeNode(0);
        TreeNode l = new TreeNode(0);
        TreeNode ll = new TreeNode(0);
        TreeNode lll = new TreeNode(0);
        TreeNode lllr = new TreeNode(0);
        lll.right = lllr;
        ll.left = lll;
        l.left = ll;
        root.left = l;

        int minCameraCover = minCameraCover(root);
        System.out.println(minCameraCover);
    }

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        Info info = process(root);

        return info.coverAllTreeCameraNoCareRoot;
    }

    Info process(TreeNode root) {
        if (root == null) {
            return new Info(Integer.MAX_VALUE / 2, 0, 0);
        }

        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int coverAllTreeCameraWithRoot, coverAllTreeCameraNoCareRoot, coverAllSubTreeCamera;

        coverAllTreeCameraWithRoot = leftInfo.coverAllSubTreeCamera + rightInfo.coverAllSubTreeCamera + 1;
        coverAllTreeCameraNoCareRoot = Math.min(coverAllTreeCameraWithRoot,
                Math.min(leftInfo.coverAllTreeCameraWithRoot + rightInfo.coverAllTreeCameraNoCareRoot,
                        leftInfo.coverAllTreeCameraNoCareRoot + rightInfo.coverAllTreeCameraWithRoot));
        coverAllSubTreeCamera = Math.min(coverAllTreeCameraWithRoot, leftInfo.coverAllTreeCameraNoCareRoot + rightInfo.coverAllTreeCameraNoCareRoot);

        return new Info(coverAllTreeCameraWithRoot, coverAllTreeCameraNoCareRoot, coverAllSubTreeCamera);
    }

    class Info {
        // 必须要在root 节点放置相机, 覆盖所有节点需要的相机数
        int coverAllTreeCameraWithRoot;
        // 覆盖所有节点需要的相机数, 不管root 节点是否放置了相机
        int coverAllTreeCameraNoCareRoot;
        // 覆盖所有子树需要的相机数
        int coverAllSubTreeCamera;

        public Info(int coverAllTreeCameraWithRoot, int coverAllTreeCameraNoCareRoot, int coverAllSubTreeCamera) {
            this.coverAllTreeCameraWithRoot = coverAllTreeCameraWithRoot;
            this.coverAllTreeCameraNoCareRoot = coverAllTreeCameraNoCareRoot;
            this.coverAllSubTreeCamera = coverAllSubTreeCamera;
        }
    }
}
