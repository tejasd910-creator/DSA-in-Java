class Solution {
    public int hammingWeightI(int n) {
        int count = 0;
        while(n != 0){
            count += n & 1;
            n >>>= 1;
        }

        return count;
    }
    
    public int hammingWeightII(int n) {
        int count = 0;
        while(n != 0){
            n &= (n - 1);
            count++;
        }

        return count;
    }
}
