/*
151. Reverse Words in a String
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.\
*/

class ReverseWordsInString {
    public String reverseWords(String s) {
        // Split the string into individual words using space as the delimiter
        String[] words = s.trim().split("\\s+");
        
        // Reverse the array of words
        reverseArray(words);

        // Join the reversed words with a single space as the separator
        return String.join(" ", words);
    }

    private static void reverseArray(String[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}