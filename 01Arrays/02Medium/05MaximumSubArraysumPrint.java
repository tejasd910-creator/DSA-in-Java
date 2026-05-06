import java.util.*;

class Solution {
    public ArrayList<Integer> findSubarray(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();

        int maxSum = -1;
        int maxStart = -1;
        int maxLen = 0;

        int currSum = 0;
        int currStart = 0;
        int currLen = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                currSum += arr[i];
                currLen++;

                // Check if this subarray is better
                if (currSum > maxSum || (currSum == maxSum && currLen > maxLen)) {
                    maxSum = currSum;
                    maxStart = currStart;
                    maxLen = currLen;
                }
            } else {
                // Reset on negative number
                currSum = 0;
                currLen = 0;
                currStart = i + 1;
            }
        }

        if (maxStart == -1) {
            result.add(-1);
        } else {
            for (int i = maxStart; i < maxStart + maxLen; i++) {
                result.add(arr[i]);
            }
        }

        return result;
    }
}