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
		
		testSortedString();
		
		testAnagrams();
		
		testInsertionSort();
		
		testInsertionSortPredict();
		
		testLargestAnagram();
		
		testMergeSortPredict();
	}
		
		
		
		
	
	public static void testSortedString() {
		SortedString s1 = new SortedString("listen");
		SortedString s2 = new SortedString("silent");
		
	// Testing getSorted	
	if (!s1.getSorted().equals(s2.getSorted())) {
		System.out.println("Test Failed");
	} else {
		System.out.println("Testing Done.");
	}
	
	// Testing compareTo
	if (s1.compareTo(s2)!= 0) {
		System.out.println("Test Failed");
	} else {
		System.out.println("Testing Done.");
	}
	
	
	if (!s1.getSorted().equals("eilnst")) {
		System.out.println("Test Failed");
	} else {
		System.out.println("Testing Done.");
	}

	
	if (!s1.getUnsorted().equals("listen")) {
		System.out.println("Test Failed");
	} else {
		System.out.println("Testing Done.");
	}
	
	}

	// Testing AreAnagrams
	public static void testAnagrams() {
		SortedString s1 = new SortedString("Listen");
		SortedString s2 = new SortedString("Silent");
		SortedString s3 = new SortedString("Apple");
		
		if (!AnagramUtil.areAnagrams(s1,s2)) {
			System.out.println("Test Failed");
		} else {
			System.out.println("Testing Done.");
		}
		
	
		
		if (AnagramUtil.areAnagrams(s1,s3)) {
			System.out.println("Test Failed");
		} else {
			System.out.println("Testing Done.");
		}
		
	}
	

		
	public static void testInsertionSort() {
		
		InsertionSort<Integer> sortIntTest = new InsertionSort<>();
		
		Integer[] list1 = {1};
		Integer[] list2 = {1, 2};
		Integer[] list3 = {1,2,3,4,5};
		Integer[] list4 = {5,3,1,2,4};
		
		Integer[] sortedList1 = sortIntTest.sort(list1);
		Integer[] sortedList2 = sortIntTest.sort(list2);
		Integer[] sortedList3 = sortIntTest.sort(list3);
		Integer[] sortedList4 = sortIntTest.sort(list4);
		
		Integer[] anslist4 = {1,2,3,4,5};
		
		for(int i = 0; i < list1.length; i++)
		{
			if (!list1[i].equals(sortedList1[i])) {
				System.out.println("test Failed");
			}
		}
		
		for(int i = 0; i < sortedList2.length; i++)
		{
			if (!list2[i].equals(sortedList2[i])) {
				System.out.println("test Failed");
			}
			
		}
		
		for(int i = 0; i < list3.length; i++)
		{
			if (!list3[i].equals(sortedList3[i])) {
				System.out.println("test Failed");
			}
		}
		
		for(int i = 0; i < list4.length; i++)
		{
			if (!anslist4[i].equals(sortedList4[i])) {
				System.out.println("test Failed");
			}
		}
		
		
		
	}

	public static void testInsertionSortPredict() {
		InsertionSort<SortedString> sorter = new InsertionSort<>();
		String[] words = {"apple", "banana", "cherry"};
		SortedString[] sortedStrings = SortedString.toSortedString(words);

    
		sorter.fit(sortedStrings);

    
		double prediction = sorter.predict(1000);

	    if (prediction < Double.POSITIVE_INFINITY) {
	        System.out.println("Testing Done.");
	    } else {
	        System.out.println("Test Failed");
	    }
	}
	
	public static void testLargestAnagram() {
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		
		String testOutput = "";
		for(String s: s3) {
			testOutput+= s + " ";
		}
		
		if (testOutput.equals("carets Caters caster crates Reacts recast traces ")) {
			System.out.println("Testing Done.");
		}
		else {
			System.out.println("Testing failed.");
		}
		
		}
		
		
	public static void testMergeSortPredict() {
		MergeSort<SortedString> sorter = new MergeSort<>();
		String[] words = {"apple", "banana", "cherry"};
		SortedString[] sortedStrings = SortedString.toSortedString(words);

    
		sorter.fit(sortedStrings);

    
		double prediction = sorter.predict(1000);

	    if (prediction < Double.POSITIVE_INFINITY) {
	        System.out.println("Testing Done.");
	    } else {
	        System.out.println("Test Failed");
	    }
	}
	
	
    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */

}

