import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main{
    public static List<String> results = new ArrayList();
    public static String input;
    public static final String[][] nums = new String[][] {
            {}, {},
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"},
    };

    public static List<String> letterCombinations(String digits) {
        input = digits;
        backtrack(0, new StringBuilder());
        return results;
    }



    static void main(String[] args){
        input = "2";
        //Choices to pick from each step
        //Constraints - something we have to /cannot do
        //Base case - returns
        //backtrack

        List<String> output = letterCombinations(input);
        System.out.println(output);
    }

    public static void backtrack(int index, StringBuilder current) {
        if (index == input.length()) {
            results.add(current.toString());
            return;
        }
        int digit = Integer.parseInt(String.valueOf((input.charAt(index))));
        for (String choice : nums[digit]) {
            StringBuilder child = new StringBuilder(current.toString()).append(choice);
            backtrack(index + 1, child);
        }
    }
}