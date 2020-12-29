package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author gzm
 * @date 2020/12/25 9:15 上午
 * @desc: 455. 分发饼干
 */
public class No_455_Distribute_cookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int sumNum = 0;
        int sIndex = 0;
        for (int i = 0; i < g.length; i++) {

            for (int j = sIndex; j < s.length; j++) {
                if (s[j] >= g[i]) {
                    sumNum++;
                    sIndex = j + 1;
                    break;
                }
            }
        }

        return sumNum;
    }
}
