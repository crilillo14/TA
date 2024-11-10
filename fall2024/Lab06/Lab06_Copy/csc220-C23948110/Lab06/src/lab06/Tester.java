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
	//
	public static void main(String[] args) {

		SortedString sortedString1 = new SortedString("qwertyuiopasdfghjklzxcvbnm");
		System.out.println(sortedString1.getSorted());
		
		SortedString sortedString2 = new SortedString("bar");
		System.out.println(sortedString2.getSorted());
		
		SortedString sortedString3 = new SortedString("rat");
		System.out.println(sortedString3.getSorted());
		
		if (sortedString2.compareTo(sortedString3) < 0) {
			System.out.println(sortedString2.getSorted() + " < " + sortedString3.getSorted());
		} else if (sortedString2.compareTo(sortedString3) == 0) {
			System.out.println(sortedString2.getSorted() + " = " + sortedString3.getSorted());
		} else {
			System.out.println(sortedString2.getSorted() + " > " + sortedString3.getSorted());
		
		}
		
		//compareCheck(sortedString2, sortedString3);
		
		AnagramUtil anagramDetector = new AnagramUtil();
		SortedString str1 = new SortedString("");
		SortedString str2 = new SortedString("cat");
		SortedString str3 = new SortedString("cat");
		SortedString str4 = new SortedString("aCt");
		SortedString str5 = new SortedString("bat");
		if(anagramDetector.areAnagrams(str1, str2)) {
			System.out.println(str1.getUnsorted() + " & " + str2.getUnsorted() + " are anagrams!");
		} else {
			System.out.println(str1.getUnsorted() + " & " + str2.getUnsorted() + " are not anagrams.");
		}
		
		if(anagramDetector.areAnagrams(str2, str3)) {
			System.out.println(str2.getUnsorted() + " & " + str3.getUnsorted() + " are anagrams!");
		} else {
			System.out.println(str2.getUnsorted() + " & " + str3.getUnsorted() + " are not anagrams.");
		}
		
		if(anagramDetector.areAnagrams(str3, str4)) {
			System.out.println(str3.getUnsorted() + " & " + str4.getUnsorted() + " are anagrams!");
		} else {
			System.out.println(str3.getUnsorted() + " & " + str4.getUnsorted() + " are not anagrams.");
		}
		
		if(anagramDetector.areAnagrams(str4, str5)) {
			System.out.println(str4.getUnsorted() + " & " + str5.getUnsorted() + " are anagrams!");
		} else {
			System.out.println(str4.getUnsorted() + " & " + str5.getUnsorted() + " are not anagrams.");
		}
		
		
		//-----InsertionSort Tests:
		InsertionSort<String> insertionSorter = new InsertionSort<String>();
		String[] stringsList = {"caT", "act", "baT", "car"};
		for (int i = 0; i < stringsList.length; i++) {
			System.out.print(stringsList[i] + " ");
		}
		System.out.println();
		
		String[] sortedStringsList = insertionSorter.sort(stringsList);
		for (int i = 0; i < sortedStringsList.length; i++) {
			System.out.print(sortedStringsList[i] + " ");
		}
		System.out.println();
		
		String [] strings1 = {"dog"};
		String[] sStrings1 = insertionSorter.sort(strings1);
		for (int i = 0; i < sStrings1.length; i++) {
			System.out.print(sStrings1[i] + " ");
		}
		System.out.println();
		
		
		InsertionSort<SortedString> insertionSorter1 = new InsertionSort<SortedString>();
		String[] stringsList1 = {"car", "act", "bat", "cat"};
		SortedString[] sortedStrings = SortedString.toSortedString(stringsList1);
		insertionSorter1.sort(sortedStrings);
		for (int i = 0; i < sortedStrings.length; i++) {
			System.out.print(sortedStrings[i] + " ");
		}
		System.out.println();
		
		
		InsertionSort<Integer> insertionSorter2 = new InsertionSort<Integer>();
		Integer[] numberList = {7, 0, 12, -3, -7, 16};
		for (int i = 0; i < numberList.length; i++) {
			System.out.print(numberList[i] + " ");
		}
		System.out.println();
		
		Integer[] sortedNumberList = insertionSorter2.sort(numberList);
		for (int i = 0; i < sortedNumberList.length; i++) {
			System.out.print(sortedNumberList[i] + " ");
		}
		System.out.println();
		System.out.println();
		//-----end of tests
		
		//------Testing fit & predict.
		Integer[] smallNumberList = {-27, 3, 95, -87, -86, 12, 13, 9, 0, 1};
		insertionSorter2.fit(smallNumberList);
		System.out.println();
		
		System.out.println("Prediction for n = 10: " + insertionSorter2.predict(10) + " microseconds");
		System.out.println("Prediction for n = 100000: " + insertionSorter2.predict(100000)+ " microseconds");
		System.out.println("Prediction for n = 1000000: " + insertionSorter2.predict(1000000) + " microseconds");
		System.out.println();
		System.out.println();
		//------------------------------------------------------------------------------------------------------
		
		//---------ASSIGNMENT TESTS
		System.out.println("ASSIGNMENT TESTS:");
    	//AnagramUtil myAnagrams = new AnagramUtil();
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		//System.out.println("Largest Anagrams Group: " + Arrays.toString(s3));
		System.out.print("Largest Anagrams Group: ");
		System.out.println(s3.length);
		for (int i = 0; i < s3.length; i++) {
			System.out.print(s3[i] + " ");
		}
		System.out.println("\n");
		//more tests???
		
		//-----MergeSort Tests
		MergeSort<String> mS1 = new MergeSort<String>();
		String[] list1 = {"Salad"};
		String[] mergeSorted1 = mS1.sort(list1);
		for (int i = 0; i < mergeSorted1.length; i++) {
			System.out.print(mergeSorted1[i] + " ");
		}
		System.out.println();
		
		String[] list2 = {"dog", "cat"};
		String[] mergeSorted2 = mS1.sort(list2);
		for (int i = 0; i < mergeSorted2.length; i++) {
			System.out.print(mergeSorted2[i] + " ");
		}
		System.out.println();
		
		
		
		MergeSort<Integer> mS2 = new MergeSort<Integer>();
		
		Integer[] list3 = {1, 2, 3, 4, 5, 9};
		Integer[] mergeSorted3 = mS2.sort(list3);
		for (int i = 0; i < mergeSorted3.length; i++) {
			System.out.print(mergeSorted3[i] + " ");
		}
		System.out.println();
		
		Integer[] list4 = {7, 0, 12, -3, -7, 16};
		Integer[] mergeSorted4 = mS2.sort(list4);
		for (int i = 0; i < mergeSorted4.length; i++) {
			System.out.print(mergeSorted4[i] + " ");
		}
		System.out.println();
		
		//------Testing fit & predict for MergeSort.
				Integer[] smallNumberList1 = {-27, 3, 95, -87, -86, 12, 13, 9, 0, 1};
				mS2.fit(smallNumberList1);
				System.out.println();
				
				System.out.println("Prediction for n = 10: " + mS2.predict(10) + " microseconds");
				System.out.println("Prediction for n = 100000: " + mS2.predict(100000)+ " microseconds");
				System.out.println("Prediction for n = 1000000: " + mS2.predict(1000000) + " microseconds");
				System.out.println();
				System.out.println();
		
	
	}
	
//	private static void compareCheck (SortedString s1, SortedString s2) {
//		if (s1.compareTo(s2) < 0) {
//			System.out.println(s1.getSorted() + " < " + s2.getSorted());
//		} else if (s1.compareTo(s2) == 0) {
//			System.out.println(s1.getSorted() + " = " + s2.getSorted());
//		} else {
//			System.out.println(s1.getSorted() + " > " + s2.getSorted());
//	}
	

    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */

	
}

