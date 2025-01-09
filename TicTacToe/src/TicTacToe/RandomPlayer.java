package TicTacToe;

//import java.util.Random;

class RandomPlayer extends Player {
//    private Random random;

    public RandomPlayer() {
        super("random");
    }


    @Override
    public int[] getNextMove(Board board, String somethingElse, Mark mark) {
        int row = (int) (Math.random() * Board.SIZE);
        int col = (int) (Math.random() * Board.SIZE);
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                if (board.getMark((row + i) % Board.SIZE, (col + j) % Board.SIZE) == Mark.EMPTY) {
                    return new int[]{(row + i) % Board.SIZE, (col + j) % Board.SIZE};
                }
            }
        }
        return new int[]{-1, -1};    // Apparently the board is full
    }
}
