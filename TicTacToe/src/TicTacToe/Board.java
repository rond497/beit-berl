package TicTacToe;

public class Board {

    public static final int SIZE = 3 ;
    public static final int WIN_STREAK = 3 ;
    private Mark[][] board;
    private int pieces;

    public Board () {
        pieces = 0;
        board = new Mark[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Mark.EMPTY;
            }
        }
    }

    // Clear the board
    public void clear() {
        pieces = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Mark.EMPTY;
            }
        }
    }
    // Clear a specific cell
    public void clearCell(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return;
        }
        if (board[row][col] != Mark.EMPTY) {
            board[row][col] = Mark.EMPTY;
            pieces--;
        }
    }

    public Mark getMark(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return Mark.EMPTY;
        }
        return board[row][col];
    }
    public boolean putMark(Mark mark, int row, int col) {
        //System.out.println("Player try: " + mark + " at " + row + "," + col);

        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return false;
        }
        if (getMark(row, col) == Mark.EMPTY) {
            board[row][col] = mark;
            pieces++;
            //print the added place
            //System.out.println("Move OK: " + mark + " at " + row + "," + col);
            return true;
        }
        return false;
    }

    public Result checkResult() {
        // Check horizontal and vertical streaks
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != Mark.EMPTY) {
                    // Check horizontal streak
                    if (j <= SIZE - WIN_STREAK) {
                        boolean win = true;
                        for (int k = 1; k < WIN_STREAK; k++) {
                            if (board[i][j] != board[i][j + k]) {
                                win = false;
                                break;
                            }
                        }
                        if (win) {
                            return board[i][j] == Mark.X ? Result.X_WINS : Result.O_WINS;
                        }
                    }

                    // Check vertical streak
                    if (i <= SIZE - WIN_STREAK) {
                        boolean win = true;
                        for (int k = 1; k < WIN_STREAK; k++) {
                            if (board[i][j] != board[i + k][j]) {
                                win = false;
                                break;
                            }
                        }
                        if (win) {
                            return board[i][j] == Mark.X ? Result.X_WINS : Result.O_WINS;
                        }
                    }

                    // Check main diagonal streak
                    if (i <= SIZE - WIN_STREAK && j <= SIZE - WIN_STREAK) {
                        boolean win = true;
                        for (int k = 1; k < WIN_STREAK; k++) {
                            if (board[i][j] != board[i + k][j + k]) {
                                win = false;
                                break;
                            }
                        }
                        if (win) {
                            return board[i][j] == Mark.X ? Result.X_WINS : Result.O_WINS;
                        }
                    }

                    // Check anti-diagonal streak
                    if (i <= SIZE - WIN_STREAK && j >= WIN_STREAK - 1) {
                        boolean win = true;
                        for (int k = 1; k < WIN_STREAK; k++) {
                            if (board[i][j] != board[i + k][j - k]) {
                                win = false;
                                break;
                            }
                        }
                        if (win) {
                            return board[i][j] == Mark.X ? Result.X_WINS : Result.O_WINS;
                        }
                    }
                }
            }
        }

        if (pieces == SIZE * SIZE) {
            return Result.DRAW;
        }
        return Result.IN_PROGRESS;
    }
}
