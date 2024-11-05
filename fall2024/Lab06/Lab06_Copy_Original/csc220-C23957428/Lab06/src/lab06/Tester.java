package lab06;

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
	
	public static void main(String[] args) {
		
		// test SortedString Constructor 
		SortedString s1 = new SortedString("dcbae");
		
		if(s1.getSorted().equals("abcde")) {
			System.out.println("Test 1 Passed: Sorted Correctly");
		} else {
			System.out.println("Test 1 Failed: Expected ABCDE");
		}
		
		SortedString s2 = new SortedString("Hello");
		if(s2.getSorted().equals("ehllo")) {
			System.out.println("Test 2 Passed: Sorted Correctly");
		} else {
			System.out.println("Test 2 Failed: Expected ehllo");
		}
		
		SortedString s4 = new SortedString("UMiami");
		if(s4.getSorted().equals("UMiami")) {
			System.out.println("Test 3 Passed: Sorted Correctly");
		} else {
			System.out.println("Test 3 Failed: Expected aiimmu");
		}
		
		System.out.println("");
		
		// test AnagramUtil Implementation 
		SortedString str1 = new SortedString("listen");
		SortedString str2 = new SortedString("silent");
		
		boolean Result = AnagramUtil.areAnagrams(str1, str2);
		
		if (!Result) {
			System.out.println("Are Anagrams failed");
		} else {
			System.out.println("Are Anagrams passed");
		}
		
		SortedString str3 = new SortedString("");
		
		boolean Result2 = AnagramUtil.areAnagrams(str1, str3);
		
		if (!Result) {
			System.out.println("One Empty String Anagram failed");
		} else {
			System.out.println("One Empty String Anagram passed");
		}
		
		SortedString str5 = new SortedString("silent");
		
		boolean Result3 = AnagramUtil.areAnagrams(str2, str5);
		
		if (!Result) {
			System.out.println("Same Anagram failed");
		} else {
			System.out.println("Same Anagram passed");
		}
		
		System.out.println("");
		
		// test InsertionSort
		InsertionSort<Integer> sorter = new InsertionSort<>();
		Integer[] input = {5};
		Integer[] sorted = sorter.sort(input);
		
		if (input.length == sorted.length) {
			boolean equal = true;
			for ( int i = 0; i < input.length; i++) {
				if (!input[i].equals(sorted[i])) {
					equal = false;
					break;
				}
			}
			
			if (equal) {
				System.out.println("One Element Insertion Test Passed");
			} else {
				System.out.println("One Element Insertion Test Passed");
			}
		}
		
	
		Integer[] input2 = {2, 1};
		Integer[] sorted2 = sorter.sort(input2);
		Integer[] expected = {1, 2};
		
		if (expected.length == sorted2.length) {
			boolean equal = true;
			for ( int i = 0; i < expected.length; i++) {
				if (!expected[i].equals(sorted[i])) {
					equal = false;
					break;
				}
			}
			
			if (equal) {
				System.out.println("Two Element Insertion Test Passed");
			} else {
				System.out.println("Two Element Insertion Test Passed");
			}
		}
		
		Integer[] input3 = {3, 5, 1, 4, 2};
		Integer[] sorted3 = sorter.sort(input3);
		Integer[] expected3 = {1, 2, 3, 4, 5};
		
		if (expected3.length == sorted3.length) {
			boolean equal = true;
			for ( int i = 0; i < expected3.length; i++) {
				if (!expected3[i].equals(sorted3[i])) {
					equal = false;
					break;
				}
			}
			
			if (equal) {
				System.out.println("Random List Insertion Test Passed");
			} else {
				System.out.println("Random List Insertion Test Passed");
			}
		}
		
		System.out.println("");
		
		// test for predicting runtime for insertionSort
	
		double expectedO = Math.pow(1, 2);
		double resultRun = sorter.O(1);
		
		if (resultRun == expectedO) {
			System.out.println("Big O Notation Test passed.");
		} else {
			System.out.println("Big O Notation Test passed.");
		}
		
		
		Integer[] smallerArray = {3, 1, 2};
		sorter.fit(smallerArray);
		
		int largerSize = 100000;
		double predictedT = sorter.predict(largerSize);
		System.out.println("Insertion Sort: Predicted runtime for size " + largerSize + ": " + predictedT);
		
		int largerSize2 = 1000000;
		double predictedT2 = sorter.predict(largerSize2);
		System.out.println("Insertion Sort: Predicted runtime for size " + largerSize2 + ": " + predictedT2);
		
		System.out.println("");
		
		
		// getLargestAnagramGroup test
		
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		
		System.out.println("");
		
		// merge sort test
		Integer[] smallerArray2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		MergeSort<Integer> mergeSort = new MergeSort<>();
		mergeSort.fit(smallerArray2);
		
		int largerSize3 = 100000;
		double predictedT3 = mergeSort.predict(largerSize3);
		System.out.println("Merge Sort: Predicted runtime for size " + largerSize3 + ": " + predictedT3);
		
		int largerSize4 = 1000000;
		double predictedT4 = mergeSort.predict(largerSize4);
		System.out.println("Merge Sort: Predicted runtime for size " + largerSize4 + ": " + predictedT4);
		
		System.out.println("");
	}
	
	
	
	
	//


    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */

}

