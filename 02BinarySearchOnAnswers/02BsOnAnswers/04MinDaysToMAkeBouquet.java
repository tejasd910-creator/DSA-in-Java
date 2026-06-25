import java.util.*;

class Solution {

    // Check if it's possible to make 'm' bouquets by 'day'
    private static boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0, flowers = 0;

        for (int d : bloomDay) {
            if (d <= day) {
                if (++flowers == k) {
                    bouquets++;
                    flowers = 0;
                    if (bouquets >= m)
                        return true; // early exit
                }
            } else {
                flowers = 0; // reset sequence
            }
        }
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long required = (long) m * k;
        if (required > n)
            return -1;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int d : bloomDay) { // faster than streams
            if (d < min)
                min = d;
            if (d > max)
                max = d;
        }

        int left = min, right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}