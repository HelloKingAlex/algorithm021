public class LeetCode0647 {
    public int countSubstrings(String s) {
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < 2 * len - 1; ++i) {
            int l = i / 2;
            int r = i / 2 + i % 2;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }
}
