package lab06;

//import java.util.Arrays; Used it to only see Array output easier in console

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
		
		
//		SortedString test1 = new SortedString("silent");
//		SortedString test2 = new SortedString("listen");
//		SortedString test3 = new SortedString("orange");
//		SortedString test4 = new SortedString("apple");
//		SortedString test5 = new SortedString(" ");
//		SortedString test6 = new SortedString("silent");
//		SortedString test7 = new SortedString("hat");
//		SortedString test8 = new SortedString("rat");
//		
//		
//		
//		
//		
//		System.out.println(test1);
//		System.out.println(test2);
//		
//		System.out.println(test1.compareTo(test2)); // Should be sorted the same, so 0
//		System.out.println(test7.compareTo(test8)); // Should be sorted different, so -  or +
//		
//		
//		AnagramUtil anagramTest = new AnagramUtil();
//		
//		
//		System.out.println(anagramTest.areAnagrams(test1, test6)); // exact same string
//		System.out.println(anagramTest.areAnagrams(test5, test2)); // empty vs string
//		System.out.println(anagramTest.areAnagrams(test1, test2)); // shuffled strings
//		
//		System.out.println(anagramTest.areAnagrams(test3, test4)); // Two different strings
		
		
//		InsertionSort<String> sorter = new InsertionSort<>();
//		
//		String [] array = {"cat", "hat", "rat", "pete", "frank", "ok"};
//		
//		// Organize array should be: ["cat", "frank", "hat", "ok", "pete", "rat"]
//		
//		String [] sorted = sorter.sort(array);
//		
//		for(String word: sorted) {
//			
//			System.out.println(word);
//			
//		}
//		
		
			
		
		InsertionSort<Integer> sorter = new InsertionSort<>();
		
        Integer[] array = {1, 10, 230, 340, 41};
        
        Integer [] sorted = sorter.sort(array);
        
		for(Integer word: sorted) {
		
		System.out.println(word);
		
	}
              
        sorter.fit(array);
        
        
       System.out.println(sorter.predict(1000));
       System.out.println(sorter.predict(1000000));
       System.out.println(sorter.predict(1000000000));
		
//		
//	        SortedString[] sortedString = AnagramUtil.readFile("sample_word_list.txt");
//
//		 String[] s3 = AnagramUtil.getLargestAnagramGroup(sortedString);
//		
//		 System.out.println("Largest Anagram Group:");
//	        for (String word : s3) {
//	            System.out.println(word);
//	        }
//	        
//	        
//	        
//	     // Test empty file
//	        String[] result1 = AnagramUtil.getLargestAnagramGroup("empty.txt");
//	        System.out.println("Result for empty file: " + Arrays.toString(result1));
//
//	        // Test one word file
//	        String[] result2 = AnagramUtil.getLargestAnagramGroup("one_word.txt");
//	        System.out.println("Result for one word file: " + Arrays.toString(result2));
//
//	        // Test no anagrams file
//	        String[] result3 = AnagramUtil.getLargestAnagramGroup("no_anagrams.txt");
//	        System.out.println("Result for no anagrams file: " + Arrays.toString(result3));
//
//	        // Test mixed anagrams file
//	        String[] result4 = AnagramUtil.getLargestAnagramGroup("mixed_anagrams.txt");
//	        System.out.println("Result for mixed anagrams file: " + Arrays.toString(result4));
	        
//		MergeSort<Integer> sorter = new MergeSort<>();
//
//        // Test case 1: A list with one element
//        Integer[] singleElementArray = {5};
//        System.out.println("Test 1 - Single Element: " + Arrays.toString(sorter.sort(singleElementArray)));
//
//        // Test case 2: A list with two elements
//        Integer[] twoElementArray = {3, 1};
//        System.out.println("Test 2 - Two Elements: " + Arrays.toString(sorter.sort(twoElementArray)));
//
//        // Test case 3: A sorted list of numbers
//        Integer[] sortedArray = {1, 2, 3, 4, 5};
//        System.out.println("Test 3 - Already Sorted: " + Arrays.toString(sorter.sort(sortedArray)));
//
//        // Test case 4: A random list of numbers
//        Integer[] randomArray = {4, 2, 5, 1, 3};
//        System.out.println("Test 4 - Random List: " + Arrays.toString(sorter.sort(randomArray)));
		
		
		
       MergeSort<Integer> sorter1 = new MergeSort<>();

       Integer[] array1 = {5, 2, 9, 1, 5, 6, 3, 8, 4, 7};

       Integer[] sorted1 = sorter.sort(array1);

       for (Integer number : sorted1) {
           System.out.println(number);
       }

       
       sorter1.fit(array1);

       
       System.out.println("Predicted time for size 1000: " + sorter1.predict(1000));
       System.out.println("Predicted time for size 1,000,000: " + sorter1.predict(1000000));
       System.out.println("Predicted time for size 1,000,000,000: " + sorter1.predict(1000000000));
   
    
    
		
		
    } // end of main
	
	
} // end of class

