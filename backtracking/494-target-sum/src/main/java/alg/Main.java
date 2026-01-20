package alg;

public class Main {
    public static int res = 0;
    static void main() {
        int[] nums = new int[]{1,1,1,1,1};
        findTargetSumWays(nums, 3);
    }

    public static int findTargetSumWays(int[] nums, int target){
        res = 0;
        backtrack(0, 0, nums, target);
        return res;
    }

    public static void backtrack(int index, int sum, int[] nums, int target){
        if(sum == target && index == nums.length){
            res += 1;
            return;
        }

        if(index+1 > nums.length) return;
        sum += nums[index];
        backtrack(index+1, sum, nums, target);
        sum -= 2*nums[index];
        backtrack(index+1, sum, nums, target);
    }
}
