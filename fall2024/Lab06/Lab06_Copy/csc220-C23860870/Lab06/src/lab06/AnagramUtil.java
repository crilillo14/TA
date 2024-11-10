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
    public static boolean areAnagrams(SortedString str1, SortedString str2){
        // TODO: Lab Part 2
        return str1.getSorted().equals(str2.getSorted());
    }

    /**
     * Finds the largest group of anagrams in a file. The file should contain one
     * word per line.
     *
     * @param filename the name of the file containing the list of words
     * @return an array of strings containing the largest group of anagrams
     */
    public static String[] getLargestAnagramGroup(String filename){
        SortedString[] words = readFile(filename);
        String[] toReturn = getLargestAnagramGroup(words);
        return toReturn;
    }

    /**
     * Finds the largest group of anagrams in a list of SortedString objects.
     *
     * @param stringList an array of SortedString objects
     * @return an array of strings containing the largest group of anagrams
     */
    public static String[] getLargestAnagramGroup(SortedString[] stringList){

        //TODO Assignment Part 1

    	if (stringList.length == 0) {
            return new String[0];
        }

        // Use MergeSort to sort the list based on the sorted representation of the strings
        MergeSort<SortedString> mergeSort = new MergeSort<>();
        SortedString[] sortedList = mergeSort.sort(stringList);

        // Variables to track the largest group of anagrams
        int maxLength = 0;
        int currentLength = 1;  // Start with 1 as each word is a group by itself initially
        int maxEndIndex = -1;   // The index where the largest group ends

        // Loop through the sorted list and find the largest group of anagrams
        for (int i = 1; i < sortedList.length; i++) {
            if (sortedList[i].getSorted().equals(sortedList[i - 1].getSorted())) {
                // If two adjacent strings are anagrams, increment the current group length
                currentLength++;
            } else {
                // If the group ends, check if it's the largest group so far
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxEndIndex = i - 1;
                }
                // Reset the current group length
                currentLength = 1;
            }
        }

        // Final check for the last group in the array
        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxEndIndex = stringList.length - 1;
        }

        // If no group of anagrams larger than 1 was found, return an empty array
        if (maxLength <= 1) {
            return new String[0];
        }

        // Extract the largest group of anagrams from the sorted list
        String[] largestAnagramGroup = new String[maxLength];
        for (int j = 0; j < maxLength; j++) {
            largestAnagramGroup[j] = sortedList[maxEndIndex - maxLength + 1 + j].getUnsorted();
        }

        return largestAnagramGroup;
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
            while(input.ready()) {
                results.add(new SortedString(input.readLine()));
            }
            input.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        SortedString[] retval = new SortedString[1];
        return results.toArray(retval);
    }
}
