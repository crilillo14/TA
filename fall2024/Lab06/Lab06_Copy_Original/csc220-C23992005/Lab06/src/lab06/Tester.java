package lab06;

import java.util.Arrays;

public class Tester 
{

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
	
	public static void main(String[] args) 
	{
        testSortedString();
        testInsertionSort();
        testMergeSort();
        testSortedStringEdgeCases();
        testInsertionSortEdgeCases();
        testMergeSortEdgeCases();
        testAnagramUtil();
    }

    private static void testSortedString() 
    {
        // Test 1: Constructor and Sorting for Anagram Detection
        SortedString s1 = new SortedString("listen");
        SortedString s2 = new SortedString("silent");

        System.out.println("Testing SortedString Method:");
        System.out.println("Unsorted: " + s1.getUnsorted() + " | Sorted: " + s1.getSorted());
        System.out.println("Unsorted: " + s2.getUnsorted() + " | Sorted: " + s2.getSorted());
        
        // Test 2: Implementing CompareTo method to verify Results
        assert s1.compareTo(s2) == 0 : "Failed: listen and silent should be equal (anagrams)";
        System.out.println("Test passed: listen and silent are anagrams\n");
    }

    private static void testInsertionSort() 
    {
        // Test 1: Basic Insertion Sorting
        InsertionSort<SortedString> insertionSort = new InsertionSort<>();
        
        String[] unsortedStrings = {"banana", "apple", "orange"};
        SortedString[] sortedStrings = SortedString.toSortedString(unsortedStrings);
        
        System.out.println("Testing InsertionSort Method:");
        SortedString[] sortedResult = insertionSort.sort(sortedStrings);
        System.out.println("Sorted array: " + Arrays.toString(sortedResult));
        
        // Making sure that sorting works accordingly
        assert sortedResult[0].getUnsorted().equals("apple") : "Failed: First element should be apple";
        assert sortedResult[1].getUnsorted().equals("banana") : "Failed: Second element should be banana";
        assert sortedResult[2].getUnsorted().equals("orange") : "Failed: Third element should be orange";
        System.out.println("InsertionSort Tests Passed!\n");

        // Test 2: Predicting running time
        insertionSort.fit(sortedResult);
        System.out.println("Predicted time for size 3: " + insertionSort.predict(3) + " microseconds.");
    }

    private static void testMergeSort() 
    {
        // Test 1: Basic sorting
        MergeSort<SortedString> mergeSort = new MergeSort<>();
        
        String[] unsortedStrings = {"banana", "apple", "orange", "grape", "pear"};
        SortedString[] sortedStrings = SortedString.toSortedString(unsortedStrings);
        
        System.out.println("Testing MergeSort Method:");
        SortedString[] sortedResult = mergeSort.sort(sortedStrings);
        System.out.println("Sorted array: " + Arrays.toString(sortedResult));
        
        // Verify sorting
        assert sortedResult[0].getUnsorted().equals("apple") : "Failed: First element should be apple";
        assert sortedResult[1].getUnsorted().equals("banana") : "Failed: Second element should be banana";
        assert sortedResult[2].getUnsorted().equals("grape") : "Failed: Third element should be grape";
        assert sortedResult[3].getUnsorted().equals("orange") : "Failed: Fourth element should be orange";
        assert sortedResult[4].getUnsorted().equals("pear") : "Failed: Fifth element should be pear";
        System.out.println("MergeSort Tests Passed!\n");

        // Test 2: Predict running time
        mergeSort.fit(sortedResult);
        System.out.println("Predicted time for size 5: " + mergeSort.predict(5) + " microseconds.");

    }
    
    private static void testSortedStringEdgeCases() 
    {
        // Taking in Empty strings
        SortedString empty1 = new SortedString("");
        SortedString empty2 = new SortedString("");
        assert empty1.compareTo(empty2) == 0 : "Failed: Empty strings should be equal";

        // Taking into account Single character strings
        SortedString single1 = new SortedString("a");
        SortedString single2 = new SortedString("a");
        assert single1.compareTo(single2) == 0 : "Failed: Single character strings 'a' should be equal";

        // Case sensitivity Implementation
        SortedString case1 = new SortedString("Listen");
        SortedString case2 = new SortedString("silent");
        assert case1.compareTo(case2) != 0 : "Failed: 'Listen' and 'silent' should not be equal if case-sensitive";

        // Assortment of Special characters
        SortedString special1 = new SortedString("123abc");
        SortedString special2 = new SortedString("abc123");
        assert special1.compareTo(special2) == 0 : "Failed: '123abc' and 'abc123' should be equal";
        
        System.out.println("Edge Case Tests for SortedString Passed!\n");
    }
    
