package lab06;

public class Tester {

    //You will need to write your own tests
    public static void main(String[] args) {
        SortedString str1 = new SortedString("Hello");
        System.out.println(str1);

        SortedString str2 = new SortedString("World");
        System.out.println(str2);

        SortedString str3 = new SortedString("listen");
        SortedString str4 = new SortedString("silent");
        System.out.println(str3.compareTo(str4));

        SortedString str5 = new SortedString("apple");
        SortedString str6 = new SortedString("banana");
        System.out.println(str5.compareTo(str6));

        SortedString[] sortedStrings = SortedString.toSortedString(new String[]{"dog", "god", "cat"});
        for (SortedString ss : sortedStrings) {
            System.out.println(ss); 
        }

        System.out.println(AnagramUtil.areAnagrams(new SortedString("listen"), new SortedString("silent")));
        System.out.println(AnagramUtil.areAnagrams(new SortedString("apple"), new SortedString("banana")));
        System.out.println(AnagramUtil.areAnagrams(new SortedString("dog"), new SortedString("god")));
        System.out.println(AnagramUtil.areAnagrams(new SortedString(""), new SortedString("silent")));
        System.out.println(AnagramUtil.areAnagrams(new SortedString("silent"), new SortedString("silent"))); 
        
        InsertionSort<Integer> sorter = new InsertionSort<>();

        Integer[] oneElement = {42};
        Integer[] sortedOneElement = sorter.sort(oneElement);
        System.out.println("Sorted one element: " + sortedOneElement[0]); 

        Integer[] twoElements = {5, 2};
        Integer[] sortedTwoElements = sorter.sort(twoElements);
        System.out.print("Sorted two elements: ");
        for (Integer num : sortedTwoElements) {
            System.out.print(num + " "); 
        }
        System.out.println();

        Integer[] sortedArray = {1, 2, 3, 4, 5};
        Integer[] sortedSortedArray = sorter.sort(sortedArray);
        System.out.print("Sorted already sorted array: ");
        for (Integer num : sortedSortedArray) {
            System.out.print(num + " "); 
        }
        System.out.println();

        Integer[] randomArray = {4, 1, 3, 2, 5};
        Integer[] sortedRandomArray = sorter.sort(randomArray);
        System.out.print("Sorted random array: ");
        for (Integer num : sortedRandomArray) {
            System.out.print(num + " "); 
        }
        System.out.println();

        sorter.fit(randomArray);
        System.out.println("Predicted runtime for 100K elements: " + sorter.predict(100000) + " microseconds");
        System.out.println("Predicted runtime for 1M elements: " + sorter.predict(1000000) + " microseconds");
   
    System.out.println("\nTesting getLargestAnagramGroup with sample_word_list.txt");
    String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
    if (s3.length > 0) {
        System.out.print("Largest group of anagrams: ");
        for (String word : s3) {
            System.out.print(word + " ");
        }
        System.out.println();
    } else {
        System.out.println("No anagrams found.");
             
    }
    
	 
	}
    private static void testTimingFunctions() {
        MergeSort<Integer> mergeSorter = new MergeSort<>();

        // Test with an array of 10 elements
        Integer[] tenElements = {5, 1, 4, 2, 8, 0, 6, 3, 9, 7};
        mergeSorter.fit(tenElements);

        // Predict runtimes for larger sizes
        System.out.printf("Predicted runtime for 100K: %.2f microseconds%n", mergeSorter.predict(100000));
        System.out.printf("Predicted runtime for 1M: %.2f microseconds%n", mergeSorter.predict(1000000));
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

