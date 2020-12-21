package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gzm
 * @date 2020/10/14 4:00 下午
 * @desc: 查找常用字符
 */
public class No_1002_Find_common_characters {
    @Test
    public void test() {
        String[] A = new String[]{"bella", "label", "roller"};
        A = new String[]{"cool", "lock", "cook"};
        List<String> strings = commonChars(A);
        System.out.println(strings);
    }

    public List<String> commonChars(String[] A) {
        List<String> results = new ArrayList<>();
        // 设置一个全局最小的值, 用全局最大值初始化填充
        int[] minCounts = new int[26];
        Arrays.fill(minCounts, Integer.MAX_VALUE);

        for (String s : A) {
            int[] tmpCounts = new int[26];
            // 遍历每个string, 统计临时每个字符的个数
            for (int i = 0; i < s.length(); i++) {
                tmpCounts[s.charAt(i) - 'a']++;
            }

            // 选择所有string的固定字符的最小的个数
            for (int i = 0; i < minCounts.length; i++) {
                minCounts[i] = Math.min(minCounts[i], tmpCounts[i]);
            }
        }

        // 收集重复的字符
        for (int i = 0; i < minCounts.length; i++) {
            for (int j = 1; j <= minCounts[i]; j++) {
                results.add(String.valueOf((char) (i + 'a')));
            }
        }

        return results;
    }
}
