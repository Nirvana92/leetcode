package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/9/22 5:34 下午
 * @desc: 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class No_208_Trie {
    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    class Trie {
        boolean isEnd;
        Trie[] next;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            next = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] words = word.toCharArray();
            Trie curTrie = this;
            for (int i = 0; i < words.length; i++) {
                int index = words[i] - 'a';
                if (curTrie.next[index] == null) {
                    curTrie.next[index] = new Trie();
                    curTrie = curTrie.next[index];
                } else {
                    curTrie = curTrie.next[index];
                }
            }

            curTrie.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] words = word.toCharArray();
            Trie curTrie = this;
            for (int i = 0; i < words.length; i++) {
                int index = words[i] - 'a';
                if (curTrie.next[index] == null) {
                    return false;
                }
                curTrie = curTrie.next[index];
            }

            // 如果不是结束节点, 返回false
            if (!curTrie.isEnd) {
                return false;
            }

            return true;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            char[] prefixs = prefix.toCharArray();

            Trie curTrie = this;
            for (int i = 0; i < prefixs.length; i++) {
                int index = prefixs[i] - 'a';

                if (curTrie.next[index] == null) {
                    return false;
                }
                curTrie = curTrie.next[index];
            }

            return true;
        }
    }
}
