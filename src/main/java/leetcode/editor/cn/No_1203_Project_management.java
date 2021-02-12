package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzm
 * @date 2021/1/12 9:26 上午
 * @desc: 1203. 项目管理
 * <p>
 * 每日一题: 待处理
 */
public class No_1203_Project_management {
    @Test
    public void test() {
        int n = 8, m = 2;
        int[] group = new int[]{};
        List<List<Integer>> beforeItems = new ArrayList<>();

        int[] sortItems = sortItems(n, m, group, beforeItems);
        PrintUtils.print(sortItems);
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        return null;
    }
}
