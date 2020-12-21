package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author gzm
 * @date 2020/11/13 5:20 下午
 * @desc: 451. 根据字符出现频率排序
 */
public class No_451_Sort_by_frequency_of_characters {
    @Test
    public void test() {
        String s = "tree";
        s = "cccaaa";

        String frequencySort = frequencySort(s);
        System.out.println(frequencySort);
    }

    public String frequencySort(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Info> queues = new PriorityQueue<Info>((i1, i2) -> i2.count - i1.count);
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            queues.add(new Info(entry.getValue(), entry.getKey()));
        }

        StringBuffer buffer = new StringBuffer();
        while (!queues.isEmpty()) {
            Info info = queues.poll();
            for (int i = 0; i < info.count; i++) {
                buffer.append(info.c);
            }
        }

        return buffer.toString();
    }

    class Info {
        int count;
        char c;

        public Info(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }
}
