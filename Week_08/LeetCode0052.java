public class LeetCode0052 {
    private int size;
    private int count;
    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }

    private void solve(int row, int pie, int na) {
        if (row == size) {
            count++;
            return;
        }
        int pos = size & (~(row | pie | na));
        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p;
            solve(row | p, (pie | p) << 1, (na | p) >> 1);
        }
    }
}
