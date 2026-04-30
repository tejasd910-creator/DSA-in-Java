class Solution {
    public int majorityElement(int[] nums) {

        int ctr = 0;
        int count = 0;

        for (int i : nums) {
            if (count == 0)
                ctr = i;

            if (i == ctr)
                count++;
            else
                count--;
        }

        return ctr;
    }
}