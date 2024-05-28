/* Problem:
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.
Example 1:
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"

Example 2:
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"

Example 3:
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
*/

class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder mergedString = new StringBuilder();
        int shorterLength = Math.min(word1.length(), word2.length());

        for (int i = 0; i < shorterLength; i++) {
            mergedString.append(word1.charAt(i)).append(word2.charAt(i));
        }

        mergedString.append(word1.substring(shorterLength)).append(word2.substring(shorterLength));

        return mergedString.toString();
    }
}