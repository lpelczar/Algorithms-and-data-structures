import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Minesweeper {

    char[][] generateBoard() {
        int minBoardSize = 3;
        int maxBoardSize = 10;

        int randomBoardSize = ThreadLocalRandom.current().nextInt(minBoardSize, maxBoardSize + 1);

        List<Character> weightedFieldsList = new ArrayList<>();
        weightedFieldsList.addAll(Collections.nCopies(7, '.'));
        weightedFieldsList.addAll(Collections.nCopies(3, '*'));

        char[][] board = new char[randomBoardSize][randomBoardSize];

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = getRandomFieldFromList(weightedFieldsList);
            }
        }
        return board;
    }

    char[][] enumerateBoard(char[][] board) {

        char[][] extendedBoard = new char[board.length + 2][board[0].length + 2];

        // copy board in the center of extended board
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, extendedBoard[i + 1], 1, board[i].length);
        }

        char[][] result = new char[board.length][board[0].length];

        for(int i = 1; i < extendedBoard.length - 1; i++) {
            for(int k = 1; k < extendedBoard[i].length - 1; k++) {

                int counter = 0;
                for (int m = -1; m <= 1; m++) {
                    for (int n = -1; n <= 1; n++) {
                        if (m == 0 && n == 0) {
                            continue;
                        }
                        if (extendedBoard[i + m][k + n] == '*') {
                            counter++;
                        }
                    }
                }
                if (extendedBoard[i][k] == '*') {
                    result[i-1][k-1] = '*';
                } else {
                    result[i - 1][k - 1] = Character.forDigit(counter, 10);
                }
            }
        }
        return result;
    }

    void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    private char getRandomFieldFromList(List<Character> fields) {
        return fields.get(ThreadLocalRandom.current().nextInt(0, fields.size()));
    }
}
