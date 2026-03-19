class Solution {
    static int count = 0;

    public static void main(String[] args) {
        countSubsequences("abc");
        System.out.println(count);
    }

    private static void countSubsequences(String s) {
        checkSubsequences(s, "", 0);
    }
    
    private static void checkSubsequences(String s, String sub, int  idx){
        if(idx == s.length()){
            count++;
            return ;
        }

        checkSubsequences(s, sub + s.charAt(idx), idx + 1);

        checkSubsequences(s, sub, idx + 1);
    }
    
}