package alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static void main() {
        restoreIpAddresses("101023");
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(0, new StringBuilder(), res, 0, s);
        return res;

    }

    public static void backtrack(int seg, StringBuilder cur, List<String> res, int index, String s){
        if(cur.length() == s.length()+3 && !(cur.charAt(cur.length()-1) == '.')){
                res.add(cur.toString());
            return;
        }

        if(seg >= 4) return;

        for(int i = 1; i <= 3; i++){
            if(index+i >= s.length()+1) break;
            String newSegment = s.substring(index, index+i);
            if(!isValidSegment(newSegment, s, index)) continue;
            int dotSpace = seg == 3 ? 0 : 1;

            cur.append(newSegment);
            cur.repeat(".", dotSpace);
            backtrack(seg+1, cur, res, index+i, s);
            cur.delete(cur.lastIndexOf(".")+1, cur.length());
        }
        if(!cur.isEmpty()) cur.deleteCharAt(cur.length()-1);
    }


    public static boolean isValidSegment(String segment, String s, int index){
        if(segment.length() > 1 && segment.charAt(0) == '0') return false;
        int segNumerical = Integer.parseInt(segment);
        if(segNumerical < 0 || segNumerical > 255) return false;
        return true;
    }
}
