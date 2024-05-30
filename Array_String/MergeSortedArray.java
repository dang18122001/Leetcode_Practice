class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Two pointers: i for nums1 (from the back) and j for nums2
        int i = m - 1;
        int j = n - 1;
        
        // Start at the end of the combined array (nums1.length - 1)
        for (int k = m + n - 1; k >= 0; k--) {
            // If m reaches 0, all elements in nums1 have been processed, fill with nums2
            if (i < 0) {
                nums1[k] = nums2[j--];
            // If j reaches 0, all elements in nums2 have been processed, fill with remaining nums1
            } else if (j < 0) {
                nums1[k] = nums1[i--];
            // Compare and insert the larger element from either array
            } else if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
        }
    }
}