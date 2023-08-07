/*
1456. Maximum Number of Vowels in a Substring of Given Length
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
*/

class MaxNumberOfVowels {
    public int maxVowels(String s, int k) {
        int maxVowelsCount = 0;
        int currentVowelsCount = 0;
        String vowels = "aeiou";

        // Calculate the vowel count for the first window of length k
        for (int i = 0; i < k; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentVowelsCount++;
            }
        }

        maxVowelsCount = currentVowelsCount;

        // Slide the window through the string and update the maxVowelsCount
        for (int i = k; i < s.length(); i++) {
            char leftChar = s.charAt(i - k);
            char rightChar = s.charAt(i);

            if (vowels.indexOf(leftChar) != -1) {
                currentVowelsCount--;
            }

            if (vowels.indexOf(rightChar) != -1) {
                currentVowelsCount++;
            }

            maxVowelsCount = Math.max(maxVowelsCount, currentVowelsCount);
        }

        return maxVowelsCount;
    }
}