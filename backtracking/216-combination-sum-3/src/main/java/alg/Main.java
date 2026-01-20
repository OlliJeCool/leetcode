package alg;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        combinationSum3(4, 1);
    }

    public static List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> res = new ArrayList<>();
        backtrack(k, n, res, new ArrayList<>(), 0, 1);
        return res;
    }

    public static void backtrack(int k, int n, List<List<Integer>> res, List<Integer> current, int sum, int index){
        if(sum == n && current.size() == k){
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i <= 9; i++){
            if(sum + i > n) break;
            current.add(i);
            backtrack(k, n, res, current, sum+i, i+1);
            current.removeLast();
        }
    }
}
