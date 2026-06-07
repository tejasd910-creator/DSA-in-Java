class Solution {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> list = new ArrayList<>();

        int ctr1 = 0, count1 = 0;
        int ctr2 = 0, count2 = 0;

        for (int i : nums) {
            if (count1 == 0 && i != ctr2)
                ctr1 = i;
            if (count2 == 0 && i != ctr1)
                ctr2 = i;

            if (i == ctr1) {
                count1++;
            } else if (i == ctr2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (i == ctr1)
                count1++;
            else if (i == ctr2)
                count2++; // avoid double-counting if ctr1 == ctr2
        }

        int n = nums.length;
        if (count1 > n / 3)
            list.add(ctr1);
        if (count2 > n / 3)
            list.add(ctr2);

        return list;
    }
}