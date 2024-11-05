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
		
		SortedString test1 = new SortedString("baton");
		System.out.println(test1);
		SortedString test2 = new SortedString("Notab");
		SortedString test3 = new SortedString("giraffe");
		System.out.println(test1.compareTo(test2));
		System.out.println(test1.compareTo(test3));
		
		SortedString test4 = new SortedString("");
		System.out.println("\n" + AnagramUtil.areAnagrams(test1, test2));
		System.out.println(AnagramUtil.areAnagrams(test1, test3));
		System.out.println(AnagramUtil.areAnagrams(test3, test4));
		System.out.println(AnagramUtil.areAnagrams(test2, test2) + "\n");
		
		String[] test5_Strings = {"Hello", "Goodbye", "University", "College", "Bat", "Tab", 
								  "Racecar", "Racecar", "Anatomy", "Motyana"};
		SortedString[] test5 = SortedString.toSortedString(test5_Strings);
		SortedString[] test6 = SortedString.toSortedString(new String[]{"Superhero"});
		SortedString[] test7 = SortedString.toSortedString(new String[]{"Not", "Bot"});
		Integer[] test8 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer[] test9 = {34, 45, 12, 89, 23, 67, 23, 68};
		
		InsertionSort<SortedString> insertionSortObject1 = new InsertionSort<SortedString>();
		InsertionSort<Integer> insertionSortObject2 = new InsertionSort<Integer>();

		System.out.println("Insertion Sort Tests: ");
		SortedString[] tempArray1 = insertionSortObject1.sort(test5);
		for (SortedString element : tempArray1) {
			System.out.println(element);
		}
		
		System.out.println();
		Integer[] tempArray2 = insertionSortObject2.sort(test9);
		for (Integer element : tempArray2) {
			System.out.println(element);
		}
		
		System.out.println("\nInsertion Sort Speed Tests: ");
		insertionSortObject1.fit(test5);
		System.out.println(insertionSortObject1.predict(500) + " microseconds.");
		System.out.println(insertionSortObject1.predict(5000) + " microseconds.");
		System.out.println(insertionSortObject1.predict(500000) + " microseconds.");
		

		/* 
		 * As a reminder these are the methods we did in assignment:
		 * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
		 * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
		 * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
		 */
	
		String[] test10_Strings = {"Hello", "Goodbye", "University", "College", "Bat", "Tab", "Atb", 
			                   "Racecar", "Racecar", "Anatomy", "Motyana"};
		SortedString[] test10 = SortedString.toSortedString(test10_Strings);
		String[] test10Anagrams = AnagramUtil.getLargestAnagramGroup(test10);
		System.out.println();
		for (String string : test10Anagrams) {
			System.out.print(string + " ");
		}
		System.out.println();
		String[] test11 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		for (String string : test11) {
			System.out.print(string + " ");
		}
		
		System.out.println("\n\nMerge Sort Tests: ");
		MergeSort<SortedString> mergeSortObject1 = new MergeSort<SortedString>();
		MergeSort<Integer> mergeSortObject2 = new MergeSort<Integer>();
		
		SortedString[] tempArray3 = mergeSortObject1.sort(test5);
		for (SortedString element : tempArray3) {
			System.out.println(element);
		}
		
		System.out.println();
		Integer[] tempArray4 = mergeSortObject2.sort(test9);
		for (Integer element : tempArray4) {
			System.out.println(element);
		}
		
		System.out.println("\nMerge Sort Speed Tests: ");
		mergeSortObject1.fit(test5);
		System.out.println(mergeSortObject1.predict(500) + " microseconds.");
		System.out.println(mergeSortObject1.predict(5000) + " microseconds.");
		System.out.println(mergeSortObject1.predict(500000) + " microseconds.");
	
	} // End of main method

}// End of class