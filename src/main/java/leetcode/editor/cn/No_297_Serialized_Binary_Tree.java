package leetcode.editor.cn;

import java.util.Objects;

/**
 * 297. 二叉树的序列化与反序列化
 * <p>
 * 题目:
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 示例:
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 */
public class No_297_Serialized_Binary_Tree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        StringBuffer buffer = new StringBuffer();
        serializeProcess(root, buffer);
        return buffer.toString().substring(0, buffer.length() - 1);
    }

    /**
     * 先序遍历
     *
     * @param root
     * @param buffer
     */
    public void serializeProcess(TreeNode root, StringBuffer buffer) {
        if (root == null) {
            buffer.append("null").append(",");
            return;
        }

        buffer.append(root.val).append(",");
        serializeProcess(root.left, buffer);
        serializeProcess(root.right, buffer);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        String[] split = data.split(",");
        if (Objects.equals(split[0], "null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        deserializeProcess(root, split, 1);
        return root;
    }

    /**
     * @param split
     * @param index
     * @return
     */
    public int deserializeProcess(TreeNode root, String[] split, int index) {
        if (index >= split.length) {
            return -1;
        }
        if (root == null) {
            return index;
        }

        root.left = Objects.equals(split[index], "null") ?
                null : new TreeNode(Integer.parseInt(split[index]));

        int rightIndex = deserializeProcess(root.left, split, index + 1);

        root.right = Objects.equals(split[rightIndex], "null") ?
                null : new TreeNode(Integer.parseInt(split[rightIndex]));

        return deserializeProcess(root.right, split, rightIndex + 1);
    }

    public static void main(String[] args) {
//        TreeNode root = null;
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode r2Node = new TreeNode(3);
        r2Node.left = new TreeNode(4);
        r2Node.right = new TreeNode(5);
        root.right = r2Node;

        No_297_Serialized_Binary_Tree no_297 = new No_297_Serialized_Binary_Tree();
        String serialize = no_297.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = no_297.deserialize(serialize);
        System.out.println(deserialize);
    }
}
