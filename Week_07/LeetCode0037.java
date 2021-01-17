public class LeetCode0037 {
    public void solveSudoku(char[][] board) {
        if (board == null || board[0].length == 0) {
            return;
        }
        solve(board);
    }
    public boolean solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            int boxRow = (row/3)*3 + i/3;
            int boxCol = (col/3)*3 + i%3;
            if (board[boxRow][boxCol] != '.' && board[boxRow][boxCol] == c) {
                return false;
            }
        }
        return true;
    }
}