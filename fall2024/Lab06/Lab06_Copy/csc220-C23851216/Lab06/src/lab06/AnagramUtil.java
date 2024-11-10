package lab06;

import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class AnagramUtil {

    /**
     * Finds the largest group of anagrams in a list of SortedString objects.
     * @param stringList an array of SortedString objects
     * @return an array of strings containing the largest group of anagrams
     */
    public static String[] getLargestAnagramGroup(SortedString[] stringList) {
        if (stringList == null || stringList.length == 0) {
            return new String[0]; // Return an empty array if input is null or empty
        }

        // Use MergeSort to sort the list
        MergeSort<SortedString> mergeSorter = new MergeSort<>();
        stringList = mergeSorter.sort(stringList);

        // Variables to track the largest group of anagrams
        int maxGroupSize = 0;
        int currentGroupSize = 1;
        int startIndexOfMaxGroup = 0;
        int currentGroupStartIndex = 0;

        // Iterate over the sorted list to find the largest group of adjacent anagrams
        for (int i = 1; i < stringList.length; i++) {
            if (stringList[i].compareTo(stringList[i - 1]) == 0) {
                currentGroupSize++;
            } else {
                if (currentGroupSize > maxGroupSize) {
                    maxGroupSize = currentGroupSize;
                    startIndexOfMaxGroup = currentGroupStartIndex;
                }
                currentGroupSize = 1;
                currentGroupStartIndex = i;
            }
        }

        // One last check for the last group
        if (currentGroupSize > maxGroupSize) {
            maxGroupSize = currentGroupSize;
            startIndexOfMaxGroup = currentGroupStartIndex;
        }

        if (maxGroupSize <= 1) {
            return new String[0]; // No anagrams found
        }

        // Collect the largest group of anagrams into a string array
        String[] largestGroup = new String[maxGroupSize];
        for (int i = 0; i < maxGroupSize; i++) {
            largestGroup[i] = stringList[startIndexOfMaxGroup + i].getUnsorted();
        }

        return largestGroup;
    }

    /**
     * Helper method to find the largest group of anagrams by reading words from a file.
     * Converts each word to a SortedString object.
     * @param filename the name of the file containing the list of words
     * @return an array of strings containing the largest group of anagrams
     */
    public static String[] getLargestAnagramGroup(String filename) {
        SortedString[] words = readFile(filename);
        return getLargestAnagramGroup(words);
    }

    /**
     * Reads a list of words from a file, where each line of the file contains a single word.
     * Converts the words to SortedString objects.
     * @param filename the name of the file to read from
     * @return an array of SortedString objects representing the words in the file
     */
    public static SortedString[] readFile(String filename) {
        ArrayList<SortedString> results = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("File " + filename + " not found!");
            return new SortedString[0];
        }

        try (BufferedReader input = new BufferedReader(new FileReader(file))) {
            while (input.ready()) {
                String line = input.readLine().trim();
                if (!line.isEmpty()) {
                    results.add(new SortedString(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results.toArray(new SortedString[0]);
    }
}
