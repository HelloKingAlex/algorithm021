public class LeetCode0022 {
    List<String> output;
    public List<String> generateParenthesis(int n) {
        output = new ArrayList<>();
        recur(0, 0, n, "");
        return output;
    }
    public void recur(int left, int right, int n, String s) {
        if (left == n && right == n) {
            output.add(s);
            return;
        }
        if (left < n) {
            recur(left + 1, right, n, s + "(");
        }
        if (right < left) {
            recur(left, right + 1, n, s + ")");
        }
    }
}