package lab06;

public class Tester {

	// You will need to write your own tests

	/*
	 * As a reminder these are the methods we did in lab: 1.1) SortedString
	 * Constructor 1.2) SortedString compareTo(SortedString other) 2) AnagramUtil
	 * areAnagrams(SortedString str1, SortedString str2) 3) InsertionSort sort(E[]
	 * array) (HINT: use the toSortedString() convenience function from
	 * SortedString) 4.1, 4.2, 4.3) InsertionSort O(int n), fit(E[] array), and
	 * predict(int n)
	 */

	/*
	 * As a reminder these are the methods we did in assignment: 1) AnagramUtil
	 * getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use
	 * getLargestAnagramGroup(String filename)) 2) MergeSort sort(E[] array1, E[]
	 * array2, int first, int last) (Hint: You can use sort(E[] array)) 3.1, 3.2,
	 * 3.3) MergeSort O(int n), fit(E[] array), and predict(int n)
	 */

	public static void main(String[] args) {
		
		//*******************************************************************8

		// Sorted String Testing
		
		SortedString string1 = new SortedString("blazer");
		SortedString string2 = new SortedString("care");
		SortedString string3 = new SortedString("race");
		SortedString string4 = new SortedString("zelarb");
		SortedString string5 = new SortedString("");
		
		System.out.println("String 1: " + string1);
		System.out.println("String 2: " + string2);
		System.out.println("String 3: " + string3);
		System.out.println("String 4: " + string4);
		System.out.println("String 5: " + string5);
		
		// Compare
		System.out.println(string1.compareTo(string4) == 0);
		System.out.println(string4.compareTo(string1) == 0);
		System.out.println(string2.compareTo(string3) == 0);
		System.out.println(string1.compareTo(string5) == 0);

		// Anagram Testing
		System.out.println(AnagramUtil.areAnagrams(string4, string1));
		System.out.println(AnagramUtil.areAnagrams(string1, string1));
		System.out.println(AnagramUtil.areAnagrams(string2, string3));
		System.out.println(AnagramUtil.areAnagrams(string1, string5));

		// Insertion Sort Testing
		InsertionSort <Double> numberSorter = new InsertionSort();
		InsertionSort <SortedString> stringSorter = new InsertionSort();
		
		Double[] array1 = {};
		Double[] array2 = {1.0, 0.0};
		Double[] array3 = {1.4, -0.9, 5.0, 1.2, 4.3, 67.0, -23.4};
		Double[] array4 = {9.23, -235.5, 9.43, 999999.9, -0.000003};
		Double[] array5 = {12.3, 43.5, 643.2, 234.5};
		
		array1 = numberSorter.sort(array1);
		array2 = numberSorter.sort(array2);
		array3 = numberSorter.sort(array3);
		array4 = numberSorter.sort(array4);
		array5 = numberSorter.sort(array5);
		
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < array3.length; i++) {
			System.out.print(array3[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < array4.length; i++) {
			System.out.print(array4[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < array5.length; i++) {
			System.out.print(array5[i] + " ");
		}
		System.out.println();
	
		String[] string101 = {"cat", "asd", "fox", "blaze", "go", "light", "nike"};
		SortedString[] string201 = SortedString.toSortedString(string101);

		string201 = stringSorter.sort(string201);
		
		for (int i = 0; i < string201.length; i++) {
			System.out.print(string201[i] + " ");
		}
		
		// Insertion runtime testing
		System.out.println("Insertion Sort runtime");
		System.out.println("Time for 1000: " + numberSorter.predict(10000));
		
		// Assignment testing
		
		String [] anagrams = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		
		for (int i = 0; i < anagrams.length; i++) {
			System.out.print(anagrams[i] + " ");
		}
		
		// MergeSort Testing
		MergeSort <Double> MergeSorter = new MergeSort();
		
		Double[] array6 = {};
		Double[] array7 = {1.0, 0.0};
		Double[] array8 = {1.4, -0.9, 5.0, 1.2, 4.3, 67.0, -23.4};
		Double[] array9 = {9.23, -235.5, 9.43, 999999.9, -0.000003};
		Double[] array10 = {12.3, 43.5, 643.2, 234.5};
		
		array6 = MergeSorter.sort(array1);
		array7 = MergeSorter.sort(array2);
		array8 = MergeSorter.sort(array3);
		array9 = MergeSorter.sort(array4);
		array10 = MergeSorter.sort(array5);
		
		for (int i = 0; i < array6.length; i++) {
			System.out.print(array6[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < array7.length; i++) {
			System.out.print(array7[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < array8.length; i++) {
			System.out.print(array8[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < array9.length; i++) {
			System.out.print(array9[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < array10.length; i++) {
			System.out.print(array10[i] + " ");
		}
		System.out.println();
		
		MergeSort<SortedString> mergeStringSorter = new MergeSort();
		String[] string301 = {"cat", "asd", "fox", "blaze", "go", "light", "nike"};
		SortedString[] string401 = SortedString.toSortedString(string301);
		
		string401 = mergeStringSorter.sort(string401);
		
		for (int i = 0; i < string401.length; i++) {
			System.out.print(string401[i] + " ");
		}
		
		mergeStringSorter.fit(string401);
		
		System.out.println("Merge Sort Runtime");
		System.out.println("Time for 1000: " + mergeStringSorter.predict(1000));
		
		System.out.println("All done");
		
	}
	
	
}
