package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/21 3:08 下午
 * @desc: 思路描述: 在每个节点的下一个节点新增复制节点.
 * 然后新增一个快指针, 修改random指针.
 * 最后抽离两个链表
 */
public class No_138_copy_a_linked_list_with_random_pointers {
    @Test
    public void test() {
//        Node root = new Node(7);
//        Node n = new Node(13);
//        Node nn = new Node(11);
//        Node nnn = new Node(10);
//        Node nnnn = new Node(1);
//        root.next = n;
//        n.next = nn;
//        nn.next = nnn;
//        nnn.next = nnnn;
//
//        n.random = root;
//        nn.random = nnnn;
//        nnn.random = nn;
//        nnnn.random = root;
        Node root = new Node(1);
        Node n = new Node(2);
        root.next = n;

        root.random = n;
        n.random = n;

        Node result = copyRandomList(root);
        System.out.println(root);
        System.out.println(result);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 遍历节点, 在每个节点下方拷贝一个节点
        Node tmpNode = head;
        while (tmpNode != null) {
            Node node = new Node(tmpNode.val);
            node.random = tmpNode.random;
            node.next = tmpNode.next;
            tmpNode.next = node;

            tmpNode = node.next;
        }

        // 生成好了原链表和复制链表
        // 再次遍历, 调整复制链表的random指针
        tmpNode = head.next;
        while (tmpNode != null) {
            Node curRandomNode = tmpNode.random;
            if (curRandomNode != null) {
                tmpNode.random = curRandomNode.next;
            }

            if (tmpNode.next != null) {
                tmpNode = tmpNode.next.next;
            } else {
                tmpNode = null;
            }
        }

        // 还原原始链表和复制链表
        tmpNode = head;
        Node newNode = head.next;
        Node newTmpNode = newNode;

        while (newTmpNode != null
                && newTmpNode.next != null) {
            tmpNode.next = tmpNode.next.next;
            newTmpNode.next = newTmpNode.next.next;

            tmpNode = tmpNode.next;
            newTmpNode = newTmpNode.next;
        }
        tmpNode.next = null;

        return newNode;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}