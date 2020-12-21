package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gzm
 * @date 2020/11/16 9:58 上午
 * @desc: 406. 根据身高重建队列
 * <p>
 * 贪心方法
 */
public class No_406_Rebuild_the_queue_based_on_height {
    @Test
    public void test() {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] reconstructQueue = reconstructQueue(people);
        PrintUtils.print(reconstructQueue);
    }

    public int[][] reconstructQueue(int[][] people) {
        // 先按照 个子大 -> 小的排序. 身高相同按照 k 小-> 大的排序
        Arrays.sort(people, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));

        List<int[]> results = new ArrayList<>();
        for (int[] person : people) {
            results.add(person[1], person);
        }

        // 然后依次插入到k 位置。 因为个子是从大到小排序的, 第k 个位置前面肯定会有k个高个子人。
        int[][] rets = new int[people.length][2];
        for (int i = 0; i < results.size(); i++) {
            rets[i] = results.get(i);
        }

        return rets;
    }
}
