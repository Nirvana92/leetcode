package leetcode.editor.cn;

//在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。 
//
// 「黑皇后」在棋盘上的位置分布用整数坐标数组 queens 表示，「白国王」的坐标用数组 king 表示。 
//
// 「黑皇后」的行棋规定是：横、直、斜都可以走，步数不受限制，但是，不能越子行棋。 
//
// 请你返回可以直接攻击到「白国王」的所有「黑皇后」的坐标（任意顺序）。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
//输出：[[0,1],[1,0],[3,3]]
//解释： 
//[0,1] 的皇后可以攻击到国王，因为他们在同一行上。 
//[1,0] 的皇后可以攻击到国王，因为他们在同一列上。 
//[3,3] 的皇后可以攻击到国王，因为他们在同一条对角线上。 
//[0,4] 的皇后无法攻击到国王，因为她被位于 [0,1] 的皇后挡住了。 
//[4,0] 的皇后无法攻击到国王，因为她被位于 [1,0] 的皇后挡住了。 
//[2,4] 的皇后无法攻击到国王，因为她和国王不在同一行/列/对角线上。
// 
//
// 示例 2： 
//
// 
//
// 输入：queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
//输出：[[2,2],[3,4],[4,4]]
// 
//
// 示例 3： 
//
// 
//
// 输入：queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3
//],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],
//[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
//输出：[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= queens.length <= 63 
// queens[0].length == 2 
// 0 <= queens[i][j] < 8 
// king.length == 2 
// 0 <= king[0], king[1] < 8 
// 一个棋盘格上最多只能放置一枚棋子。 
// 
// Related Topics 数组 
// 👍 23 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class No_1222 {
    public static void main(String[] args) {
        Solution solution = new No_1222().new Solution();
        int[][] queens = new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 4}, {3, 5}, {4, 4}, {4, 5}};
        int[] king = new int[]{3, 3};

        List<List<Integer>> lists = solution.queensAttacktheKing(queens, king);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    class Solution {
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            List<List<Integer>> queensCoordinates = new ArrayList<>();
            for (int index = 0; index < queens.length; index++) {
                int queenX = queens[index][0];
                int queenY = queens[index][1];

                // 在同一行或同一列或在斜线上, 即此时的queen可以杀死king
                if (queenX == king[0] || queenY == king[1] || (Math.abs(queenX - king[0]) == Math.abs(queenY - king[1]))) {
                    int queenCoordinate = findCoordinate(queenX, queenY, king);
                    List<List<Integer>> collect = queensCoordinates
                            .stream()
                            .filter(qc -> findCoordinate(qc.get(0), qc.get(1), king) == queenCoordinate).collect(Collectors.toList());

                    List<Integer> curQueen = new ArrayList<>();
                    if (collect.size() == 0) {
                        curQueen.add(queenX);
                        curQueen.add(queenY);
                        queensCoordinates.add(curQueen);
                    } else if (Math.abs(queenX - king[0]) < Math.abs(collect.get(0).get(0) - king[0]) ||
                            Math.abs(queenY - king[1]) < Math.abs(collect.get(0).get(1) - king[1])) {
                        queensCoordinates.remove(collect.get(0));
                        curQueen.add(queenX);
                        curQueen.add(queenY);
                        queensCoordinates.add(curQueen);
                    }
                }
            }

            return queensCoordinates;
        }

        /**
         * 根据皇后的x,y坐标找到相对与king 的坐标
         * 如:
         * (queueX, queueY) 在king 的正左边; 坐标为0
         * (queueX, queueY) 在king 的左上边; 坐标为1
         * (queueX, queueY) 在king 的正上边; 坐标为2
         * (queueX, queueY) 在king 的右上边; 坐标为3
         * (queueX, queueY) 在king 的正右边; 坐标为4
         * (queueX, queueY) 在king 的右下边; 坐标为5
         * (queueX, queueY) 在king 的正下边; 坐标为6
         * (queueX, queueY) 在king 的左下边; 坐标为7
         *
         * @param queenX: 皇后的x坐标
         * @param queenY: 皇后的y坐标
         * @param king
         * @return
         */
        public int findCoordinate(int queenX, int queenY, int[] king) {
            int disX = queenX - king[0];
            int disY = queenY - king[1];
            if (disX < 0 && disY == 0) {
                return 0;
            }

            if (disX < 0 && disY > 0) {
                return 1;
            }

            if (disX == 0 && disY > 0) {
                return 2;
            }

            if (disX > 0 && disY > 0) {
                return 3;
            }

            if (disX > 0 && disY == 0) {
                return 4;
            }

            if (disX > 0 && disY < 0) {
                return 5;
            }

            if (disX == 0 && disY < 0) {
                return 6;
            }

            if (disX < 0 && disY < 0) {
                return 7;
            }

            System.out.println("===== 走了默认的返回; 皇后的坐标和国王的坐标重合");
            return 0;
        }
    }

    @Test
    public void testList() {
        List<String> strs = new ArrayList<>();
        strs.add(null);
        strs.add(null);

        strs.add(5, "Hello");
        System.out.println(strs.get(0));
        System.out.println(strs.get(5));
    }
}