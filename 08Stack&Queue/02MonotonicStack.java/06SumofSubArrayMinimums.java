import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<int[]> stack = new Stack<>();

        // Previous Less Element
        for (int i = 0; i < n; i++) {
            int count = 1;

            while (!stack.isEmpty() && stack.peek()[0] > arr[i]) {
                count += stack.pop()[1];
            }

            stack.push(new int[]{arr[i], count});
            left[i] = count;
        }

        stack.clear();

        // Next Less or Equal Element
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;

            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                count += stack.pop()[1];
            }

            stack.push(new int[]{arr[i], count});
            right[i] = count;
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * left[i] * right[i]) % MOD;
        }

        return (int) result;
    }

    //*******************BRUTE FORCE APPROACH***************** */

    // Function to find the sum of the minimum value in each subarray
    public int sumSubarrayMinsII(int[] arr) {
        // Size of the array
        int n = arr.length;

        // Modulo value to prevent integer overflow
        int mod = (int)1e9 + 7;

        // Variable to store the total sum
        int sum = 0;

        // Traverse each starting index of subarrays
        for (int i = 0; i < n; i++) {
            // Initialize the minimum as the current element
            int mini = arr[i];

            // Traverse all subarrays starting at index i
            for (int j = i; j < n; j++) {
                // Update the minimum in the current subarray
                mini = Math.min(mini, arr[j]);

                // Add the current minimum to the total sum
                sum = (sum + mini) % mod;
            }
        }

        // Return the total computed sum
        return sum;
    }
}