package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

/**
 * @author gzm
 * @date 2020/10/26 7:38 下午
 * @desc: 316. 去除重复字母
 * <p>
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小
 * （要求不能打乱其他字符的相对位置）。
 * <p>
 * leetcode_1081 一毛一样的题目
 */
public class No_316_Remove_duplicate_letters {
    @Test
    public void test() {
        String str = "bcabc";
        // str = "cbacdcbc";
        // str = "abacb";

        String removeDuplicateLetters = removeDuplicateLetters(str);
        System.out.println(removeDuplicateLetters);
    }

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        // 已经添加过的字符
        Set<Character> seen = new HashSet<>();
        // 每个字符最晚出现的下标索引
        Map<Character, Integer> maps = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            maps.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            if (!seen.contains(s.charAt(i))) {
                while (!stack.isEmpty() && s.charAt(i) < stack.peek() && maps.get(stack.peek()) > i) {
                    Character pop = stack.pop();
                    seen.remove(pop);
                }

                stack.add(s.charAt(i));
                seen.add(s.charAt(i));
            }
        }

        char[] rsts = new char[stack.size()];
        for (int i = rsts.length - 1; i >= 0; i--) {
            rsts[i] = stack.pop();
        }

        return new String(rsts);
    }
}
