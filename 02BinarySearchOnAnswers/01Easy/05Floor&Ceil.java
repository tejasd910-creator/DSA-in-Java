class Solution {
    public int findFloor(int[] arr, int x) {
        // code here
        
        int low = 0, high = arr.length - 1;
        int floor = -1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(arr[mid] <= x){
                floor = mid;
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        
        return floor;
    }

    public int findCeil(int[] arr, int x) {
        // code here
        
        int low = 0, high = arr.length - 1;
        int ceil = -1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(arr[mid] >= x){
                ceil = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return ceil;
    }
}