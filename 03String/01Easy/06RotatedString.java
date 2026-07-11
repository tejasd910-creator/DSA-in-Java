class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        int n = s.length();

        for (int shift = 0; shift < n; shift++) {
            // Try matching s with goal rotated by "shift"
            boolean match = true;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != goal.charAt((i + shift) % n)) {
                    match = false;
                    break;
                }
            }

            if (match)
                return true;
        }

        return false;
    }
}