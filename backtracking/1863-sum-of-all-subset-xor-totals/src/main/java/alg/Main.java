package alg;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int sum = 0;
    static void main() {
        subsetXORSum(new int[]{1,3});
    }

    public static int subsetXORSum(int[] nums){
        sum = 0;
        backtrack(0, nums[0], nums);
        return sum;
    }

    public static void backtrack(int index, int temp, int[] nums){
        if(index == nums.length){
            sum += temp;
            return;
        }

        backtrack(index+1, temp ^ nums[index], nums);
        backtrack(index+1, temp, nums);
    }

}
