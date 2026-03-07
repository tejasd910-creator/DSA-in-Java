class Solution {

    public int myAtoi(String s) {

        int i = 0;
        int sign = 1;
        int n = s.length();

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ')
            i++;

        if (i == n)
            return 0;

        // Check sign
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } 
        else if (s.charAt(i) == '+') {
            i++;
        }

        return convert(i, 0, sign, s);
    }

    public int convert(int i, int num, int sign, String s) {

        if (i >= s.length() || !Character.isDigit(s.charAt(i)))
            return num * sign;

        int digit = s.charAt(i) - '0';

        // Overflow check
        if (num > Integer.MAX_VALUE / 10 || 
           (num == Integer.MAX_VALUE / 10 && digit > 7)) {

            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        num = num * 10 + digit;

        return convert(i + 1, num, sign, s);
    }
}