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
	
	

    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */
	
	public static void main(String[] args) {
		// Build some SortedString objects
		SortedString s0 = new SortedString("");
		SortedString s1 = new SortedString("tar");
		SortedString s2 = new SortedString("act");
		SortedString s3 = new SortedString("cat");
		SortedString s4 = new SortedString("rAt");
		
		System.out.println("1: " + s1 + " 2: " + s2 + " 3: " + s3 + " 4: " + s4 + "\n");
		
		// Compare
		if (s1.compareTo(s2) <= 0) {
			System.err.println("Error comparing strings that should be different");
		} if (s2.compareTo(s3) != 0) {
			System.err.println("Error comparing strings that should be equal");
		} if (s4.compareTo(s1) != 0) {
			System.err.println("Error comparing strings that should be equal");
		}
		
		// Test areAnagrams
		if (AnagramUtil.areAnagrams(s0, s1)) {
			System.err.println("Error areAnagrams of empty string and another string");
		} if (!AnagramUtil.areAnagrams(s1, s1)) {
			System.err.println("Error areAnagrams of same string");
		} if (!AnagramUtil.areAnagrams(s1, s4)) {
			System.err.println("Error areAnagrams of shuffled strings");
		} if (AnagramUtil.areAnagrams(s1, s3)) {
			System.err.println("Error areAnagram of different strings");
		}
		
		
		// Test InsertionSort
		InsertionSort<Double> I = new InsertionSort<Double>();
		InsertionSort<SortedString> I2 = new InsertionSort<SortedString>();
		
		Double[] arr0 = {1.0};
		Double[] arr1 = {1.0, -12.4};
		Double[] arr2 = {1.0, 2.4, 3.99, 5.2, 5.3, 9.23, 43.2};
		Double[] arr3 = {9.23, 3.99, 5.2, 1.0, 43.2, 2.4, 5.3};
		
		String[] strings = {"house", "mouse", "cat", "dog", "act", "rat", "tar", "god", "soume"};
		SortedString[] arr4 = SortedString.toSortedString(strings);
		
		arr0 = I.sort(arr0);
		arr1 = I.sort(arr1);
		arr2 = I.sort(arr2);
		arr3 = I.sort(arr3);
		arr4 = I2.sort(arr4);
		
		Double[][] doubleArrays = {arr0, arr1, arr2, arr3};
		for (int i = 0; i < doubleArrays.length; i++) {
			for (int j = 1; j < doubleArrays[i].length; j++) {
				if (doubleArrays[i][j] < doubleArrays[i][j-1]) {
					System.err.println("Error, double lists did not sort correctly (insertion sort)");
				}
			}
		}
		
		for (int i = 1; i < arr4.length; i++) {
			if (arr4[i].compareTo(arr4[i-1]) < 0) {
				System.err.println("Error, SortedString list did not sort correctly (insertion sort)");
			}
		}
		
		// Test Runtime Prediction
		Double[] arr5 = {9.23, 3.99, 5.2, 1.0, 43.2, 2.4, 5.3, 8.93, 5.32, 4.23, -1.34, 0.1, 34.9};
		
		I.fit(arr5);
		
		System.out.println("Insertion Sort Timing");
		System.out.println("Time for 1000: " + I.predict(1000) + " microseconds\nTime for 10000: " + I.predict(10000) + " microseconds\nTime for 100K: " + I.predict(100000) + " microseconds\nTime for 1M: " + I.predict(1000000) + " microseconds\n");
		
		
		// ASSIGNMENT TESTING
		
		// Test getLargestAnagramGroup
		String[] anagrams = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		
		String[] expected = {"carets", "Caters", "caster", "crates", "Reacts", "recast", "traces"};
		
		if (anagrams.length != expected.length) {
			System.err.println("Error getting largest anagram group from text file");
		} else {
			for (int i = 0; i < expected.length; i++) {
				if (!anagrams[i].equals(expected[i])) {
					System.err.println("Error getting largest anagram group from text file");
				}
			}
		}
		
		// Test empty file
		String[] anagrams2 = AnagramUtil.getLargestAnagramGroup("empty_text_file.txt");
		if (anagrams2.length != 0) {
			System.err.println("Error getting anagrams from empty file");
		}
		
		// Test file with one word
		String[] anagrams3 = AnagramUtil.getLargestAnagramGroup("one_word_file.txt");
		if (anagrams3.length != 0) {
			System.err.println("Error getting anagrams from a one-word file");
		}
		
		// Test file with no anagrams
		String[] anagrams4 = AnagramUtil.getLargestAnagramGroup("no_anagram_file.txt");
		if (anagrams4.length != 0) {
			System.err.println("Error getting anagrams from a no-anagram file");
		}
		
		// Test file where the largest group of anagrams is in the middle or end
		String[] anagrams5 = AnagramUtil.getLargestAnagramGroup("100_word_file.txt");
		System.out.println("Out of 100 words this was the largest anagram group:");
		for (int i = 0; i < anagrams5.length; i++) {
			if (i == anagrams5.length -1) {
				System.out.print(anagrams5[i]);
				break;
			}
			System.out.print(anagrams5[i] + ", ");
		}
		System.out.println("\n");
		
		// Test Merge Sort
		MergeSort<Double> M = new MergeSort<Double>();
		MergeSort<SortedString> M2 = new MergeSort<SortedString>();
		
		Double[] arr6 = {1.0};
		Double[] arr7 = {1.0, -12.4};
		Double[] arr8 = {1.0, 2.4, 3.99, 5.2, 5.3, 9.23, 43.2};
		Double[] arr9 = {9.23, 3.99, 5.2, 1.0, 43.2, 2.4, 5.3};
		
		String[] strings2 = {"house", "mouse", "cat", "dog", "act", "rat", "tar", "god", "soume"};
		SortedString[] arr10 = SortedString.toSortedString(strings2);
		
		arr6 = M.sort(arr6);
		arr7 = M.sort(arr7);
		arr8 = M.sort(arr8);
		arr9 = M.sort(arr8);
		arr10 = M2.sort(arr10);
		
		Double[][] doubleArrays2 = {arr6, arr7, arr8, arr9};
		for (int i = 0; i < doubleArrays2.length; i++) {
			for (int j = 1; j < doubleArrays[i].length; j++) {
				if (doubleArrays[i][j] < doubleArrays[i][j-1]) {
					System.err.println("Error, double lists did not sort correctly (merge sort)");
				}
			}
		}
		
		for (int i = 1; i < arr10.length; i++) {
			if (arr10[i].compareTo(arr10[i-1]) < 0) {
				System.err.println("Error, SortedString list did not sort correctly (merge sort)");
			}
		}
		
		// Test Runtime Prediction
		Double[] arr11 = {9.23, 3.99, 5.2, 1.0, 43.2, 2.4, 5.3, 8.93, 5.32, 4.23, -1.34, 0.1, 34.9};
		
		M.fit(arr11);
		
		System.out.println("Merge Sort Timing");
		System.out.println("Time for 1000: " + M.predict(1000) + " microseconds\nTime for 10000: " + M.predict(10000) + " microseconds\nTime for 100K: " + M.predict(100000) + " microseconds\nTime for 1M: " + M.predict(1000000) + " microseconds\n");

		System.out.println("All Done !");
		
		
	}

}

