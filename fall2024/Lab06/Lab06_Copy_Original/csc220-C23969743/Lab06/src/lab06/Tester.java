package lab06;
import java.util.Arrays;
import java.util.Random;


public class Tester {

    //You will need to write your own tests
	
	private static Integer[] generateRandomArray(int size) {
	    Integer[] array = new Integer[size];
	    Random rand = new Random();
	    for (int i = 0; i < size; i++) {
	        array[i] = rand.nextInt(1000);
	    }
	    return array;
	}

    public static void main(String[] args) {
        String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println(Arrays.toString(s3));
        
        testMergeSort();
        String[] s4 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println(Arrays.toString(s4));
        
        Integer[] array10 = generateRandomArray(10);
        
        testMergeSortTiming();

        
    }

    public static void testSortedStringConstructor() {
        SortedString ss1 = new SortedString("abc");
        System.out.println(ss1.getUnsorted()); // "abc"
        System.out.println(ss1.getSorted());   // "abc"

        SortedString ss2 = new SortedString("bca");
        System.out.println(ss2.getUnsorted()); // "bca"
        System.out.println(ss2.getSorted());   // "abc"

        SortedString ss3 = new SortedString("ABC");
        System.out.println(ss3.getUnsorted()); // "ABC"
        System.out.println(ss3.getSorted());   // "abc"
    }

    public static void testSortedStringCompareTo() {
        SortedString ss1 = new SortedString("abc");
        SortedString ss2 = new SortedString("bca");
        SortedString ss3 = new SortedString("def");

        System.out.println(ss1.compareTo(ss2)); // 0 (equal)
        System.out.println(ss1.compareTo(ss3)); // -3 (less than)
        System.out.println(ss3.compareTo(ss1)); // 3 (greater than)
    }

    public static void testAnagramUtilAreAnagrams() {
        // Empty string vs. another string
        SortedString ss1 = new SortedString("");
        SortedString ss2 = new SortedString("abc");
        System.out.println(AnagramUtil.areAnagrams(ss1, ss2)); // false

        // Exactly the same string
        SortedString ss3 = new SortedString("abc");
        SortedString ss4 = new SortedString("abc");
        System.out.println(AnagramUtil.areAnagrams(ss3, ss4)); // true

        // Shuffled strings
        SortedString ss5 = new SortedString("abc");
        SortedString ss6 = new SortedString("bca");
        System.out.println(AnagramUtil.areAnagrams(ss5, ss6)); // true

        // Two different strings
        SortedString ss7 = new SortedString("abc");
        SortedString ss8 = new SortedString("def");
        System.out.println(AnagramUtil.areAnagrams(ss7, ss8)); // false

        // Case-insensitive
        SortedString ss9 = new SortedString("Abc");
        SortedString ss10 = new SortedString("bca");
        System.out.println(AnagramUtil.areAnagrams(ss9, ss10)); // true
    }

    public static void testInsertionSort() {
        // List with one element
        Integer[] array1 = {5};
        InsertionSort<Integer> is1 = new InsertionSort<>();
        Integer[] sorted1 = is1.sort(array1);
        System.out.println(Arrays.toString(sorted1)); // [5]

        // List with two elements
        Integer[] array2 = {5, 2};
        InsertionSort<Integer> is2 = new InsertionSort<>();
        Integer[] sorted2 = is2.sort(array2);
        System.out.println(Arrays.toString(sorted2)); // [2, 5]

        // Sorted list of numbers
        Integer[] array3 = {1, 2, 3, 4, 5};
        InsertionSort<Integer> is3 = new InsertionSort<>();
        Integer[] sorted3 = is3.sort(array3);
        System.out.println(Arrays.toString(sorted3)); // [1, 2, 3, 4, 5]

        // Random list of numbers
        Integer[] array4 = {3, 1, 4, 2, 5};
        InsertionSort<Integer> is4 = new InsertionSort<>();
        Integer[] sorted4 = is4.sort(array4);
        System.out.println(Arrays.toString(sorted4)); // [1, 2, 3, 4, 5]

        // Test InsertionSort<SortedString>
        String[] strings = {"abc", "bca", "cab"};
        SortedString[] sortedStrings = SortedString.toSortedString(strings);
        InsertionSort<SortedString> iss = new InsertionSort<>();
        SortedString[] sortedSortedStrings = iss.sort(sortedStrings);
        for (SortedString ss : sortedSortedStrings) {
            System.out.println(ss); // abc/abc, bca/abc, cab/abc
        }
    }

    public static void testInsertionSortPrediction() {
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] smallArray = {1, 2, 3, 4, 5};
        is.fit(smallArray);
        int largeSize = 100000;
        double predictedTime = is.predict(largeSize);
        System.out.println("Predicted time for " + largeSize + " elements: " + predictedTime + " microseconds");
    }
    
    public static void testMergeSort() {
        // List with one element
        Integer[] array1 = {5};
        MergeSort<Integer> ms1 = new MergeSort<>();
        Integer[] sorted1 = ms1.sort(array1);
        System.out.println(Arrays.toString(sorted1)); // [5]

        // List with two elements
        Integer[] array2 = {5, 2};
        MergeSort<Integer> ms2 = new MergeSort<>();
        Integer[] sorted2 = ms2.sort(array2);
        System.out.println(Arrays.toString(sorted2)); // [2, 5]

        // Sorted list of numbers
        Integer[] array3 = {1, 2, 3, 4, 5};
        MergeSort<Integer> ms3 = new MergeSort<>();
        Integer[] sorted3 = ms3.sort(array3);
        System.out.println(Arrays.toString(sorted3)); // [1, 2, 3, 4, 5]

        // Random list of numbers
        Integer[] array4 = {3, 1, 4, 2, 5};
        MergeSort<Integer> ms4 = new MergeSort<>();
        Integer[] sorted4 = ms4.sort(array4);
        System.out.println(Arrays.toString(sorted4)); // [1, 2, 3, 4, 5]

        // Test MergeSort<SortedString>
        String[] strings = {"abc", "bca", "cab"};
        SortedString[] sortedStrings = SortedString.toSortedString(strings);
        MergeSort<SortedString> mss = new MergeSort<>();
        SortedString[] sortedSortedStrings = mss.sort(sortedStrings);
        for (SortedString ss : sortedSortedStrings) {
            System.out.println(ss); // abc/abc, bca/abc, cab/abc
        }
    }
    
    public static void testMergeSortTiming() {
        MergeSort<Integer> ms = new MergeSort<>();

        // Fit with an array of 10 elements
        Integer[] array10 = generateRandomArray(10);
        ms.fit(array10);
        System.out.println("Constant c: " + ms.getC());

        // Predict runtime for larger sizes
        int[] sizes = {100000, 1000000};
        for (int size : sizes) {
            double predictedTime = ms.predict(size);
            System.out.println("Predicted time for " + size + " elements: " + predictedTime + " microseconds");
        }

        // Compare with Insertion Sort
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] array100k = generateRandomArray(100000);
        long startTime = System.nanoTime();
        is.sort(array100k);
        long endTime = System.nanoTime();
        long actualTime = endTime - startTime;
        System.out.println("Actual time for Insertion Sort (100K elements): " + actualTime + " microseconds");
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

}

