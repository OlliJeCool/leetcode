package alg;

import java.util.*;

public class Main {
    static void main(){
        HashSet<List<Integer>> res = new LinkedHashSet<>();
        backtrack(0, new ArrayList<>(), new int[] {1,1,2} , res, new ArrayList<>());
        System.out.println("Done");
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> res = new LinkedHashSet<>();
        backtrack(0, new ArrayList<>(), nums, res, new ArrayList<>());
        return res.stream().toList();
    }


    public static void backtrack(int index, List<Integer> curr, int[] arr, HashSet<List<Integer>> res, List<Integer> skip){
        if(index == arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(skip.contains(i)) continue;
            curr.addLast(arr[i]);
            skip.add(i);
            backtrack(index+1, curr, arr, res, skip);
            curr.removeLast();
            skip.removeLast();
        }
    }
}
