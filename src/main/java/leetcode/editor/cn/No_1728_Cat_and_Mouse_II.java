package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2021/1/19 4:23 下午
 * @desc: 1728. 猫和老鼠 II
 */
public class No_1728_Cat_and_Mouse_II {
    @Test
    public void test() {
        String[] grid = new String[]{};
        int catJump = 1;
        int mouseJump = 1;

        boolean canMouseWin = canMouseWin(grid, catJump, mouseJump);
        System.out.println(canMouseWin);
    }

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        return false;
    }
}
