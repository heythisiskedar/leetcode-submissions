class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;

        int left = 0;
        int zeros = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) zeros++;
            if (zeros > k) {
                while ( left < n && zeros > k) {
                    if (nums[left] == 0) zeros--;
                    left++;
                }
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}