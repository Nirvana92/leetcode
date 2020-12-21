package leetcode.editor.cn;

import org.junit.Test;

/**
 * @author gzm
 * @date 2020/10/23 5:03 下午
 * @desc: 741. 摘樱桃
 * <p>
 * 一个N x N的网格(grid) 代表了一块樱桃地，每个格子由以下三种数字的一种来表示：
 * <p>
 * 0 表示这个格子是空的，所以你可以穿过它。
 * 1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
 * -1 表示这个格子里有荆棘，挡着你的路。
 * 你的任务是在遵守下列规则的情况下，尽可能的摘到最多樱桃：
 * <p>
 * 从位置 (0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）；
 * 当到达 (N-1, N-1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
 * 当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为0）；
 * 如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。
 * <p>
 * 示例:
 * 输入: grid =
 * [[0, 1, -1],
 * [1, 0, -1],
 * [1, 1,  1]]
 * 输出: 5
 * 解释：
 * 玩家从（0,0）点出发，经过了向下走，向下走，向右走，向右走，到达了点(2, 2)。
 * 在这趟单程中，总共摘到了4颗樱桃，矩阵变成了[[0,1,-1],[0,0,-1],[0,0,0]]。
 * 接着，这名玩家向左走，向上走，向上走，向左走，返回了起始点，又摘到了1颗樱桃。
 * 在旅程中，总共摘到了5颗樱桃，这是可以摘到的最大值了。
 */
public class No_741_Cherry_picking {
    @Test
    public void test() {
        int[][] grid = new int[][]{
                {0, 1, -1},
                {1, 0, -1},
                {1, 1, 1}};

        grid = new int[][]{
                {1, 1, -1},
                {1, -1, 1},
                {-1, 1, 1}};

        int cherryPickup = cherryPickup(grid);
        System.out.println(cherryPickup);

//        int cherryPickupDp = cherryPickupDp(grid);
//        System.out.println(cherryPickupDp);
    }

    /**
     * 改写的动态规划版本
     *
     * @param grid
     * @return: 通过dp 来完成稿缓存的作用
     */
    int cherryPickupDp(int[][] grid) {
        return 1;
    }


    /**
     * 假设有两个角色:
     * 一个角色从 [0][0] ~ [N-1][N-1]
     * 一个角色从 [N-1][N-1] ~ [0][0]
     * <p>
     * 然后求两个一起的总和
     *
     * @param grid
     * @return
     */
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        if (grid.length == 0 || grid[0][0] == -1 || grid[N - 1][N - 1] == -1) {
            return -1;
        }

        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0] == -1 ? 0 : grid[0][0];
        }

        int rst = process(grid, 0, 0, N - 1);
        return rst == -1 ? 0 : rst;
    }

    int process(int[][] grid, int fRow, int fCol, int sRow) {
        int N = grid.length;

        if (fRow == N - 1 && fCol == N - 1) {
            return 0;
        }

        // 计算当前sCol 的位置
        int sCol = N - 1 - sRow + N - 1 - fRow - fCol;

        int curVal = 0, fNum = 0, sNum = 0;
        if (fRow == sRow && fCol == sCol) {
            curVal = grid[fRow][fCol];
            fNum = grid[fRow][fCol];
            grid[fRow][fCol] = 0;
        } else {
            curVal = grid[fRow][fCol] + grid[sRow][sCol];
            fNum = grid[fRow][fCol];
            sNum = grid[sRow][sCol];
            grid[fRow][fCol] = 0;
            grid[sRow][sCol] = 0;
        }

        int maxVals = -1;
        // 下, 上
        if (fRow + 1 < N && sRow - 1 >= 0 && grid[fRow + 1][fCol] != -1 && grid[sRow - 1][sCol] != -1) {
            int p1 = process(grid, fRow + 1, fCol, sRow - 1);
            maxVals = Math.max(maxVals, p1);
        }

        // 下, 左
        if (fRow + 1 < N && sCol - 1 >= 0 && grid[fRow + 1][fCol] != -1 && grid[sRow][sCol - 1] != -1) {
            int p2 = process(grid, fRow + 1, fCol, sRow);
            maxVals = Math.max(maxVals, p2);
        }

        // 右, 上
        if (fCol + 1 < N && sRow - 1 >= 0 && grid[fRow][fCol + 1] != -1 && grid[sRow - 1][sCol] != -1) {
            int p3 = process(grid, fRow, fCol + 1, sRow - 1);
            maxVals = Math.max(maxVals, p3);
        }

        // 右, 左
        if (fCol + 1 < N && sCol - 1 >= 0 && grid[fRow][fCol + 1] != -1 && grid[sRow][sCol - 1] != -1) {
            int p4 = process(grid, fRow, fCol + 1, sRow);
            maxVals = Math.max(maxVals, p4);
        }

        grid[fRow][fCol] = fNum;
        grid[sRow][sCol] = sNum;
        return maxVals == -1 ? -1 : (maxVals + curVal);
    }
}
