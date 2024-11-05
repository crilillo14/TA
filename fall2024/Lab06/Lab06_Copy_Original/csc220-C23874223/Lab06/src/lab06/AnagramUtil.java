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

        // TODO: Assignment Part 1

        if (stringList.length <= 1) {
            return new String[0];  // Return an empty array if the list has 0 or 1 element
        }

        // Sort the array using MergeSort
        MergeSort<SortedString> sorter = new MergeSort<>();
        stringList = sorter.sort(stringList);  // Sort the list

        int maxLength = 1, currentLength = 1;
        int startIndexOfMaxGroup = 0, startIndexOfCurrentGroup = 0;

        // Traverse the sorted list to find the largest group of anagrams
        for (int i = 1; i < stringList.length; i++) {
            if (areAnagrams(stringList[i - 1], stringList[i])) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startIndexOfMaxGroup = startIndexOfCurrentGroup;
                }
                startIndexOfCurrentGroup = i;
                currentLength = 1;
            }
        }

        // Final check if the largest group is at the end
        if (currentLength > maxLength) {
            maxLength = currentLength;
            startIndexOfMaxGroup = startIndexOfCurrentGroup;
        }

        // Prepare the return array
        String[] result = new String[maxLength];
        for (int i = 0; i < maxLength; i++) {
            result[i] = stringList[startIndexOfMaxGroup + i].getUnsorted();
        }

        return result;
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
        SortedString[] retval = new SortedString[results.size()];
        return results.toArray(retval);
    }
}
