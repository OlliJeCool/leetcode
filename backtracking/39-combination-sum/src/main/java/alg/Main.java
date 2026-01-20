package alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static int targetNum = 0;
    public static int[] candidatesArr;
    public static List<List<Integer>> results = new ArrayList<>();
    static void main() {
        combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println("Done");
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        targetNum = target;
        candidatesArr = candidates;
        results.clear();
        Arrays.sort(candidatesArr);
        backtrack(0, new ArrayList<>(), 0);
        return results;
    };

    public static void backtrack(int index, List<Integer> current, int sum){
        if(sum == targetNum){
            results.add(new ArrayList<>(current));
            return;
        }

        if(sum > targetNum || index >= candidatesArr.length) return;

        current.addLast(candidatesArr[index]);
        backtrack(index, current, sum+candidatesArr[index]);
        current.removeLast();
        backtrack(index+1, current, sum);
    }
}
