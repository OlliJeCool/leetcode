package alg;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        combine(4,2);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }


    public static void backtrack(int index, int n, int k, List<Integer> current, List<List<Integer>> results){
        if(current.size() == k){
            results.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i <= n; i++){
            current.addLast(i);
            backtrack(i+1, n, k, current, results);
            current.removeLast();
        }

    }

}
