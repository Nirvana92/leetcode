package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 */
public class No_78_Subset {
    public static void main(String[] args) {
        No_78_Subset no_78 = new No_78_Subset();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets = no_78.subsets(nums);
        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> paths = new ArrayList<>();
        process(nums, 0, paths, subsets);

        return subsets;
    }

    public void process(int[] nums, int l, ArrayList<Integer> paths, List<List<Integer>> subsets) {
        if (l == nums.length) {
            // 记录结果
            List<Integer> cloneLists = (List<Integer>) paths.clone();
            subsets.add(cloneLists);
            return;
        }

        // 选 l 位置的数字
        process(nums, l + 1, paths, subsets);

        // 不选 l 位置的数字
        paths.add(nums[l]);
        process(nums, l + 1, paths, subsets);
        paths.remove(paths.size() - 1);
    }


    @Test
    public void testList() {
        List<String> strs = new ArrayList<>();
        strs.add("1");
        strs.add("2");
        strs.add("3");
        strs.add("4");
        strs.add("5");
        strs.remove(strs.size() - 1);
        System.out.println(strs);
    }
}
