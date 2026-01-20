package alg;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static  int N = 0;
    public static List<String> results = new ArrayList<>();

    static void main() {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n){
        N = n;
        results.clear();
        backtrack(0, new StringBuilder(), n, n);
        return results;
    }

    public static void backtrack(int index, StringBuilder current, int leftCount, int rightCount){
        if(index == N*2){
            results.add(current.toString());
            return;
        }

        if(leftCount > rightCount) return;

        StringBuilder clone = new StringBuilder(current.toString());
        if(leftCount > 0) backtrack(index+1, clone.append("("), leftCount-1, rightCount);
        clone = new StringBuilder(current.toString());
        if(rightCount > 0) backtrack(index+1, clone.append(")"), leftCount, rightCount-1);
    }
}
