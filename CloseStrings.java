/*
1657. Determine if Two Strings Are Close
Two strings are considered close if you can attain one from the other using the following operations:
Operation 1: Swap any two existing characters.
    For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
    For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.
Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
*/

class CloseStrings {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        // Count the frequency of characters in word1 and word2
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
            set1.add(c);
        }

        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
            set2.add(c);
        }

        // Check if the sets of characters are the same
        if (!set1.equals(set2)) {
            return false;
        }

        // Sort the frequency arrays and check if they are the same
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
}