package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;
import org.nirvana.util.Utils;

/**
 * @author Nirvana
 * @date 2020/11/17 22:22
 * <p>
 * 1248. 统计「优美子数组」
 * <p>
 * 滑动窗口 + 辅助数组
 */
public class No_1248_Statistics_beautiful_sub_array {
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 2, 1, 1};
        int k = 3;

        nums = new int[]{2, 4, 6};
        k = 1;

        nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        k = 2;

        nums = new int[]{7, 5};
        k = 2;

        int numberOfSubarrays = numberOfSubarrays(nums, k);
        System.out.println(numberOfSubarrays);
    }

    @Test
    public void t() {
        int times = 1000;

        while (times-- > 0) {
            int[] ints = Utils.generIntArr(1, 1000, 1, 100000);
            int k = Utils.generInt(1, ints.length);
            int numberOfSubarrays = numberOfSubarrays(ints, k);
            int numberOfSubarraysOthers = numberOfSubarraysOthers(ints, k);
            if (numberOfSubarrays != numberOfSubarraysOthers) {
                PrintUtils.print(ints);
                System.out.println(k);
                System.out.println("error");
                System.out.println(numberOfSubarrays);
                System.out.println(numberOfSubarraysOthers);
                break;
            }
        }
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int numOfSub = 0, r = 0, curOddNums = 0, N = nums.length;
        int[] rightEvenNums = new int[nums.length + 1];
        rightEvenNums[N] = 1;
        rightEvenNums[N - 1] = nums[N - 1] % 2 == 1 ? 1 : 1;
        for (int i = N - 2; i >= 0; i--) {
            if (nums[i + 1] % 2 == 1) {
                rightEvenNums[i] = 1;
            } else {
                rightEvenNums[i] += rightEvenNums[i + 1] + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            while (r < N && curOddNums < k) {
                if (nums[r] % 2 == 1) {
                    curOddNums++;
                }

                r++;
            }

            if (curOddNums == k) {
                numOfSub += rightEvenNums[r - 1];
            }

            if (nums[i] % 2 == 1) {
                curOddNums--;
            }
        }

        return numOfSub;
    }

    public int numberOfSubarraysOthers(int[] nums, int k) {
        // 数组 prefixCnt 的下标是前缀和（即当前奇数的个数），值是前缀和的个数。
        int[] prefixCnt = new int[nums.length + 1];
        prefixCnt[0] = 1;
        // 遍历原数组，计算当前的前缀和，统计到 prefixCnt 数组中，
        // 并且在 res 中累加上与当前前缀和差值为 k 的前缀和的个数。
        int res = 0, sum = 0;
        for (int num : nums) {
            sum += num & 1;
            prefixCnt[sum]++;
            if (sum >= k) {
                res += prefixCnt[sum - k];
            }
        }
        return res;
    }
}
