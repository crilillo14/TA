package lab06;

import java.util.Arrays;


public class Tester {

    //You will need to write your own tests

    /* 
    * As a reminder these are the methods we did in lab:
    * 1.1) SortedString Constructor
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
		// 1
		SortedString empty = new SortedString("");
		SortedString s1 = new SortedString("cat");
	    SortedString s2 = new SortedString("car");
	    SortedString s3 = new SortedString("act");
	    SortedString s4 = new SortedString("late");
	    System.out.println(s1);
	    System.out.println(s1.compareTo(s3));	
	    System.out.println(s2.compareTo(s3));
	    System.out.println(s1.compareTo(s2));	
	    
	    // 2
	    System.out.println(AnagramUtil.areAnagrams(empty, s2));
	    System.out.println(AnagramUtil.areAnagrams(s1, s1));
	    System.out.println(AnagramUtil.areAnagrams(s1, s2));
	    System.out.println(AnagramUtil.areAnagrams(s1, s4));
	    
	    // 3
	    InsertionSort<Integer> insertionSort = new InsertionSort<>();

        // Insertion
        Integer[] randomArray = {3, 8, 1, 7, 4};
        System.out.println("\nOriginal array: " + Arrays.toString(randomArray));
        System.out.println("Sorted array: " + Arrays.toString(insertionSort.sort(randomArray)));
        insertionSort.fit(randomArray);
        System.out.println("\nPredicted time to sort an array size 100,000: " + insertionSort.predict(100000) + " microseconds");
        System.out.println("Predicted time to sort an array of size 1,000,000: " + insertionSort.predict(1000000) + " microseconds");
        
        //Merge
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] array = {5, 1, 9, 3, 7};
        System.out.println("\nOriginal array: " + Arrays.toString(array));
        Integer[] sortedArray = mergeSort.sort(array);
        System.out.println("MergeSort array: " + Arrays.toString(sortedArray));
        mergeSort.fit(array); 
        System.out.println("\nPredicted time to sort an array of size 100,000: " + mergeSort.predict(100000) + " microseconds");
        System.out.println("Predicted time to sort an array of size 1,000,000: " + mergeSort.predict(1000000) + " microseconds");

        //getLargestAnagramGroup
        String[] s8 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println("\nLargest group of anagrams from file: " + Arrays.toString(s8));


	}

}

