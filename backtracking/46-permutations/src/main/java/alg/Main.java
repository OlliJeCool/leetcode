package alg;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, res);
        return res;
    }

    public static void backtrack(int index, List<Integer> curr, int[] arr, List<List<Integer>> res) {
        if (index == arr.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (curr.contains(arr[i]))
                continue;
            curr.addLast(arr[i]);
            backtrack(index + 1, curr, arr, res);
            curr.removeLast();
        }
    }
}
