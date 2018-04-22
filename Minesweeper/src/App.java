public class App {

    public static void main(String[] args) {

        Minesweeper minesweeper = new Minesweeper();
        char[][] board = minesweeper.generateBoard();
        minesweeper.printBoard(board);
        char[][] enumeratedBoard = minesweeper.enumerateBoard(board);
        System.out.println();
        minesweeper.printBoard(enumeratedBoard);
    }
}
