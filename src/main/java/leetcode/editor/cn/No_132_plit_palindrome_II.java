package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/3/8 3:24 下午
 * @desc: 132. 分割回文串 II
 */
public class No_132_plit_palindrome_II {
    @Test
    public void test() {
        String s = "";
        int minCut = minCut(s);
        System.out.println(minCut);
    }

    public int minCut(String s) {
        // 新增一个dp[i]: 表示s[i..len] 是回文的最小切割术
        // 新增一个dp[i][j]: 表示s[i...j] 是否是回文
        // 然后遍历当前位置i.  一次i+1, i+2 ...... 的各种情况
        return -1;
    }


    /**
     * 从i位置开始切割。定义dp[i][j] 记录  i...j 是否是回文串, 预先求出这个dp的内容
     *
     * @param s
     * @param i
     * @return
     */
    public int process(String s, int i) {
        return -1;
    }
}
