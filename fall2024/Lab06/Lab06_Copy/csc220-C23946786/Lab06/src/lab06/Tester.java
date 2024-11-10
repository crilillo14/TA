package lab06;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Tester {

	// You will need to write your own tests

	public static void main(String[] args) {

		SortedString str1 = new SortedString("hello");
		SortedString str2 = new SortedString("world");
		System.out.println(str1.getUnsorted());
		System.out.println(str1.getSorted());
		System.out.println(str1.compareTo(str2));

		System.out.println(AnagramUtil.areAnagrams(str1, new SortedString("")));
		System.out.println(AnagramUtil.areAnagrams(str1, new SortedString("hello")));
		System.out.println(AnagramUtil.areAnagrams(str1, new SortedString("hElLo")));
		System.out.println(AnagramUtil.areAnagrams(str1, new SortedString("elloh")));
		System.out.println(AnagramUtil.areAnagrams(str1, new SortedString("world")));

		Integer[] array1 = { 1 };
		InsertionSort<Integer> sort = new InsertionSort();
		Integer[] sorted1 = sort.sort(array1);
		for (int i = 0; i < sorted1.length; i++) {

			System.out.println(sorted1[i]);

		}

		System.out.println();
		Integer[] array2 = { 2, 1 };
		Integer[] sorted2 = sort.sort(array2);
		for (int i = 0; i < sorted2.length; i++) {

			System.out.println(sorted2[i]);

		}

		System.out.println();
		Integer[] array3 = { 1, 2, 3 };
		Integer[] sorted3 = sort.sort(array3);
		for (int i = 0; i < sorted3.length; i++) {

			System.out.println(sorted3[i]);

		}

		System.out.println();
		Integer[] array4 = { 1, 5, 4, 6, 0 };
		Integer[] sorted4 = sort.sort(array4);
		for (int i = 0; i < sorted4.length; i++) {

			System.out.println(sorted4[i]);

		}
		
		System.out.println();
		Integer[] array5 = { 1, 5, 4, 6, 0, 2, 3, 5, 6, 3, 2, 3, 2, 5, 9, 0 };
		

		System.out.println();
		InsertionSort<SortedString> myInsertion = new InsertionSort();
		String[] myStrings = { "caT", "act", "baT", "car" };
		SortedString[] sortedStrings = SortedString.toSortedString(myStrings);

		for (int i = 0; i < sortedStrings.length; i++) {

			System.out.println(sortedStrings[i]);

		}
		
		System.out.println();
		SortedString[] sortedSortedStrings = myInsertion.sort(sortedStrings);

		for (int i = 0; i < sortedSortedStrings.length; i++) {

			System.out.println(sortedSortedStrings[i]);

		}
		
		System.out.println();
		
		sort.fit(array5);

		System.out.println(sort.predict(100_000));
		System.out.println(sort.predict(100_000_000));
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		System.out.println();
		for(int i = 0; i < s3.length; i++) {
			
			System.out.println(s3[i]);
			
		}
		
		String[] words2 = AnagramUtil.getLargestAnagramGroup("test1.txt");
		System.out.println(words2.length);
		
		String[] words3 = AnagramUtil.getLargestAnagramGroup("test2.txt");
		System.out.println(words3.length);
		
		String[] words4 = AnagramUtil.getLargestAnagramGroup("test3.txt");
		System.out.println(words4.length);
		
		String[] words5 = AnagramUtil.getLargestAnagramGroup("test4.txt");
		System.out.println();
		for(int i = 0; i < words5.length; i++) {
			
			System.out.println(words5[i]);
			
		}
		
		String[] words6 = AnagramUtil.getLargestAnagramGroup("test5.txt");
		System.out.println();
		for(int i = 0; i < words6.length; i++) {
			
			System.out.println(words6[i]);
			
		}
		
		System.out.println();
		
		MergeSort<Integer> m = new MergeSort();
		
		Integer[] test1 = {5, 4, 3, 2, 1, 0};
		Integer[] test1s = m.sort(test1);
		for(int i=0; i < test1s.length; i++){
		    System.out.println(test1s[i]);
		}
		
		System.out.println();
		
		Integer[] test2 = {5};
		Integer[] test2s = m.sort(test2);
		for(int i=0; i < test2s.length; i++){
		    System.out.println(test2s[i]);
		}
		
		System.out.println();
		
		Integer[] test3 = {5, 4};
		Integer[] test3s = m.sort(test3);
		for(int i=0; i < test3s.length; i++){
		    System.out.println(test3s[i]);
		}
		
		System.out.println();
		
		Integer[] test4 = {0, 1, 2, 3, 4, 5};
		Integer[] test4s = m.sort(test4);
		for(int i=0; i < test4s.length; i++){
		    System.out.println(test4s[i]);
		}
		
		System.out.println();
		
		Integer[] test5 = {4, 57, 4, 32, 2, 1, 04};
		Integer[] test5s = m.sort(test5);
		for(int i=0; i < test5s.length; i++){
		    System.out.println(test5s[i]);
		}
		
		System.out.println();
		
		Integer[] test6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		m.fit(test6);
		System.out.println(m.predict(1_000_000));
		
	}

	/*
	 * As a reminder these are the methods we did in lab: 1.1) SortedString
	 * Constuctor 1.2) SortedString compareTo(SortedString other) 2) AnagramUtil
	 * areAnagrams(SortedString str1, SortedString str2) 3) InsetionSort sort(E[]
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

}
