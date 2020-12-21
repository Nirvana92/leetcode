package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No_46_Full_array {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        Set<Integer> selected = new HashSet<>();
        process(nums, paths, results, selected);
        return results;
    }

    void process(int[] nums, List<Integer> paths, List<List<Integer>> results, Set<Integer> selected) {
        if (selected.size() == nums.length) {
            results.add(Utils.copyLists(paths));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!selected.contains(nums[i])) {
                // 选和不选
                paths.add(nums[i]);
                selected.add(nums[i]);
                process(nums, paths, results, selected);
                paths.remove(paths.size() - 1);
                selected.remove(nums[i]);
            }
        }
    }
}
