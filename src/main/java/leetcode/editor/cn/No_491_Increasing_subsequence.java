package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nirvana
 * @date 2020/10/25 11:14
 * <p>
 * 491. 递增子序列
 * <p>
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * <p>
 * 说明:
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 */
public class No_491_Increasing_subsequence {
    @Test
    public void test() {
        int[] nums = new int[]{4, 6, 7, 7};
        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1};

        List<List<Integer>> subsequences = findSubsequences(nums);
        System.out.println(subsequences);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> rsts = new ArrayList<>();

        List<Integer> paths = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            dfs(nums, i, paths, rsts);
//        }
        dfs(nums, 0, Integer.MIN_VALUE, paths, rsts);

        return rsts;
    }

    void dfs(int[] nums, int i, int preVal, List<Integer> paths, List<List<Integer>> rsts) {
        if (i == nums.length) {
            if (paths.size() >= 2) {
                rsts.add(Utils.copyLists(paths));
            }
            return;
        }

        if (nums[i] >= preVal) {
            paths.add(nums[i]);
            dfs(nums, i + 1, nums[i], paths, rsts);
            paths.remove(paths.size() - 1);
        }

        // 当当前数和前面一个数不等的时候才考虑不添加当前元素
        if (nums[i] != preVal) {
            dfs(nums, i + 1, preVal, paths, rsts);
        }

//        if (paths.size() == 0) {
//            dfs(nums, i + 1, preVal, paths, rsts);
//
//            paths.add(nums[i]);
//            dfs(nums, i + 1, nums[i], paths, rsts);
//            paths.remove(paths.size() - 1);
//        } else {
//            if (nums[i] >= preVal) {
//                // 当当前数和前面一个数不等的时候才考虑不添加当前元素
//                if (nums[i] != preVal) {
//                    dfs(nums, i + 1, preVal, paths, rsts);
//                }
//
//                paths.add(nums[i]);
//                dfs(nums, i + 1, nums[i], paths, rsts);
//                paths.remove(paths.size() - 1);
//            }
//        }
    }
}
