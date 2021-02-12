package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/1/25 2:04 下午
 * @desc: 1733. 需要教语言的最少人数
 */
public class No_1733_Minimum_number_of_people_who_need_to_teach_language {
    @Test
    public void test() {
        int n = 2;
        int[][] languages = new int[][]{{1}, {2}, {1, 2}};
        int[][] friendships = new int[][]{{1, 2}, {1, 3}, {2, 3}};

        int minimumTeachings = minimumTeachings(n, languages, friendships);
        System.out.println(minimumTeachings);
    }

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        return -1;
    }
}
