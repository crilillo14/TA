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
        // Test SortedString class
        testSortedString();

        // Test AnagramUtil class
        testAnagramUtil();

        // Test InsertionSort
        testInsertionSort();

        // Test MergeSort
        testMergeSort();

        // Test MergeSort runtime predictions
        testMergeSortRuntimePrediction();
    }

    public static void testSortedString() {
        System.out.println("Testing SortedString...");

        SortedString s1 = new SortedString("carets");
        SortedString s2 = new SortedString("Caters");
        SortedString s3 = new SortedString("caster");
        SortedString s4 = new SortedString("hello");

        
        System.out.println("s1 sorted: " + s1.getSorted());
        System.out.println("s2 sorted: " + s2.getSorted());
        System.out.println("s4 sorted: " + s4.getSorted());

        System.out.println("s1.compareTo(s2): " + s1.compareTo(s2)); 
        System.out.println("s1.compareTo(s4): " + s1.compareTo(s4));
    }

  
    public static void testAnagramUtil() {
        System.out.println("Testing AnagramUtil...");

        SortedString s1 = new SortedString("carets");
        SortedString s2 = new SortedString("Caters");
        SortedString s3 = new SortedString("caster");
        SortedString s4 = new SortedString("hello");

        
        System.out.println("AnagramUtil.areAnagrams(s1, s2): " + AnagramUtil.areAnagrams(s1, s2)); // Expected: true
        System.out.println("AnagramUtil.areAnagrams(s1, s4): " + AnagramUtil.areAnagrams(s1, s4)); // Expected: false

        
        SortedString[] array = {s1, s2, s3, s4};
        String[] largestGroup = AnagramUtil.getLargestAnagramGroup(array);
        System.out.println("Largest anagram group: " + Arrays.toString(largestGroup)); 

        
        String[] largestGroupFromFile = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        
        System.out.println("Largest anagram group from file: " + Arrays.toString(largestGroupFromFile));
        
    }

    public static void testInsertionSort() {
        System.out.println("Testing InsertionSort...");

        InsertionSort<SortedString> insertionSort = new InsertionSort<>();
        SortedString[] strings = {
                new SortedString("banana"),
                new SortedString("apple"),
                new SortedString("cherry"),
                new SortedString("blueberry")
        };

      
        SortedString[] sortedStrings = insertionSort.sort(strings);
        System.out.println("Sorted strings: " + Arrays.toString(sortedStrings));
        

        insertionSort.fit(strings);
        double predictedTime = insertionSort.predict(100000);
        System.out.println("Predicted time for 100,000 elements (InsertionSort): " + predictedTime + " microseconds");
    }

    
    public static void testMergeSort() {
        System.out.println("Testing MergeSort...");

        MergeSort<SortedString> mergeSort = new MergeSort<>();
        SortedString[] strings = {
                new SortedString("banana"),
                new SortedString("apple"),
                new SortedString("cherry"),
                new SortedString("blueberry")
        };

        
        SortedString[] sortedStrings = mergeSort.sort(strings);
        System.out.println("Sorted strings: " + Arrays.toString(sortedStrings));
        
    }

    
    public static void testMergeSortRuntimePrediction() {
        System.out.println("Testing MergeSort runtime prediction...");

        MergeSort<SortedString> mergeSort = new MergeSort<>();
        SortedString[] strings = {
                new SortedString("banana"),
                new SortedString("apple"),
                new SortedString("cherry"),
                new SortedString("blueberry")
        };

        
        mergeSort.fit(strings);

        double predictedTime = mergeSort.predict(100000);
        System.out.println("Predicted time for 100,000 elements (MergeSort): " + predictedTime + " microseconds");

        double predictedTimeForMillion = mergeSort.predict(1000000);
        System.out.println("Predicted time for 1,000,000 elements (MergeSort): " + predictedTimeForMillion + " microseconds");
    }
	
	     
	
}

