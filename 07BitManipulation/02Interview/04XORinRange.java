
class Solution {
    public static int findXOR(int l, int r) {
        int xor = 0;
        while(l <= r){
            xor ^= l;
            l++;
        }
        
        return xor;
    }
}