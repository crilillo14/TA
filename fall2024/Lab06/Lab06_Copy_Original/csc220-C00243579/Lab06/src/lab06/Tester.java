package lab06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.ArrayList;

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
	public static void main(String [] args) {	
		String temp_str1 = "Cat";
		System.out.println("** log 01 ** unsorted temp_str1 = " + temp_str1);
		SortedString temp_sorted_str1 = new SortedString(temp_str1);
		System.out.println("** log 05 ** sorted temp_str1 = " + temp_sorted_str1);
		
		String temp_str2 = "CAT";
		SortedString temp_sorted_str2 = new SortedString(temp_str2);
		System.out.println("** log 06 ** sorted temp_str2 = " + temp_sorted_str2);
		
		System.out.println("** log 07 ** compare sorted str1 to sorted str2 = " +
	                           temp_sorted_str1.compareTo(temp_sorted_str2));

		System.out.println("** log 10 ** Anagrams sorted str1, sorted str2 = " +
	                         (AnagramUtil.areAnagrams(temp_sorted_str1, temp_sorted_str2)));
		
		String[] temp_array_str1 = {"Cat", "car", "boy", "girl", "cow", "lamp", "van", "bus", "rat", "bet"};		
		System.out.print("** log 11 ** temp_array_str1 = "); 
		for (int i = 0; i < temp_array_str1.length; i++) {
			System.out.print(temp_array_str1[i] + " ");
		}
		System.out.println("");
		
		
		
		SortedString[] toSorted_str1 = SortedString.toSortedString(temp_array_str1);				
		System.out.print("** log 12 ** toSorted_str1 = "); 
		for (int i = 0; i < toSorted_str1.length; i++) {
			System.out.print(toSorted_str1[i] + " ");
		}
		System.out.println("");
		
		
		String[] temp_array_str2 = {"cat", "bat", "dog"};
		SortedString[] toSorted_str2 = SortedString.toSortedString(temp_array_str2);
		
		System.out.print("** log 15 ** temp_array_str2 = ");
		for (int i = 0; i < temp_array_str2.length; i++) {		 
			System.out.print(temp_array_str2[i] + " ");
		}
		System.out.println("");
		
		System.out.print("** log 16 ** toSorted_str2 = "); 
		for (int i = 0; i < toSorted_str2.length; i++) {
			System.out.print(toSorted_str2[i] + " ");
		}
		System.out.println("");
		
		InsertionSort<SortedString> temp_sort_array_str1 = new InsertionSort<SortedString>();
		SortedString[] sortedString1 = temp_sort_array_str1.sort(toSorted_str1);
		System.out.print("** log 17 ** sortedString1 = ");
		for (int i = 0; i < sortedString1.length; i++) {		 
			System.out.print(sortedString1[i].getSorted() + " ");
		}
		System.out.println("");
		
		InsertionSort<SortedString> temp_sort_array_str2 = new InsertionSort<SortedString>();
		SortedString[] sortedString2 = temp_sort_array_str2.sort(toSorted_str2);
		System.out.print("** log 18 ** sortedString2 = ");
		for (int i = 0; i < sortedString2.length; i++) {		 
			System.out.print(sortedString2[i].getSorted() + " ");
		}
		System.out.println("");
		
		temp_sort_array_str1.fit(toSorted_str1);
		double predict_time = temp_sort_array_str1.predict(sortedString1.length);
		System.out.println("** log 21 ** predict time for temp_sort_array_str1 = " + predict_time);
		
		Integer[] int_arr = new Integer[100];
		for (int i =100; i>0;i--) {
			int_arr[100-i]=i;
		}
		
		InsertionSort<Integer> is_ints = new InsertionSort<Integer>();
		is_ints.fit(int_arr);
		double is__int_predict_time = is_ints.predict(100);
		System.out.println("** log 21 ** predict time for temp_sort_array_str1 = " + is__int_predict_time);
		

    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */

		System.out.println("");			
		System.out.print("** log 31 ** list of s3 = ");
	    String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
	    for (int i = 0; i < s3.length; i++) {
	    	System.out.print(s3[i] + " ");
	    }
			
		/*******
		InsertionSort<SortedString> temp_sort_array_str1 = new InsertionSort<SortedString>();
		SortedString[] sortedString1 = temp_sort_array_str1.sort(toSorted_str1);
		System.out.print("** log 17 ** sortedString1 = ");
		for (int i = 0; i < sortedString1.length; i++) {		 
			System.out.print(sortedString1[i].getSorted() + " ");
		}
		System.out.println("");
		********/
	    	    
		System.out.println(" ");		
		MergeSort<SortedString> temp_merge_sort_array_str1 = new MergeSort<SortedString>();		
		SortedString[] mergeSortedString1 = temp_merge_sort_array_str1.sort(toSorted_str1);		
		System.out.print("** log 35 ** mergeSortedString1 = ");
		for (int i = 0; i < mergeSortedString1.length; i++) {		 
			System.out.print(mergeSortedString1[i].getSorted() + " ");
		}
		
		/*****
		temp_sort_array_str1.fit(toSorted_str1);
		double predict_time = temp_sort_array_str1.predict(sortedString1.length);
		System.out.println("** log 21 ** predict time for temp_sort_array_str1 = " + predict_time);
        *****/		
		
		System.out.println(" ");
		temp_merge_sort_array_str1.fit(toSorted_str1);
		double merge_predict_time = temp_merge_sort_array_str1.predict(mergeSortedString1.length);	
		System.out.println("** log 36 ** predict time for temp_merge_sort_array_str1 = " + merge_predict_time);
		
		MergeSort<Integer> ms_ints = new MergeSort<Integer>();
		ms_ints.fit(int_arr);
		double ms__int_predict_time = is_ints.predict(100);
		System.out.println("** log 36 ** predict time for temp_merge_sort_array_str1 = " + ms__int_predict_time);
	}
}

