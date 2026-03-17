// User function Template for Java
import java.util.*;

class Solution {
    public List<String> AllPossibleStrings(String s) {
        // Code here
        List<String> result = new ArrayList<>();
        subSequence(result, s, "", 0);
        Collections.sort(result);
        return result;
    }
    
    private void subSequence(List<String> result, String s, String current, int idx){
        if(idx == s.length()){
            result.add(current);
            return;
        }
        char curChar = s.charAt(idx);
        
        subSequence(result, s, current + curChar, idx + 1);
        
        subSequence(result, s, current, idx + 1);
    }
}