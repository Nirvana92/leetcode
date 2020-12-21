package leetcode.editor.cn;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int data) {
        this.val = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
}
