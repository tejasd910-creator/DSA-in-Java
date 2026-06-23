class Solution {
    public static int power(int a, int b){
        int power = 1;
        for(int i = 1; i <= b; i++){
            power *= a;
        }
        return power;
    }
    
    public int nthRoot(int n, int m) {
        // code here
        int low = 0, high = m;
        int ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(power(mid,n) == m){
                ans = mid;
                break;
            }else if(power(mid,n) < m)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return ans;
    }
}