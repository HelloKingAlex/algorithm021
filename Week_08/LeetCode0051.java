public class LeetCode0051 {
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        dfs(board, 0, 0, 0, 0, res);
        return res;
    }

    private void dfs(char[][] board, int row, int col, int pie, int na, List<List<String>> res) {
        if (row == board.length) {
            res.add(paint(board));
            return;
        }
        int pos = ((1 << board.length) - 1) & (~(col | pie | na));
        while (pos != 0) {
            int p = pos & -pos;
            pos &= pos - 1;
            int idx = (int) (Math.log(p) / Math.log(2));
            board[row][idx] = 'Q';
            dfs(board, row + 1, col | p, (pie | p) << 1, (na | p) >> 1, res);
            board[row][idx] = '.';
        }
    }

    private List<String> paint(char[][] board) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            ret.add(new String(board[i]));
        }
        return ret;
    }
}
