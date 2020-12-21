package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/24 20:16
 * <p>
 * 1529. 灯泡开关 IV
 * <p>
 * 房间中有 n 个灯泡，编号从 0 到 n-1 ，自左向右排成一行。最开始的时候，所有的灯泡都是 关 着的。
 * <p>
 * 请你设法使得灯泡的开关状态和 target 描述的状态一致，其中 target[i] 等于 1 第 i 个灯泡是开着的，等于 0 意味着第 i 个灯是关着的。
 * <p>
 * 有一个开关可以用于翻转灯泡的状态，翻转操作定义如下：
 * <p>
 * 选择当前配置下的任意一个灯泡（下标为 i ）
 * 翻转下标从 i 到 n-1 的每个灯泡
 * 翻转时，如果灯泡的状态为 0 就变为 1，为 1 就变为 0 。
 * <p>
 * 返回达成 target 描述的状态所需的 最少 翻转次数。
 */
public class No_1529_Bulb_switch_IV {
    @Test
    public void test() {
        String target = "101";
        target = "10111";
        target = "00000";
//        target = "001011101";
//        target = "1111111";
//        target = "1010101010101";

        int minFlips = minFlips(target);
        System.out.println(minFlips);
    }

    /**
     * 本题的思路其实就是从target 第一个1 的开始数, 中间 0 1 的连续串有多少段
     * 就是本题的结果
     *
     * @param target
     * @return
     */
    public int minFlips(String target) {
        int N = target.length();

        // 找到第一个1 的位置
        int index = 0;
        while (index < N && target.charAt(index) == '0') {
            index++;
        }
        // 如果全部都是0, 直接返回结果
        if (index == N) {
            return 0;
        }

        // 从第一个1 开始找个数
        int minFlips = 0;
        char preChar = '1';
        while (index < N) {
            if (target.charAt(index) != preChar) {
                minFlips++;
                preChar = target.charAt(index);
            }

            index++;
        }

        return minFlips + 1;
    }
}
