/* Problem:
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
*/

/* Solution 1: Reverse Array
Reverse array from index 0 to index n - k - 1.
Reverse array from index n - k to n - 1.
Reverse the whole array.
*/

/* Solution 2: Using Juggling Algorithm
Find GCD of n and k which is d.
Divide the array into d sets, each set contains numbers that has the same modulo between the index and d.
Rotate each number in the step to the right once.
*/

class RotateArray {
    public void rotate1(int[] nums, int k) {
        if (k == 0) {
            return;
        }

        int n = nums.length;
        k = k % n;

        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - k - 1);
        reverse(nums, 0, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate2(int[] nums, int k) {
        if (k == 0) {
            return;
        }

        int n = nums.length;
        k = k % n;
        int d = gcd(n, k);

        for (int i = 0; i < d; i++) {
            int temp = nums[i];
            int j = i;
            while (true) {
                int t = (j - k) % n;

                if (t < 0) {
                    t += n;
                }

                if (t == i) {
                    break;
                }

                nums[j] = nums[t];
                j = t;
            }

            nums[j] = temp;
        }
    }

    public int gcd(int a, int b) {
        // stores minimum(a, b)
        int i;
        if (a < b)
            i = a;
        else
            i = b;
 
        // take a loop iterating through smaller number to 1
        for (i = i; i > 1; i--) {
 
            // check if the current value of i divides both
            // numbers with remainder 0 if yes, then i is
            // the GCD of a and b
            if (a % i == 0 && b % i == 0)
                return i;
        }
 
        // if there are no common factors for a and b other
        // than 1, then GCD of a and b is 1
        return 1;
    }
}