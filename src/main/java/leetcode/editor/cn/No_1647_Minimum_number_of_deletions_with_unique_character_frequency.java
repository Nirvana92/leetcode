package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzm
 * @date 2020/11/9 1:00 下午
 * @desc: 1647. 字符频次唯一的最小删除次数
 */
public class No_1647_Minimum_number_of_deletions_with_unique_character_frequency {
    @Test
    public void test() {
        String s = "aab";
        s = "aaabbbcc";
        s = "ceabaacb";
        s = "asflkadjfaldjflasdfashdfiashdfkadlfasjdfhasidfhakdhfksdakshdfioefowneohfhasdfhksadfjhskahflifsd";

        int minDeletions = minDeletions(s);
        System.out.println(minDeletions);
    }

    public int minDeletions(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        int minDel = 0;
        Map<Integer, Character> maps = new HashMap<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                continue;
            }

            if (maps.containsKey(counts[i])) {
                int curCount = counts[i] - 1;
                while (maps.containsKey(curCount) && curCount != 0) {
                    curCount--;
                }

                if (curCount != 0 && !maps.containsKey(curCount)) {
                    maps.put(curCount, (char) (i + 'a'));
                }

                minDel += counts[i] - curCount;
            } else {
                maps.put(counts[i], (char) (i + 'a'));
            }
        }

        return minDel;
    }
}
