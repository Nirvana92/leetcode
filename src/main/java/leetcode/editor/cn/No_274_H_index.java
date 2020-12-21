package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Nirvana
 * @date 2020/11/13 22:16
 * <p>
 * 274. H 指数
 */
public class No_274_H_index {
    @Test
    public void test() {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        int hIndex = hIndex(citations);
        System.out.println(hIndex);
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int maxH = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] < maxH) {
                maxH--;
            }
        }

        return maxH;
    }
}
