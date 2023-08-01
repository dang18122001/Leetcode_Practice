/*
238. Product of Array Except Self
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
*/

class ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProducts = new int[n];
        int[] suffixProducts = new int[n];
        int[] answer = new int[n];

        // Calculate prefix products
        prefixProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
        }

        // Calculate suffix products
        suffixProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffixProducts[i] = suffixProducts[i + 1] * nums[i + 1];
        }

        // Calculate the answer using prefix and suffix products
        for (int i = 0; i < n; i++) {
            answer[i] = prefixProducts[i] * suffixProducts[i];
        }

        return answer;
    }
}