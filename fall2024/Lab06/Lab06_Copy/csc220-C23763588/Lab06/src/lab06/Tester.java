package lab06;
import java.util.Arrays;




public class Tester {
	
	
	public static void main(String[] args) {
		
		/* 
		    * As a reminder these are the methods we did in lab:
		    * 1.1) SortedString Constuctor
		    * 1.2) SortedString compareTo(SortedString other)
		    * 2) AnagramUtil areAnagrams(SortedString str1, SortedString str2)
		    * 3) InsetionSort sort(E[] array) (HINT: use the toSortedString() convenience function from SortedString)
		    * 4.1, 4.2, 4.3) InsertionSort  O(int n), fit(E[] array), and predict(int n)
		    */
		
		// 1.1 sorted constructor
        SortedString str1 = new SortedString("Hello");
        SortedString str2 = new SortedString("world");
        SortedString str3 = new SortedString("apple");

        System.out.println(str1); // Hello/ehllo
        System.out.println(str2); // world/dlorw
        System.out.println(str3); // apple/aelpp
        
        // 1.2 sorted string compare to

        System.out.println(str1.compareTo(str2)); // Compare "ehllo" with "dlorw"
        System.out.println(str2.compareTo(str3)); // Compare "dlorw" with "aelpp"
        System.out.println(str1.compareTo(str3)); // Compare "ehllo" with "aelpp"
        
        // 2 AnagramUtil areAnagrams(SortedString str1, SortedString str2) 
        
        SortedString str4 = new SortedString("");
        SortedString str5 = new SortedString("anything");
        System.out.println(AnagramUtil.areAnagrams(str1, str2)); // Expected: false

        // Test 2: Exactly the same string
        str1 = new SortedString("listen");
        str2 = new SortedString("listen");
        System.out.println(AnagramUtil.areAnagrams(str1, str2)); // Expected: true

        // Test 3: shuffled strings
        str1 = new SortedString("listen");
        str2 = new SortedString("silent");
        System.out.println(AnagramUtil.areAnagrams(str1, str2)); // Expected: true

        // Test 4: Two different strings
        str1 = new SortedString("hello");
        str2 = new SortedString("world");
        System.out.println(AnagramUtil.areAnagrams(str1, str2)); // Expected: false
        
        // 3 InsetionSort sort(E[] array) (HINT: use the toSortedString() convenience function from SortedString)
        InsertionSort<Integer> myInsertion = new InsertionSort<>();

        // A list with one element
        Integer[] oneElement = {5};
        System.out.println(Arrays.toString(myInsertion.sort(oneElement))); // Expected: [5]

        // A list with two elements
        Integer[] twoElements = {9, 3};
        System.out.println(Arrays.toString(myInsertion.sort(twoElements))); // Expected: [3, 9]

        // A sorted list of numbers
        Integer[] sortedList = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(myInsertion.sort(sortedList))); // Expected: [1, 2, 3, 4, 5]

        // A random list of numbers
        Integer[] randomList = {8, 4, 7, 1, 5};
        System.out.println(Arrays.toString(myInsertion.sort(randomList))); // Expected: [1, 4, 5, 7, 8]

        // InsertionSort<SortedString> using toSortedString()
        String[] words = {"banana", "apple", "pear"};
        SortedString[] sortedStrings = SortedString.toSortedString(words);
        InsertionSort<SortedString> stringSorter = new InsertionSort<>();
        SortedString[] sortedResult = stringSorter.sort(sortedStrings);
        for (SortedString ss : sortedResult) {
            System.out.println(ss); 
        }
        
        // 4 4.1, 4.2, 4.3) InsertionSort  O(int n), fit(E[] array), and predict(int n)
        
        InsertionSort<Integer> sorter = new InsertionSort<>();

        // Fit the sorter with a small array
        Integer[] smallArray = {8, 2, 5, 1, 9};
        sorter.fit(smallArray);

        // Predict the time for a much larger array size
        int largeSize = 1000;
        double predictedTime = sorter.predict(largeSize);

        System.out.println("Predicted time for sorting an array of size " + largeSize + ": " + predictedTime + " microseconds");
        
        
        System.out.println();
        System.out.println("Now Assignment: ");
        
        String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println(Arrays.toString(s3));
        

        System.out.println("Assignment Testing:");

        // 1. Test AnagramUtil.getLargestAnagramGroup(SortedString[] stringList)
        System.out.println("\n1. Testing getLargestAnagramGroup:");
        String[] words1 = {"listen", "silent", "enlist", "tinsel", "google", "apple"};
        SortedString[] sortedStrings1 = SortedString.toSortedString(words1);
        String[] largestGroup = AnagramUtil.getLargestAnagramGroup(sortedStrings1);
        System.out.println("Largest anagram group: " + Arrays.toString(largestGroup));

        // Also test with file input
        System.out.println("\nTesting getLargestAnagramGroup with file input:");
        String[] fileGroup = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println("Largest anagram group from file: " + Arrays.toString(fileGroup));

        // 2. Test MergeSort.sort(E[] array1, E[] array2, int first, int last)
        System.out.println("\n2. Testing MergeSort.sort:");
        Integer[] array = {5, 2, 8, 12, 1, 6};
        MergeSort<Integer> sorter1 = new MergeSort<>();

        System.out.println("Original array: " + Arrays.toString(array));
        Integer[] sortedArray = sorter1.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));

        // 3. Test MergeSort timing functions
        System.out.println("\n3. Testing MergeSort timing functions:");
        
        // 3.1 Test O(int n)
        System.out.println("O(100): " + sorter1.O(100));
        System.out.println("O(1000): " + sorter1.O(1000));

        // 3.2 Test fit(E[] array)
        Integer[] fitArray = {4, 2, 7, 1, 5, 3, 8, 6, 9, 0};
        sorter1.fit(fitArray);
        System.out.println("Fit completed with array of size " + fitArray.length);

        // 3.3 Test predict(int n)
        System.out.println("Predicted time for n=100000: " + sorter1.predict(100000) + " microseconds");
        System.out.println("Predicted time for n=1000000: " + sorter1.predict(1000000) + " microseconds");
        
        
    } // end of main method

    //You will need to write your own tests

    

    

    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */
 
} // end of class

