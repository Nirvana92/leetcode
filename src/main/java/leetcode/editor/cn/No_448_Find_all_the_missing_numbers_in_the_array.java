package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.Utils;

import java.util.*;

/**
 * @author Nirvana
 * @date 2021/2/13 17:45
 * <p>
 * 448. 找到所有数组中消失的数字
 */
public class No_448_Find_all_the_missing_numbers_in_the_array {
    @Test
    public void test() {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        int[] cNums = Arrays.copyOf(nums, nums.length);

        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);

        List<Integer> baoli = baoli(cNums);
        System.out.println(baoli);
    }

    @Test
    public void t() {
        int times = 10000;

        while (times-- > 0) {
            int len = Utils.generInt(2, 10);

            int[] nums = new int[len];
            int[] cNums = new int[len];

            for (int i = 0; i < len; i++) {
                int num = Utils.generInt(1, len);
                nums[i] = num;
                cNums[i] = num;
            }

            List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
            List<Integer> baoli = baoli(cNums);

            if (disappearedNumbers.size() != baoli.size()) {
                System.out.println("error");
                break;
            } else {
                for (int i = 0; i < disappearedNumbers.size(); i++) {
                    if (disappearedNumbers.get(i) != baoli.get(i)) {
                        System.out.println("error");
                        break;
                    }
                }
            }
        }

    }

    public List<Integer> baoli(int[] nums) {
        Set<Integer> sets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            sets.add(nums[i]);
        }

        List<Integer> disNums = new ArrayList<>();
        for (int num = 1; num <= nums.length; num++) {
            if (!sets.contains(num)) {
                disNums.add(num);
            }
        }

        return disNums;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disNums = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // nums[i];
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                disNums.add(i + 1);
            }
        }

        return disNums;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
