package leetcode.editor.cn;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 1531 👎 0

// TrappingRainWater
public class No_42_Catch_rain {
    public static void main(String[] args) {

        Solution solution = new No_42_Catch_rain().new Solution();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = solution.trap(height);
        System.out.println(trap);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 双指针的方式处理该问题
     * 定义lMaxVal: 左边最大的数值, rMaxVal: 右边最大的数值
     * 定义两个指针, lIndex: 左边的指针, rIndex: 右边的指针
     * <p>
     * 如果lMaxVal > rMaxVal: 计算 rIndex 位置的可存储的水量. 然后rIndex往中间移动. 重新计算rMaxVal.
     * 如果lMaxVal <= rMaxVal: 计算lIndex 位置的可存储的水量, 然后lIndex往中间移动. 重新计算lMaxVal.
     */
    class Solution {
        public int trap(int[] height) {
            if (height == null || height.length <= 2) {
                return 0;
            }

            int waters = 0;
            int lMaxVal = height[0], rMaxVal = height[height.length - 1];
            int lIndex = 1, rIndex = height.length - 2;
            while (lIndex <= rIndex) {
                if (lMaxVal <= rMaxVal) {
                    // 左边 > 右边
                    waters += Math.max(lMaxVal - height[lIndex], 0);
                    lMaxVal = Math.max(lMaxVal, height[lIndex]);
                    lIndex++;
                } else {
                    waters += Math.max(rMaxVal - height[rIndex], 0);
                    rMaxVal = Math.max(rMaxVal, height[rIndex]);
                    rIndex--;
                }
            }

            return waters;
        }
    }
}