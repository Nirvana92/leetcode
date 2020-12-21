package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzm
 * @date 2020/10/22 10:05 上午
 * @desc: 763. 划分字母区间
 * <p>
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
 * 返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例:
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */
public class No_763_Divide_letter_interval {
    @Test
    public void test() {
        String s = "ababcbacadefegdehijhklij";

        s = "a";

        List<Integer> partitionLabels = partitionLabels(s);
        System.out.println(partitionLabels);
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> rsts = new ArrayList<>();

        int N = S.length();
        // 首先遍历一遍, 找到每个字符出现的最后的位置
        int[] ends = new int[26];
        for (int i = N - 1; i >= 0; i--) {
            char curChar = S.charAt(i);
            if (ends[curChar - 'a'] == 0) {
                ends[curChar - 'a'] = i;
            }
        }

        for (int i = 0; i < N; i++) {
            int curIndex = i, curSegmentIndex = ends[S.charAt(i) - 'a'];
            while (curIndex < curSegmentIndex && curIndex < N) {
                curIndex++;
                curSegmentIndex = Math.max(curSegmentIndex, ends[S.charAt(curIndex) - 'a']);
            }
            rsts.add(curIndex - i + 1);
            i = curIndex;
        }

        return rsts;
    }
}
