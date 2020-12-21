package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nirvana
 * @date 2020/11/9 22:36
 * <p>
 * 830. 较大分组的位置
 */
public class No_830_Location_of_larger_group {
    @Test
    public void test() {
        String s = "abc";
        s = "abcdddeeeeaabbbcddd";
        List<List<Integer>> lists = largeGroupPositions(s);
        System.out.println(lists);
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        int N = s.length();
        List<List<Integer>> rets = new ArrayList<>();

        char preChar = s.charAt(0);
        int preIndex = 0, targetLen = 3;

        for (int i = 1; i < N; i++) {
            if (s.charAt(i) != preChar) {
                if (i - preIndex >= targetLen) {
                    // 收集结果
                    List<Integer> ret = new ArrayList<>();
                    ret.add(preIndex);
                    ret.add(i - 1);
                    rets.add(ret);
                }

                // 重新赋值
                preChar = s.charAt(i);
                preIndex = i;
            }
        }

        if (N - preIndex >= targetLen) {
            List<Integer> ret = new ArrayList<>();
            ret.add(preIndex);
            ret.add(N - 1);
            rets.add(ret);
        }

        return rets;
    }
}
