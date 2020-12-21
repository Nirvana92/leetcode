package leetcode.editor.cn;

/**
 * 79. 单词搜索
 */
public class No_79 {
    public static void main(String[] args) {
        No_79 no_79 = new No_79();
        char[][] board = new char[][]{
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        String word = "AAB";
        boolean exist = no_79.exist(board, word);
        System.out.println(exist);
    }

    public boolean exist(char[][] board, String word) {
        int rowLen = board.length;
        int colLen = board[0].length;

        char[] words = word.toCharArray();

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (process(board, words, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 从 startRow, startCol 开始匹配 words[wordIndex ....] 往后是否能匹配
     * used[row][col] 是否已经使用过. 走过的位置设置为0, 然后恢复现场
     *
     * @param board
     * @param words
     * @param startRow
     * @param startCol
     * @param wordIndex
     * @return
     */
    public boolean process(char[][] board, char[] words, int startRow, int startCol, int wordIndex) {
        if (wordIndex == words.length) {
            return true;
        }

        int rowLen = board.length;
        int colLen = board[0].length;
        if (startRow == rowLen || startRow < 0 || startCol == colLen || startCol < 0) {
            return false;
        }

        boolean result = false;
        char tmp = board[startRow][startCol];
        board[startRow][startCol] = 0;
        if (tmp == words[wordIndex]) {
            // 上下左右方向尝试, 只要有一个尝试成功, 返回true
            result = process(board, words, startRow + 1, startCol, wordIndex + 1)
                    || process(board, words, startRow - 1, startCol, wordIndex + 1)
                    || process(board, words, startRow, startCol + 1, wordIndex + 1)
                    || process(board, words, startRow, startCol - 1, wordIndex + 1);
        }
        board[startRow][startCol] = tmp;

        return result;
    }
}
