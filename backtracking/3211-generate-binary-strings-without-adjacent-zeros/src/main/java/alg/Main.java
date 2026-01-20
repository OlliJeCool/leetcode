package alg;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        validStrings(1);
    }


    public static List<String> validStrings(int n){
        List<String> res = new ArrayList<>();
        backtrack(1, n, res, new StringBuilder("1"));
        backtrack(1, n, res, new StringBuilder("0"));
        return res;
    }

    public static void backtrack(int index, int n, List<String> res, StringBuilder current){
        if(index == n){
            res.add(current.toString());
            return;
        }

        char last = current.charAt(index-1);
        if(last == '0'){
            current.append("1");
            backtrack(index+1, n, res, current);
            current.deleteCharAt(index);
        } else{
        for(int i = 0; i <= 1; i++){
            current.append((char)(i+'0'));
            backtrack(index+1, n, res, current);
            current.deleteCharAt(index);
            }
        }
    }
}
