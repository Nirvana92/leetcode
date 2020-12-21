package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzm
 * @date 2020/9/8 12:03 下午
 * @desc
 */
public class No_77 {

    public static void main(String[] args) {
        No_77 no_77 = new No_77();
        int n = 3;
        int k = 1;
        List<List<Integer>> combine = no_77.combine(n, k);
        System.out.println(combine);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        ArrayList<Integer> paths = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            process(n, k, i, 1, paths, results);
        }

        return results;
    }

    void process(int n, int k, int index, int currentNum, ArrayList<Integer> paths, List<List<Integer>> results) {
        if (index == k && paths.size() == k) {
            results.add((List<Integer>) paths.clone());
            return;
        }

        if (currentNum > n) {
            return;
        }

        // index 的数选择
        paths.add(currentNum);
        process(n, k, index + 1, currentNum + 1, paths, results);
        paths.remove(paths.size() - 1);

        // index 的数不选择
        process(n, k, index, currentNum + 1, paths, results);
    }
}
