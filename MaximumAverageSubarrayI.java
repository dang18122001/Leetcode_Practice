/*
643. Maximum Average Subarray I
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
*/

class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAverage = (double) sum / k;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxAverage = Math.max(maxAverage, (double) sum / k);
        }

        return maxAverage;
    }
}