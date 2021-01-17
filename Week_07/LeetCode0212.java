public class LeetCode0212 {
    int[] dx = new int[]{1, 0, 0, -1};
    int[] dy = new int[]{0, 1, -1, 0};
    public List<String> findWords(char[][] board, String[] words) {
        WordTrie trie = new WordTrie();
        TrieNode root = trie.root;
        for (String s : words) {
            trie.insert(s);
        }

        Set<String> wordSet = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, i, j, m, n, wordSet, root);
            }
        }
        return new LinkedList<String>(wordSet);
    }
    private void dfs(char[][] board, boolean[][] visited, 
        int i, int j, int m, int n, 
        Set<String> wordSet, TrieNode root) {
        if (i<0 || m<= i || j<0 || n<=j || visited[i][j]) {
            return;
        }

        int index = board[i][j] - 'a';
        visited[i][j] = true;
        root = root.children[index];
        if (root == null) {
            visited[i][j] = false;
            return;
        }

        if (root.isEnd) {
            wordSet.add(root.word);
        }

        for (int dpx = 0; dpx < 4; dpx++) {
            dfs(board, visited, i+dx[dpx], j+dy[dpx], m, n, wordSet, root);
        }
        visited[i][j] = false;

    }
}
class TrieNode {
    String word = null;
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}
class WordTrie {
    public TrieNode root = new TrieNode();
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int index = c-'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
                cur = cur.children[index];
            } else {
                cur = cur.children[index];
            }
        }
        cur.isEnd = true;
        cur.word = word;
    }
}