package lab06;

import java.util.Arrays;
import java.util.Random;

public class Tester {

    public static void main(String[] args) {
        // Test InsertionSort
        testInsertionSort();

        // Test MergeSort
        testMergeSort();

        // Test Anagram Util
        testAnagramUtil();
    }

    private static void testInsertionSort() {
        InsertionSort<Integer> sorter = new InsertionSort<>();

        // Test a list with one element
        Integer[] oneElement = {42};
        System.out.println("One element: " + Arrays.toString(sorter.sort(oneElement))); // Expected: [42]

        // Test a list with two elements
        Integer[] twoElements = {9, 3};
        System.out.println("Two elements: " + Arrays.toString(sorter.sort(twoElements))); // Expected: [3, 9]

        // Test a sorted list of numbers
        Integer[] sortedList = {1, 2, 3, 4, 5};
        System.out.println("Sorted list: " + Arrays.toString(sorter.sort(sortedList))); // Expected: [1, 2, 3, 4, 5]

        // Test a random list of numbers
        Integer[] randomList = {5, 1, 4, 2, 3};
        System.out.println("Random list: " + Arrays.toString(sorter.sort(randomList))); // Expected: [1, 2, 3, 4, 5]

        // Example small array to calculate c
        Integer[] smallArray = {5, 3, 8, 6, 2};
        sorter.fit(smallArray);
        
        // Now predicting runtime for larger sizes
        double predictedTime100k = sorter.predict(100000);
        double predictedTime1m = sorter.predict(1000000);
        
        System.out.println("Predicted time for 100K elements: " + predictedTime100k + " microseconds");
        System.out.println("Predicted time for 1M elements: " + predictedTime1m + " microseconds");
    }

    private static void testMergeSort() {
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Random rand = new Random();

        // Create an array of 10 random integers
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100); // Fill with random values
        }

        // Fit the constant c using the array
        mergeSort.fit(array);

        // Predict times for larger input sizes
        int[] sizes = {100, 1000, 10000, 100000, 1000000};
        for (int size : sizes) {
            double predictedTime = mergeSort.predict(size);
            System.out.println("Predicted time to sort array of size " + size + ": " + predictedTime + " microseconds");
        }
    }

    private static void testAnagramUtil() {
        String[] anagrams = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println("Largest Anagram Group: ");
        for (String word : anagrams) {
            System.out.print(word + " ");
        }
        System.out.println(); // For a new line after the anagrams output
    }
}
