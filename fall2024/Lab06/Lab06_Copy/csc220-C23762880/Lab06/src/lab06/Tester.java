package lab06;

import java.util.Arrays;

public class Tester {
	public static void main(String[] args) {
        SortedString str1 = new SortedString("Act");
        SortedString str2 = new SortedString("Cat");
        SortedString str3 = new SortedString("Bat");
        SortedString str4 = new SortedString("");
        SortedString str5 = new SortedString("Bat");


        if(str1.compareTo(str2) != 0) {
        	System.out.println("Test failed");// Should return 0 since "hello" and "olelh" sort to the same string
        }
        //Testing anagrams
        if(!AnagramUtil.areAnagrams(str1,str2)) {
        	System.out.println("Testing failed");
        }
        //Testing different words
        if(AnagramUtil.areAnagrams(str1, str3)) {
        	System.out.println("Testing failed");
        }
        //Testing an empty string
        if(AnagramUtil.areAnagrams(str1,str4)) {
        	System.out.println("Testing failed");
        }
        //Testing the same word
        if(!AnagramUtil.areAnagrams(str5, str3)) {
        	System.out.println("Testing failed");
        }
        
      InsertionSort<SortedString> sorter = new InsertionSort<>();

     // Testing with a list of two elements
     String[] twoElementStrings = { "Joe", "Mark" };
     SortedString[] twoElementArray = SortedString.toSortedString(twoElementStrings);
     SortedString[] sortedTwoElement = sorter.sort(twoElementArray);

     // Check if the sorted output matches the expected values
     if (!sortedTwoElement[0].getUnsorted().equals("Mark") || 
         !sortedTwoElement[1].getUnsorted().equals("Joe")) {
         System.out.println("Two element sort test failed");
     }

     // Testing with a list of one element
     String[] oneElementStrings = { "Bob" };
     SortedString[] oneElementArray = SortedString.toSortedString(oneElementStrings);
     SortedString[] sortedOneElement = sorter.sort(oneElementArray);
     if (!sortedOneElement[0].getUnsorted().equals("Bob")) {
         System.out.println("One element sort test failed");
     }

     // Sorted numbers test
     String[] sortedNumbersStrings = { "1", "2", "3" };
     SortedString[] sortedNumbersArray = SortedString.toSortedString(sortedNumbersStrings);
     SortedString[] sortedNumbersResult = sorter.sort(sortedNumbersArray);
     if (!sortedNumbersResult[0].getUnsorted().equals("1") || 
         !sortedNumbersResult[1].getUnsorted().equals("2") || 
         !sortedNumbersResult[2].getUnsorted().equals("3")) {
         System.out.println("Sorted numbers test failed");
     }

     // Random numbers test
     String[] randomNumbersStrings = { "3", "1", "2" };
     SortedString[] randomNumbersArray = SortedString.toSortedString(randomNumbersStrings);
     SortedString[] sortedRandomNumbers = sorter.sort(randomNumbersArray);
     if (!sortedRandomNumbers[0].getUnsorted().equals("1") || 
         !sortedRandomNumbers[1].getUnsorted().equals("2") || 
         !sortedRandomNumbers[2].getUnsorted().equals("3")) {
         System.out.println("Random numbers sort test failed");
     }
     String[] smallArray = { "Bob", "Act", "Cat" };
     SortedString[] sortedSmallArray = SortedString.toSortedString(smallArray);
     sorter.fit(sortedSmallArray);
     
     // Predicting runtime for a larger size
     int largeSize = 100000; // Change this to 1_000_000 for even larger
     double predictedTime = sorter.predict(largeSize);
     System.out.println("Predicted runtime for size " + largeSize + ": " + predictedTime + " seconds");
     String[] largestGroup = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
     System.out.println(String.join(" ", largestGroup));
     String[] result2 = AnagramUtil.getLargestAnagramGroup("empty_file.txt");
     System.out.println(String.join(" ", result2));
     String[] result3 = AnagramUtil.getLargestAnagramGroup("one_word.txt");
     System.out.println(String.join(" ", result3));
     String[] result4 = AnagramUtil.getLargestAnagramGroup("no_anagrams.txt");
     System.out.println(String.join(" ", result4));
     String[] result5 = AnagramUtil.getLargestAnagramGroup("anagrams_end.txt");
     System.out.println(String.join(" ", result5));
     
     MergeSort<SortedString> mergeSorter = new MergeSort<>();

     // One-element list
     String[] oneElementStringsMerge = { "Bob" };
     SortedString[] oneElementArrayMerge = SortedString.toSortedString(oneElementStringsMerge);
     SortedString[] sortedOneElementMerge = mergeSorter.sort(oneElementArrayMerge);
     if (!sortedOneElementMerge[0].getUnsorted().equals("Bob")) {
         System.out.println("MergeSort: One element sort test failed");
     }

     // Two-element list
     String[] twoElementStringsMerge = { "Joe", "Mark" };
     SortedString[] twoElementArrayMerge = SortedString.toSortedString(twoElementStringsMerge);
     SortedString[] sortedTwoElementMerge = mergeSorter.sort(twoElementArrayMerge);
     if (!sortedTwoElementMerge[0].getUnsorted().equals("Mark") || 
         !sortedTwoElementMerge[1].getUnsorted().equals("Joe")) {
         System.out.println("MergeSort: Two element sort test failed");
     }

     // Sorted numbers
     String[] sortedNumbersStringsMerge = { "1", "2", "3" };
     SortedString[] sortedNumbersArrayMerge = SortedString.toSortedString(sortedNumbersStringsMerge);
     SortedString[] sortedNumbersResultMerge = mergeSorter.sort(sortedNumbersArrayMerge);
     if (!sortedNumbersResultMerge[0].getUnsorted().equals("1") || 
         !sortedNumbersResultMerge[1].getUnsorted().equals("2") || 
         !sortedNumbersResultMerge[2].getUnsorted().equals("3")) {
         System.out.println("MergeSort: Sorted numbers test failed");
     }

     // Random numbers
     String[] randomNumbersStringsMerge = { "3", "1", "2" };
     SortedString[] randomNumbersArrayMerge = SortedString.toSortedString(randomNumbersStringsMerge);
     SortedString[] sortedRandomNumbersMerge = mergeSorter.sort(randomNumbersArrayMerge);
     if (!sortedRandomNumbersMerge[0].getUnsorted().equals("1") || 
         !sortedRandomNumbersMerge[1].getUnsorted().equals("2") || 
         !sortedRandomNumbersMerge[2].getUnsorted().equals("3")) {
         System.out.println("MergeSort: Random numbers sort test failed");
     }
     MergeSort<Integer> mergeNumberSorter = new MergeSort<>();
     Integer[] smallNumberArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
     mergeNumberSorter.fit(smallNumberArray);
     System.out.println("Predicted time for 100,000 elements: " + mergeNumberSorter.predict(100000) + " microseconds");
     System.out.println("Testing done");
    }
	

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

}

