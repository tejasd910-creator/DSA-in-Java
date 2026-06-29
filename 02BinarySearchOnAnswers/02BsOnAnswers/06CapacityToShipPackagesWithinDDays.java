class Solution {
    private boolean checkDays(int[] weights, int capacity, int maxDays) {
        int days = 1, sum = 0;
        for (int w : weights) {
            if (sum + w > capacity) {
                if (++days > maxDays) return false; // early exit
                sum = 0;
            }
            sum += w;
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0], high = 0;
        for (int w : weights) {
            if (w > low) low = w;
            high += w;
        }

        while (low < high) {
            int mid = (low + high) >>> 1;
            if (checkDays(weights, mid, days))
                high = mid;     // try smaller
            else
                low = mid + 1;  // need larger
        }

        return low;
    }
}