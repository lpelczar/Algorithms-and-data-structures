import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Minesweeper {

    private char[][] board;

    void generateBoard() {
        int minBoardSize = 3;
        int maxBoardSize = 10;

        int randomBoardSize = ThreadLocalRandom.current().nextInt(minBoardSize, maxBoardSize + 1);

        List<Character> fields = new ArrayList<>();
        fields.addAll(Collections.nCopies(7, '.'));
        fields.addAll(Collections.nCopies(3, '*'));

        this.board = new char[randomBoardSize][randomBoardSize];

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = getRandomField(fields);
            }
        }
    }

    private char getRandomField(List<Character> fields) {
        return fields.get(ThreadLocalRandom.current().nextInt(0, fields.size()));
    }

    void printBoard() {
        for (char[] row : board) {
            for (char column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }
}
