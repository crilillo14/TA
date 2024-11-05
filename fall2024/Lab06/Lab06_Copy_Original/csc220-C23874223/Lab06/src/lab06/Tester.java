

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
	package lab06;

	import java.util.Arrays;

	public class Tester {

	    public static void main(String[] args) {
	        // Test SortedString Constructor and compareTo
	        testSortedString();

	        // Test AnagramUtil areAnagrams
	        testAreAnagrams();

	        // Test InsertionSort sorting and performance
	        testInsertionSort();

	        // Test getLargestAnagramGroup from AnagramUtil
	        testGetLargestAnagramGroup();

	        // Test MergeSort sorting and performance
	        testMergeSort();
	    }

	    // 1.1) Testing SortedString Constructor and compareTo
	    public static void testSortedString() {
	        SortedString s1 = new SortedString("Listen");
	        SortedString s2 = new SortedString("Silent");
	        SortedString s3 = new SortedString("Apple");

	        System.out.println("Testing SortedString Constructor and compareTo:");
	        System.out.println("s1 (Listen) sorted: " + s1);  // Expected output: Listen/eilnst
	        System.out.println("s2 (Silent) sorted: " + s2);  // Expected output: Silent/eilnst
	        System.out.println("s3 (Apple) sorted: " + s3);   // Expected output: Apple/aelpp
	        System.out.println("s1.compareTo(s2): " + s1.compareTo(s2));  // Expected output: 0 (since they are anagrams)
	        System.out.println("s1.compareTo(s3): " + s1.compareTo(s3));  // Expected output: > 0 or < 0 depending on lexicographical order
	        System.out.println();
	    }

	    // 2) Testing AnagramUtil.areAnagrams
	    public static void testAreAnagrams() {
	        SortedString s1 = new SortedString("Listen");
	        SortedString s2 = new SortedString("Silent");
	        SortedString s3 = new SortedString("Apple");

	        System.out.println("Testing AnagramUtil.areAnagrams:");
	        System.out.println("areAnagrams(s1, s2): " + AnagramUtil.areAnagrams(s1, s2));  // Expected: true
	        System.out.println("areAnagrams(s1, s3): " + AnagramUtil.areAnagrams(s1, s3));  // Expected: false
	        System.out.println();
	    }

	    // 3) Testing InsertionSort sorting and performance methods
	    public static void testInsertionSort() {
	        InsertionSort<SortedString> sorter = new InsertionSort<>();
	        String[] words = {"Listen", "Apple", "Banana", "Silent"};
	        SortedString[] sortedStrings = SortedString.toSortedString(words);

	        System.out.println("Testing InsertionSort:");
	        System.out.println("Before sorting: " + Arrays.toString(sortedStrings));

	        // Sorting
	        SortedString[] sortedArray = sorter.sort(sortedStrings);
	        System.out.println("After sorting: " + Arrays.toString(sortedArray));

	        // Test O() method
	        System.out.println("O(10): " + sorter.O(10));  // Expected: 100 (O(n^2))

	        // Test fit() and predict()
	        sorter.fit(sortedStrings);
	        System.out.println("Predicted time for 1000 elements: " + sorter.predict(1000));  // Predicted time in microseconds

	        System.out.println();
	    }

	    // 4) Testing AnagramUtil.getLargestAnagramGroup with sample file
	    public static void testGetLargestAnagramGroup() {
	        System.out.println("Testing AnagramUtil.getLargestAnagramGroup:");

	        // Assuming sample_word_list.txt is in the correct location
	        String filename = "sample_word_list.txt";
	        String[] largestAnagramGroup = AnagramUtil.getLargestAnagramGroup(filename);

	        System.out.println("Largest anagram group from sample_word_list.txt:");
	        System.out.println(Arrays.toString(largestAnagramGroup));  // Expected output: Group of anagrams (e.g. [carets, Caters, caster, crates, Reacts, recast, traces])
	        System.out.println();
	    }

	    // 5) Testing MergeSort sorting and performance methods
	    public static void testMergeSort() {
	        MergeSort<SortedString> sorter = new MergeSort<>();
	        String[] words = {"Listen", "Apple", "Banana", "Silent"};
	        SortedString[] sortedStrings = SortedString.toSortedString(words);

	        System.out.println("Testing MergeSort:");
	        System.out.println("Before sorting: " + Arrays.toString(sortedStrings));

	        // Sorting
	        SortedString[] sortedArray = sorter.sort(sortedStrings);
	        System.out.println("After sorting: " + Arrays.toString(sortedArray));

	        // Test O() method
	        System.out.println("O(10): " + sorter.O(10));  // Expected: O(n log n)

	        // Test fit() and predict()
	        sorter.fit(sortedStrings);
	        System.out.println("Predicted time for 1000 elements: " + sorter.predict(1000));  // Predicted time in microseconds

	        System.out.println();
	    }
}
