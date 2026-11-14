class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sumRange = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int k = i; k <= j; k++) {
                    min = Math.min(min, nums[k]);
                    max = Math.max(max, nums[k]);
                }

                sumRange += (max - min);
            }
        }

        return sumRange;
    }
}