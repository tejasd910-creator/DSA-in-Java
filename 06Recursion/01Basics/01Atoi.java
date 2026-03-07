class Solution {

    public int myAtoi(String s) {

        int i = 0;
        int sign = 1;
        int n = s.length();

        // skip spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n)
            return 0;

        // sign check
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        int num = convert(i, 0, s);

        return sign * num;
    }

    public static int convert(int i, int num, String s) {

        if (i == s.length())
            return num;

        if (!Character.isDigit(s.charAt(i)))
            return num;

        int digit = s.charAt(i) - '0';
        num = num * 10 + digit;

        return convert(i + 1, num, s);
    }
}