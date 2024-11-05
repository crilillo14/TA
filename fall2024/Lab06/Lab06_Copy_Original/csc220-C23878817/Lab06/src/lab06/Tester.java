package lab06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Tester {
	
	public static void main(String args[]) {
		SortedString s1 = new SortedString("Listen");
        SortedString s2 = new SortedString("Silent");
        
        System.out.println(s1.getSorted());
        System.out.println(s2.getSorted());
        
        testSortedString();
        testInsertionSort();

        String[] words = loadWordsFromFile("sample_word_list.txt");
        SortedString[] sortedStrings = new SortedString[words.length];

        for (int i = 0; i < words.length; i++) {
            sortedStrings[i] = new SortedString(words[i]);
        }

        // Find the largest group of anagrams
        String[] largestAnagramGroup = AnagramUtil.getLargestAnagramGroup(sortedStrings);

        // Print the result
        System.out.println(Arrays.toString(largestAnagramGroup));
    }
    
	
	private static void testSortedString() {
        SortedString s1 = new SortedString("Listen");
        SortedString s2 = new SortedString("Silent");
        SortedString s3 = new SortedString("");
        SortedString s4 = new SortedString("no");
        System.out.println("Are anagrams: " + AnagramUtil.areAnagrams(s1, s2)); // true
        System.out.println("Are anagrams: " + AnagramUtil.areAnagrams(s1, s1)); // true
        System.out.println("Are anagrams: " + AnagramUtil.areAnagrams(s1, s3)); // false
        System.out.println("Are anagrams: " + AnagramUtil.areAnagrams(s2, s1)); // true
        System.out.println("Are anagrams: " + AnagramUtil.areAnagrams(s1, s4)); // false
        
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
	}
        private static String[] loadWordsFromFile(String filename) {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                return br.lines().toArray(String[]::new);
            } catch (IOException e) {
                e.printStackTrace();
                return new String[0]; // Return empty array on error
            }
        }
	

	
	private static void testInsertionSort() {
	InsertionSort<Integer> sorter1 = new InsertionSort<>();
    Integer[] unsorted1 = {};
    Integer[] sorted1 = sorter1.sort(unsorted1);
    System.out.println(Arrays.toString(sorted1)); // Should print [1, 2, 3, 4, 5]
    
    InsertionSort<Integer> sorter2 = new InsertionSort<>();
    Integer[] unsorted2 = {-1,-9, 9, 3, -3};
    Integer[] sorted2 = sorter2.sort(unsorted2);
    System.out.println(Arrays.toString(sorted2));
}

}

