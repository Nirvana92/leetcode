package leetcode.editor.cn;

/**
 * 124. 二叉树中的最大路径和
 *
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 *
 * 示例 2:
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No_124 {

    public static void main(String[] args) {
        // TreeNode root = TreeUtils.generTreeNode();
        TreeNode root = new TreeNode(-2);
        TreeNode leftNode = new TreeNode(1);
        root.setLeft(leftNode);
        No_124 no_124 = new No_124();
        int maxPath = no_124.maxPathSum(root);
        System.out.println(maxPath);
    }

    /**
     * 情况分析:
     * 1. 最大路径在左子树中
     * 2. 最大路径在右子树中
     * 3. 最大路径包括头节点在两树中
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return process(root).maxPath;
    }

    public PathInfo process(TreeNode root) {
        if(root == null) {
            return null;
        }

        if(root.getLeft() == null && root.getRight() == null) {
            return new PathInfo(root.val, root.val);
        }

        PathInfo leftPath = process(root.getLeft());
        PathInfo rightPath = process(root.getRight());

        // 避免越界处理. 如果root.val 是负数, root.val + Integer.MIN_VALUE 越界了
        int leftMaxPath = root.val > 0 ? 0 : root.val,
                rightMaxPath = root.val > 0 ? 0 : root.val,
                leftFromHeadMaxPath = root.val > 0 ? 0 : root.val,
                rightFromHeadMaxPath = root.val > 0 ? 0 : root.val;
        if(leftPath != null) {
            leftMaxPath = leftPath.maxPath;
            leftFromHeadMaxPath = leftPath.fromHeadMaxPath;
        }

        if(rightPath != null) {
            rightMaxPath = rightPath.maxPath;
            rightFromHeadMaxPath = rightPath.fromHeadMaxPath;
        }

        // 从头节点开始的三种情况
        int fromHeadMaxPath = Math.max(root.val+leftFromHeadMaxPath,
                Math.max(root.val, root.val+rightFromHeadMaxPath));

        // 最大路径包括从头节点开始和不从头节点开始
        int maxPath = Math.max(fromHeadMaxPath, Math.max(leftMaxPath,
                Math.max(rightMaxPath, root.val+leftFromHeadMaxPath + rightFromHeadMaxPath)));
        return new PathInfo(maxPath, fromHeadMaxPath);
    }

    /**
     * 定义了每个路径需要返回的信息内容
     */
    class PathInfo {
        // 最长路径
        int maxPath;
        // 从头节点开始的最长路径
        int fromHeadMaxPath;

        public PathInfo(int maxPath, int fromHeadMaxPath) {
            this.maxPath = maxPath;
            this.fromHeadMaxPath = fromHeadMaxPath;
        }
    }
}