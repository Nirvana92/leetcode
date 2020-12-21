package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;
import org.nirvana.util.Utils;

import java.util.TreeSet;

/**
 * @author gzm
 * @date 2020/10/15 10:58 上午
 * @desc 220. 存在重复元素 III
 * <p>
 * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 */
public class No_220_There_are_duplicate_elements_III {
    @Test
    public void test() {
        // [-2147483648,2147483647]
        // 1
        // 1
        int[] nums = new int[]{1, 2, 3, 4, 1};
        int k = 3, t = 0;

        nums = new int[]{-2147483648, 2147483647};
        k = 1;
        t = 1;

        nums = new int[]{1, 2};
        k = 0;
        t = 1;

        boolean containsNearbyAlmostDuplicate = containsNearbyAlmostDuplicate(nums, k, t);
        boolean containsNearbyAlmostDuplicateBaoli = containsNearbyAlmostDuplicateBaoli(nums, k, t);
        System.out.println(containsNearbyAlmostDuplicate);
        System.out.println(containsNearbyAlmostDuplicateBaoli);
    }

    /**
     * 对数器
     */
    @Test
    public void logarithm() {
        int times = 10000;
        while (times-- > 0) {
            int[] nums = Utils.generIntArr(1, 20, -20, 30);
            int k = Utils.generInt(1, 40);
            int t = Utils.generInt(1, 10);

            boolean containsNearbyAlmostDuplicate = containsNearbyAlmostDuplicate(nums, k, t);
            boolean containsNearbyAlmostDuplicateBaoli = containsNearbyAlmostDuplicateBaoli(nums, k, t);
            if (containsNearbyAlmostDuplicate != containsNearbyAlmostDuplicateBaoli) {
                PrintUtils.print(nums);
                System.out.println(k);
                System.out.println(t);
                System.out.println("containsNearbyAlmostDuplicate: " + containsNearbyAlmostDuplicate + "; containsNearbyAlmostDuplicateBaoli" + containsNearbyAlmostDuplicateBaoli);
                System.out.println("==error");
            }
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // abs(nums[i] - nums[j]) <= t
        // abs(i - j) <= k   =>>>>> 窗口
        if (k == 0) {
            return false;
        }

        int R = 0;
        TreeSet<Integer> sets = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            while (R < nums.length && (R - i + 1) <= k) {
                // 统计结果
                boolean contain = haveNearbyTNum(sets, nums[R], t);
                if (contain) {
                    return contain;
                }

                sets.add(nums[R]);
                R++;
            }

            // 统计结果
            if (R < nums.length) {
                boolean contain = haveNearbyTNum(sets, nums[R], t);
                if (contain) {
                    return contain;
                }
            }
            // 移除元素
            sets.remove(nums[i]);
        }

        return false;
    }

    boolean haveNearbyTNum(TreeSet<Integer> sets, int curNum, int t) {
        Integer floor = sets.floor(curNum);
        Integer ceiling = sets.ceiling(curNum);

        if (floor != null && Math.abs((long) curNum - (long) floor) <= t) {
            return true;
        }

        return ceiling != null && Math.abs((long) curNum - (long) ceiling) <= t;
    }


    public boolean containsNearbyAlmostDuplicateBaoli(int[] nums, int k, int t) {
        if (k >= nums.length - 1) {
            return haveNearByTNum(nums, 0, nums.length - 1, t);
        }
        for (int i = 0; i < (nums.length - k); i++) {
            if (haveNearByTNum(nums, i, i + k, t)) {
                return true;
            }
        }

        return false;
    }

    public boolean haveNearByTNum(int[] nums, int l, int r, int t) {
        for (int startIndex = l; startIndex <= r; startIndex++) {
            for (int endIndex = startIndex + 1; endIndex <= r; endIndex++) {
                if (Math.abs(nums[startIndex] - nums[endIndex]) <= t) {
                    return true;
                }
            }
        }

        return false;
    }
}
