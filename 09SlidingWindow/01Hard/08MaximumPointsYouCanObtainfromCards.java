class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // Sum of first k cards
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += cardPoints[i];
        }

        int maxSum = currentSum;

        // Replace left cards with right cards one by one
        for (int i = 1; i <= k; i++) {
            currentSum = currentSum
                       - cardPoints[k - i]
                       + cardPoints[n - i];

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}