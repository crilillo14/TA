package lab06;

import java.util.Arrays;

public class Tester {

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

	
	public static void main(String[] args) {
	      // Test 1: Basic test with a simple string
        SortedString test1 = new SortedString("tac");
        System.out.println("Test 1 - Unsorted: " + test1.getUnsorted());
        System.out.println("Test 1 - Sorted: " + test1.getSorted());
        System.out.println("Test 1 - toString: " + test1.toString());

        //TESTS FOR AREANAGRAMS:
        System.out.println("__________________________________________________________________________");

        // Case 1: Empty string vs. another string
        SortedString emptyString = new SortedString("");
        SortedString nonEmptyString = new SortedString("hello");
        System.out.println("Empty string vs non-empty string: " + 
                            AnagramUtil.areAnagrams(emptyString, nonEmptyString));  // Expected: false

        // Case 2: Exactly the same string
        SortedString sameString1 = new SortedString("listen");
        SortedString sameString2 = new SortedString("listen");
        System.out.println("Same string vs same string: " + 
                            AnagramUtil.areAnagrams(sameString1, sameString2));  // Expected: true

        // Case 3: Shuffled strings (anagrams)
        SortedString shuffledString1 = new SortedString("listen");
        SortedString shuffledString2 = new SortedString("silent");
        System.out.println("Shuffled strings (anagrams): " + 
                            AnagramUtil.areAnagrams(shuffledString1, shuffledString2));  // Expected: true

        // Case 4: Two different strings
        SortedString differentString1 = new SortedString("cat");
        SortedString differentString2 = new SortedString("dog");
        System.out.println("Two different strings: " + 
                            AnagramUtil.areAnagrams(differentString1, differentString2));  // Expected: false

        // Case 5: Case-insensitive comparison
        SortedString caseInsensitive1 = new SortedString("Listen");
        SortedString caseInsensitive2 = new SortedString("Silent");
        System.out.println("Case-insensitive comparison: " + 
                            AnagramUtil.areAnagrams(caseInsensitive1, caseInsensitive2));  // Expected: true

        System.out.println("_________________________________________________________________________________");

     // Testing InsertionSort with SortedString
        InsertionSort<SortedString> insertionSortString = new InsertionSort<>();

        // Test Case 1: A list with one element
        SortedString[] singleElementArray = { new SortedString("apple") };
        SortedString[] sortedSingleElement = insertionSortString.sort(singleElementArray);
        System.out.println("Test Case 1 - Single Element Array: " + Arrays.toString(sortedSingleElement)); // Expected: [apple]

        // Test Case 2: A list with two elements (unsorted)
        SortedString[] twoElementArrayUnsorted = { new SortedString("banana"), new SortedString("apple") };
        SortedString[] sortedTwoElementUnsorted = insertionSortString.sort(twoElementArrayUnsorted);
        System.out.println("Test Case 2 - Two Element Array (Unsorted): " + Arrays.toString(sortedTwoElementUnsorted)); // Expected: [apple, banana]

        // Test Case 3: A list with two elements (sorted)
        SortedString[] twoElementArraySorted = { new SortedString("apple"), new SortedString("banana") };
        SortedString[] sortedTwoElementSorted = insertionSortString.sort(twoElementArraySorted);
        System.out.println("Test Case 3 - Two Element Array (Sorted): " + Arrays.toString(sortedTwoElementSorted)); // Expected: [apple, banana]

        // Test Case 4: A sorted list of strings
        SortedString[] sortedList = { new SortedString("apple"), new SortedString("banana"), new SortedString("cherry") };
        SortedString[] sortedListOutput = insertionSortString.sort(sortedList);
        System.out.println("Test Case 4 - Sorted List: " + Arrays.toString(sortedListOutput)); // Expected: [apple, banana, cherry]
        
        // Test Case 5: A reversed list of strings
        SortedString[] reversedList = { new SortedString("cherry"), new SortedString("banana"), new SortedString("apple") };
        SortedString[] sortedReversedList = insertionSortString.sort(reversedList);
        System.out.println("Test Case 5 - Reversed List: " + Arrays.toString(sortedReversedList)); // Expected: [apple, banana, cherry]

        // Test Case 6: A list with duplicate strings
        SortedString[] duplicateList = { new SortedString("banana"), new SortedString("apple"), new SortedString("banana") };
        SortedString[] sortedDuplicateList = insertionSortString.sort(duplicateList);
        System.out.println("Test Case 6 - Duplicate List: " + Arrays.toString(sortedDuplicateList)); // Expected: [apple, banana, banana]
   
	
	
	System.out.println("_________________________________________________________________________________");
	
//testing predicting runtime for insertion sort
	
	 // Create an instance of InsertionSort
    InsertionSort<Integer> sorter = new InsertionSort<>();

    // Create a small array to fit the constant c
    Integer[] smallArray = {5, 3, 8, 6, 2, 7, 4, 1, 9, 0};

    // Fit the sorter using the small array to calculate constant c
    sorter.fit(smallArray);

    // Predict the time for sorting a larger array, e.g., 100,000 elements
    double predictedTime100K = sorter.predict(100000);
    System.out.println("Predicted time for sorting 100K elements: " + predictedTime100K + " microseconds");

    // Predict the time for sorting an even larger array, e.g., 1,000,000 elements
    double predictedTime1M = sorter.predict(1000000);
    System.out.println("Predicted time for sorting 1M elements: " + predictedTime1M + " microseconds");

	
    
    
    
    /////////////////////////////////////////////////
    //String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
    //`System.out.println("Largest Anagram Group: " + Arrays.toString(largestAnagramGroup));
    
    String[] largestAnagramGroup = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
    System.out.println("Largest Anagram Group: " + Arrays.toString(largestAnagramGroup));

System.out.println("_________________________________________________________________________________");    
MergeSort<Integer> mergeSorter = new MergeSort<>();
    
    // Example array of 10 elements
    Integer[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
    
    // Fit the model (calculate constant c)
    mergeSorter.fit(array);
    
    // Predict time for a larger array (e.g., size 100,000)
    System.out.println("Predicted time for 100,000 elements: " + mergeSorter.predict(100000) + " microseconds");
    
    // Predict time for a larger array (e.g., size 1,000,000)
    System.out.println("Predicted time for 1,000,000 elements: " + mergeSorter.predict(1000000) + " microseconds");
    
    
    
	}
    }


