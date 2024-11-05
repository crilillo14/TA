package lab06;

import java.util.ArrayList;
import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
    	
    	SortedString word1 = new SortedString("CAT");
    	System.out.println(word1);
 
    	SortedString word2 = new SortedString("DOG");
    	System.out.println(word1.compareTo(word2));
    	
    	SortedString word3 = new SortedString("listen");
        SortedString word4 = new SortedString("silent");
        System.out.println("Test 1: " + AnagramUtil.areAnagrams(word3, word4)); // Expected: true

        
        
        // Test 2: Check if two strings with different characters are not anagrams
        SortedString word5 = new SortedString("dog");
        SortedString word6 = new SortedString("cat");
        System.out.println("Test 2: " + AnagramUtil.areAnagrams(word5, word6)); // Expected: false
        
        // Test 3: Check if two strings with same characters but different cases are anagrams
        SortedString word7 = new SortedString("God");
        SortedString word8 = new SortedString("dog");
        System.out.println("Test 3: " + AnagramUtil.areAnagrams(word7, word8)); // Expected: true
        
        
        
        InsertionSort<Integer> intSorter = new InsertionSort<>();

        // Test 1: Sorting a list with one element
        Integer[] singleElement = {5};
        System.out.println("Test 1 (one element): " + Arrays.toString(intSorter.sort(singleElement))); // Expected: [5]

        // Test 2: Sorting a list with two elements
        Integer[] twoElements = {10, 2};
        System.out.println("Test 2 (two elements): " + Arrays.toString(intSorter.sort(twoElements))); // Expected: [2, 10]

        // Test 3: Sorting a sorted list of numbers
        Integer[] sortedList = {1, 2, 3, 4, 5};
        System.out.println("Test 3 (sorted list): " + Arrays.toString(intSorter.sort(sortedList))); // Expected: [1, 2, 3, 4, 5]

        // Test 4: Sorting a random list of numbers
        Integer[] randomList = {7, 3, 8, 1, 2, 6};
        System.out.println("Test 4 (random list): " + Arrays.toString(intSorter.sort(randomList))); // Expected: [1, 2, 3, 6, 7, 8]
        
        InsertionSort<String> strSorter = new InsertionSort<>();
        
        String[] words = {"cat", "dog", "act", "god"};
        System.out.println("Test 1 (one element): " + Arrays.toString(strSorter.sort(words))); // Expected: [act, cat, dog, god]
        
        
        
        Integer[] singElement = {5};
        Integer[] sortedSingle = intSorter.sort(singleElement);
        assert Arrays.equals(singElement, sortedSingle);
        
        
        
        Integer[] smallArray = {5, 3, 2, 8, 6, 1};
        intSorter.fit(smallArray);
        
        int largeSize = 100000;
        double predictedTime = intSorter.predict(largeSize);
        System.out.println("Predicted time to sort " + largeSize + " elements: " + predictedTime + " microseconds.");
    
        String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println("Largest anagram group: " + Arrays.toString(s3));
        
        
        
        MergeSort<Integer> mergeSorter = new MergeSort<>();

        // Test 1: Sorting a list with random elements using MergeSort
        Integer[] exampleList = {7, 3, 1, 6, 2};
        System.out.println("MergeSort Example (initial list): " + Arrays.toString(exampleList)); // Original list: [7, 3, 1, 6, 2]
        
        // Sort the array
        Integer[] sortedExampleList = mergeSorter.sort(exampleList);
        System.out.println("MergeSort Example (sorted list): " + Arrays.toString(sortedExampleList)); // Expected: [1, 2, 3, 6, 7]

        // Test 2: Sorting a sorted list using MergeSort
        Integer[] mergeSortedList = {1, 2, 3, 4, 5};
        System.out.println("MergeSort Test 2 (sorted list): " + Arrays.toString(mergeSorter.sort(mergeSortedList))); // Expected: [1, 2, 3, 4, 5]

        // Test 3: Sorting a reverse sorted list using MergeSort
        Integer[] reverseList = {5, 4, 3, 2, 1};
        System.out.println("MergeSort Test 3 (reverse sorted list): " + Arrays.toString(mergeSorter.sort(reverseList))); // Expected: [1, 2, 3, 4, 5]

        
        
        int testSize = 10;
        System.out.println("MergeSort O(n): " + mergeSorter.O(testSize)); // Expected: O(n log n) result (may vary based on implementation)

        Integer[] testArray = {7, 3, 1, 6, 2, 5, 4, 9, 8, 10};
        System.out.println("Running fit() with an array of size 10...");
        mergeSorter.fit(testArray);  // Should calculate the constant c based on the time it takes to sort this array.

        int largerSize = 100000; // Predict time for a larger array of size 100K
        double predictTime = mergeSorter.predict(largerSize);
        System.out.println("Predicted time to sort an array of size " + largerSize + ": " + predictTime + " microseconds");

        int millionSize = 1000000; // Predict time for an array of size 1M
        double predictedTimeForMillion = mergeSorter.predict(millionSize);
        System.out.println("Predicted time to sort an array of size " + millionSize + ": " + predictedTimeForMillion + " microseconds");

        InsertionSort<Integer> insertionSorter = new InsertionSort<>();
        insertionSorter.fit(testArray);  // Fit InsertionSort with the same test array

        double predictedInsertionTime = insertionSorter.predict(largerSize);
        System.out.println("Predicted time for InsertionSort to sort an array of size " + largerSize + ": " + predictedInsertionTime + " microseconds");

        double predictedInsertionTimeForMillion = insertionSorter.predict(millionSize);
        System.out.println("Predicted time for InsertionSort to sort an array of size " + millionSize + ": " + predictedInsertionTimeForMillion + " microseconds");
        
        }
    	
	}
	//You will need to write your own tests

    /* 
    * As a reminder these are the methods we did in lab:
    * 1.1) SortedString Constuctor
    * 1.2) SortedString compareTo(SortedString other)
    * 2) AnagramUtil areAnagrams(SortedString str1, SortedString str2)
    * 3) InsetionSort sort(E[] array) (HINT: use the toSortedString() convenience function from SortedString)
    * 4.1, 4.2, 4.3) InsertionSort  O(int n), fit(E[] array), and predict(int n)
    */

    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */



