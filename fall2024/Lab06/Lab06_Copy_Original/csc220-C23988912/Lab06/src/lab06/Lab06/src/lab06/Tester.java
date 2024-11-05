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
		SortedString firstString = new SortedString("vitamin");
		SortedString secondString = new SortedString("rockets");
		SortedString thirdString = new SortedString("rockets");
		SortedString fourthString = new SortedString("");
		SortedString fifthString = new SortedString("stekcor");
		SortedString sixthString = new SortedString("tSeKcOR");
		SortedString sventhString = new SortedString("");
		System.out.println("orginal: " + firstString.getUnsorted());
		System.out.println("sorted: " + firstString.getSorted());
		System.out.println("Compare " + firstString.compareTo(secondString));
		boolean result1 = AnagramUtil.areAnagrams(firstString, secondString);
		boolean result2 = AnagramUtil.areAnagrams(thirdString, secondString);
		boolean result3 = AnagramUtil.areAnagrams(thirdString, fifthString);
		boolean result4 = AnagramUtil.areAnagrams(fifthString, sixthString);
		boolean result5 = AnagramUtil.areAnagrams(fourthString, sixthString);
		boolean result6 = AnagramUtil.areAnagrams(fourthString, sventhString);
		System.out.println("Are anagrams: " + result1);
		System.out.println("Are anagrams: " + result2);
		System.out.println("Are anagrams: " + result3);
		System.out.println("Are anagrams: " + result4);
		System.out.println("Are anagrams: " + result5);
		System.out.println("Are anagrams: " + result6);
		

        Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Integer Array: " + Arrays.toString(intArray));
        
     
        InsertionSort<Integer> sorter = new InsertionSort<>();
        Integer[] sortedIntArray = sorter.sort(intArray);
        System.out.println("Sorted Integer Array: " + Arrays.toString(sortedIntArray));
        
       
        String[] strArray = {"banana", "apple", "orange", "grape", "pear"};
        System.out.println("\nOriginal String Array: " + Arrays.toString(strArray));
        

        InsertionSort<String> stringSorter = new InsertionSort<>();
        String[] sortedStrArray = stringSorter.sort(strArray);
        System.out.println("Sorted String Array: " + Arrays.toString(sortedStrArray));
        SortedString[] stringArray = SortedString.toSortedString(new String[]{"listen", "silent", "enlist", "inlets", "google", "gogole",
        	    "evil", "vile", "veil", "live", "dusty", "study",
        	    "night", "thing", "brag", "grab", "race", "care", "acre",
        	    "angel", "glean", "angle", "bored", "robed", "drawer",
        	    "reward", "redraw", "dear", "read", "dare", "wear", "ware",
        	    "rat", "tar", "art", "elbow", "below", "state", "taste",
        	    "tea", "eat", "ate", "item", "time", "mite", "emit"});
        
        Integer[] emptyArray = {};
        System.out.println("\nOriginal Empty Array: " + Arrays.toString(emptyArray));
        Integer[] sortedEmptyArray = sorter.sort(emptyArray);
        System.out.println("Sorted Empty Array: " + Arrays.toString(sortedEmptyArray));
        

        Integer[] singleElementArray = {42};
        System.out.println("\nOriginal Single Element Array: " + Arrays.toString(singleElementArray));
        Integer[] sortedSingleElementArray = sorter.sort(singleElementArray);
        System.out.println("Sorted Single Element Array: " + Arrays.toString(sortedSingleElementArray));
        
   
        Integer[] alreadySortedArray = {1, 2, 3, 4, 5};
        System.out.println("\nOriginal Already Sorted Array: " + Arrays.toString(alreadySortedArray));
        Integer[] sortedAlreadySortedArray = sorter.sort(alreadySortedArray);
        System.out.println("Sorted Already Sorted Array: " + Arrays.toString(sortedAlreadySortedArray));
        
     
        Integer[] reverseSortedArray = {5, 4, 3, 2, 1};
        System.out.println("\nOriginal Reverse Sorted Array: " + Arrays.toString(reverseSortedArray));
        Integer[] sortedReverseSortedArray = sorter.sort(reverseSortedArray);
        System.out.println("Sorted Reverse Sorted Array: " + Arrays.toString(sortedReverseSortedArray));
        
        Integer[] smallArray = new Integer[1000];
        for (int i = 0; i < smallArray.length; i++) {
            smallArray[i] = (int) (Math.random() * 1000);
        }

        System.out.println("Running fit() with a small array of size 1000...");
        sorter.fit(smallArray); 

       
        int largeSize1 = 100000; 
        int largeSize2 = 1000000; 
        double predictedTime1 = sorter.predict(largeSize1);
        double predictedTime2 = sorter.predict(largeSize2);

        System.out.println("\nPredicted time to sort an array of size " + largeSize1 + ": " + predictedTime1 + " microseconds");
        System.out.println("Predicted time to sort an array of size " + largeSize2 + ": " + predictedTime2 + " microseconds");
        
        Integer[] largeArray = new Integer[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (int) (Math.random() * 10000);
        }
        System.out.println("\nTesting Large Array (size 10,000)...");
        long startTime = System.nanoTime();
        sorter.sort(largeArray);
        long endTime = System.nanoTime();
        System.out.println("Time taken to sort large array: " + (endTime - startTime) / 1000000.0 + " milliseconds");
        System.out.println("\nAssignment Part 1 Testing AnagramUtil getLargestAnagramGroup");

        String[] largestGroup = AnagramUtil.getLargestAnagramGroup(stringArray);

        System.out.println("Largest anagram group: " + Arrays.toString(largestGroup));
        MergeSort<SortedString> mergeSort = new MergeSort<>();

        System.out.println("Original: " + Arrays.toString(stringArray));

        SortedString[] mergeSortedArray = mergeSort.sort(stringArray);

        System.out.println("Sorted using MergeSort: " + Arrays.toString(mergeSortedArray));


        mergeSort.fit(stringArray);

        System.out.println("MergeSort: " + mergeSort.predict(100) + " microseconds");
        System.out.println("MergeSort: " + mergeSort.predict(1000) + " microseconds");
        testBasicAnagrams();

        // Section 2: Sorting Tests
        testSortingAlgorithms();

        // Section 3: Anagram Grouping Tests
        testAnagramGrouping();

        // Section 4: Performance Prediction Tests
        testPerformancePrediction();

        // Section 5: Testing with sample_word_list.txt
        testWithSampleFile();
    }

    /**
     * Section 1: Basic Anagram Tests
     */
    private static void testBasicAnagrams() {
        System.out.println("=== Section 1: Basic Anagram Tests ===");
        
        SortedString str1 = new SortedString("listen");
        SortedString str2 = new SortedString("silent");
        SortedString str3 = new SortedString("enlist");
        SortedString str4 = new SortedString("inlets");
        SortedString str5 = new SortedString("google");

        // Test if str1 and str2 are anagrams
        boolean test1 = AnagramUtil.areAnagrams(str1, str2);
        System.out.println("Are \"" + str1.getUnsorted() + "\" and \"" + str2.getUnsorted() + "\" anagrams? " + test1); // Expected: true

        // Test if str1 and str3 are anagrams
        boolean test2 = AnagramUtil.areAnagrams(str1, str3);
        System.out.println("Are \"" + str1.getUnsorted() + "\" and \"" + str3.getUnsorted() + "\" anagrams? " + test2); // Expected: true

        // Test if str1 and str5 are anagrams
        boolean test3 = AnagramUtil.areAnagrams(str1, str5);
        System.out.println("Are \"" + str1.getUnsorted() + "\" and \"" + str5.getUnsorted() + "\" anagrams? " + test3); // Expected: false

        System.out.println();
    }

    /**
     * Section 2: Sorting Tests
     */
    private static void testSortingAlgorithms() {
        System.out.println("=== Section 2: Sorting Tests ===");

        // Test InsertionSort with Integer Array
        Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Integer Array: " + Arrays.toString(intArray));
        InsertionSort<Integer> insertionSorter = new InsertionSort<>();
        Integer[] sortedIntArray = insertionSorter.sort(intArray);
        System.out.println("Sorted Integer Array (InsertionSort): " + Arrays.toString(sortedIntArray));

        // Test MergeSort with String Array
        String[] strArray = {"banana", "apple", "orange", "grape", "pear"};
        System.out.println("Original String Array: " + Arrays.toString(strArray));
        MergeSort<String> mergeSorter = new MergeSort<>();
        String[] sortedStrArray = mergeSorter.sort(strArray);
        System.out.println("Sorted String Array (MergeSort): " + Arrays.toString(sortedStrArray));

        System.out.println();
    }

    /**
     * Section 3: Anagram Grouping Tests
     */
    private static void testAnagramGrouping() {
        System.out.println("=== Section 3: Anagram Grouping Tests ===");

        String[] words = {"listen", "silent", "enlist", "inlets", "google", "gogole",
                         "evil", "vile", "veil", "live", "dusty", "study",
                         "night", "thing", "brag", "grab", "race", "care", "acre",
                         "angel", "glean", "angle", "bored", "robed", "drawer",
                         "reward", "redraw", "dear", "read", "dare", "wear", "ware",
                         "rat", "tar", "art", "elbow", "below", "state", "taste",
                         "tea", "eat", "ate", "item", "time", "mite", "emit"};

        SortedString[] sortedStrings = SortedString.toSortedString(words);
        String[] largestGroup = AnagramUtil.getLargestAnagramGroup(sortedStrings);
        System.out.println("Largest Anagram Group: " + Arrays.toString(largestGroup)); // Expected: ["listen", "silent", "enlist", "inlets"] or similar

        System.out.println();
    }

    /**
     * Section 4: Performance Prediction Tests
     */
    private static void testPerformancePrediction() {
        System.out.println("=== Section 4: Performance Prediction Tests ===");

        // Prepare a small array for InsertionSort
        Integer[] smallArray = new Integer[1000];
        for (int i = 0; i < smallArray.length; i++) {
            smallArray[i] = (int) (Math.random() * 1000);
        }

        InsertionSort<Integer> insertionSorter = new InsertionSort<>();
        System.out.println("Running fit() for InsertionSort with array size 1000...");
        insertionSorter.fit(smallArray);
        System.out.println("Predicted time to sort 100 elements: " + insertionSorter.predict(100) + " microseconds");
        System.out.println("Predicted time to sort 1000 elements: " + insertionSorter.predict(1000) + " microseconds");

        // Prepare a small array for MergeSort
        String[] sampleWords = {"listen", "silent", "enlist", "inlets", "google", "gogole",
                               "evil", "vile", "veil", "live", "dusty", "study",
                               "night", "thing", "brag", "grab", "race", "care", "acre",
                               "angel", "glean", "angle", "bored", "robed", "drawer",
                               "reward", "redraw", "dear", "read", "dare", "wear", "ware",
                               "rat", "tar", "art", "elbow", "below", "state", "taste",
                               "tea", "eat", "ate", "item", "time", "mite", "emit"};
        SortedString[] sortedStrings = SortedString.toSortedString(sampleWords);
        MergeSort<SortedString> mergeSorter = new MergeSort<>();
        System.out.println("Running fit() for MergeSort with array size " + sortedStrings.length + "...");
        mergeSorter.fit(sortedStrings);
        System.out.println("Predicted time to sort 100 elements using MergeSort: " + mergeSorter.predict(100) + " microseconds");
        System.out.println("Predicted time to sort 1000 elements using MergeSort: " + mergeSorter.predict(1000) + " microseconds");

        System.out.println();
    }

    /**
     * Section 5: Testing with sample_word_list.txt
     */
    private static void testWithSampleFile() {
        System.out.println("=== Section 5: Testing with sample_word_list.txt ===");

        String filename = "sample_word_list.txt"; // Ensure this file is in the project root directory
        String[] largestGroup = AnagramUtil.getLargestAnagramGroup(filename);
        System.out.println("Largest Anagram Group from " + filename + ": " + Arrays.toString(largestGroup));

        System.out.println();


        }

}

