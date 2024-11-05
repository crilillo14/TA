package lab06;

import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
        testConstructor();
        testCompareTo();
        testAreAnagrams();
        testInsertionSort();
        testInsertionSortPrediction();
        testMergeSort();
        testMergeSortPrediction();
        testGetLargestAnagramGroup();
    }

    /**
     * Tests the constructor for SortedString.
     * Ensures that the unsorted and sorted strings are initialized correctly.
     */
    
    public static void testConstructor() {
        System.out.println("Testing SortedString Constructor...");

        // Normal string
        SortedString s1 = new SortedString("apple");
        assert s1.getUnsorted().equals("apple") : "Test case 1 failed: unsorted should be 'apple'";
        assert s1.getSorted().equals("aelpp") : "Test case 1 failed: sorted should be 'aelpp'";

        // String with uppercase letters
        SortedString s2 = new SortedString("Banana");
        assert s2.getUnsorted().equals("Banana") : "Test case 2 failed: unsorted should be 'Banana'";
        assert s2.getSorted().equals("aaabnn") : "Test case 2 failed: sorted should be 'aaabnn'";

        // String with special characters and numbers
        SortedString s3 = new SortedString("Hello123!");
        assert s3.getUnsorted().equals("Hello123!") : "Test case 3 failed: unsorted should be 'Hello123!'";
        assert s3.getSorted().equals("!123ehllo") : "Test case 3 failed: sorted should be '!123ehllo'";

        // Empty string
        SortedString s4 = new SortedString("");
        assert s4.getUnsorted().equals("") : "Test case 4 failed: unsorted should be ''";
        assert s4.getSorted().equals("") : "Test case 4 failed: sorted should be ''";

        System.out.println("Constructor tests passed.");
    }

    /**
     * Tests the compareTo method for SortedString.
     * Ensures that strings are compared correctly based on their sorted versions.
     */
    public static void testCompareTo() {
        System.out.println("Testing compareTo method...");

        SortedString s1 = new SortedString("apple");
        SortedString s2 = new SortedString("Banana");
        SortedString s3 = new SortedString("Hello123!");

        // Compare different strings
        assert s1.compareTo(s2) < 0 : "Test case 1 failed: 'apple' should be less than 'Banana'";
        assert s2.compareTo(s1) > 0 : "Test case 1 failed: 'Banana' should be greater than 'apple'";

        // Compare identical strings
        SortedString s4 = new SortedString("apple");
        assert s1.compareTo(s4) == 0 : "Test case 2 failed: 'apple' should be equal to 'apple'";

        // Compare string with special characters
        SortedString s5 = new SortedString("hello123!");
        assert s3.compareTo(s5) == 0 : "Test case 3 failed: 'Hello123!' should be equal to 'hello123!'";

        System.out.println("compareTo tests passed.");
    }
    
    public static void testAreAnagrams() {
    	System.out.println("Testing AnagramUtil.areAnagrams...");

        // An empty string vs. another string
        SortedString empty = new SortedString("");
        SortedString nonEmpty = new SortedString("apple");
        assert !AnagramUtil.areAnagrams(empty, nonEmpty) : "Test case 1 failed: empty string and 'apple' should not be anagrams";

        // Two exactly the same strings
        SortedString str1 = new SortedString("listen");
        SortedString str2 = new SortedString("listen");
        assert AnagramUtil.areAnagrams(str1, str2) : "Test case 2 failed: 'listen' and 'listen' should be anagrams";

        // Shuffled strings that are anagrams
        SortedString shuffled1 = new SortedString("silent");
        SortedString shuffled2 = new SortedString("listen");
        assert AnagramUtil.areAnagrams(shuffled1, shuffled2) : "Test case 3 failed: 'silent' and 'listen' should be anagrams";

        // Two different strings
        SortedString different1 = new SortedString("apple");
        SortedString different2 = new SortedString("banana");
        assert !AnagramUtil.areAnagrams(different1, different2) : "Test case 4 failed: 'apple' and 'banana' should not be anagrams";

        // Case-insensitive check
        SortedString mixedCase1 = new SortedString("Listen");
        SortedString mixedCase2 = new SortedString("Silent");
        assert AnagramUtil.areAnagrams(mixedCase1, mixedCase2) : "Test case 5 failed: 'Listen' and 'Silent' should be anagrams (case-insensitive)";

        System.out.println("areAnagrams tests passed.");
    }
    
    public static void testInsertionSort() {
    	System.out.println("Testing InsertionSort...");

        InsertionSort<Integer> sorter = new InsertionSort<>();

        // A list with one element
        Integer[] singleElement = {42};
        Integer[] sortedSingle = sorter.sort(singleElement);
        assert Arrays.equals(sortedSingle, new Integer[]{42}) : "Test case 1 failed: single element array should remain the same";

        // A list with two elements
        Integer[] twoElements = {2, 1};
        Integer[] sortedTwo = sorter.sort(twoElements);
        assert Arrays.equals(sortedTwo, new Integer[]{1, 2}) : "Test case 2 failed: two elements array should be sorted";

        // A sorted list of numbers
        Integer[] sortedNumbers = {1, 2, 3, 4, 5};
        Integer[] resultSorted = sorter.sort(sortedNumbers);
        assert Arrays.equals(resultSorted, sortedNumbers) : "Test case 3 failed: already sorted array should remain the same";

        // A random list of numbers
        Integer[] randomNumbers = {4, 2, 5, 1, 3};
        Integer[] sortedRandom = sorter.sort(randomNumbers);
        assert Arrays.equals(sortedRandom, new Integer[]{1, 2, 3, 4, 5}) : "Test case 4 failed: random array should be sorted";

        // Testing InsertionSort with SortedString
        InsertionSort<SortedString> stringSorter = new InsertionSort<>();
        SortedString[] strings = {
            new SortedString("banana"),
            new SortedString("apple"),
            new SortedString("cherry"),
        };
        SortedString[] sortedStrings = stringSorter.sort(strings);
        assert Arrays.equals(sortedStrings, new SortedString[]{new SortedString("apple"), new SortedString("banana"), new SortedString("cherry")}) : "Test case 5 failed: sorted strings should be in order";

        System.out.println("InsertionSort tests passed.");
    }
    
    public static void testInsertionSortPrediction() {
    	System.out.println("Testing InsertionSort Prediction...");

        InsertionSort<Integer> sorter = new InsertionSort<>();
        
        // Fit the sorter with a small array
        Integer[] smallArray = {3, 1, 2};
        sorter.fit(smallArray);
        
        // Predict runtime for a larger array size (e.g., 100,000)
        int largeSize = 100_000; // 100K
        double predictedTime = sorter.predict(largeSize);
        System.out.println("Predicted time for sorting an array of size " + largeSize + ": " + predictedTime + " microseconds");
        
        System.out.println("InsertionSort Prediction tests passed.");
    }
    
    public static void testMergeSort() {
    	System.out.println("Testing MergeSort...");

        MergeSort<Integer> sorter = new MergeSort<>();

        // A list with one element
        Integer[] singleElement = {42};
        Integer[] sortedSingle = sorter.sort(singleElement);
        assert Arrays.equals(sortedSingle, new Integer[]{42}) : "Test case 1 failed: single element array should remain the same";

        // A list with two elements
        Integer[] twoElements = {2, 1};
        Integer[] sortedTwo = sorter.sort(twoElements);
        assert Arrays.equals(sortedTwo, new Integer[]{1, 2}) : "Test case 2 failed: two elements array should be sorted";

        // A sorted list of numbers
        Integer[] sortedNumbers = {1, 2, 3, 4, 5};
        Integer[] resultSorted = sorter.sort(sortedNumbers);
        assert Arrays.equals(resultSorted, sortedNumbers) : "Test case 3 failed: already sorted array should remain the same";

        // A random list of numbers
        Integer[] randomNumbers = {4, 2, 5, 1, 3};
        Integer[] sortedRandom = sorter.sort(randomNumbers);
        assert Arrays.equals(sortedRandom, new Integer[]{1, 2, 3, 4, 5}) : "Test case 4 failed: random array should be sorted";

        // Testing MergeSort with SortedString
        MergeSort<SortedString> stringSorter = new MergeSort<>();
        SortedString[] strings = {
            new SortedString("banana"),
            new SortedString("apple"),
            new SortedString("cherry"),
        };
        SortedString[] sortedStrings = stringSorter.sort(strings);
        assert Arrays.equals(sortedStrings, new SortedString[]{new SortedString("apple"), new SortedString("banana"), new SortedString("cherry")}) : "Test case 5 failed: sorted strings should be in order";

        System.out.println("MergeSort tests passed.");
    }
    
    public static void testGetLargestAnagramGroup() {
    	System.out.println("Testing getLargestAnagramGroup...");

        // Sample file
        String[] s1 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println("Largest anagram group in sample_word_list.txt: " + Arrays.toString(s1));
        assert Arrays.equals(s1, new String[]{"carets", "Caters", "caster", "crates", "Reacts", "recast", "traces"}) 
            : "Test case 1 failed: expected largest anagram group not found";

        // Empty file
        String[] s2 = AnagramUtil.getLargestAnagramGroup("empty.txt");
        System.out.println("Largest anagram group in empty.txt: " + Arrays.toString(s2));
        assert s2.length == 0 : "Test case 2 failed: expected no anagrams in empty file";

        // File with one word
        String[] s3 = AnagramUtil.getLargestAnagramGroup("one_word.txt");
        System.out.println("Largest anagram group in one_word.txt: " + Arrays.toString(s3));
        assert s3.length == 0 : "Test case 3 failed: expected no anagrams with one word";

        // File with no anagrams
        String[] s4 = AnagramUtil.getLargestAnagramGroup("no_anagrams.txt");
        System.out.println("Largest anagram group in no_anagrams.txt: " + Arrays.toString(s4));
        assert s4.length == 0 : "Test case 4 failed: expected no anagrams";

        // File where largest anagram group is in the middle
        String[] s5 = AnagramUtil.getLargestAnagramGroup("middle_anagram_group.txt");
        System.out.println("Largest anagram group in middle_anagram_group.txt: " + Arrays.toString(s5));
        assert Arrays.equals(s5, new String[]{"least", "stale"}) 
            : "Test case 5 failed: expected group 'least', 'stale'";

        // File where largest anagram group is at the end
        String[] s6 = AnagramUtil.getLargestAnagramGroup("end_anagram_group.txt");
        System.out.println("Largest anagram group in end_anagram_group.txt: " + Arrays.toString(s6));
        assert Arrays.equals(s6, new String[]{"bats", "Stab", "tabs"}) 
            : "Test case 6 failed: expected group 'bats', 'Stab', 'tabs'";

        System.out.println("getLargestAnagramGroup tests passed.");
    }
    
    public static void testMergeSortPrediction() {
        System.out.println("Testing MergeSort Prediction...");

        MergeSort<Integer> sorter = new MergeSort<>();

        // Fit the sorter with a small array
        Integer[] smallArray = {3, 1, 2}; // Example array for fitting
        sorter.fit(smallArray);

        // Predict runtime for a larger array size (e.g., 100,000)
        int largeSize = 100_000; // 100K
        double predictedTime = sorter.predict(largeSize);
        System.out.println("Predicted time for sorting an array of size " + largeSize + ": " + predictedTime + " microseconds");

        // Predict runtime for an even larger size (e.g., 1,000,000)
        int veryLargeSize = 1_000_000; // 1M
        double predictedTime2 = sorter.predict(veryLargeSize);
        System.out.println("Predicted time for sorting an array of size " + veryLargeSize + ": " + predictedTime2 + " microseconds");

        // You can also compare it to InsertionSort predictions
        InsertionSort<Integer> insertionSorter = new InsertionSort<>();
        insertionSorter.fit(smallArray);
        double insertionPredictedTime = insertionSorter.predict(largeSize);
        System.out.println("InsertionSort predicted time for sorting an array of size " + largeSize + ": " + insertionPredictedTime + " microseconds");

        // Compare with InsertionSort for larger size
        double insertionPredictedTime2 = insertionSorter.predict(veryLargeSize);
        System.out.println("InsertionSort predicted time for sorting an array of size " + veryLargeSize + ": " + insertionPredictedTime2 + " microseconds");

        System.out.println("MergeSort Prediction tests passed.");
    }

}