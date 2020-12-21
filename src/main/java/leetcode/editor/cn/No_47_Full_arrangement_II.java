package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 47. 全排列 II
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 全排列的代码解法
 * 参考: {@link Offer_38_String_arrangement}
 */
public class No_47_Full_arrangement_II {
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 2};
        nums = new int[]{1, 2, 3};

        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println(lists);
    }

    List<List<Integer>> rets = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        process(nums, 0);

        return rets;
    }

    void process(int[] nums, int curIndex) {
        int N = nums.length;
        if (curIndex == N) {
            rets.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));

            return;
        }

        Set<Integer> sets = new HashSet<>();
        for (int i = curIndex; i < N; i++) {
            if (sets.contains(nums[i])) {
                continue;
            }
            sets.add(nums[i]);
            swap(nums, curIndex, i);
            process(nums, curIndex + 1);
            swap(nums, curIndex, i);
        }
    }

    void swap(int[] arrs, int i, int j) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}
