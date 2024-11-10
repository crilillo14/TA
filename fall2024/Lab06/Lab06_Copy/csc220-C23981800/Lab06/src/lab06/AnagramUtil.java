package lab06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Utility class for handling anagram-related operations such as determining
 * if two strings are anagrams and finding the largest group of anagrams from
 * a list.
 */
public class AnagramUtil {

    /**
     * Determines if two SortedString objects are anagrams of each other.
     *
     * @param str1 the first SortedString
     * @param str2 the second SortedString
     * @return true if the two strings are anagrams, false otherwise
     */
    public static boolean areAnagrams(SortedString str1, SortedString str2) {
        // Compare the sorted strings of both SortedString objects
        return str1.getSorted().equals(str2.getSorted());
    }

    /**
     * Finds the largest group of anagrams in a file. The file should contain one
     * word per line.
     *
     * @param filename the name of the file containing the list of words
     * @return an array of strings containing the largest group of anagrams
     */
    public static String[] getLargestAnagramGroup(String filename) {
        SortedString[] words = readFile(filename);
        return getLargestAnagramGroup(words);
    }

    /**
     * Finds the largest group of anagrams in a list of SortedString objects.
     *
     * @param stringList an array of SortedString objects
     * @return an array of strings containing the largest group of anagrams
     */
    public static String[] getLargestAnagramGroup(SortedString[] stringList) {
        // Check if stringList is empty
        if (stringList.length == 0) {
            return new String[0]; // Return empty array if no strings
        }

        // Initialize InsertionSort for SortedString
        MergeSort<SortedString> sorter = new MergeSort<>();


        // Sort the input string list
        SortedString[] sortedList = sorter.sort(stringList);

        // Variables to keep track of the largest anagram group
        int end = 0, length = 1, maxLength = 1;

        // Loop through sortedList to find groups of anagrams
        for (int i = 0; i < sortedList.length - 1; i++) {
            if (areAnagrams(sortedList[i], sortedList[i + 1])) {
                length++; // Increment length if they are anagrams
            } else {
                // Check if the current group length is the maximum
                if (length > maxLength) {
                    maxLength = length; // Update maxLength
                    end = i; // Update end to current index
                }
                length = 1; // Reset length for the next group
            }
        }

        // Final check for the last group
        if (length > maxLength) {
            maxLength = length;
            end = sortedList.length - 1; // Set end to the last element
        }

        // Prepare to return the largest anagram group
        String[] toReturn = new String[maxLength];
        for (int j = 0; j < maxLength; j++) {
            toReturn[j] = sortedList[j + end - maxLength + 1].getUnsorted(); // Get the original strings
        }

        return toReturn; // Return the largest group of anagrams
    }

    /**
     * Reads a list of words from a file, where each line of the file contains a single word.
     * Converts the words to SortedString objects.
     *
     * @param filename the name of the file to read from
     * @return an array of SortedString objects representing the words in the file
     */
    public static SortedString[] readFile(String filename) {
        ArrayList<SortedString> results = new ArrayList<SortedString>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = input.readLine()) != null) {
                if (!line.trim().isEmpty()) { // Ensure no empty lines are added
                    results.add(new SortedString(line));
                }
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results.toArray(new SortedString[0]); // Return the array directly
    }
}
