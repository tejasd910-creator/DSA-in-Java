class Solution {
    public static void pow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        brute(x, N);

        optimal(x, N);
    }

    public static double brute(double x, long n) {
        if (n == 0)
            return 1;

        return x * brute(x, n - 1);
    }

    private static double optimal(double x, long n){
        if(n == 0)
            return 1;

        double res = optimal(x, n/2);

        if(n % 2 == 0)
            return res * res;
        else
            return res * res* x;
    }
}