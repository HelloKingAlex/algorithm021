public class LeetCode0036 {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Boolean>[] rows = new HashMap[9];
        HashMap<Character, Boolean>[] cols = new HashMap[9];
        HashMap<Character, Boolean>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Character, Boolean>();
            cols[i] = new HashMap<Character, Boolean>();
            boxes[i] = new HashMap<Character, Boolean>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                int boxIndex = (i/3)*3+j/3;
                if (num == '.') {
                    continue;
                }
                if (rows[i].containsKey(num)) {
                    return false;
                }
                rows[i].put(num, true);
                if (cols[j].containsKey(num)) {
                    return false;
                }
                cols[j].put(num, true);
                if (boxes[boxIndex].containsKey(num)) {
                    return false;
                }
                boxes[boxIndex].put(num, true);

            }
        } 
        return true;
    }
}