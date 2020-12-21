package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/24 23:56
 * <p>
 * 470. 用 Rand7() 实现 Rand10()
 * <p>
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 * <p>
 * 不要使用系统的 Math.random() 方法。
 */
public class No_470_Implement_Rand10_with_Rand7 {
    @Test
    public void test() {

    }

    public int rand10() {
        int firstNum = rand7();
        while (firstNum == 7) {
            firstNum = rand7();
        }

        int preNum = 0;
        if (firstNum >= 1 && firstNum <= 3) {
            // 10中选: 1~5
        } else {
            // 10中选: 6~10
            preNum = 5;
        }

        int secondNum = rand7();
        while (secondNum > 5) {
            secondNum = rand7();
        }

        return preNum + secondNum;
    }

    /**
     * 系统实现的函数
     *
     * @return
     */
    public int rand7() {
        return 1;
    }
}
