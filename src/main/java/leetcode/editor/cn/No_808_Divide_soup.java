package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/17 20:57
 * <p>
 * 808. 分汤
 */
public class No_808_Divide_soup {
    @Test
    public void test() {
        int N = 50;
        double soupServings = soupServings(N);
        System.out.println(soupServings);
    }

    /**
     * todo: 将N /25 求得最终需要计算的值, 然后使用动态规划求得概率, 并且 N >= 500 的时候概率为1, 通过打表
     *
     * @param N
     * @return
     */
    public double soupServings(int N) {
        return 0D;
    }
}
