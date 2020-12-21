package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author Nirvana
 * @date 2020/10/24 00:20
 * <p>
 * 1024. 视频拼接
 */
public class No_1024_Video_stitching {
    @Test
    public void test() {
        int[][] clips = new int[][]{
                {0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}
        };
        int T = 10;

        clips = new int[][]{
                {0, 1},
                {1, 2}
        };
        T = 5;

        int videoStitching = videoStitching(clips, T);
        System.out.println(videoStitching);
    }

    public int videoStitching(int[][] clips, int T) {
        int[] maxLast = new int[T];

        // 保存以 clip[0] 开头的最远到达的地方。
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxLast[clip[0]] = Math.max(maxLast[clip[0]], clip[1]);
            }
        }

        // 一次填充 0 ~ T 看是否有满足条件的个数返回
        int last = 0, ret = 0, pre = 0;
        for (int i = 0; i < T; i++) {
            last = Math.max(maxLast[i], last);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }

        return ret;
    }
}
