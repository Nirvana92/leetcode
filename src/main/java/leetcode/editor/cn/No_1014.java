package leetcode.editor.cn;

/**
 * 1014. 最佳观光组合
 *
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 *
 * 示例：
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *  
 * 提示：
 *
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No_1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int maxScore = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                int tmpSocre = A[i]+A[j]+i-j;
                maxScore = Math.max(maxScore, tmpSocre);
            }
        }
        return maxScore;
    }

    public int maxScoreSightseeingPairDp(int[] A) {

        //int[] dp = new int[A.length];
        int preDpScore = A[A.length-2]+A[A.length-1]-1;
        int maxScore = preDpScore;

        for (int index = A.length-3; index >= 0; index--) {
            int curDpScore = Math.max(A[index]+A[index+1]-1, A[index]-A[index+1]+preDpScore-1);

            maxScore = Math.max(curDpScore, maxScore);
            preDpScore = curDpScore;
        }

        //System.out.println(Arrays.toString(dp));
        return maxScore;
    }

    public static void main(String[] args) {
        // int[] A = new int[]{8,1,5,2,6};
        int[] A = new int[]{7,8,8,10};

        No_1014 no_1014 = new No_1014();
        int maxScore = no_1014.maxScoreSightseeingPair(A);
        int maxScoreDp = no_1014.maxScoreSightseeingPairDp(A);
        System.out.println(maxScore);
        System.out.println(maxScoreDp);
    }
}
