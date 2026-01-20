package alg;

import java.util.List;

public class Main {
    public static int[][] directions = new int[][]{
            {1, 0},
            {-1, 0},
            {0, -1},
            {0, 1},
    };
    static void main() {
        char[][] board = new char[][]{
                {'a','a','b','a','a','b'},
                {'a','a','b','b','b','a'},
                {'a','a','a','a','b','a'},
                {'b','a','b','b','a','b'},
                {'a','b','b','a','b','a'},
                {'b','a','b','b','a','b'},
        };
        exist(board, "bbbaabbbbbab");
    }

    public static boolean exist(char[][] board, String word){
        for(int y = 0; y < board.length; y++){
            boolean[][] visited = new boolean[board.length][board[0].length];
            for(int x = 0; x < board[y].length; x++){
                if(board[y][x] != word.charAt(0)) continue;
                visited[y][x] = true;
                if(backtrack(0, word, board, x, y, "", visited)) return true;
            }
        }
        return false;
    }

    public static boolean backtrack(int index, String word, char[][] board, int x, int y, String current, boolean[][] visited){
        if((current+board[y][x]).equals(word)){
            visited[y][x] = false;
            return true;
        }

        boolean found = false;
        for(int[] dir : directions){
            int xd = x + dir[0];
            int yd = y + dir[1];

            if(!isValidNextMove(xd, yd, word.charAt(index+1), board, visited) || !(index+1 < word.length())) continue;
            visited[yd][xd] = true;
            found |= backtrack(index + 1, word, board, xd, yd, current+ board[y][x], visited);
        }

        visited[y][x] = false;
        return found;
    }


    public static boolean isValidNextMove(int x, int y, char target, char[][] board, boolean[][] visited){
        if(!(0<= x && x < board[0].length && 0 <= y && y < board.length)) return false;
        if(visited[y][x]) return false;
        return board[y][x] == target;
    }
}
