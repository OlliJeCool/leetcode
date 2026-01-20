package alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static void main() {
        int[] nums = new int[]{1,2,2};
        subsetsWithDup(nums);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, results, new ArrayList<>());
        return  results;
    }

    public static void backtrack(int index, int[] nums, List<List<Integer>> results, List<Integer> current){
        //base case
        if(index == nums.length){
            results.add(new ArrayList<>(current));
            return;
        }
        //choices + constraints
        //backtrack
        current.addLast(nums[index]);
        backtrack(index+1, nums, results, current);
        current.removeLast();

        while(index+1 < nums.length && nums[index] == nums[index+1]) index++;
        backtrack(index+1, nums, results, current);
    }
}
