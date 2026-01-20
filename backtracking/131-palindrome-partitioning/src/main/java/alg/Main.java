package alg;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        partition("abbab");
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, new ArrayList<>(), res);
        return res;
    }

    public static void backtrack(String remainder, List<String> current, List<List<String>> res){
        if(remainder.isEmpty()){
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i = 1; i < remainder.length()+1; i++){
            String cut = remainder.substring(0, i);
            if(!isPalindrome(cut)) continue;
            current.add(cut);
            backtrack(remainder.substring(i), current, res);
            current.removeLast();
        }
    }


    public static boolean isPalindrome(String s){
        if(s.length() == 1) return true;
        s = s.replace(" ", "");
        int half = s.length()/2;
        boolean isOdd = s.length() % 2 == 0;
        String left = s.substring(0, half);
        String right = s.substring(isOdd ? half : half+1);
        StringBuilder sb = new StringBuilder(right);
        sb.reverse();
        right = sb.toString();

        return left.equals(right);
    }
}
