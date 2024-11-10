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
    	
        // Test Lab Part 1:
    	
    	System.out.println("Test Lab Part 1:");

        SortedString testString1 = new SortedString("listen");
        System.out.println("Test 1.1a (Constructor - Unsorted): " + testString1.getUnsorted());
        System.out.println("Test 1.1b (Constructor - Sorted): " + testString1.getSorted());
        
        SortedString testString2 = new SortedString("Silent");
        System.out.println("Test 1.1c (Constructor - Unsorted with mixed case): " + testString2.getUnsorted());
        System.out.println("Test 1.1d (Constructor - Sorted with mixed case): " + testString2.getSorted());

        SortedString compare1 = new SortedString("listen");
        SortedString compare2 = new SortedString("silent");
        System.out.println("Test 1.2a (Compare two anagrams): " + compare1.compareTo(compare2));

        SortedString compare3 = new SortedString("abc");
        SortedString compare4 = new SortedString("xyz");
        System.out.println("Test 1.2b (Compare two different strings): " + compare3.compareTo(compare4));

        SortedString compare5 = new SortedString("zebra");
        SortedString compare6 = new SortedString("apple");
        System.out.println("Test 1.2c (Compare two different strings): " + compare5.compareTo(compare6));

        SortedString compare7 = new SortedString("Apple");
        SortedString compare8 = new SortedString("apple");
        System.out.println("Test 1.2d (Case insensitive comparison): " + compare7.compareTo(compare8));

        // Test Lab Part 2:
        
    	System.out.println("Test Lab Part 2:");

        SortedString empty = new SortedString("");
        SortedString nonEmpty = new SortedString("example");
        System.out.println("Test 1 (Empty vs Non-Empty): " + AnagramUtil.areAnagrams(empty, nonEmpty));

        SortedString same1 = new SortedString("test");
        SortedString same2 = new SortedString("test");
        System.out.println("Test 2 (Same String): " + AnagramUtil.areAnagrams(same1, same2));

        SortedString shuffled1 = new SortedString("listen");
        SortedString shuffled2 = new SortedString("silent");
        System.out.println("Test 3 (Anagrams): " + AnagramUtil.areAnagrams(shuffled1, shuffled2));

        SortedString diff1 = new SortedString("hello");
        SortedString diff2 = new SortedString("world");
        System.out.println("Test 4 (Different Strings): " + AnagramUtil.areAnagrams(diff1, diff2));

        SortedString caseInsensitive1 = new SortedString("Listen");
        SortedString caseInsensitive2 = new SortedString("Silent");
        System.out.println("Test 5 (Case Insensitivity): " + AnagramUtil.areAnagrams(caseInsensitive1, caseInsensitive2));
        
        // Test Lab Part 3:
        
        InsertionSort<Integer> sorter = new InsertionSort<>();
        
    	System.out.println("Test Lab Part 3:");

        Integer[] oneElement = {5};
        System.out.println("Test 1 (One Element): " + Arrays.toString(sorter.sort(oneElement)));

        Integer[] twoElements = {10, 3};
        System.out.println("Test 2 (Two Elements): " + Arrays.toString(sorter.sort(twoElements)));

        Integer[] sortedList = {1, 2, 3, 4, 5};
        System.out.println("Test 3 (Sorted List): " + Arrays.toString(sorter.sort(sortedList)));

        Integer[] randomList = {42, 13, 9, 73, 5};
        System.out.println("Test 4 (Random List): " + Arrays.toString(sorter.sort(randomList)));

        String[] stringArray = {"silent", "listen", "enlist", "hello"};
        SortedString[] sortedStrings = SortedString.toSortedString(stringArray);
        InsertionSort<SortedString> stringSorter = new InsertionSort<>();
        SortedString[] sortedResult = stringSorter.sort(sortedStrings);

        System.out.print("Test 5 (SortedString): ");
        for (SortedString ss : sortedResult) {
            System.out.print(ss.getUnsorted() + " ");
        }
        
        // Test Lab Part 4:
        
    	System.out.println("Test Lab Part 4:");
        
        Integer[] smallArray = {42, 13, 9, 73, 5, 12};
        sorter.fit(smallArray);

        int largeSize1 = 100_000;
        double predictedTime1 = sorter.predict(largeSize1);
        System.out.println("Predicted time for sorting 100,000 elements: " + predictedTime1 + " microseconds");

        int largeSize2 = 1_000_000;
        double predictedTime2 = sorter.predict(largeSize2);
        System.out.println("Predicted time for sorting 1,000,000 elements: " + predictedTime2 + " microseconds");
        
        // Test Assignments:
        
        System.out.println("Test Assignments:");
        
        String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println("Largest group of anagrams: " + Arrays.toString(s3));
        System.out.println("Expected output: [carets, Caters, caster, crates, Reacts, recast, traces]");
                
        MergeSort<Integer> mergeSorter = new MergeSort<>();

        Integer[] oneElementMerge = {42};
        System.out.println("Test Case 1 (One Element): " + Arrays.toString(mergeSorter.sort(oneElementMerge)));

        Integer[] twoElementMerge = {5, 3};
        System.out.println("Test Case 2 (Two Elements): " + Arrays.toString(mergeSorter.sort(twoElementMerge)));

        Integer[] sortedArrayMerge = {1, 2, 3, 4, 5};
        System.out.println("Test Case 3 (Sorted List): " + Arrays.toString(mergeSorter.sort(sortedArrayMerge)));

        Integer[] randomArrayMerge = {42, 23, 17, 93, 56};
        System.out.println("Test Case 4 (Random List): " + Arrays.toString(mergeSorter.sort(randomArrayMerge)));

        Integer[] duplicateArrayMerge = {4, 2, 4, 1, 3, 2};
        System.out.println("Test Case 5 (Duplicate Elements): " + Arrays.toString(mergeSorter.sort(duplicateArrayMerge)));

        Integer[] smallArrayMerge = {10, 3, 76, 34, 23, 2, 6, 90, 45, 21};  // Array with 10 elements
        mergeSorter.fit(smallArrayMerge);

        int largeSizeMerge1 = 100_000;
        double predictedTimeMerge1 = mergeSorter.predict(largeSizeMerge1);
        System.out.println("Predicted time for sorting 100,000 elements: " + predictedTimeMerge1 + " microseconds");

        int largeSizeMerge2 = 1_000_000;
        double predictedTimeMerge2 = mergeSorter.predict(largeSizeMerge2);
        System.out.println("Predicted time for sorting 1,000,000 elements: " + predictedTimeMerge2 + " microseconds");

    }
}

