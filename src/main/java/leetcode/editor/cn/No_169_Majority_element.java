package leetcode.editor.cn;

import org.classic_interview_questions.traincamp._15._15_3;

/**
 * 血王问题: 参考: {@link _15_3}
 */
public class No_169_Majority_element {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        No_169_Majority_element no_169 = new No_169_Majority_element();
        int mostNumEle = no_169.majorityElement(nums);
        System.out.println(mostNumEle);
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        int pre = nums[0];
        for (int index = 1; index < nums.length; index++) {
            if (pre == nums[index]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                pre = nums[index];
                count = 1;
            }
        }

        return pre;
    }
}
