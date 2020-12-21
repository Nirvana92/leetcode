package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

/**
 * @author gzm
 * @date 2020/9/29 12:57 下午
 * @desc: 10 个长度的字符串, 相同的序列超过1 返回
 * <p>
 * 思路1: 转换成前缀树, 然后判断是否能找到进行处理
 * 思路2: 从每个索引开始遍历, 然后放到set中, 最后进行判断是否存在
 */
public class No_187_Repetitive_DNA_sequence {
    @Test
    public void test() {
        String str = "AAAAAAAAAAAA";
        List<String> repeatedDnaSequences = findRepeatedDnaSequences(str);
        System.out.println(repeatedDnaSequences);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        int DNA_LEN = 10;

        if (s.length() <= DNA_LEN) {
            return new ArrayList<>();
        }
        Set<String> sets = new HashSet<>();
        Set<String> results = new HashSet<>();

        char[] dnas = s.toCharArray();
        for (int startIndex = 0; startIndex <= dnas.length - DNA_LEN; startIndex++) {
            String curStr = new String(Arrays.copyOfRange(dnas, startIndex, startIndex + DNA_LEN));
            if (sets.contains(curStr)) {
                results.add(curStr);
            } else {
                sets.add(curStr);
            }
        }

        return new ArrayList<>(results);
    }
}
