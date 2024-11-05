package lab06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
        // Test cases for getLargestAnagramGroup and sorting methods

        testEmptyArray();
        testNoAnagrams();
        testSingleAnagramGroup();
        testMultipleAnagramGroups();
        testSingleWord();
     
        // Step 1: Read the file and create an array of SortedString
        String filename = "sample_word_list.txt";
        SortedString[] stringList = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            // Assuming each line in the file is a separate word
            stringList = reader.lines()
                    .map(SortedString::new) // Assuming SortedString has a constructor that takes a String
                    .toArray(SortedString[]::new);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 2: Call the getLargestAnagramGroup method
        if (stringList != null) {
            String[] largestAnagramGroup = AnagramUtil.getLargestAnagramGroup(stringList);

            // Step 3: Print the output
            System.out.println("Largest Anagram Group:");
            for (String word : largestAnagramGroup) {
                System.out.println(word);
            }
        } else {
            System.out.println("No words found in the file.");
        }
    }

    // Test: Empty array case
    public static void testEmptyArray() {
        SortedString[] emptyArray = new SortedString[0];
        String[] result = AnagramUtil.getLargestAnagramGroup(emptyArray);
        if (result.length == 0) {
            System.out.println("testEmptyArray: Passed");
        } else {
            System.out.println("testEmptyArray: Failed");
        }
    }

    // Test: No anagrams case
    public static void testNoAnagrams() {
        SortedString[] noAnagrams = {
                new SortedString("cat"),
                new SortedString("dog"),
                new SortedString("bird")
        };
        String[] result = AnagramUtil.getLargestAnagramGroup(noAnagrams);
        if (result.length == 1 && result[0].equals("cat")) {
            System.out.println("testNoAnagrams: Passed");
        } else {
            System.out.println("testNoAnagrams: Failed");
        }
    }

    // Test: Single anagram group case
    public static void testSingleAnagramGroup() {
        SortedString[] anagrams = {
                new SortedString("listen"),
                new SortedString("silent"),
                new SortedString("enlist")
        };
        String[] result = AnagramUtil.getLargestAnagramGroup(anagrams);
        if (result.length == 3 && containsWord(result, "listen") && containsWord(result, "silent") && containsWord(result, "enlist")) {
            System.out.println("testSingleAnagramGroup: Passed");
        } else {
            System.out.println("testSingleAnagramGroup: Failed");
        }
    }

    // Test: Multiple anagram groups case
    public static void testMultipleAnagramGroups() {
        SortedString[] words = {
                new SortedString("listen"),
                new SortedString("silent"),
                new SortedString("enlist"),
                new SortedString("cat"),
                new SortedString("act"),
                new SortedString("dog")
        };
        String[] result = AnagramUtil.getLargestAnagramGroup(words);
        if (result.length == 3 && containsWord(result, "listen") && containsWord(result, "silent") && containsWord(result, "enlist")) {
            System.out.println("testMultipleAnagramGroups: Passed");
        } else {
            System.out.println("testMultipleAnagramGroups: Failed");
        }
    }

    // Test: Single word case
    public static void testSingleWord() {
        SortedString[] singleWord = {
                new SortedString("apple")
        };
        String[] result = AnagramUtil.getLargestAnagramGroup(singleWord);
        if (result.length == 1 && result[0].equals("apple")) {
            System.out.println("testSingleWord: Passed");
        } else {
            System.out.println("testSingleWord: Failed");
        }
    }



    // Helper method: Check if a word exists in the result
    private static boolean containsWord(String[] result, String word) {
        for (String s : result) {
            if (s.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
