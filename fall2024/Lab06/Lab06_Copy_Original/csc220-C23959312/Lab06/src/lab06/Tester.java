package lab06;

import java.util.Random;
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
		SortedString test1 = new SortedString("aceGGGXBde");
		SortedString test2 = new SortedString("ceaXdeGGb");
		System.out.println(test1.getSorted());
		System.out.println(test1.compareTo(test2));
		System.out.println(test2.getSorted());
		AnagramUtil newtest = new AnagramUtil();
		System.out.println(newtest.areAnagrams(test1, test2));
		
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		
		for (int i = 0; i < s3.length; i++) {
            System.out.println( s3[i] + " ");
		}
		
		
		
		Integer[] singleElementList = {42};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        Integer[] sortedSingle = sorter.sort(singleElementList);
        System.out.println("Single Element List Sorted: " + Arrays.toString(sortedSingle));

        // Test InsertionSort with a list containing two elements
        Integer[] twoElementList = {5, 3};
        Integer[] sortedTwo = sorter.sort(twoElementList);
        System.out.println("Two Element List Sorted: " + Arrays.toString(sortedTwo));

        // Test InsertionSort with a sorted list of numbers
        Integer[] sortedList = {1, 2, 3, 4, 5};
        Integer[] sortedSortedList = sorter.sort(sortedList);
        System.out.println("Already Sorted List Sorted: " + Arrays.toString(sortedSortedList));

        // Test InsertionSort with a random list of numbers
        Integer[] randomList = generateRandomList(10);
        Integer[] sortedRandomList = sorter.sort(randomList);
        System.out.println("Random List Sorted: " + Arrays.toString(sortedRandomList));

        // Test InsertionSort<SortedString> using toSortedString()
        String[] stringArray = {"cat", "dog", "act", "god", "tac"};
        SortedString[] sortedStrings = SortedString.toSortedString(stringArray);
        InsertionSort<SortedString> stringSorter = new InsertionSort<>();
        SortedString[] sortedStringList = stringSorter.sort(sortedStrings);
        System.out.println("SortedStrings: " + Arrays.toString(sortedStringList));

        // Testing runtime prediction
        Integer[] smallArray = {1, 2, 3, 4, 5}; // small array for fit()
        sorter.fit(smallArray); // Fit the model with the small array

        // Predict runtime for a much larger size (e.g., 100K)
        int largeSize = 100_000_000; // Size for prediction
        double predictedTime = sorter.predict(largeSize);
        System.out.println("Predicted runtime for sorting " + largeSize + " elements: " + predictedTime + " microseconds");
        
        Integer[] singleElementList1 = {42};
        MergeSort<Integer> mergeSorter = new MergeSort<>();
        Integer[] sortedSingle1 = mergeSorter.sort(singleElementList1);
        System.out.println("Single Element List Sorted: " + Arrays.toString(sortedSingle1));

        // Test MergeSort with a list containing two elements
        Integer[] twoElementList1 = {5, 3};
        Integer[] sortedTwo1 = mergeSorter.sort(twoElementList1);
        System.out.println("Two Element List Sorted: " + Arrays.toString(sortedTwo1));

        // Test MergeSort with a sorted list of numbers
        Integer[] sortedList1 = {1, 2, 3, 4, 5};
        Integer[] sortedSortedList1 = mergeSorter.sort(sortedList1);
        System.out.println("Already Sorted List Sorted: " + Arrays.toString(sortedSortedList1));

        // Test MergeSort with a random list of numbers
        Integer[] randomList1 = generateRandomList2(10);
        Integer[] sortedRandomList1 = mergeSorter.sort(randomList1);
        System.out.println("Random List Sorted: " + Arrays.toString(sortedRandomList1));

        // Test MergeSort<SortedString> using toSortedString()
        String[] stringArray1 = {"cat", "dog", "act", "god", "tac"};
        SortedString[] sortedStrings1 = SortedString.toSortedString(stringArray1);
        MergeSort<SortedString> stringMergeSorter = new MergeSort<>();
        SortedString[] sortedStringList1 = stringMergeSorter.sort(sortedStrings1);
        System.out.println("SortedStrings: " + Arrays.toString(sortedStringList1));

        // Testing runtime prediction
        Integer[] smallArray1 = {1, 2, 3, 4, 5}; // small array for fit()
        mergeSorter.fit(smallArray1); // Fit the model with the small array

        // Predict runtime for a much larger size (e.g., 100K)
        int largeSize1 = 100_000; // Size for prediction
        double predictedTime1 = mergeSorter.predict(largeSize1);
        System.out.println("Predicted runtime for sorting " + largeSize1 + " elements: " + predictedTime1 + " microseconds");
    }
	

    // Helper method to generate a random array of integers
    private static Integer[] generateRandomList(int size) {
        Integer[] list = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list[i] = random.nextInt(100); // Random numbers between 0 and 99
        }
        return list;
    }
    
   

// Helper method to generate a random array of integers
private static Integer[] generateRandomList2(int size) {
    Integer[] list = new Integer[size];
    Random random = new Random();
    for (int i = 0; i < size; i++) {
        list[i] = random.nextInt(100); // Random numbers between 0 and 99
    }
    return list;
}
}

		
		
		



	




