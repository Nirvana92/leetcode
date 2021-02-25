package leetcode.editor.cn;

import org.junit.Test;
import org.nirvana.util.PrintUtils;
import org.nirvana.util.Utils;

import java.util.LinkedList;

/**
 * @author Nirvana
 * @date 2021/2/18 11:23
 * <p>
 * 995. K 连续位的最小翻转次数
 * <p>
 * 使用滑动窗口的处理方法处理本题
 */
public class No_995_K_minimum_number_of_consecutive_bit_flips {
    @Test
    public void test() {
        int[] nums = new int[]{0, 1, 0};
        int k = 1;

//        nums = new int[]{1, 1, 0};
//        k = 2;

//        nums = new int[]{0, 0, 0, 1, 0, 1, 1, 0};
//        k = 3;

        nums = new int[]{0, 0, 0, 0};
        k = 3;

        int minKBitFlips = minKBitFlips(nums, k);
        System.out.println(minKBitFlips);
    }

    @Test
    public void t() {
        int times = 1000000;


        while (times-- > 0) {
            int[] nums = Utils.generIntArr(1, 10, 0, 2);
            //PrintUtils.print(nums);
            int len = nums.length;
            int k = Utils.generInt(1, len);

            int minKBitFlips = minKBitFlips(nums, k);
            int muban = muban(nums, k);
            if (minKBitFlips != muban) {
                System.out.println("error");
                PrintUtils.print(nums);
                System.out.println("k: " + k);
                System.out.println("min: " + minKBitFlips);
                System.out.println("muban: " + muban);
                break;
            }
        }
    }

    public int minKBitFlips(int[] nums, int k) {
        int minFlips = 0;
        int rIndex = 0;
        int curFlips = 0;
        // 1: 代表进行了翻转, 0: 代表没有进行翻转
        LinkedList<Integer> queues = new LinkedList<>();
        for (int i = 0; i <= nums.length - k; i++) {
            while (rIndex < nums.length && rIndex - i < k) {
                if ((nums[rIndex] == 0 && curFlips % 2 == 0)
                        || (nums[rIndex] == 1 && curFlips % 2 == 1)) {
                    curFlips++;
                    minFlips++;
                    queues.add(1);
                } else {
                    queues.add(0);
                }
                rIndex++;
            }

            // 出队列的时候需要判断i 位置是否做过翻转
            if (!queues.isEmpty() && queues.pollFirst() == 1) {
                curFlips--;
            }
        }

        // 判断最后的k 范围, 是否进行了翻转. 如果进行了翻转则不存在翻转的方法
        while (!queues.isEmpty()) {
            if (queues.poll() == 1) {
                return -1;
            }
        }

        return minFlips;
    }

    /**
     * 模板方法
     *
     * @param A
     * @param K
     * @return
     */
    public int muban(int[] A, int K) {
        int n = A.length;
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= K && A[i - K] > 1) {
                revCnt ^= 1;
                A[i - K] -= 2; // 复原数组元素，若允许修改数组 A，则可以省略
            }
            if (A[i] == revCnt) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                A[i] += 2;
            }
        }
        return ans;
    }
}
