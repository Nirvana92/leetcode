package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

/**
 * 139. 单词拆分
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * <p>
 * 示例:
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * <p>
 * https://leetcode-cn.com/problems/word-break/
 */
public class No_139_Word_split {
    public static void main(String[] args) {
        No_139_Word_split no_139 = new No_139_Word_split();
        String s = "leetcode";
        List<String> wordsDict = Arrays.asList("leet", "code");

//        s = "applepenapple";
//        wordsDict = Arrays.asList("apple", "pen");

//        s = "catsandog";
//        wordsDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

        s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        wordsDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");

//        s = "cbca";
//        wordsDict = Arrays.asList("bc", "ca");

        boolean matched = no_139.wordBreak(s, wordsDict);
        System.out.println(matched);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode trieNode = new TrieNode();
        // 根据给定的wordDict 初始化前缀树
        for (int index = 0; index < wordDict.size(); index++) {
            char[] words = wordDict.get(index).toCharArray();

            TrieNode preNode = trieNode;
            for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
                int charIndex = words[wordIndex] - 'a';
                if (preNode.next[charIndex] == null) {
                    // 该节点没有赋值过
                    if (wordIndex == words.length - 1) {
                        // 是结尾的节点
                        preNode.next[charIndex] = new TrieNode(true);
                    } else {
                        preNode.next[charIndex] = new TrieNode();
                    }
                }

                // 给前置节点赋值
                preNode = preNode.next[charIndex];
                if (wordIndex == words.length - 1) {
                    // 当前节点为结束节点
                    preNode.setEnd(true);
                }
            }
        }

        // 遍历s 看是否在前缀树中能够完美找到对应的字符
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        return process(0, s.toCharArray(), trieNode, dp);
    }

    /**
     * 在ss 字符数组中, 从startIndex 往后长度的字符串是否可以在 trieNode 字典中完全匹配到
     *
     * @param startIndex: ss[startIndex .....] 是否可以在 trieNode 中找到
     * @param ss:         给定的字符数组
     * @param trieNode:   前缀树字典
     * @return
     */
    public boolean process(int startIndex, char[] ss, TrieNode trieNode, int[] dp) {
        if (dp[startIndex] != 0) {
            return dp[startIndex] == 1;
        }

        TrieNode nextTrie = trieNode;
        for (int index = startIndex; index < ss.length
                && nextTrie.next != null; index++) {
            int tmpIndex = ss[index] - 'a';

            TrieNode tmpTrie = nextTrie.next[tmpIndex];
            if (tmpTrie == null) {
                dp[startIndex] = 2;
                return false;
            }

            if (tmpTrie.isEnd && process(index + 1, ss, trieNode, dp)) {
                // 结尾字符, 可以做一个分界点, 递归调用下一个代码
                dp[startIndex] = 1;
                return true;
            }
            nextTrie = tmpTrie;
        }

        dp[startIndex] = 2;
        return false;
    }
}

class TrieNode {
    TrieNode[] next;
    boolean isEnd;

    public TrieNode() {
        this.next = new TrieNode[26];
    }

    public TrieNode(boolean isEnd) {
        this();
        this.isEnd = isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
