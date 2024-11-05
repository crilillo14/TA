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

    // Test SortedString functionality
    public static void testSortedString() {
        System.out.println("Testing SortedString...");

        SortedString s1 = new SortedString("carets");
        SortedString s2 = new SortedString("Caters");
        SortedString s3 = new SortedString("caster");
        SortedString s4 = new SortedString("hello");

        // Test sorted values and compareTo method
        System.out.println("s1 sorted: " + s1.getSorted()); // Expected: "acerst"
        System.out.println("s2 sorted: " + s2.getSorted()); // Expected: "acerst"
        System.out.println("s4 sorted: " + s4.getSorted()); // Expected: "ehllo"

        System.out.println("s1.compareTo(s2): " + s1.compareTo(s2)); // Expected: 0 (anagrams)
        System.out.println("s1.compareTo(s4): " + s1.compareTo(s4)); // Expected: non-zero (not anagrams)
    }

    // Test AnagramUtil class
    public static void testAnagramUtil() {
        System.out.println("Testing AnagramUtil...");

        SortedString s1 = new SortedString("carets");
        SortedString s2 = new SortedString("Caters");
        SortedString s3 = new SortedString("caster");
        SortedString s4 = new SortedString("hello");

        // Test areAnagrams method
        System.out.println("AnagramUtil.areAnagrams(s1, s2): " + AnagramUtil.areAnagrams(s1, s2)); // Expected: true
        System.out.println("AnagramUtil.areAnagrams(s1, s4): " + AnagramUtil.areAnagrams(s1, s4)); // Expected: false

        // Test getLargestAnagramGroup with array input
        SortedString[] array = {s1, s2, s3, s4};
        String[] largestGroup = AnagramUtil.getLargestAnagramGroup(array);
        System.out.println("Largest anagram group: " + Arrays.toString(largestGroup)); // Expected: ["carets", "Caters", "caster"]

        // Test getLargestAnagramGroup with file input (sample_word_list.txt)
        try {
            String[] largestGroupFromFile = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
            System.out.println("Largest anagram group from file: " + Arrays.toString(largestGroupFromFile));
            // Expected: ["carets", "Caters", "caster", "crates", "Reacts", "recast", "traces"]
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Test InsertionSort class
    public static void testInsertionSort() {
        System.out.println("Testing InsertionSort...");

        InsertionSort<SortedString> insertionSort = new InsertionSort<>();
        SortedString[] strings = {
                new SortedString("banana"),
                new SortedString("apple"),
                new SortedString("cherry"),
                new SortedString("blueberry")
        };

        // Test sorting
        SortedString[] sortedStrings = insertionSort.sort(strings);
        System.out.println("Sorted strings: " + Arrays.toString(sortedStrings));
        // Expected: [apple, banana, blueberry, cherry]

        // Test O(n) and predict() functionality
        insertionSort.fit(strings);
        System.out.println("Fitted constant c: " + insertionSort.getC()); // Test fitted constant
        double predictedTime = insertionSort.predict(100000);
        System.out.println("Predicted time for 100,000 elements (InsertionSort): " + predictedTime + " microseconds");
    }

    // Test MergeSort class
    public static void testMergeSort() {
        System.out.println("Testing MergeSort...");

        MergeSort<SortedString> mergeSort = new MergeSort<>();
        SortedString[] strings = {
                new SortedString("banana"),
                new SortedString("apple"),
                new SortedString("cherry"),
                new SortedString("blueberry")
        };

        // Test sorting
        SortedString[] sortedStrings = mergeSort.sort(strings);
        System.out.println("Sorted strings: " + Arrays.toString(sortedStrings));
        // Expected: [apple, banana, blueberry, cherry]
    }

    // Test MergeSort runtime prediction functionality
    public static void testMergeSortRuntimePrediction() {
        System.out.println("Testing MergeSort runtime prediction...");

        MergeSort<SortedString> mergeSort = new MergeSort<>();
        SortedString[] strings = {
                new SortedString("banana"),
                new SortedString("apple"),
                new SortedString("cherry"),
                new SortedString("blueberry")
        };

        // Fit the runtime model
        mergeSort.fit(strings);
        System.out.println("Fitted constant c: " + mergeSort.getC()); // Test fitted constant

        // Predict runtime for larger input sizes
        double predictedTime = mergeSort.predict(100000);
        System.out.println("Predicted time for 100,000 elements (MergeSort): " + predictedTime + " microseconds");

        double predictedTimeForMillion = mergeSort.predict(1000000);
        System.out.println("Predicted time for 1,000,000 elements (MergeSort): " + predictedTimeForMillion + " microseconds");
    }
}
 
 
 
	
