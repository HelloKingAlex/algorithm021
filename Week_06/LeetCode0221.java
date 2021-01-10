public class LeetCode0221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        for (int i = 0; i< row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i][j])+1;
                    max = Math.max(max, dp[i+1][j+1]);
                }
            }
        }
        return max * max;
    }
}
