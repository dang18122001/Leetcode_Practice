/*
2215. Find the Difference of Two Arrays
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
    answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
    answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.
*/

class DiffernceOfArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
          Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<List<Integer>> answer = new ArrayList<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> distinctInNums1 = new ArrayList<>(set1);
        List<Integer> distinctInNums2 = new ArrayList<>(set2);

        distinctInNums1.removeAll(set2);
        distinctInNums2.removeAll(set1);

        answer.add(distinctInNums1);
        answer.add(distinctInNums2);

        return answer;
    }
}