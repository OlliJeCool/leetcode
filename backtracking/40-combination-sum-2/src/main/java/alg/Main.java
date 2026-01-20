package alg;

import java.util.*;

public class Main {
    public static int[] can;
    public static HashSet<List<Integer>> res = new LinkedHashSet<>();
    static void main() {
        List<List<Integer>> finalarr = combinationSum2(new int[] {10,1,2,7,6,1,5}, 8);
        System.out.println("Done");
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target){
        can = candidates;
        Arrays.sort(candidates);
        backtrack(0, new ArrayList<>(), target);
        return res.stream().toList();
    }

    public static void backtrack(int index, List<Integer> cur, int target){
        if(target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = index; i < can.length; i++){
            if(i > index && can[i] == can[i-1]) continue;
            if(can[i] > target) break;

            cur.addLast(can[i]);
            backtrack(i+1, cur, target - can[i]);
            cur.removeLast();
        }
    }
}
