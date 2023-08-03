/*
283. Move Zeroes
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
*/

class MoveZeroes {
    public void moveZeroes(int[] nums) {
          int writeIndex = 0;

        // Move non-zero elements to their correct positions
        for (int readIndex = 0; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != 0) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }

        // Fill the rest of the array with zeros
        while (writeIndex < nums.length) {
            nums[writeIndex] = 0;
            writeIndex++;
        }
    }
}