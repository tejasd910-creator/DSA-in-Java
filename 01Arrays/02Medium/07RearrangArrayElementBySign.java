class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int i = 0 , j = 1;

        for(int e : nums){
            if(e>0){
                result[i] = e;
                i += 2;
            }else{
                result[j] = e;
                j += 2;
            }
        }

        return result;
    }
}