    private static void testInsertionSortEdgeCases() 
    {
        InsertionSort<SortedString> insertionSort = new InsertionSort<>();
        
        // Test Case #1: Empty array
        SortedString[] emptyArray = {};
        SortedString[] sortedEmpty = insertionSort.sort(emptyArray);
        assert sortedEmpty.length == 0 : "Failed: Empty array should remain empty";
        
        // Test Case #2: Array with duplicate elements
        String[] duplicateStrings = {"apple", "apple", "banana"};
        SortedString[] sortedDuplicates = SortedString.toSortedString(duplicateStrings);
        SortedString[] sortedResult = insertionSort.sort(sortedDuplicates);
        assert sortedResult[0].getUnsorted().equals("apple") : "Failed: First element should be apple";
        assert sortedResult[1].getUnsorted().equals("apple") : "Failed: Second element should be apple";
        assert sortedResult[2].getUnsorted().equals("banana") : "Failed: Third element should be banana";
        
        // Test Case #3: Array with all identical elements
        String[] identicalStrings = {"pear", "pear", "pear"};
        SortedString[] sortedIdenticals = SortedString.toSortedString(identicalStrings);
        SortedString[] sortedResultIdenticals = insertionSort.sort(sortedIdenticals);
        for (int i = 0; i < sortedResultIdenticals.length; i++) {
            assert sortedResultIdenticals[i].getUnsorted().equals("pear") : "Failed: Element should be pear";
        }
        
        System.out.println("Edge Case Tests for InsertionSort Passed!\n");
    }
    
    private static void testMergeSortEdgeCases() 
    {
        MergeSort<SortedString> mergeSort = new MergeSort<>();
        
        // Test #1: Single element array
        String[] singleElement = {"orange"};
        SortedString[] singleSorted = SortedString.toSortedString(singleElement);
        SortedString[] sortedSingle = mergeSort.sort(singleSorted);
        assert sortedSingle[0].getUnsorted().equals("orange") : "Failed: Single element should remain unchanged";
        
        // Test #2: Randomized array
        String[] randomStrings = {"mango", "kiwi", "apple", "banana"};
        SortedString[] randomSortedStrings = SortedString.toSortedString(randomStrings);
        SortedString[] sortedRandom = mergeSort.sort(randomSortedStrings);
        String[] expectedOrder = {"apple", "banana", "kiwi", "mango"};
        for (int i = 0; i < sortedRandom.length; i++) {
            assert sortedRandom[i].getUnsorted().equals(expectedOrder[i]) : "Failed: Sorted array does not match expected order";
        }
        
        // Test #3: Large input array
        String[] largeInput = new String[1000];
        for (int i = 0; i < largeInput.length; i++) {
            largeInput[i] = "string" + i;
        }
        SortedString[] largeSortedStrings = SortedString.toSortedString(largeInput);
        SortedString[] sortedLarge = mergeSort.sort(largeSortedStrings);
        for (int i = 0; i < sortedLarge.length; i++) {
            assert sortedLarge[i].getUnsorted().equals("string" + i) : "Failed: Sorted array element mismatch at index " + i;
        }
        
        System.out.println("Edge Case Tests for MergeSort Passed!\n");
    }
    
    //Ask the TA if this test is necessary
    
    private static void testAnagramUtil() 
    {
        // Implementing areAnagrams test
        SortedString s1 = new SortedString("apple");
        SortedString s2 = new SortedString("pale");
        assert !AnagramUtil.areAnagrams(s1, s2) : "Failed: apple and pale are not anagrams";

        // Taking in to consideration Case and punctuation
        SortedString s3 = new SortedString("A man, a plan, a canal: Panama!");
        SortedString s4 = new SortedString("A canal, a man, a plan: Panama!");
        assert AnagramUtil.areAnagrams(s3, s4) : "Failed: Punctuation and case-insensitive comparison failed";

        // Taking all the anagrams possible for the getLargestAnagramGroup test
        SortedString[] noAnagramGroup = {s1, s2};
        String[] resultGroup = AnagramUtil.getLargestAnagramGroup(noAnagramGroup);
        assert resultGroup.length == 0 : "Failed: There should be no anagram group";

        System.out.println("AnagramUtil Tests Passed!\n");
    }

}

