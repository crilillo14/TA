package lab06;

import java.util.Arrays;
import java.util.Random;

public class Tester {

    //You will need to write your own tests

    /* 
    * As a reminder these are the methods we did in lab:
    * 1.1) SortedString Constructor
    * 1.2) SortedString compareTo(SortedString other)
    * 2) AnagramUtil areAnagrams(SortedString str1, SortedString str2)
    * 3) InsertionSort sort(E[] array) (HINT: use the toSortedString() convenience function from SortedString)
    * 4.1, 4.2, 4.3) InsertionSort  O(int n), fit(E[] array), and predict(int n)
    */

    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */

	public static void main(String[] args) {
        testSortedString();
        testAnagramUtil();
        testInsertionSort();
        testMergeSort();
        testLargestAnagramGroup();
        testSortingPerformance();
    }

    public static void testSortedString() {
        System.out.println("Testing SortedString...");
        SortedString s1 = new SortedString("hello");
        SortedString s2 = new SortedString("olleh");
        SortedString s3 = new SortedString("world");

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s3: " + s3);

        System.out.println("s1.compareTo(s2): " + s1.compareTo(s2));
        System.out.println("s1.compareTo(s3): " + s1.compareTo(s3));
    }

    public static void testAnagramUtil() {
        System.out.println("\nTesting AnagramUtil...");
        SortedString s1 = new SortedString("listen");
        SortedString s2 = new SortedString("silent");
        SortedString s3 = new SortedString("hello");

        System.out.println("Are 'listen' and 'silent' anagrams? " + AnagramUtil.areAnagrams(s1, s2));
        System.out.println("Are 'listen' and 'hello' anagrams? " + AnagramUtil.areAnagrams(s1, s3));
    }

    public static void testInsertionSort() {
        System.out.println("\nTesting InsertionSort...");
        InsertionSort<Integer> sorter = new InsertionSort<>();
        Integer[] arr = {5, 2, 8, 12, 1, 6};
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Sorted array: " + Arrays.toString(sorter.sort(arr)));

        // Test with SortedString
        String[] words = {"hello", "world", "apple", "zebra", "banana"};
        SortedString[] sortedStrings = SortedString.toSortedString(words);
        InsertionSort<SortedString> stringSorter = new InsertionSort<>();
        System.out.println("Original SortedString array: " + Arrays.toString(sortedStrings));
        System.out.println("Sorted SortedString array: " + Arrays.toString(stringSorter.sort(sortedStrings)));
    }

    public static void testMergeSort() {
        System.out.println("\nTesting MergeSort...");
        MergeSort<Integer> sorter = new MergeSort<>();
        
        // Test with one element
        Integer[] oneElement = {5};
        System.out.println("One element: " + Arrays.toString(sorter.sort(oneElement)));

        // Test with two elements
        Integer[] twoElements = {5, 2};
        System.out.println("Two elements: " + Arrays.toString(sorter.sort(twoElements)));

        // Test with sorted list
        Integer[] sortedList = {1, 2, 3, 4, 5};
        System.out.println("Sorted list: " + Arrays.toString(sorter.sort(sortedList)));

        // Test with random list
        Integer[] randomList = {5, 2, 8, 12, 1, 6};
        System.out.println("Random list: " + Arrays.toString(sorter.sort(randomList)));

        // Test with SortedString
        String[] words = {"hello", "world", "apple", "zebra", "banana"};
        SortedString[] sortedStrings = SortedString.toSortedString(words);
        MergeSort<SortedString> stringSorter = new MergeSort<>();
        System.out.println("Original SortedString array: " + Arrays.toString(sortedStrings));
        System.out.println("Sorted SortedString array: " + Arrays.toString(stringSorter.sort(sortedStrings)));
    }

    public static void testLargestAnagramGroup() {
        System.out.println("\nTesting getLargestAnagramGroup...");
        
        // Test with sample_word_list.txt
        System.out.println("Testing with sample_word_list.txt:");
        String[] result = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println("Largest anagram group: " + Arrays.toString(result));

        // Test edge cases
        System.out.println("\nTesting edge cases:");
        SortedString[] emptyList = new SortedString[0];
        String[] emptyResult = AnagramUtil.getLargestAnagramGroup(emptyList);
        System.out.println("Empty list result: " + Arrays.toString(emptyResult));

        SortedString[] singleWord = {new SortedString("word")};
        String[] singleWordResult = AnagramUtil.getLargestAnagramGroup(singleWord);
        System.out.println("Single word result: " + Arrays.toString(singleWordResult));

        SortedString[] noAnagrams = {new SortedString("cat"), new SortedString("dog"), new SortedString("bird")};
        String[] noAnagramsResult = AnagramUtil.getLargestAnagramGroup(noAnagrams);
        System.out.println("No anagrams result: " + Arrays.toString(noAnagramsResult));
    }

    public static void testSortingPerformance() {
        System.out.println("\nTesting Sorting Performance...");
        InsertionSort<Integer> insertionSorter = new InsertionSort<>();
        MergeSort<Integer> mergeSorter = new MergeSort<>();

        // Fit with a small array
        Integer[] smallArray = generateRandomArray(10);
        insertionSorter.fit(smallArray);
        mergeSorter.fit(smallArray);

        // Predict for larger sizes
        int[] sizesToPredict = {100, 1000, 10000, 100000, 1000000};
        for (int size : sizesToPredict) {
            System.out.println("Predicted time for size " + size + ":");
            System.out.println("  Insertion Sort: " + insertionSorter.predict(size) + " microseconds");
            System.out.println("  Merge Sort: " + mergeSorter.predict(size) + " microseconds");
        }
    }

    private static Integer[] generateRandomArray(int size) {
        Integer[] array = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        return array;
    }
}