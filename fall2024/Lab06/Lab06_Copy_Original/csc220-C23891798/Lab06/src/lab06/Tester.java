package lab06;
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
	public void testSortedStringConstructor() {
        SortedString str = new SortedString("apple");
        assertEquals("aelpp", str.getSorted()); // Assuming getSorted() gives the sorted string
    }

   
    public void testSortedStringCompareTo() {
        SortedString str1 = new SortedString("listen");
        SortedString str2 = new SortedString("silent");
        assertEquals(0, str1.compareTo(str2)); // Should return 0 if they are anagrams
    }
    
    public void testAreAnagrams() {
        SortedString str1 = new SortedString("listen");
        SortedString str2 = new SortedString("silent");
        SortedString str3 = new SortedString("apple");

        assertTrue(AnagramUtil.areAnagrams(str1, str2)); // listen and silent are anagrams
        assertFalse(AnagramUtil.areAnagrams(str1, str3)); // listen and apple are not anagrams
    }

    
    public void testInsertionSort() {
        InsertionSort<String> sorter = new InsertionSort<>();
        String[] unsorted = {"banana", "apple", "grape"};
        String[] sorted = {"apple", "banana", "grape"};

        assertArrayEquals(sorted, sorter.sort(unsorted));
    }
   
    public void testInsertionSortO() {
        InsertionSort<String> sorter = new InsertionSort<>();
        assertEquals(100, sorter.O(10)); // O(n) should return n^2
    }

    
    public void testInsertionSortFitAndPredict() {
        InsertionSort<String> sorter = new InsertionSort<>();
        String[] array = {"banana", "apple", "grape"};

        sorter.fit(array); // Measure sorting time and calculate c

        double predictedTime = sorter.predict(100);
        assertTrue(predictedTime > 0); // The predicted time should be positive
    }
    
    public void testMergeSort() {
        MergeSort<String> sorter = new MergeSort<>();
        String[] unsorted = {"banana", "apple", "grape"};
        String[] sorted = {"apple", "banana", "grape"};

        assertArrayEquals(sorted, sorter.sort(unsorted));
    }
    
    public void testMergeSortO() {
        MergeSort<String> sorter = new MergeSort<>();
        assertEquals(10 * Math.log(10) / Math.log(2), sorter.O(10)); // O(n log n) for merge sort
    }

    
    public void testMergeSortFitAndPredict() {
        MergeSort<String> sorter = new MergeSort<>();
        String[] array = {"banana", "apple", "grape"};

        sorter.fit(array); // Measure sorting time and calculate c

        double predictedTime = sorter.predict(100);
        assertTrue(predictedTime > 0); // The predicted time should be positive
    }


}


