class Solution {
    public int divide(int dividend, int divisor) {
        // handle overflow
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long sum = 0;

        while(n >= d){
            int pos = 0;
            while(n >= (d * (1L << (pos + 1)))) pos++;  // prevent overshoot
            sum += (1L << pos);
            n -= d * (1L << pos);
        }

        return (int)(sign * sum);
    }
}