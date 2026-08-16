import java.util.*;

class Solution {
    private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        
        // Check upper vertical column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        
        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
    }

    private static void solve(char[][] board, int row, List<List<String>> result) {
        int n = board.length;
        if (row == n) {
            List<String> sol = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sol.add(new String(board[i]));
            }
            result.add(sol);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        solve(board, 0, result);
        return result;
    }
}