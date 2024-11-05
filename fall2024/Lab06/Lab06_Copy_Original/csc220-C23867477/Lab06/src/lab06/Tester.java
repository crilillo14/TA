package lab06;

import java.util.Arrays;
import java.util.Random;

public class Tester {
	
	public static void main(String[] args) {
        System.out.println("Running anagram tests:");
        testAnagrams();
        System.out.println("\nTesting largest anagram group:");
        testLargestAnagramGroup();
        System.out.println("\nTesting InsertionSort:");
        testInsertionSort();
        System.out.println("\nTesting InsertionSort prediction:");
        testInsertionSortPrediction();
        System.out.println("\nTesting MergeSort:");
        testMergeSort();
        System.out.println("\nTesting MergeSort prediction:");
        testMergeSortPrediction();
        System.out.println("\nComparing InsertionSort and MergeSort:");
        compareSortingAlgorithms();
        System.out.println("\nTesting MergeSort in getLargestAnagramGroup:");
        testMergeSortInLargestAnagramGroup();
    }
	
	public static void testAnagrams() {
	    // Test case 1: Empty string vs another string
	    SortedString empty = new SortedString("");
	    SortedString notEmpty = new SortedString("hello");
	    System.out.println("Empty vs non-empty: " + AnagramUtil.areAnagrams(empty, notEmpty));  // Should be false

	    // Test case 2: Exactly the same string
	    SortedString str1 = new SortedString("hello");
	    SortedString str2 = new SortedString("hello");
	    System.out.println("Same string: " + AnagramUtil.areAnagrams(str1, str2));  // Should be true

	    // Test case 3: Shuffled strings
	    SortedString str3 = new SortedString("listen");
	    SortedString str4 = new SortedString("silent");
	    System.out.println("Shuffled strings: " + AnagramUtil.areAnagrams(str3, str4));  // Should be true

	    // Test case 4: Different strings
	    SortedString str5 = new SortedString("hello");
	    SortedString str6 = new SortedString("world");
	    System.out.println("Different strings: " + AnagramUtil.areAnagrams(str5, str6));  // Should be false

	    // Test case 5: Case-insensitive
	    SortedString str7 = new SortedString("Hello");
	    SortedString str8 = new SortedString("hello");
	    System.out.println("Case-insensitive: " + AnagramUtil.areAnagrams(str7, str8));  // Should be true
	}
	
	public static void testLargestAnagramGroup() {
        String[] largestGroup = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println("Largest anagram group from sample_word_list.txt:");
        for (String word : largestGroup) {
            System.out.println(word);
        }
    }

	public static void testInsertionSort() {
        InsertionSort<SortedString> sorter = new InsertionSort<>();
        
        // Read words from the sample file
        SortedString[] words = AnagramUtil.readFile("sample_word_list.txt");
        
        System.out.println("Original words (first 10):");
        printFirst10(words);

        SortedString[] sortedWords = sorter.sort(words);
        
        System.out.println("Sorted words (first 10):");
        printFirst10(sortedWords);
    }
	
	public static void testInsertionSortPrediction() {
        InsertionSort<SortedString> sorter = new InsertionSort<>();
        
        // Fit with the sample file
        SortedString[] words = AnagramUtil.readFile("sample_word_list.txt");
        sorter.fit(words);

        // Predict for larger sizes
        int[] sizes = {1000, 10000, 100000};
        for (int size : sizes) {
            double predictedTime = sorter.predict(size);
            System.out.printf("Predicted time for size %d: %.2f microseconds%n", size, predictedTime);
        }
    }
	
	private static void printFirst10(SortedString[] array) {
        for (int i = 0; i < Math.min(10, array.length); i++) {
            System.out.println(array[i].getUnsorted());
        }
        if (array.length > 10) {
            System.out.println("...");
        }
    }
	
	public static void testMergeSort() {
        MergeSort<Integer> sorter = new MergeSort<>();
        
        // Test case 1: List with one element
        Integer[] oneElement = {5};
        System.out.println("One element: " + Arrays.toString(sorter.sort(oneElement)));

        // Test case 2: List with two elements
        Integer[] twoElements = {5, 2};
        System.out.println("Two elements: " + Arrays.toString(sorter.sort(twoElements)));

        // Test case 3: Sorted list of numbers
        Integer[] sortedList = {1, 2, 3, 4, 5};
        System.out.println("Sorted list: " + Arrays.toString(sorter.sort(sortedList)));

        // Test case 4: Random list of numbers
        Integer[] randomList = generateRandomArray(10);
        System.out.println("Random list: " + Arrays.toString(randomList));
        System.out.println("Sorted random list: " + Arrays.toString(sorter.sort(randomList)));
    }
	
	public static void testMergeSortPrediction() {
        MergeSort<SortedString> sorter = new MergeSort<>();
        
        // Fit with the sample file
        SortedString[] words = AnagramUtil.readFile("sample_word_list.txt");
        sorter.fit(words);

        // Predict for larger sizes
        int[] sizes = {1000, 10000, 100000};
        for (int size : sizes) {
            double predictedTime = sorter.predict(size);
            System.out.printf("Predicted time for size %d: %.2f microseconds%n", size, predictedTime);
        }
    }
	
	 public static void compareSortingAlgorithms() {
	        InsertionSort<Integer> insertionSort = new InsertionSort<>();
	        MergeSort<Integer> mergeSort = new MergeSort<>();
	        
	        Integer[] array = generateRandomArray(1000);
	        insertionSort.fit(array);
	        mergeSort.fit(array);
	        
	        System.out.println("Predictions for 1,000,000 elements:");
	        System.out.println("InsertionSort: " + insertionSort.predict(1000000) + " microseconds");
	        System.out.println("MergeSort: " + mergeSort.predict(1000000) + " microseconds");
	    }
	 
	 public static void testMergeSortInLargestAnagramGroup() {
	        // Replace InsertionSort with MergeSort in AnagramUtil.getLargestAnagramGroup
	        // This is just to verify that the output remains unchanged
	        String[] largestGroup = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
	        System.out.println("Largest anagram group using MergeSort:");
	        for (String word : largestGroup) {
	            System.out.println(word);
	        }
	    }
	 
	 private static Integer[] generateRandomArray(int size) {
	        Integer[] array = new Integer[size];
	        Random random = new Random();
	        for (int i = 0; i < size; i++) {
	            array[i] = random.nextInt(1000);
	        }
	        return array;
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



