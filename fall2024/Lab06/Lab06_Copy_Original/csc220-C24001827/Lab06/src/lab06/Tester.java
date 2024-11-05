package lab06;

import java.util.Arrays;

public class Tester {

    // You will need to write your own tests

    /* 
    * As a reminder these are the methods we did in lab:
    * 1.1) SortedString Constructor
    * 1.2) SortedString compareTo(SortedString other)
    * 2) AnagramUtil areAnagrams(SortedString str1, SortedString str2)
    * 3) InsertionSort sort(E[] array) (HINT: use the toSortedString() convenience function from SortedString)
    * 4.1, 4.2, 4.3) InsertionSort  O(int n), fit(E[] array), and predict(int n)
    */

    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */

    public static void main(String[] args) {
    	
    	 // Test sample_word_list.txt 
        System.out.println("Test sample_word_list.txt: ");
        String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt"); 
        System.out.println("Largest Anagram Group: " + Arrays.toString(s3));

        // Test 1.1: SortedString Constructor
        SortedString s1 = new SortedString("carets");
        SortedString s2 = new SortedString("Caters");

        System.out.println("\nTest SortedString Constructor: ");
        System.out.println("Original: " + s1.getUnsorted() + ", Sorted: " + s1.getSorted());  
        System.out.println("Original: " + s2.getUnsorted() + ", Sorted: " + s2.getSorted());  

        // Test 1.2: SortedString compareTo(SortedString other)
        System.out.println("\nTest SortedString compareTo: ");
        System.out.println(s1.compareTo(s2)); 

        // Test 2: AnagramUtil areAnagrams(SortedString str1, SortedString str2)
        System.out.println("\nTest AnagramUtil.areAnagrams: ");
        System.out.println(AnagramUtil.areAnagrams(s1, s2)); 

        // Test 3: InsertionSort sort(E[] array)
        String[] words = {"carets", "Caters", "caster", "Reacts", "crates", "traces"};
        SortedString[] sortedStrings = SortedString.toSortedString(words);
        InsertionSort<SortedString> insertionSort = new InsertionSort<>();
        SortedString[] sortedResult = insertionSort.sort(sortedStrings);

        System.out.println("\nTest InsertionSort: ");
        for (SortedString s : sortedResult) {
            System.out.println(s); 
        }

        // Test 4.1, 4.2, 4.3: InsertionSort O(int n), fit(E[] array), predict(int n)
        insertionSort.fit(sortedStrings);
        System.out.println("\nTest InsertionSort.predict for n=10000: ");
        System.out.println(insertionSort.predict(10000)); 

        // Test 1 (Assignment): AnagramUtil getLargestAnagramGroup(SortedString[] stringList)
        System.out.println("\nTest AnagramUtil.getLargestAnagramGroup: ");
        String[] largestGroup = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println("Largest Anagram Group: " + Arrays.toString(largestGroup)); 

        // Test 2: MergeSort sort(E[] array)
        MergeSort<SortedString> mergeSort = new MergeSort<>();
        SortedString[] mergeSortedResult = mergeSort.sort(sortedStrings);

        System.out.println("\nTest MergeSort: ");
        for (SortedString s : mergeSortedResult) {
            System.out.println(s); // Expected sorted order of the strings
        }

        // Test 3.1, 3.2, 3.3: MergeSort O(int n), fit(E[] array), predict(int n)
        mergeSort.fit(sortedStrings);
        System.out.println("\nTest MergeSort.predict for n=10000: ");
        System.out.println(mergeSort.predict(10000)); 
    }
}
