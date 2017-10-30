package ameedf.jb8223.lectures.arrays;

public class TicTacToe {
    private char[][] board;
    private char nextPlayer;

    public TicTacToe(char firstPlayer) {
        this.board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = ' ';
            }
        }
        this.nextPlayer = firstPlayer;
    }

    public boolean set(int row, int column) {
        if (this.board[row][column] != ' ') {
            return false;
        }
        this.board[row][column] = nextPlayer;
        if (nextPlayer == 'X') {
            nextPlayer = 'O';
        } else {
            nextPlayer = 'X';
        }
        return true;
    }

    @Override
    public String toString() {
        String boarder = "\n+---+---+---+";
        String lineFormat = "\n|-%C-|-%C-|-%C-|";
        String result = boarder;
        for (char[] row : board) {
            result += String.format(lineFormat, row[0], row[1], row[2]);
        }
        result += boarder;
        return result;
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe('X');
        ticTacToe.set(0, 0);
        System.out.println(ticTacToe);
        ticTacToe.set(0, 1);
        System.out.println(ticTacToe);
        ticTacToe.set(0, 2);
        System.out.println(ticTacToe);
        ticTacToe.set(1, 0);
        System.out.println(ticTacToe);
        ticTacToe.set(1, 1);
        System.out.println(ticTacToe);
        ticTacToe.set(1, 2);
        System.out.println(ticTacToe);
    }
}
