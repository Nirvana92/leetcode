package leetcode.editor.cn;

/**
 * LCP 06. 拿硬币
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 *
 * 示例 1：
 * 输入：[4,2,1]
 *
 * 输出：4
 *
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 *
 * 示例 2：
 * 输入：[2,3,10]
 *
 * 输出：8
 *
 * 限制：
 * 1 <= n <= 4
 * 1 <= coins[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/na-ying-bi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No_LCP_06 {

    public static void main(String[] args) {
        int[] coins = new int[]{2,3,10};

        No_LCP_06 no_lcp_06 = new No_LCP_06();
        int i = no_lcp_06.minCount(coins);
        System.out.println(i);
    }

    public int minCount(int[] coins) {
        int minCount = 0;
        for (int coin : coins) {
            // 避免奇偶性
            ++coin;

            minCount += coin >> 1;
        }

        return minCount;
    }
}
