class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        for(int i = 0; i < nums1.length; i++){
            boolean flag = false;
            int cur = nums1[i];
            for(int j = 0; j < nums2.length; j++){
                if(cur == nums2[j]) flag = true;

                if(cur < nums2[j] && flag){
                    nums1[i] = nums2[j];
                    break;
                }

                else nums1[i] = -1;
            }
        }

        return nums1;
    }
}