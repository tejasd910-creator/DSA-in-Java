class SolutionI {
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

// Stack answer for this question impractical and not good practice 

//Optimal solution include Fenwick Tree (BIT).

class SolutionII {
    public static int[] count_NGE(int arr[], int indices[]) {
        int n = arr.length;

        // Coordinate compression
        int[] sorted = arr.clone();
        java.util.Arrays.sort(sorted);

        java.util.Map<Integer, Integer> rank = new java.util.HashMap<>();
        int r = 1;

        for (int x : sorted) {
            if (!rank.containsKey(x)) {
                rank.put(x, r++);
            }
        }

        Fenwick bit = new Fenwick(r + 2);

        int[] greaterRight = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int val = rank.get(arr[i]);

            int total = bit.query(r);
            int leq = bit.query(val);

            greaterRight[i] = total - leq;

            bit.update(val, 1);
        }

        int[] ans = new int[indices.length];
        for (int i = 0; i < indices.length; i++) {
            ans[i] = greaterRight[indices[i]];
        }

        return ans;
    }

    static class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 1];
        }

        void update(int i, int val) {
            while (i < bit.length) {
                bit[i] += val;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}



