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
        // TODO: Lab Part 2
    	return str1.getSorted().equals(str2.getSorted());  // Compare sorted versions
    	

       // return false; // placeholder
    }

    private static boolean contains(Object str1) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
     * Finds the largest group of anagrams in a file. The file should contain one
     * word per line.
     *
     * @param filename the name of the file containing the list of words
     * @return an array of strings containing the largest group of anagrams
     */
    public static String[] getLargestAnagramGroup(String filename){
    	SortedString[] sortedStrings = readFile(filename);

        
        return getLargestAnagramGroup(sortedStrings);
    }

    /**
     * Finds the largest group of anagrams in a list of SortedString objects.
     *
     * @param stringList an array of SortedString objects
     * @return an array of strings containing the largest group of anagrams
     */
    public static String[] getLargestAnagramGroup(SortedString[] stringList) {
        if (stringList == null || stringList.length == 0) {
            return new String[0]; // Handle edge case of empty or null array
        }

        // Sort the list of SortedString objects (You can replace InsertionSort with MergeSort if needed)
        InsertionSort<SortedString> sorter = new InsertionSort<>();
        sorter.sort(stringList);  // Sort based on sorted character representations

        // Variables to track the largest group of anagrams
        int maxLength = 1; // Length of the largest anagram group
        int currentLength = 1; // Length of the current anagram group
        int startIndexOfMaxGroup = 0; // Start index of the largest group

        // Iterate through the sorted list to find groups of anagrams
        for (int i = 1; i < stringList.length; i++) {
            if (stringList[i].getSorted().equals(stringList[i - 1].getSorted())) {
                currentLength++; // Increment current group length if anagram found
            } else {
                // Check if the current group is the largest so far
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startIndexOfMaxGroup = i - currentLength; // Update start index of the largest group
                }
                currentLength = 1; // Reset current group length
            }
        }

        // Handle the case where the last group is the largest
        if (currentLength > maxLength) {
            maxLength = currentLength;
            startIndexOfMaxGroup = stringList.length - currentLength;
        }

        // Create an array to store the largest group of anagrams
        String[] largestGroup = new String[maxLength];
        for (int i = 0; i < maxLength; i++) {
            largestGroup[i] = stringList[startIndexOfMaxGroup + i].getUnsorted();
        }

        return largestGroup; // Return the largest group of anagrams
    }


    /**
     * Reads a list of words from a file, where each line of the file contains a single word.
     * Converts the words to SortedString objects.
     *
     * @param filename the name of the file to read from
     * @return an array of SortedString objects representing the words in the file
     */
    public static SortedString[] readFile(String filename) {
    	ArrayList<SortedString> results = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = input.readLine()) != null) {
                results.add(new SortedString(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results.toArray(new SortedString[0]); // Return an array of the correct size
    }
}
