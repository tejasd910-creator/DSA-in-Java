import java.util.*;

class Solution {
    public static long totalhours(int[] a, int hours) {
        long totalhrs = 0;
        for (int pile : a) {
            totalhrs += (pile + hours - 1) / hours; // integer ceil
        }
        return totalhrs;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int maxValue = Arrays.stream(piles).max().getAsInt();

        int low = 1, high = maxValue;

        while (low <= high) {
            int mid = low - (low - high) / 2;
            if (totalhours(piles, mid) <= h)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }
}