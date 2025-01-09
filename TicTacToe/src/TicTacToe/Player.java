package TicTacToe;

class Player {

    String strategy;
    public Player(String strategy) {
        this.strategy = strategy;
    }
    // Set the strategy of the player
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
    // Get the strategy of the player
    public String getStrategy() {
        return strategy;
    }

    // Get the Board and the Mark of the current player, calculate a move,
    // and plays the move on the board.
    // We should not expect the player to play a move that is not valid.
    public void playTurn(Board board, Mark mark) {
        int[] move;
        boolean validMove = false;
        move = getNextMove(board, strategy, mark);
        validMove = board.putMark(mark, move[0], move[1]);
        if (!validMove) {
            throw new IllegalArgumentException("No valid move found or invalid move: " + move[0] + ", " + move[1]);
        }
    }
    // Calculate the next move for the player
    public int[] getNextMove(Board board, String strategy, Mark mark) {

        switch (strategy) { // two strategies: random and human, are implemented as Subclasses
            /*case "random":
                return getRandomMove(board);
            /*case "human":
                return getHumanMove(board);*/
            case "smart":
                return getSmartMove(board, mark);
            case "smart1":
                return getSmart1Move(board, mark);
            default:
                throw new IllegalArgumentException("Unknown strategy type: " + strategy);
        }
    }

    private int[] getRandomMove(Board board) {
        // Query the user for a move; for now, just use random numbers
        // Player draws a random number between 0 and 4 for the row and column, then checks if the cell is empty.
        // If the cell is not empty, we look for the next empty cell, along the rows and columns.
        int row = (int) (Math.random() * Board.SIZE);
        int col = (int) (Math.random() * Board.SIZE);
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                if (board.getMark((row + i) % Board.SIZE, (col + j) % Board.SIZE) == Mark.EMPTY) {
                    return new int[] { (row + i) % Board.SIZE, (col + j) % Board.SIZE };
                }
            }
        }
        throw new IllegalArgumentException("No move found in Random: " + row + col);
    }

    private int[] getSmartMove(Board board, Mark mark) {
        // Simplest strategy: win/block if possible (no preference), random otherwise
        // Check Win or Block are possible:
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                if (board.getMark(i, j) == Mark.EMPTY) {
                    board.putMark(Mark.X, i, j);
                    boolean winX = board.checkResult() == Result.X_WINS;
                    board.clearCell(i, j);
                    board.putMark(Mark.O, i, j);
                    boolean winO = board.checkResult() == Result.O_WINS;
                    board.clearCell(i, j);
                    if (winX || winO)
                        return new int[] { i, j };
                }
            }
        }
        return getRandomMove(board); // No winning move found; return a random move
    }

    private int[] getSmart1Move(Board board, Mark mark) {
        // Simple strategy: win if possible, then block if necessary, random otherwise
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                if (board.getMark(i, j) == Mark.EMPTY) {
                    board.putMark(Mark.X, i, j);
                    boolean winX = (board.checkResult() == Result.X_WINS);
                    board.clearCell(i, j);
                    board.putMark(Mark.O, i, j);
                    boolean winO = (board.checkResult() == Result.O_WINS);
                    board.clearCell(i, j);
                    if ((mark == Mark.X) && winX)
                        return new int[] { i, j };
                    else if ((mark == Mark.O) && winO)
                        return new int[] { i, j };
                    else if (winX || winO)
                        return new int[] { i, j };
                }
            }
        }
        return getRandomMove(board); // No winning move found; return a random move
    }

}
