class StreakChecker {

    public static boolean hasStreak(int[][] board, int k) {
        int n = board.length;

        // Check for horizontal and vertical streaks
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int current = board[i][j];

                if (current != 0) { // Assume 0 is not a valid streak value
                    // Check horizontal streak
                    if (j + k <= n && isStreak(board, current, i, j, 0, 1, k)) {
                        return true;
                    }
                    // Check vertical streak
                    if (i + k <= n && isStreak(board, current, i, j, 1, 0, k)) {
                        return true;
                    }
                    // Check diagonal down-right streak
                    if (i + k <= n && j + k <= n && isStreak(board, current, i, j, 1, 1, k)) {
                        return true;
                    }
                    // Check diagonal up-right streak
                    if (i - k + 1 >= 0 && j + k <= n && isStreak(board, current, i, j, -1, 1, k)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean isStreak(int[][] board, int value, int row, int col, int dRow, int dCol, int k) {
        for (int i = 0; i < k; i++) {
            if (board[row + i * dRow][col + i * dCol] != value) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = {
                {1, 1, 0, 2},
                {0, 1, 2, 0},
                {2, 1, 1, 1},
                {2, 2, 0, 1}
        };

        int k = 3;
        if (hasStreak(board, k)) {
            System.out.println("There is a streak of at least " + k + " cells with the same value.");
        } else {
            System.out.println("No streak of " + k + " found.");
        }
    }
}

