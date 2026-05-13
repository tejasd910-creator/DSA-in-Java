class Solution {
    public static int[] count_NGE(int arr[], int indices[]) {
        int q = indices.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int idx = indices[i];
            int count = 0;

            // Count greater elements on the right
            for (int j = idx + 1; j < arr.length; j++) {
                if (arr[j] > arr[idx]) {
                    count++;
                }
            }

            ans[i] = count;
        }

        return ans;
    }
}