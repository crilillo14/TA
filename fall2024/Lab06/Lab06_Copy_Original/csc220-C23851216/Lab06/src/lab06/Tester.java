package lab06;

import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
        System.out.println("Running AnagramUtil Tests...");
        testAnagramUtil();

        System.out.println("\nRunning MergeSort Tests...");
        testMergeSort();

        System.out.println("\nRunning Runtime Prediction Tests...");
        testRuntimePrediction();
    }

    private static void testAnagramUtil() {
        // Test with sample_word_list.txt
        String[] largestAnagramGroup = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        if (largestAnagramGroup.length > 0) {
            System.out.println("Largest anagram group: " + String.join(" ", largestAnagramGroup));
        } else {
            System.out.println("No anagrams found.");
        }

        // Edge case tests for AnagramUtil
        System.out.println("Empty file test: " + (AnagramUtil.getLargestAnagramGroup("empty.txt").length == 0 ? "Passed" : "Failed"));
        System.out.println("One word test: " + (AnagramUtil.getLargestAnagramGroup("one_word.txt").length == 0 ? "Passed" : "Failed"));
        System.out.println("No anagrams test: " + (AnagramUtil.getLargestAnagramGroup("no_anagrams.txt").length == 0 ? "Passed" : "Failed"));

        // Custom edge case: all words are anagrams
        String[] allAnagramsTest = {"listen", "silent", "enlist", "inlets", "tinsel"};
        String[] allAnagramsResult = AnagramUtil.getLargestAnagramGroup(SortedString.toSortedString(allAnagramsTest));
        System.out.println("All words are anagrams test: " + (allAnagramsResult.length == allAnagramsTest.length ? "Passed" : "Failed"));

        // Custom edge case: words with no anagrams
        String[] noAnagramsTest = {"apple", "banana", "carrot", "dog", "elephant"};
        String[] noAnagramsResult = AnagramUtil.getLargestAnagramGroup(SortedString.toSortedString(noAnagramsTest));
        System.out.println("No anagrams in custom test: " + (noAnagramsResult.length == 0 ? "Passed" : "Failed"));
    }

    private static void testMergeSort() {
        MergeSort<Integer> mergeSorter = new MergeSort<>();

        // Test 1: Single element array
        Integer[] single = {42};
        System.out.println("Single element test: " + Arrays.toString(mergeSorter.sort(single)));

        // Test 2: Two element array
        Integer[] twoElements = {5, 2};
        System.out.println("Two element test: " + Arrays.toString(mergeSorter.sort(twoElements)));

        // Test 3: Sorted array
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        System.out.println("Sorted array test: " + Arrays.toString(mergeSorter.sort(sortedArray)));

        // Test 4: Random array
        Integer[] randomArray = {4, 1, 3, 5, 2};
        System.out.println("Random array test: " + Arrays.toString(mergeSorter.sort(randomArray)));

        // Test 5: Empty array
        Integer[] emptyArray = {};
        System.out.println("Empty array test: " + Arrays.toString(mergeSorter.sort(emptyArray)));

        // Test 6: Array with duplicates
        Integer[] arrayWithDuplicates = {4, 2, 2, 1, 5, 4, 3, 1};
        System.out.println("Array with duplicates test: " + Arrays.toString(mergeSorter.sort(arrayWithDuplicates)));
    }

    private static void testRuntimePrediction() {
        MergeSort<Integer> mergeSorter = new MergeSort<>();

        // Small array for fitting
        Integer[] smallArray = {4, 1, 3, 5, 2, 9, 7, 8, 6, 0};
        mergeSorter.fit(smallArray);

        // Predict runtimes for larger arrays
        System.out.println("Predicted time for 100K elements: " + mergeSorter.predict(100000) + " ms");
        System.out.println("Predicted time for 1M elements: " + mergeSorter.predict(1000000) + " ms");

        // Add custom runtime tests if needed
        Integer[] mediumArray = new Integer[500000];
        Arrays.fill(mediumArray, 42); // Filling with the same number just as a large array test
        mergeSorter.fit(mediumArray);
        System.out.println("Predicted time for 500K elements: " + mergeSorter.predict(500000) + " ms");
    }
}
