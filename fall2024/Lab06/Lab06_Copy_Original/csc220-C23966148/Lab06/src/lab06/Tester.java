package lab06;

import java.util.Arrays;

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
	
	
		 
		 
	SortedString sorted1 = new SortedString("cheater");
	
	SortedString sorted2 = new SortedString("teacher");
	
	//Test SortedSTring Constructor
	
	if(sorted1.getSorted().equals(sorted2.getSorted())) {
		
		System.out.println("SortedSTring Constructor: Pass");
		
	}
	
	else {
		
		System.out.println("SortedSTring Constructor: Failed");
		
	}
	
	//Test CompareTo
	if (sorted1.compareTo(sorted2) == 0) {
		
        System.out.println("Test CompareTo: passed");
        
    } 
	
	else {
        
		System.out.println("Test compareTo: failed");
    }
	
	//Test a word that's not an anagram
	
	SortedString sorted3 = new SortedString("hello");
	SortedString sorted4 = new SortedString("jello");

    if (sorted3.compareTo(sorted4) != 0) {
       
    	System.out.println("Test CompareTo passed: not anagrams");
    	
    } 
    
    else {
       
    	System.out.println("Test CompareTo failed: not anagrams");
    	
    }
    
    SortedString sorted5 = new SortedString("lion");   
    SortedString sorted6 = new SortedString("zebra");   
    SortedString sorted7 = new SortedString("lion");  

  
    int result1 = sorted5.compareTo(sorted6);
    if (result1 > 0) {
        System.out.println("compareTo test passed: +");
    } else {
        System.out.println("compareTo test failed:" + result1);
    }

  
    int result2 = sorted6.compareTo(sorted5);
    if (result2 < 0) {
        System.out.println("compareTo test passed: -");
    } else {
        System.out.println("compareTo test failed: " + result2);
    }

    int result3 = sorted5.compareTo(sorted7);
    if (result3 == 0) {
        System.out.println("compareTo test passed: 0");
    } else {
        System.out.println("compareTo test failed " + result3);
    }
    
    
	
    
    SortedString sorted8 = new SortedString("cheater");
    SortedString sorted9 = new SortedString("teacher");
    
    if (AnagramUtil.areAnagrams(sorted8, sorted9)) {
        System.out.println("Test passed: are anagrams");
    } else {
        System.out.println("Test failed: are anagrams");
    }

    SortedString sorted10 = new SortedString("hello");
    SortedString sorted11 = new SortedString("world");
    
    if (!AnagramUtil.areAnagrams(sorted10, sorted11)) {
        System.out.println("Test passed: non-anagram");
    } else {
        System.out.println("Test failed: non-anagram");
    }

    
    SortedString sorted12 = new SortedString("computer");
    SortedString sorted13 = new SortedString("computer");
    
    if (AnagramUtil.areAnagrams(sorted12, sorted13)) {
        System.out.println("Test passed: same word");
    } else {
        System.out.println("Test failed: same word");
    }

    SortedString sorted14 = new SortedString("");
    SortedString sorted15 = new SortedString("word");
    
    if (!AnagramUtil.areAnagrams(sorted14, sorted15)) {
        System.out.println("Test passed: empty string");
    } else {
        System.out.println("Test failed: empty string");
    }

 
    
    
    InsertionSort<Integer> sorter = new InsertionSort<>();

   
    Integer[] oneElement = {1};
    Integer[] sortedOneElement = sorter.sort(oneElement);
    System.out.println("Test One Element: " + Arrays.toString(sortedOneElement));

    Integer[] twoElementsSorted = {1, 2};
    Integer[] sortedTwoElementsSorted = sorter.sort(twoElementsSorted);
    System.out.println("Test Two Elements Sorted: " + Arrays.toString(sortedTwoElementsSorted));

    Integer[] elementsUnsorted = {2, 1};
    Integer[] sortedTwoElementsUnsorted = sorter.sort(elementsUnsorted);
    System.out.println("Test Elements Unsorted: " + Arrays.toString(sortedTwoElementsUnsorted));

    
    
    String[] sorted16 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");

    System.out.println("getLargestAnagram " + Arrays.toString(sorted16));

	
    SortedString[] emptyTest = new SortedString[]{};
    System.out.println(Arrays.toString(AnagramUtil.getLargestAnagramGroup(emptyTest))); 

    SortedString[] oneTest = new SortedString[]{new SortedString("class")};
    System.out.println(Arrays.toString(AnagramUtil.getLargestAnagramGroup(oneTest))); 


    Integer[] smallArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    
    Integer[] largeArray = new Integer[100000];
    Integer[] largerArray = new Integer[1000000];
    
    for (int i = 0; i < largeArray.length; i++) {
        largeArray[i] = largeArray.length - i;
    }
    
    for (int i = 0; i < largerArray.length; i++) {
        largerArray[i] = largerArray.length - i;
    }

   
    MergeSort<Integer> mergeSort = new MergeSort<>();
    mergeSort.fit(smallArray);
    System.out.println("MergeSort Time largeArray: " + mergeSort.predict(100000));
    System.out.println("MergeSort Time largerArray: " + mergeSort.predict(1000000));

    InsertionSort<Integer> insertionSort = new InsertionSort<>();
 
    insertionSort.fit(smallArray);
    System.out.println("InsertionSort Time largeArray:  " + insertionSort.predict(100000));
    System.out.println("InsertionSort Time largerArray: " + insertionSort.predict(1000000));

}
	 
	 
	 

}




