// 最小路径和
class LeetCode0064 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int[row][col];

        for (int i = row - 1; i>=0; i--) {
            for (int j = col - 1; j>=0; j--) {
                if (i == row -1 && j != col - 1) { 
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                } else if (j == col - 1 && i != row - 1) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                } else if (i != row - 1 && j != col - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
}