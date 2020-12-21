package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Nirvana
 * @date 2020/11/7 13:37
 * <p>
 * 384. 打乱数组
 */
public class No_384_Shuffle_the_array {

    class Solution {
        int[] oriArrs = null;
        int[] curArrs = null;
        Random random = null;

        public Solution(int[] nums) {
            this.oriArrs = nums;
            this.curArrs = Arrays.copyOf(nums, nums.length);
            random = new Random();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            this.curArrs = Arrays.copyOf(oriArrs, oriArrs.length);
            return curArrs;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            for (int i = 0; i < curArrs.length; i++) {
                int swapIndex = random.nextInt(curArrs.length);
                swap(i, swapIndex);
            }

            return curArrs;
        }

        void swap(int i, int j) {
            int tmp = curArrs[i];
            curArrs[i] = curArrs[j];
            curArrs[j] = tmp;
        }
    }
}
