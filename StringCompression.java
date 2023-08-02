/*
443. String Compression
Given an array of characters chars, compress it using the following algorithm:
Begin with an empty string s. For each group of consecutive repeating characters in chars:
    If the group's length is 1, append the character to s.
    Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
After you are done modifying the input array, return the new length of the array.
You must write an algorithm that uses only constant extra space.
*/

class StringCompression {
    public int compress(char[] chars) {
         int writeIndex = 0;
        int readIndex = 0;

        while (readIndex < chars.length) {
            char currentChar = chars[readIndex];
            int count = 0;

            // Count the number of consecutive occurrences of currentChar
            while (readIndex < chars.length && chars[readIndex] == currentChar) {
                readIndex++;
                count++;
            }

            // Write the currentChar and its count to the compressed array
            chars[writeIndex] = currentChar;
            writeIndex++;

            if (count > 1) {
                // Convert count to a string and write its characters to the compressed array
                String countString = String.valueOf(count);
                for (char c : countString.toCharArray()) {
                    chars[writeIndex] = c;
                    writeIndex++;
                }
            }
        }

        return writeIndex;
    }
}