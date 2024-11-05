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
		
		/*
		 * LAB TESTS
		 */
		
		// PART 1 Tests
		SortedString ss1 = new SortedString("alert");
		SortedString ss2 = new SortedString("Alter");
		
		if (ss1.compareTo(ss2) != 0)
			System.err.println("TEST 1 ERROR: compareTo");
		
		SortedString ss3 = new SortedString("albert");
		
		if (ss1.compareTo(ss3) == 0)
			System.err.println("TEST 2 ERROR: compareTo");
		
		// PART 2 Tests
		SortedString ss4 = new SortedString("");
		
		if (AnagramUtil.areAnagrams(ss3, ss4))
			System.err.println("TEST 3 ERROR: areAnagrams");
		
		if (!AnagramUtil.areAnagrams(ss3, ss3))
			System.err.println("TEST 4 ERROR: areAnagrams");
		
		if (!AnagramUtil.areAnagrams(ss1, ss2))
			System.err.println("TEST 5 ERROR: areAnagrams");
		
		if (AnagramUtil.areAnagrams(ss1, ss3))
			System.err.println("TEST 6 ERROR: areAnagrams");
		
		// PART 3 Tests
		InsertionSort<Integer> insertNumSort = new InsertionSort<Integer>();
		
		
		Integer[] numList1 = {1,5,2,9,10};
		Integer[] sortedNumList1 = insertNumSort.sort(numList1);
		for (int i = 1; i < sortedNumList1.length; i++) {
			if (!(sortedNumList1[i-1].compareTo(sortedNumList1[i]) <= 0)) {
				System.err.println("TEST 7 ERROR: Insertion Sort");
				break;
			}
		}
		
		Integer[] numList2 = {15};
		Integer[] sortedNumList2 = insertNumSort.sort(numList2);
		if (sortedNumList2.length != 1)
			System.err.println("TEST 8 ERROR: Insertion Sort");
		
		Integer[] numList3 = {};
		Integer[] sortedNumList3 = insertNumSort.sort(numList3);
		if (sortedNumList3.length != 0)
			System.err.println("TEST 9 ERROR: Insertion Sort");
		
		Integer[] numList4 = {45, 6};
		Integer[] sortedNumList4 = insertNumSort.sort(numList4);
		for (int i = 1; i < sortedNumList4.length; i++) {
			if (!(sortedNumList4[i-1].compareTo(sortedNumList4[i]) <= 0)) {
				System.err.println("TEST 10 ERROR: Insertion Sort");
				break;
			}
		}
		
		Integer[] numList5 = {1, 2, 3, 4};
		Integer[] sortedNumList5 = insertNumSort.sort(numList5);
		for (int i = 1; i < sortedNumList5.length; i++) {
			if (!(sortedNumList5[i-1].compareTo(sortedNumList5[i]) <= 0)) {
				System.err.println("TEST 11 ERROR: Insertion Sort");
				break;
			}
		}
		
		Integer[] numList6 = {17, 6, 20, 100, -8};
		Integer[] sortedNumList6 = insertNumSort.sort(numList6);
		for (int i = 1; i < sortedNumList6.length; i++) {
			if (!(sortedNumList6[i-1].compareTo(sortedNumList6[i]) <= 0)) {
				System.err.println("TEST 12 ERROR: Insertion Sort");
				break;
			}
		}
		
		InsertionSort<SortedString> insertSSSort = new InsertionSort<SortedString>();
		
		String[] strList1 = {"hello", "Goodbye", "sunshine", "MoonlighT"};
		SortedString[] ssList1 = SortedString.toSortedString(strList1);
		SortedString[] sortedSSList1 = insertSSSort.sort(ssList1);
		for (int i = 1; i < sortedSSList1.length; i++) {
			if (!(sortedSSList1[i-1].compareTo(sortedSSList1[i]) <= 0)) {
				System.err.println("TEST 13 ERROR: Insertion Sort");
				break;
			}
		}
		
		// PART 4 Tests
		boolean showRuntimeTests = true;
		
		
		String[] strList2 = new String[200];
		for (int i = 0; i < strList2.length; i++) {
			strList2[i] = String.valueOf(i);
		}
		SortedString[] ssList2 = SortedString.toSortedString(strList2);
		insertSSSort.fit(ssList2);
		
		if (showRuntimeTests)
			System.out.println("(Insertion Sort) n = 1M Estimate: " + insertSSSort.predict(1000000));
		
		/*
		 * ASSIGNMENT TESTS
		 */
		
		// PART 1 Tests
		
		String[] strList3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		for (int i = 0; i < strList3.length; i++)
			System.out.print(strList3[i] + " ");
		
		String[] strList4 = AnagramUtil.getLargestAnagramGroup("sample_word_list_2.txt");
		System.out.println();
		for (int i = 0; i < strList4.length; i++)
			System.out.print(strList4[i] + " ");
		
		String[] strList5 = AnagramUtil.getLargestAnagramGroup("sample_word_list_3.txt");
		System.out.println();
		for (int i = 0; i < strList5.length; i++)
			System.out.print(strList5[i] + " ");
		
		String[] strList6 = AnagramUtil.getLargestAnagramGroup("sample_word_list_4.txt");
		System.out.println();
		for (int i = 0; i < strList6.length; i++)
			System.out.print(strList6[i] + " ");
		
		// PART 2 Tests
		MergeSort<Integer> mergeNumSort = new MergeSort<Integer>();
		
		sortedNumList1 = mergeNumSort.sort(numList1);
		for (int i = 1; i < sortedNumList1.length; i++) {
			if (!(sortedNumList1[i-1].compareTo(sortedNumList1[i]) <= 0)) {
				System.err.println("TEST 14 ERROR: Merge Sort");
				break;
			}
		}
		
		sortedNumList2 = mergeNumSort.sort(numList2);
		if (sortedNumList2.length != 1)
			System.err.println("TEST 15 ERROR: Merge Sort");
		
		sortedNumList3 = mergeNumSort.sort(numList3);
		if (sortedNumList3.length != 0)
			System.err.println("TEST 16 ERROR: Merge Sort");
		
		sortedNumList4 = mergeNumSort.sort(numList4);
		for (int i = 1; i < sortedNumList4.length; i++) {
			if (!(sortedNumList4[i-1].compareTo(sortedNumList4[i]) <= 0)) {
				System.err.println("TEST 17 ERROR: Merge Sort");
				break;
			}
		}
		
		sortedNumList5 = mergeNumSort.sort(numList5);
		for (int i = 1; i < sortedNumList5.length; i++) {
			if (!(sortedNumList5[i-1].compareTo(sortedNumList5[i]) <= 0)) {
				System.err.println("TEST 18 ERROR: Merge Sort");
				break;
			}
		}
		
		sortedNumList6 = mergeNumSort.sort(numList6);
		for (int i = 1; i < sortedNumList6.length; i++) {
			if (!(sortedNumList6[i-1].compareTo(sortedNumList6[i]) <= 0)) {
				System.err.println("TEST 19 ERROR: Merge Sort");
				break;
			}
		}
		
		MergeSort<SortedString> mergeSSSort = new MergeSort<SortedString>();
		
		sortedSSList1 = mergeSSSort.sort(ssList1);
		for (int i = 1; i < sortedSSList1.length; i++) {
			if (!(sortedSSList1[i-1].compareTo(sortedSSList1[i]) <= 0)) {
				System.err.println("TEST 20 ERROR: Merge Sort");
				break;
			}
		}
		
		// PART 3 Tests
		
		mergeSSSort.fit(ssList2);
		
		if (showRuntimeTests)
			System.out.println("\n(Merge Sort) n = 1M Estimate: " + mergeSSSort.predict(1000000));
		
		
		
		System.out.println();
		System.out.println("Tests complete.");
	}

}

