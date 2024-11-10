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
        if (stringList == null || stringList.length == 0) {
            return new String[0]; // Return an empty array if no anagram groups are possible
        }
       
    MergeSort<SortedString> mergeSort = new MergeSort<>();
    SortedString[] sortedList = mergeSort.sort(stringList); 
        
        int end = 0, length = 1, i = 0, maxLength = 0;

        for (i = 1; i < sortedList.length; i++) {
            // Corrected square bracket access
            if (sortedList[i].getSorted().equals(sortedList[i - 1].getSorted())) {
                length++;  // Increment length of current anagram group
            } else {
                // Update maxLength and end if current group is larger than max group
                if (length > maxLength) {
                    maxLength = length;
                    end = i - 1;  // Set end index of the largest group
                }
                length = 1;  // Reset for next group
            }
        }
        
        if (length > maxLength) {
            maxLength = length;
            end = i - 1;
        }
    
        String[] toReturn = new String[maxLength];
        for (int j = 0; j < maxLength; j++) {
            toReturn[j] = stringList[j + end - maxLength + 1].toString(); // Convert SortedString back to String
        }

        return toReturn; // Return the correct array
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
    SortedString[] retval = new SortedString[results.size()]; // Fix size of the array
    return results.toArray(retval);
}
}
