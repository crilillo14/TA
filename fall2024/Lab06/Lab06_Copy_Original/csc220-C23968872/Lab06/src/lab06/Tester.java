package lab06;

import java.util.Arrays;


public class Tester {

	public static void main(String[] args) {
        // Test SortedString implementation
        // Test Case 1: Empty strings (anagrams)
        SortedString ss1 = new SortedString("");
        SortedString ss2 = new SortedString("");
        assert AnagramUtil.areAnagrams(ss1, ss2) : "Test Case 1 Failed - Two empty strings should be anagrams";

        // Test Case 2: One empty string, one non-empty string (not anagrams)
        SortedString ss3 = new SortedString("");
        SortedString ss4 = new SortedString("abc");
        assert !AnagramUtil.areAnagrams(ss3, ss4) : "Test Case 2 Failed - Empty string and 'abc' are not anagrams";

        // Test Case 3: Shuffled anagrams ("listen" and "silent")
        SortedString ss5 = new SortedString("listen");
        SortedString ss6 = new SortedString("silent");
        assert AnagramUtil.areAnagrams(ss5, ss6) : "Test Case 3 Failed - 'listen' and 'silent' should be anagrams";

        // Test Case 4: Shuffled anagrams with different cases ("Debit Card" and "Bad Credit")
        SortedString ss7 = new SortedString("Debit Card");
        SortedString ss8 = new SortedString("Bad Credit");
        assert AnagramUtil.areAnagrams(ss7, ss8) : "Test Case 4 Failed - 'Debit Card' and 'Bad Credit' should be anagrams";

        // Test Case 5: Two different strings (not anagrams)
        SortedString ss9 = new SortedString("apple");
        SortedString ss10 = new SortedString("orange");
        assert !AnagramUtil.areAnagrams(ss9, ss10) : "Test Case 5 Failed - 'apple' and 'orange' are not anagrams";

        // Test Case 6: Anagrams with special characters ("Dormitory" and "Dirty Room")
        SortedString ss11 = new SortedString("Dormitory");
        SortedString ss12 = new SortedString("Dirty Room");
        assert AnagramUtil.areAnagrams(ss11, ss12) : "Test Case 6 Failed - 'Dormitory' and 'Dirty Room' should be anagrams";
        
        System.out.println("Testing done.");
        
        // Test AnagramUtil's areAnagrams method
       
        SortedString s1 = new SortedString("dcba");
        assert s1.getUnsorted().equals("dcba") : "Test Case 1 Failed - Unsorted string should be 'dcba'";
        assert s1.getSorted().equals("abcd") : "Test Case 1 Failed - Sorted string should be 'abcd'";

        // Test Case 2: Already sorted string
        SortedString s2 = new SortedString("abc");
        assert s2.getUnsorted().equals("abc") : "Test Case 2 Failed - Unsorted string should be 'abc'";
        assert s2.getSorted().equals("abc") : "Test Case 2 Failed - Sorted string should be 'abc'";

        // Test Case 3: String with repeated characters
        SortedString s31 = new SortedString("aabbcc");
        assert s31.getUnsorted().equals("aabbcc") : "Test Case 3 Failed - Unsorted string should be 'aabbcc'";
        assert s31.getSorted().equals("aabbcc") : "Test Case 3 Failed - Sorted string should be 'aabbcc'";

        // Test Case 4: Empty string
        SortedString s4 = new SortedString("");
        assert s4.getUnsorted().equals("") : "Test Case 4 Failed - Unsorted string should be empty";
        assert s4.getSorted().equals("") : "Test Case 4 Failed - Sorted string should be empty";

        // Test Case 5: String with special characters
        SortedString s5 = new SortedString("c@#bA");
        assert s5.getUnsorted().equals("c@#bA") : "Test Case 5 Failed - Unsorted string should be 'c@#bA'";
        assert s5.getSorted().equals("#@Abc") : "Test Case 5 Failed - Sorted string should be '#@Abc'";

        System.out.println("Testing done.");
        
        InsertionSort<Integer> sorter = new InsertionSort<>();

        // Test case 1: List with one element
        Integer[] oneElement = {5};
        Integer[] sortedOneElement = sorter.sort(oneElement);
        System.out.println("Test 1 (One Element): " + Arrays.toString(sortedOneElement));

        // Test case 2: List with two elements
        Integer[] twoElements = {7, 3};
        Integer[] sortedTwoElements = sorter.sort(twoElements);
        System.out.println("Test 2 (Two Elements): " + Arrays.toString(sortedTwoElements));

        // Test case 3: Sorted list of numbers
        Integer[] sortedList = {1, 2, 3, 4, 5};
        Integer[] sortedSortedList = sorter.sort(sortedList);
        System.out.println("Test 3 (Sorted List): " + Arrays.toString(sortedSortedList));

        // Test case 4: Random list of numbers
        Integer[] randomList = {4, 2, 5, 3, 1};
        Integer[] sortedRandomList = sorter.sort(randomList);
        System.out.println("Test 4 (Random List): " + Arrays.toString(sortedRandomList));

        // Create an instance of InsertionSort for SortedString type
        InsertionSort<SortedString> stringSorter = new InsertionSort<>();

        // Test case 1: List with one SortedString
        SortedString[] oneStringElement = {new SortedString("apple")};
        SortedString[] sortedOneStringElement = stringSorter.sort(oneStringElement);
        System.out.println("Test 1 (One SortedString Element): " + Arrays.toString(
            Arrays.stream(sortedOneStringElement).map(SortedString::getSorted).toArray(String[]::new)));

        // Test case 2: List with two SortedStrings
        SortedString[] twoStringElements = {new SortedString("banana"), new SortedString("apple")};
        SortedString[] sortedTwoStringElements = stringSorter.sort(twoStringElements);
        System.out.println("Test 2 (Two SortedString Elements): " + Arrays.toString(
            Arrays.stream(sortedTwoStringElements).map(SortedString::getSorted).toArray(String[]::new)));

        // Test case 3: Sorted list of SortedStrings
        SortedString[] sortedStringList = {
            new SortedString("apple"),
            new SortedString("banana"),
            new SortedString("cherry")
        };
        SortedString[] sortedSortedStringList = stringSorter.sort(sortedStringList);
        System.out.println("Test 3 (Sorted SortedString List): " + Arrays.toString(
            Arrays.stream(sortedSortedStringList).map(SortedString::getSorted).toArray(String[]::new)));

        // Test case 4: Random list of SortedStrings
        SortedString[] randomStringList = {
            new SortedString("grape"),
            new SortedString("apple"),
            new SortedString("banana"),
            new SortedString("kiwi")
        };
        SortedString[] sortedRandomStringList = stringSorter.sort(randomStringList);
        System.out.println("Test 4 (Random SortedString List): " + Arrays.toString(
            Arrays.stream(sortedRandomStringList).map(SortedString::getSorted).toArray(String[]::new)));
        
        // Create an instance of InsertionSort for Integer type
        InsertionSort<Integer> sorter1 = new InsertionSort<>();
        
        // Small test array for fitting the sorter
        Integer[] smallArray = {5, 3, 8, 1, 2};
        
        // Fit the sorter with the small array to calculate constant c
        sorter1.fit(smallArray);
        
        // Predict the running time for a larger input size
        int largerSize = 100000;  
        double predictedTime = sorter1.predict(largerSize);
        
        // Output the predicted time
        System.out.println("Predicted time for sorting an array of size " + largerSize + ": " + predictedTime + " microseconds");
        
        // Optional: Run a sort on the larger array to see actual performance (not timed)
        Integer[] largeArray = new Integer[largerSize];
        // Populate the large array with random integers
        for (int i = 0; i < largerSize; i++) {
            largeArray[i] = (int) (Math.random() * 10000);  // Random numbers between 0 and 9999
        }
        
        // Sort the large array (timing the sort)
        long startTime = System.nanoTime();
        sorter1.sort(largeArray);
        long endTime = System.nanoTime();
        
        // Calculate and output the actual time taken in microseconds
        double actualTime = (endTime - startTime) / 1000.0;  // Convert to microseconds
        System.out.println("Actual time taken to sort an array of size " + largerSize + ": " + actualTime + " microseconds");
        
        
        //test Merge sort runtime
        
        // Create an instance of InsertionSort for Integer type
        MergeSort<Integer> sorter2 = new MergeSort<>();
        
        // Small test array for fitting the sorter
        Integer[] smallArray2 = {6, 4, 9, 2, 3};
        
        // Fit the sorter with the small array to calculate constant c
        sorter2.fit(smallArray2);
        
        // Predict the running time for a larger input size
        int largerSize2 = 100000;  
        double predictedTime2 = sorter2.predict(largerSize);
        
        // Output the predicted time
        System.out.println("Predicted time for sorting an array of size " + largerSize2 + ": " + predictedTime2 + " microseconds");
        
        // Optional: Run a sort on the larger array to see actual performance (not timed)
        Integer[] largeArray2 = new Integer[largerSize2];
        // Populate the large array with random integers
        for (int i = 0; i < largerSize2; i++) {
            largeArray2[i] = (int) (Math.random() * 10000);  // Random numbers between 0 and 9999
        }
        
        // Sort the large array (timing the sort)
        long startTime2 = System.nanoTime();
        sorter2.sort(largeArray2);
        long endTime2 = System.nanoTime();
        
        // Calculate and output the actual time taken in microseconds
        double actualTime2 = (endTime2 - startTime2) / 1000.0;  // Convert to microseconds
        System.out.println("Actual time taken to sort an array of size " + largerSize2 + ": " + actualTime2 + " microseconds");
        
        testSortWithOneElement();
        testSortWithTwoElements();
        testSortWithSortedArray();
        testSortWithRandomArray();
        testGetLargestAnagramGroupWithSampleFile();

        
        
        
	}
	public static void testSortWithOneElement() {
        Integer[] input = {5};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] sorted = mergeSort.sort(input);
        if (arraysEqual(new Integer[]{5}, sorted)) {
            System.out.println("Testing done.");
        } else {
            System.err.println("testSortWithOneElement failed.");
        }
    }

    public static void testSortWithTwoElements() {
        Integer[] input = {10, 1};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] sorted = mergeSort.sort(input);
        if (arraysEqual(new Integer[]{1, 10}, sorted)) {
            System.out.println("Testing done.");
        } else {
            System.err.println("testSortWithTwoElements failed.");
        }
    }

    public static void testSortWithSortedArray() {
        Integer[] input = {1, 2, 3, 4, 5};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] sorted = mergeSort.sort(input);
        if (arraysEqual(new Integer[]{1, 2, 3, 4, 5}, sorted)) {
            System.out.println("Testing done.");
        } else {
            System.err.println("testSortWithSortedArray failed.");
        }
    }

    public static void testSortWithRandomArray() {
        Integer[] input = {9, 5, 2, 8, 3};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] sorted = mergeSort.sort(input);
        if (arraysEqual(new Integer[]{2, 3, 5, 8, 9}, sorted)) {
            System.out.println("Testing done.");
        } else {
            System.err.println("testSortWithRandomArray failed.");
        }
    }

    // Helper method to check if two arrays are equal
    public static boolean arraysEqual(Integer[] arr1, Integer[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static void testGetLargestAnagramGroupWithSampleFile() {
        String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");

        // Expected largest anagram group based on the sample file
        String[] expectedGroup = {"carets", "Caters", "caster", "crates", "Reacts", "recast", "traces"};

        if (arraysEqualIgnoreCase(expectedGroup, s3)) {
            System.out.println("Testing done.");
        } else {
            System.err.println("testGetLargestAnagramGroupWithSampleFile failed.");
            System.err.println("Expected: " + Arrays.toString(expectedGroup));
            System.err.println("Got: " + Arrays.toString(s3));
        }
    }

    // Helper method to check if two arrays are equal (ignoring case)
    public static boolean arraysEqualIgnoreCase(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equalsIgnoreCase(arr2[i])) {
                return false;
            }
        }
        return true;
    }


    
}
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



