package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nirvana
 * @date 2020/10/24 18:07
 * <p>
 * 386. 字典序排数
 */
public class No_386_Lexicographic_number {
    @Test
    public void test() {
        int n = 13;
        List<Integer> integers = lexicalOrder(n);
        System.out.println(integers);
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> rsts = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, rsts);
        }

        return rsts;
    }

    void dfs(int num, int n, List<Integer> rsts) {
        if (num > n) {
            return;
        }

        rsts.add(num);

        for (int i = 0; i <= 9; i++) {
            dfs(num * 10 + i, n, rsts);
        }
    }
}
