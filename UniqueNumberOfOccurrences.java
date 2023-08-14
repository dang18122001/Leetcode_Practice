/*
1207. Unique Number of Occurrences
Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
*/

class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
         Map<Integer, Integer> frequencyMap = new HashMap<>();
        Set<Integer> seenFrequencies = new HashSet<>();

        // Calculate the frequency of each value in the array
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Check if the frequency of occurrences is unique
        for (int frequency : frequencyMap.values()) {
            if (seenFrequencies.contains(frequency)) {
                return false;
            }
            seenFrequencies.add(frequency);
        }

        return true;
    }
}