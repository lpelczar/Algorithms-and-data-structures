public class App {

    public static void main(String[] args) {

        Minesweeper minesweeper = new Minesweeper();
        char[][] board = minesweeper.generateBoard();
        minesweeper.printBoard(board);
    }
}
