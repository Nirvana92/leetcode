package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1028. 从先序遍历还原二叉树
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 * 给出遍历输出 S，还原树并返回其根节点 root。
 * <p>
 * 示例 1：
 * <p>
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 * <p>
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 * <p>
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 */
public class No_1028 {

    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        for (char c : S.toCharArray()) {

        }

        return null;
    }

    public static void main(String[] args) {
        String s = "1-2--3--4-5--6--7";

        String[] split = s.split("-");
        System.out.println(Arrays.toString(split));

//        No_1028 no_1028 = new No_1028();
//        TreeNode treeNode = no_1028.recoverFromPreorder(s);
//        System.out.println(treeNode);
    }
}
