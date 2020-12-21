package leetcode.editor.cn;

//在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。 
//
// 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。 
//
// 
//
// 示例: 
//
// 输入: -3, 0, 3, 4, 0, -1, 9, 2
//输出: 45 
//
// 说明: 假设矩形面积不会超出 int 的范围。 
// Related Topics 数学 
// 👍 84 👎 0

// RectangleArea
public class No_223_Rectangular_area {
    public static void main(String[] args) {
        Solution solution = new No_223_Rectangular_area().new Solution();
        int sumArea = solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
        System.out.println(sumArea);
    }

    class Solution {
        /**
         * (A, B) (C, D)
         * (E, F) (G, H)
         */
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int leftDownX = Math.max(A, E);
            int leftDownY = Math.max(B, F);

            int rightUpX = Math.min(C, G);
            int rightUpY = Math.min(D, H);
            int firstArea = (C - A) * (D - B);
            int secondArea = (G - E) * (H - F);

            if (leftDownX > rightUpX || leftDownY > rightUpY) {
                return firstArea + secondArea;
            }

            return firstArea + secondArea - (rightUpX - leftDownX) * (rightUpY - leftDownY);
        }
    }
}