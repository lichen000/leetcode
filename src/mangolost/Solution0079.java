package mangolost;

//Given a 2D board and a word, find if the word exists in the grid.
//
//        The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//        Example:
//
//        board =
//        [
//        ['A','B','C','E'],
//        ['S','F','C','S'],
//        ['A','D','E','E']
//        ]
//
//        Given word = "ABCCED", return true.
//        Given word = "SEE", return true.
//        Given word = "ABCB", return false.

/**
 *
 */
public class Solution0079 {

    /**
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int rowSize = board.length;
        int colSize = board[0].length;
        boolean[][] visits = new boolean[rowSize][colSize];
        int cur = 0;
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                if (exist_iter(board, i, j, cur, word, visits)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board
     * @param row
     * @param col
     * @param cur
     * @param word
     * @param visits
     * @return
     */
    private boolean exist_iter(char[][] board, int row, int col, int cur, String word, boolean[][] visits) {
        if (cur == word.length()) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && col >= 0 && row < board.length && col < board[0].length && word.charAt(cur) == board[row][col] && !visits[row][col]) {
            visits[row][col] = true;
            hasPath = (exist_iter(board, row + 1, col, cur + 1, word, visits)
                    || exist_iter(board, row, col + 1, cur + 1, word, visits)
                    || exist_iter(board, row - 1, col, cur + 1, word, visits)
                    || exist_iter(board, row, col - 1, cur + 1, word, visits));
            visits[row][col] = hasPath;
        }
        return hasPath;
    }

    public static void main(String[] args) {
        Solution0079 solution = new Solution0079();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(solution.exist(board, "ABCCED"));
        System.out.println(solution.exist(board, "SEE"));
        System.out.println(solution.exist(board, "ABCB"));
    }
}
