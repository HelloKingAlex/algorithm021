// LeetCode 200
class Solution {
    public int numIslands(char[][] grid) {
        // DFS 模板
        // visted.add(node)
        // for next in node.children
        //    next not in visted
        //      dfs(next)

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int islands = 0;
        for (int row = 0; row < nr; ++r) {
            for (int column = 0; column < nc; ++c) {
                if (grid[r][column] == '1') {
                    ++islands;
                    dfs(grid, r, column);
                }
            }
        }

        return islands;
    }
    void dfs(char[][] grid, int r, int column) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || column < 0 || r >= nr || column >= nc || grid[r][column] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, column);
        dfs(grid, r + 1, column);
        dfs(grid, r, column - 1);
        dfs(grid, r, column + 1);
    }
}