package lab06;

import java.io.File;
import java.util.Arrays;
import static lab06.AnagramUtil.getLargestAnagramGroup;

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

    	    /* 
    	    * As a reminder these are the methods we did in assignment:
    	    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    	    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    	    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    	    */
       

        SortedString testString1 = new SortedString("Cat");
        System.out.println("Cat unsorted: " + testString1.getUnsorted());
        System.out.println("Cat sorted: " + testString1.getSorted());

        SortedString compare1 = new SortedString("listen");
        SortedString compare2 = new SortedString("silent");
        System.out.println("Comparing Listen & Silent (Will print 0 if they're anagrams): " + compare1.compareTo(compare2)); 

        SortedString compare3 = new SortedString("cat");
        SortedString compare4 = new SortedString("dog");
        System.out.println("Comparing Cat & Dog (Will print negative): " + compare3.compareTo(compare4)); 

        SortedString compare5 = new SortedString("dog");
        SortedString compare6 = new SortedString("cat");
        System.out.println("Comparing Dog & Cat (Will print positive): " + compare5.compareTo(compare6)); 

        SortedString compare7 = new SortedString("Frog");
        SortedString compare8 = new SortedString("frog");
        System.out.println("Comparing Frog & frog (Will print 0): " + compare7.compareTo(compare8)); 

       

        SortedString empty = new SortedString("");
        SortedString nonEmpty = new SortedString("code");
        System.out.println("Comparing an empty string to 'code': " + AnagramUtil.areAnagrams(empty, nonEmpty)); 

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

        System.out.println("Test Lab Part 3: Largest Anagram Group from file");

        // Fetch and print the largest group of anagrams from the file
        String[] s3 = getLargestAnagramGroup("sample_word_list.txt");
        System.out.println("Largest group of anagrams: " + Arrays.toString(s3)); 

        System.out.println("Test Lab Part 4: MergeSort Implementation");

        // Test case with a random string array
        String[] stringArray = {"purple", "yellow", "red", "green", "orange"};
        MergeSort<String> mergeSort = new MergeSort<>();
        String[] sortedArray = mergeSort.sort(stringArray);

        System.out.println("Original array: " + Arrays.toString(stringArray));
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));

        
        int testSize = 1000; 
        String[] largeArray = new String[testSize];
        for (int i = 0; i < testSize; i++) {
            largeArray[i] = "word" + i;
        }

        mergeSort.fit(largeArray);
        System.out.println("Predicted time for " + testSize + " elements: " + mergeSort.predict(testSize) + " microseconds.");

        System.out.println("\nAdditional MergeSort Tests:");

      
        String[] emptyArray = {};
        String[] sortedEmptyArray = mergeSort.sort(emptyArray);
        System.out.println("Sorted empty array: " + Arrays.toString(sortedEmptyArray)); 

        
        String[] singleElementArray = {"blue"};
        String[] sortedSingleElementArray = mergeSort.sort(singleElementArray);
        System.out.println("Sorted single element array: " + Arrays.toString(sortedSingleElementArray)); 
        
        
        String[] alreadySortedArray = {"blue", "red", "orange"};
        String[] sortedAlreadySortedArray = mergeSort.sort(alreadySortedArray);
        System.out.println("Sorted already sorted array: " + Arrays.toString(sortedAlreadySortedArray)); 

        
        String[] duplicateArray = {"blue", "red", "orange", "pink", "green"};
        String[] sortedDuplicateArray = mergeSort.sort(duplicateArray);
        System.out.println("Sorted array with duplicates: " + Arrays.toString(sortedDuplicateArray)); 

       
        String[] randomArray = new String[100];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = String.valueOf((int) (Math.random() * 100)); 
        }
        String[] sortedRandomArray = mergeSort.sort(randomArray);
        System.out.println("Sorted large random array: " + Arrays.toString(sortedRandomArray));
    }
}
