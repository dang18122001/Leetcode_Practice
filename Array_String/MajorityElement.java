/* Problem:
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Solution: Using the Boyer-Moore Majority Voting Algorithm
First, choose a candidate from the given set of elements if it is the same as the candidate element, increase the votes. Otherwise, decrease the votes if votes become 0, select another new element as the new candidate.
*/

class MajorityElement {
    public int majorityElement(int[] nums) {
        int output = -1;
        int vote = 0;
        for (int i = 0; i < nums.length; i++) {
            if (vote == 0) {
                output = nums[i];
            }

            if (nums[i] == output) {
                vote++;
            } else {
                vote--;
            }
        }

        return output;
    }
}