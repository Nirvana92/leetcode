package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 *  
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class No_146_LRU {
    @Test
    public void test() {
//        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        //System.out.println(cache.get(1));       // 返回  1
//        cache.put(3, 3);    // 该操作会使得关键字 2 作废
//        System.out.println(cache.get(2));       // 返回 -1 (未找到)
//        cache.put(4, 4);    // 该操作会使得关键字 1 作废
//        System.out.println(cache.get(1));       // 返回 -1 (未找到)
//        System.out.println(cache.get(3));       // 返回  3
//        System.out.println(cache.get(4));       // 返回  4

        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

//        ["LRUCache", "put", "put", "get", "get", "put", "get", "get", "get"]
//        [[2],[2, 1],[3, 2],[3],[2],[4, 3],[2],[3],[4]]
    }

    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    class LRUCacheSelf {
        Node head = null, tail = null;
        Map<Integer, Node> cacheMap = null;
        private Integer capacity = 0;

        public LRUCacheSelf(int capacity) {
            this.capacity = capacity;
            cacheMap = new HashMap<>();
        }

        public int get(int key) {
            Node node = cacheMap.get(key);
            if (node != null) {
                // 在链表中更换位置
                changeToHead(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (cacheMap.containsKey(key)) {
                Node exitNode = cacheMap.get(key);
                exitNode.value = value;
                cacheMap.put(key, exitNode);
                changeToHead(exitNode);
            } else {
                Node node = new Node(key, value);
                cacheMap.put(key, node);
                changeToHead(node);
            }

            if (cacheMap.size() > capacity) {
                // 容量超过限制, 删除
                Node delNode = tail;
                tail = delNode.pre;
                tail.next = null;
                delNode.pre = null;
                cacheMap.remove(delNode.key);
            }
        }

        private void changeToHead(Node node) {
            // 将node 移动至 head 节点, 最近使用导致活跃度靠前
            if (head == null) {
                head = node;
                tail = node;
            } else {
                if (node != head) {
                    if (node.pre != null) {
                        node.pre.next = node.next;
                        tail = node.pre;
                    }

                    if (node.next != null) {
                        node.next.pre = node.pre;
                    }

                    node.next = head;
                    node.pre = null;
                    head.pre = node;
                    head = node;
                }
            }
        }
    }

    class Node {
        public Integer key;
        public Integer value;
        public Node pre;
        public Node next;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}
