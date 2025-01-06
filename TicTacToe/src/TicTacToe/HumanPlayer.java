package TicTacToe;
import java.util.Scanner;

class HumanPlayer extends Player {
    public HumanPlayer() {
        super("human");
    }
    @Override
    public int[] getNextMove(Board board, String something, Mark mark) {
        return getHumanMove(board);
    }

    int[] getHumanMove(Board board) {
        // Query the user for a move using the console
        // Need to read two numbers from the console and check for validity
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter row of next move (1-%d): ", Board.SIZE);
        int row = scanner.nextInt() - 1;
        System.out.printf("\nEnter column of next move (1-%d): ", Board.SIZE);
        int col = scanner.nextInt() - 1;
        if (row < 0 || row >= Board.SIZE || col < 0 || col >= Board.SIZE || board.getMark(row, col) != Mark.EMPTY) {
            System.out.println("Invalid move, try again.");
            return getHumanMove(board);
        }
        return new int[]{row, col};    // For now, just return the top-left corner
    }
}
