package lab06;

import java.util.Arrays;

public class Tester {
	
	public static void main(String[] args) {
		//testing sortedstring methods
		SortedString s1 = new SortedString("Hello");
		SortedString s2 = new SortedString("oellh");
		SortedString s3 = new SortedString("world");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareTo(s3));
		
		//testing areanagrams method
		SortedString s1anagrams = new SortedString("");
		SortedString s2anagrams = new SortedString("abc");
		System.out.println(AnagramUtil.areAnagrams(s1anagrams, s2anagrams));
		
		SortedString s3anagrams = new SortedString("abc");
		SortedString s4anagrams = new SortedString("abc");
		System.out.println(AnagramUtil.areAnagrams(s3anagrams, s4anagrams));
		
		SortedString s5anagrams = new SortedString("listen");
		SortedString s6anagrams = new SortedString("silent");
		System.out.println(AnagramUtil.areAnagrams(s5anagrams, s6anagrams));
		
		SortedString s7anagrams = new SortedString("hello");
		SortedString s8anagrams = new SortedString("world");
		System.out.println(AnagramUtil.areAnagrams(s7anagrams, s8anagrams));
		
		SortedString s9anagrams = new SortedString("Listen");
		SortedString s10anagrams = new SortedString("Silent");
		System.out.println(AnagramUtil.areAnagrams(s9anagrams, s10anagrams));
		
		//testing insertionsort
		InsertionSort<Integer> integerSorter = new InsertionSort<>();

        // Test 1: List with one element
        Integer[] oneElement = {42};
        Integer[] sortedOneElement = integerSorter.sort(oneElement);
        System.out.println("One element: " + Arrays.toString(sortedOneElement)); 

        // Test 2: List with two elements
        Integer[] twoElements = {5, 3};
        Integer[] sortedTwoElements = integerSorter.sort(twoElements);
        System.out.println("Two elements: " + Arrays.toString(sortedTwoElements)); 

        // Test 3: Sorted list of numbers
        Integer[] sortedNumbers = {1, 2, 3, 4, 5};
        Integer[] sortedSortedNumbers = integerSorter.sort(sortedNumbers);
        System.out.println("Sorted list: " + Arrays.toString(sortedSortedNumbers)); 

        // Test 4: Random list of numbers
        Integer[] randomNumbers = {9, 3, 7, 1, 5};
        Integer[] sortedRandomNumbers = integerSorter.sort(randomNumbers);
        System.out.println("Random list: " + Arrays.toString(sortedRandomNumbers)); 

        // Test InsertionSort<SortedString>
        String[] words = {"apple", "banana", "orange", "grape"};
        SortedString[] sortedWords = SortedString.toSortedString(words);
        InsertionSort<SortedString> sortedStringSorter = new InsertionSort<>();
        SortedString[] sortedSortedWords = sortedStringSorter.sort(sortedWords);
        System.out.println("Sorted strings: ");
        for (SortedString ss : sortedSortedWords) {
            System.out.println(ss);
        }
        
        //Testing sort time
        InsertionSort<Integer> sorter = new InsertionSort<>();

        // Test 1: Fit with a small array
        Integer[] smallArray = {9, 3, 7, 1, 5};
        sorter.fit(smallArray); // Calculate the constant c
        System.out.println("Fitted with small array");

        // Test 2: Predict time for sorting a large array (e.g., 100,000 elements)
        int largeSize = 100000;
        double predictedTime = sorter.predict(largeSize); // Predict the runtime for size 100k
        System.out.println("Predicted time for sorting " + largeSize + " elements: " + predictedTime + " microseconds");

        // Test 3: Predict time for sorting an even larger array (e.g., 1,000,000 elements)
        int veryLargeSize = 1000000;
        double predictedTimeForLarge = sorter.predict(veryLargeSize); // Predict runtime for size 1 million
        System.out.println("Predicted time for sorting " + veryLargeSize + " elements: " + predictedTimeForLarge + " microseconds");
        
        //testing assignment part 2
        String[] s3txtfile = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        
        if (s3txtfile.length > 0) {
        	System.out.println("Largest anagram group: ");
        	for (String word : s3txtfile) {
        		System.out.println(word);
        	}
        } else {
        	System.out.println("No anagram group found.");
        }
        
        //testing mergesort
        MergeSort<Integer> mergeSorter = new MergeSort<>();
       

        // Test 1: A list with one element
        Integer[] oneElementArray = {1};
        System.out.println("Test 1 - One element: " + Arrays.toString(sorter.sort(oneElementArray)));

        // Test 2: A list with two elements
        Integer[] twoElementArray = {2, 1};
        System.out.println("Test 2 - Two elements: " + Arrays.toString(sorter.sort(twoElementArray)));

        // Test 3: A sorted list of numbers
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        System.out.println("Test 3 - Already sorted: " + Arrays.toString(sorter.sort(sortedArray)));

        // Test 4: A random list of numbers
        Integer[] randomArray = {5, 3, 8, 6, 2, 7, 4, 1};
        System.out.println("Test 4 - Random order: " + Arrays.toString(sorter.sort(randomArray)));
        
        //testing runtime
        // Test 1: Fit with a small array of 10 elements
        Integer[] smallArray2 = {3, 5, 1, 7, 2, 9, 4, 6, 8, 0};
        mergeSorter.fit(smallArray2); // Calculate the constant c
        System.out.println("Fitted with small array");

        // Test 2: Predict time for sorting a large array (e.g., 100,000 elements)
        int largeSize2 = 100000;
        double predictedTime2 = mergeSorter.predict(largeSize); // Predict the runtime for size 100k
        System.out.println("Predicted time for sorting " + largeSize + " elements: " + predictedTime + " microseconds");

        // Test 3: Predict time for sorting an even larger array (e.g., 1,000,000 elements)
        int veryLargeSize2 = 1000000;
        double predictedTimeForLarge2 = mergeSorter.predict(veryLargeSize); // Predict runtime for size 1 million
        System.out.println("Predicted time for sorting " + veryLargeSize + " elements: " + predictedTimeForLarge + " microseconds");
    
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

}

