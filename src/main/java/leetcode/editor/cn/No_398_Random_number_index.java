package leetcode.editor.cn;

import java.util.Random;

/**
 * @author Nirvana
 * @date 2020/11/7 13:43
 * <p>
 * 398. 随机数索引
 */
public class No_398_Random_number_index {

    class Solution {
        private int[] nums;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        public int pick(int target) {
            int numIndex = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    count++;
                    if (random.nextInt(nums.length) % count == 0) {
                        numIndex = i;
                    }
                }
            }

            return numIndex;
        }
    }
}