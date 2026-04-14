class Solution {
    public static ArrayList<Integer> primeFac(int n) {
        // code here
        ArrayList<Integer> prime = new ArrayList<>();
        
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0) prime.add(i);
            
            while(n % i == 0) n /= i; 
        }
        
        if(n != 1) prime.add(n);
        
        return prime;
    }
}