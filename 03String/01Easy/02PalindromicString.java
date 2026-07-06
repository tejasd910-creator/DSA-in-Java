class Solution {
    public String reverseWords(String s) {

        StringBuilder str = new StringBuilder();
        String trim = s.trim();
        int n = trim.length();
        int ctr = n;

        for (int i = n - 1; i >= 0; i--) {
            if (trim.charAt(i) == ' ') {
                if(ctr - i != 1)
                    str.append(trim.substring(i + 1, ctr) + " ");
                ctr = i;
            }
        }
        str.append(trim.substring(0, ctr));

        return str.toString();
    }

}