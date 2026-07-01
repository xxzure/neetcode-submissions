class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            int[] count1 = new int[10];
            int[] count2 = new int[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (count1[board[i][j] - '0'] >= 1) {
                        return false;
                    }
                    count1[board[i][j] - '0']++;
                }
                if (board[j][i] != '.') {
                    if (count2[board[j][i] - '0'] >= 1) {
                        return false;
                    }
                    count2[board[j][i] - '0']++;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (isValid(board, i, j, i + 2, j + 2) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int x1, int y1, int x2, int y2) {
        int[] count = new int[10];
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (board[i][j] == '.') continue;
                if (count[board[i][j] - '0'] >= 1) {
                    return false;
                }
                count[board[i][j] - '0']++;
            }
        }
        return true;
    }
}
