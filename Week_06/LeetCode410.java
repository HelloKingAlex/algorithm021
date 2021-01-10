public class LeetCode410 {
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        int[][] dp = new int[len + 1][m + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int[] sub = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        dp[0][0] = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return dp[len][m];
    }
}
