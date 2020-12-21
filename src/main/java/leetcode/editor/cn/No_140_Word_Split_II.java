package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nirvana
 * @date 2020/11/1 17:46
 * <p>
 * 140. 单词拆分 II
 */
public class No_140_Word_Split_II {
    public static boolean[] getdp(String s, TrieNode root) {
        char[] str = s.toCharArray();
        int N = str.length;
        boolean[] dp = new boolean[N + 1];
        dp[N] = true;
        for (int i = N - 1; i >= 0; i--) {
            TrieNode cur = root;
            for (int end = i; end < N; end++) {
                int path = str[end] - 'a';
                if (cur.next[path] == null) {
                    break;
                }
                cur = cur.next[path];
                if (cur.isEnd && dp[end + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp;
    }

    @Test
    public void test() {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        s = "pineapplepenapple";
        wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");

        s = "catsandog";
        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

        List<String> wordBreak = wordBreak(s, wordDict);
        System.out.println(wordBreak);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode trieNode = getTrieNode(wordDict);

        boolean[] dp = getdp(s, trieNode);

        List<String> rsts = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        process(s, 0, trieNode, buffer, rsts, dp);

        return rsts;
    }

    void process(String s, int l, TrieNode trieNode, StringBuffer pathBuffer, List<String> rsts, boolean[] dp) {
        // 达到了要求的长度, 直接保存结果
        if (l == s.length()) {
            rsts.add(pathBuffer.toString());

            return;
        }

        TrieNode tmpNode = trieNode;
        StringBuffer curBuffer = new StringBuffer();
        for (int i = l; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            TrieNode tmpTrie = tmpNode.next[index];
            if (tmpTrie == null) {
                // dp[startIndex] = 2;
                // return false;
                break;
            }

            curBuffer.append(s.charAt(i));

            // 使用dp 数组加速
            if (tmpTrie.isEnd && dp[i + 1]) {
                // 结尾字符, 可以做一个分界点, 递归调用下一个代码
                // dp[startIndex] = 1;
                // StringBuffer addPathBuffer = null;
                int endIndex = pathBuffer.length();
                if (pathBuffer.length() == 0) {
                    pathBuffer = pathBuffer.append(curBuffer.toString());
                } else {
                    pathBuffer = pathBuffer.append(" ").append(curBuffer.toString());
                }

                process(s, i + 1, trieNode, pathBuffer, rsts, dp);
                pathBuffer.delete(endIndex, pathBuffer.length());

                // return true;
            }

            tmpNode = tmpTrie;
        }
    }

    TrieNode getTrieNode(List<String> wordDict) {
        TrieNode trieNode = new TrieNode();
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

        return trieNode;
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
}
