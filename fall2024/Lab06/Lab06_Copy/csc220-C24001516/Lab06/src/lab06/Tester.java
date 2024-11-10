package lab06;

import java.util.Iterator;

public class Tester {
	
	public static void main(String[] args) {
	    //You will need to write your own tests
		InsertionSort<SortedString> myInsertion = new InsertionSort();	
		MergeSort<SortedString> myMerge = new MergeSort();
		InsertionSort<Integer> myInsertion2 = new InsertionSort();
		MergeSort<Integer> myMerge2 = new MergeSort();
		String[] myStrings = {"caT", "act", "baT", "cAr", "hsu", "atb","sef","hls", "sLH","tab"};
		String[] predictStrings = new String[1000000];
		Integer[] myNumbers = {10, 3,56,2,0,1};
		
		SortedString mysort = new SortedString("1");
		SortedString[] mySortedStringList = mysort.toSortedString(myStrings);
		////////////////////////////////////////////////////////////////////////
		System.out.println("sortedString list: ");
		for (int i=0; i<mySortedStringList.length; i++) {
			System.out.println("index" + i +":  " + mySortedStringList[i].toString());	
		}
		////////////////////////////////////////////////////////////////////////
		System.out.println("insertion sortedInteger list: ");
		myNumbers = myInsertion2.sort(myNumbers);
		for (int i=0; i<myNumbers.length; i++) {
			System.out.println("index" + i +":  " + myNumbers[i].toString());	
		}
		////////////////////////////////////////////////////////////////////////
		System.out.println("merge sortedInteger list: ");
		myNumbers = myMerge2.sort(myNumbers);
		for (int i=0; i<myNumbers.length; i++) {
			System.out.println("index" + i +":  " + myNumbers[i].toString());	
		}
		////////////////////////////////////////////////////////////////////////
		
		myInsertion.fit(mySortedStringList);
		System.out.println("predict ms for insertionSort: " + myInsertion.predict(1000000));
		System.out.println("sorted list for insertionSort: ");
		
		SortedString[] insertionStringList = myInsertion.sort(mySortedStringList);
		for (int i=0; i<insertionStringList.length; i++) {
			System.out.println("index" + i +":  " + insertionStringList[i].toString());	
		}
		
		////////////////////////////////////////////////////////
		
		myMerge.fit(mySortedStringList);
		System.out.println("predict ms for mergeSort: " + myMerge.predict(1000000));
		System.out.println("sorted list for mergeSort: ");
		
		SortedString[] mergeStringList = myMerge.sort(mySortedStringList);
		for (int i=0; i<mergeStringList.length; i++) {
			System.out.println("index" + i +":  " + mergeStringList[i].toString());	
		}

		/////////////////////////////////////////////////////////
		AnagramUtil myAnagram = new AnagramUtil();
		String[] myGroup = myAnagram.getLargestAnagramGroup("sample_word_list.txt");
		System.out.println("the longest anagram group in file: " );	
		
		for(int i=0; i<myGroup.length;i++) {
			System.out.println("index" + i + " : " + myGroup[i]);	
		}
	}

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

}

