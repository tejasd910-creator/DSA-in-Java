class Solution {
    private int countStd(int[] arr, int pages){
        int std = 1, countPage = 0;
        
        for(int i : arr){
            if((countPage + i) <= pages)
                countPage += i;
            else{
                std ++;
                countPage = i;
            }
        }
        return std;
    }
    
    public int findPages(int[] arr, int k) {
        // code here
        int low = 0, high = 0;
        
        if(arr.length < k) return -1;
        
        for(int i : arr){
            low = Math.max(low,i);
            high += i;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            int student = countStd(arr, mid);
            if (student > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}