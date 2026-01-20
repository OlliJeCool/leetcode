package alg;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int N = 0;
    public static int cnt = 0;
    static void main() {
        solveNQueens(1);
    }

    public static int solveNQueens(int n){
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        N = n;
        cnt = 0;
        sb.repeat(".", n);
        for(int i = 0; i < n; i++){
            board.add(sb.toString());
        }
        backtrack(0, board);
        return cnt;
    }

    public static void backtrack(int index, List<String> board){
        if(index == N){
            cnt += 1;
            return;
        }

        for(int i = 0; i < N; i++){
            if(!isValidPlay(board, i, index)) continue;
            StringBuilder sb = new StringBuilder(board.get(index));
            sb.setCharAt(i, 'Q');
            board.set(index, sb.toString());
            backtrack(index+1, board);
            sb = new StringBuilder(board.get(index));
            sb.setCharAt(i, '.');
            board.set(index, sb.toString());
        }
    }


    public static boolean isValidPlay(List<String> board, int x, int y){
        if(board.get(y).contains("Q")) return false;
        for(int i = 0; i < N; i++){
            if(board.get(i).charAt(x) == 'Q') return false;
        }

        for(int i = 1; i < N; i++){
            int xdp = x+i, xdn = x-i, ydp = y+i, ydn = y-i;
            if(xdp < N && ydp < N && board.get(ydp).charAt(xdp) == 'Q') return false;
            if(xdp < N && 0 <= ydn && board.get(ydn).charAt(xdp) == 'Q') return false;
            if(0 <= xdn && ydp < N && board.get(ydp).charAt(xdn) == 'Q') return false;
            if(0 <= xdn && 0 <= ydn && board.get(ydn).charAt(xdn) == 'Q') return false;
        }

        return true;
    }
}
