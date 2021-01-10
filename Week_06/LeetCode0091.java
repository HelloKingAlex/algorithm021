public class LeetCode0091 {
    public int numDecodings(String s) {
        if ( s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];

        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }

        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (chars[i] != '0') {
                dp[i] = dp[i-1];
            }

            int num = (chars[i-1]-'0') * 10 + (chars[i] - '0');
            if ( 10 <= num && num <= 26) {
                if (i==1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[len-1];
    }
}
