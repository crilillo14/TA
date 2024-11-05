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
		// Tests for part 1
		String unsortedTested1 = "laZy";
		SortedString testedString1 = new SortedString(unsortedTested1);
		System.out.println(testedString1);
		System.out.println(unsortedTested1);
		SortedString compareString = new SortedString("Azyl");
		System.out.println(testedString1.compareTo(compareString));
		// Testing AnagramUtil areAnagrams
		AnagramUtil checkedAnagrams = new AnagramUtil();
		System.out.println("Expected True: " + checkedAnagrams.areAnagrams(testedString1, compareString));
		compareString = new SortedString("lacz");
		System.out.println("Expected False: " + checkedAnagrams.areAnagrams(testedString1, compareString));
		// Testing InsertionSort
		InsertionSort<SortedString> myInsertion = new InsertionSort<>();
		String[] myStrings = {"caT", "act", "baT", "far"};
		SortedString[] sortedStrings = SortedString.toSortedString(myStrings);
		
		SortedString[] result = myInsertion.sort(sortedStrings);
		for (int i = 0; i < result.length; i++) {
		    System.out.println(result[i]);
		}
		// Testing fits and predictions
		myInsertion.fit(sortedStrings);
		int n = sortedStrings.length;
		double bigO = myInsertion.O(n);
		System.out.println("Big O for n = " + n + ": " + bigO);
		int largerN = 100000;
		double predictedTime = myInsertion.predict(largerN);
		System.out.println("Prediction to sort array of size " + largerN + ": " + predictedTime + " microseconds");		
		
		
		System.out.println("Assignment Tests");
		String[] largestAnagramGroupFromFile = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		
		System.out.println("Largest anagram group from file: ");
		for (String word : largestAnagramGroupFromFile) {
		    System.out.println(word);
		}
		
		// 2) Testing Merge sort
		System.out.println("Testing MergeSort");
		MergeSort<SortedString> myMergeSort = new MergeSort<>();
		String[] mergeSortStrings = {"dog", "cat", "bat", "apple", "zebra", "fish"};
		SortedString[] sortedMergeStrings = SortedString.toSortedString(mergeSortStrings);
		
		// Sort using merge sort
		SortedString[] mergeSortedResult = myMergeSort.sort(sortedMergeStrings);
		System.out.println("Sorted strings using MergeSort:");
		for (SortedString s : mergeSortedResult) {
		    System.out.println(s);
		}
		
		// 3) MergeSort O(n)
		System.out.println("MergeSort O(n)");
		int nMergeSort = sortedMergeStrings.length;
		double bigOMerge = myMergeSort.O(nMergeSort);
		System.out.println("MergeSort O(n) for n = " + nMergeSort + ": " + bigOMerge);
		
		// 4) MergeSort fit() and predict()
		System.out.println("MergeSort fit ");
		myMergeSort.fit(sortedMergeStrings);
		
		System.out.println("MergeSort predict");
		int largerMergeN = 100000;
		double predictedMergeTime = myMergeSort.predict(largerMergeN);
		System.out.println("Prediction to sort array of size " + largerMergeN + ": " + predictedMergeTime + " microseconds");
		
		// Additional MergeSort tests:
		System.out.println("Extra Edge Case");
		
		// Test 1: A list with one word
		System.out.println("Test 1: A list with one word");
		String[] oneWordArray = {"apple"};
		SortedString[] sortedOneWordArray = SortedString.toSortedString(oneWordArray);
		SortedString[] resultOneWordArray = myMergeSort.sort(sortedOneWordArray);
		System.out.println("Sorted array (one word): " + resultOneWordArray[0]);
		
		// Test 2: A list with two words
		System.out.println("Test 2: A list with two words");
		String[] twoWordArray = {"banana", "apple"};
		SortedString[] sortedTwoWordArray = SortedString.toSortedString(twoWordArray);
		SortedString[] resultTwoWordArray = myMergeSort.sort(sortedTwoWordArray);
		System.out.println("Sorted array (two words): " + resultTwoWordArray[0] + ", " + resultTwoWordArray[1]);

	}

}

