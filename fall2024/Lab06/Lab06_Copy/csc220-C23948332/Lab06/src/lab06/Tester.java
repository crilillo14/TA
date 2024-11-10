package lab06;

import java.util.Arrays;

public class Tester {

    //You will need to write your own tests

    
//    * As a reminder these are the methods we did in lab:
//    * 1.1) SortedString Constuctor
	
	
	public static void main(String[] args) {
		
	
	SortedString word = new SortedString("dog");
	
	System.out.println(word);
 
  
//    * 1.2) SortedString compareTo(SortedString other)
	
	SortedString word1 = new SortedString("cat");
	
	word.compareTo(word1);
	
	System.out.println(word.compareTo(word1));
	
//    * 2) AnagramUtil areAnagrams(SortedString str1, SortedString str2)
	
	SortedString s1 = new SortedString("hello");
    SortedString s2 = new SortedString("world");
    SortedString s3 = new SortedString("Hello");
    SortedString s4 = new SortedString("olleh");  // anagram of "hello"
    SortedString s5 = new SortedString("");  // empty string
    SortedString s6 = new SortedString("helloo");
    
    
    System.out.println(AnagramUtil.areAnagrams(s1, s2)); // false
    System.out.println(AnagramUtil.areAnagrams(s1, s3)); // true
    System.out.println(AnagramUtil.areAnagrams(s1, s4)); // true
    System.out.println(AnagramUtil.areAnagrams(s5, s2)); // false
    System.out.println(AnagramUtil.areAnagrams(s5, new SortedString(""))); // true
    System.out.println(AnagramUtil.areAnagrams(s1, s6)); // false
   
   
   System.out.println(AnagramUtil.areAnagrams(word, word1));
   
   
   
   
   
   
   
   
//    * 
//    * 3
//    * 
//    * 
//    * ) InsetionSort sort(E[] array) (HINT: use the toSortedString() convenience function from SortedString)
//    * 4.1, 4.2, 4.3) InsertionSort  O(int n), fit(E[] array), and predict(int n)
//    */
//  
   
   InsertionSort<Integer> intSorter = new InsertionSort< >();
   InsertionSort<String> stringSorter = new InsertionSort< >();
   
   Integer[] array1 = {4 , 20, 7, 12} ;
   System.out.println(Arrays.toString (intSorter.sort(array1)));
   
  String[] array2 = {"z", "c", "p", "a"} ;
  System.out.println(Arrays.toString (stringSorter.sort(array2)));
   
   
   
   String [] s7 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
   System.out.println("largest group: " + Arrays.toString(s7));
   
   
   
  
   
   

    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */
   
   MergeSort<Integer> mergeSorter = new MergeSort<>();
   
   Integer[] array = {5,8,4,9,3,10,15,7,20};
   
   mergeSorter.fit(array);
   
   System.out.println(mergeSorter.predict(10000));
   
   System.out.println(mergeSorter.predict(1000000));
   
   

}
}


