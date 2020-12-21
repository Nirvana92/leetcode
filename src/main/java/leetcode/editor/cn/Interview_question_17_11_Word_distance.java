package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nirvana
 * @date 2020/11/17 22:11
 * <p>
 * 面试题 17.11. 单词距离
 */
public class Interview_question_17_11_Word_distance {
    @Test
    public void test() {
        String[] words = new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"};
        String w1 = "a", w2 = "student";

        int closest = findClosest(words, w1, w2);
        System.out.println(closest);
    }

    public int findClosest(String[] words, String word1, String word2) {
        List<Integer> w1Indexs = new ArrayList<>();
        List<Integer> w2Indexs = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                w1Indexs.add(i);
            } else if (words[i].equals(word2)) {
                w2Indexs.add(i);
            }
        }

        int w1Index = 0, w2Index = 0, minDis = Integer.MAX_VALUE;
        while (w1Index < w1Indexs.size() && w2Index < w2Indexs.size()) {
            minDis = Math.min(minDis, Math.abs(w1Indexs.get(w1Index) - w2Indexs.get(w2Index)));

            if (minDis == 1) {
                return minDis;
            }

            if (w1Indexs.get(w1Index) < w2Indexs.get(w2Index)) {
                w1Index++;
            } else {
                w2Index++;
            }
        }

        return minDis;
    }
}
