import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int) 1e9 + 7;
        int n = arr.length;
        long sum = 0;

        int[] psee = new int[n];
        int[] nse = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();

            nse[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        stack.clear();

        // Previous Smaller or Equal Element
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();

            psee[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;

            sum = (sum + ((long) left * right * arr[i]) % mod) % mod;
        }

        return (int) sum;
    }

    // *******************BRUTE FORCE APPROACH***************** */

    // Function to find the sum of the minimum value in each subarray
    public int sumSubarrayMinsII(int[] arr) {
        // Size of the array
        int n = arr.length;

        // Modulo value to prevent integer overflow
        int mod = (int) 1e9 + 7;

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