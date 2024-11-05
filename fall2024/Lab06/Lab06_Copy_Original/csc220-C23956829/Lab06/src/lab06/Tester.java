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
		
		//Test 1.1
		SortedString str1 = new SortedString("Alert");
		SortedString str2 = new SortedString("Later");
		SortedString str3 = new SortedString("Different");
		SortedString str4 = new SortedString("erlat");
		SortedString str5 = new SortedString("");
		
		System.out.println("Sorted: " + str1.getSorted() + " " + "Unsorted: " + str1.getUnsorted());
		System.out.println("Sorted: " + str2.getSorted() + " " + "Unsorted: " + str2.getUnsorted());
		System.out.println("Sorted: " + str3.getSorted() + " " + "Unsorted: " + str3.getUnsorted());
		System.out.println("Sorted: " + str4.getSorted() + " " + "Unsorted: " + str4.getUnsorted());
		System.out.println();
		
		//Test 1.2
		System.out.println("Comparing Alert with Later:" + str1.compareTo(str2));
		System.out.println("Comparing Alert with elhol:" + str1.compareTo(str4));
		System.out.println("Comparing Later with Differnt:" + str2.compareTo(str3));
		System.out.println();
		
		//Test 2.1
		System.out.println("Empty vs another string: " + AnagramUtil.areAnagrams(str5, str1));
        System.out.println("Exactly the same string: " + AnagramUtil.areAnagrams(str1, str1));  
        System.out.println("Shuffled strings: " + AnagramUtil.areAnagrams(str1, str4)); 
        System.out.println("Two differnt strings: " + AnagramUtil.areAnagrams(str1, str2));
        System.out.println();
        
        //Test 1.3
        InsertionSort<Integer> sorter = new InsertionSort<>();

        // Test with a list of one element
//        Integer[] singleElement = {42};
//        Integer[] sortedSingle = sorter.sort(singleElement);
//        System.out.println("Sorted single element: " + Arrays.toString(sortedSingle));
//
//        // Test with a list of two elements
//        Integer[] twoElements = {3, 1};
//        Integer[] sortedTwo = sorter.sort(twoElements);
//        System.out.println("Sorted two elements: " + Arrays.toString(sortedTwo));
//
//        // Test with a sorted list of numbers
//        Integer[] sortedList = {1, 2, 3, 4, 5};
//        Integer[] sortedSorted = sorter.sort(sortedList);
//        System.out.println("Sorted sorted list: " + Arrays.toString(sortedSorted));
//
//        // Test with a random list of numbers
//        Integer[] randomList = {5, 2, 9, 1, 5, 6};
//        Integer[] sortedRandom = sorter.sort(randomList);
//        System.out.println("Sorted random list: " + Arrays.toString(sortedRandom));
        
        Integer[] smallArray = {5, 3, 8, 1, 2};
        sorter.fit(smallArray);
        
        int largeSize = 100_000;
        double predictedTime = sorter.predict(largeSize);
        System.out.println("Predicted runtime for sorting " + largeSize + " elements: " + predictedTime + " microseconds");
        
        largeSize = 1_000_000;
        predictedTime = sorter.predict(largeSize);
        System.out.println("Predicted runtime for sorting " + largeSize + " elements: " + predictedTime + " microseconds");
        System.out.println();
        
        String[] anagrams = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println(Arrays.toString(anagrams));
        
        // 
        Integer[] numbers = {5, 3, 8, 1, 2};
        MergeSort<Integer> sorter1 = new MergeSort<>();
        
        sorter1.fit(numbers);
        Integer[] sortedNumbers = sorter1.sort(numbers);

        System.out.println("Sorted Numbers: " + Arrays.toString(sortedNumbers));
        System.out.println("Predicted time for sorting 1000 elements: " + sorter1.predict(1000) + " microseconds");

		
	}

}

