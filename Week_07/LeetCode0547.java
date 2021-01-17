public class LeetCode0547 {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int ret = 0;
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                ret++;
            }
        }
        return ret;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int level) {
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[level][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(isConnected, visited, i);
            }
        }
    }
}