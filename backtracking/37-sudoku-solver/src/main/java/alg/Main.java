package alg;

public class Main {
    private static char[][] result;
    private static final int BOARD_SIDE = 9;

    private static final char[][] board = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
    };

    static void main() {
        solveSudoku(board.clone());
    }

    public static void solveSudoku(char[][] board){
        if(backtrack(board)){
            printBoard(board);
        } else System.out.println("No solution found!");
    }

    public static boolean backtrack(char[][] current){
        for(int y = 0; y < BOARD_SIDE; y++){
            for(int x = 0; x < BOARD_SIDE; x++){
                if(board[y][x] != '.') continue;
                for(int i = 1; i <= 9; i++){
                    char charVal = (char)(i+'0');
                    if(!isValidMove(current, x, y, charVal)) continue;

                    board[y][x] = charVal;

                    if(backtrack(board)){
                        return true;
                    }

                    board[y][x] = '.';
                }
                return false;
            }
        }
        return true;
    }

    public static boolean isValidMove(char[][] board, int x, int y, char value){
        for(int i = 0; i < BOARD_SIDE; i++){
            if(i != x && board[y][i] == value) return false;
            if(i != y && board[i][x] == value) return false;
        }
        return !isInSquare(board, x, y, value);
    }

    public static boolean isInSquare(char[][] board, int x, int y, char value){
        int horizontal = (x / 3) * 3;
        int vertical = (y / 3) * 3;

        for(int i = horizontal; i <= horizontal+2; i++){
            for(int j = vertical; j <= vertical+2; j++){
                if(board[j][i] == value) return true;
            }
        }
        return false;
    }


    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
