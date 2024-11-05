package lab06;

import java.util.Arrays;

public class Tester {

    // You will need to write your own tests
	
	/* 
	* As a reminder these are the methods we did in lab:
	* 1.1) SortedString Constuctor
	* 1.2) SortedString compareTo(SortedString other)
	* 2) AnagramUtil areAnagrams(SortedString str1, SortedString str2)
	* 3) InsetionSort sort(E[] array) (HINT: use the toSortedString() convenience function from SortedString)
	* 4.1, 4.2, 4.3) InsertionSort  O(int n), fit(E[] array), and predict(int n)
	*/
	
	public static void main(String[] args) {
		SortedString cat = new SortedString("cat");
        SortedString dog = new SortedString("dog");
        SortedString act = new SortedString("act");
        SortedString empty = new SortedString("");
        SortedString Cat = new SortedString("Cat");

        System.out.println(cat.compareTo(dog));
        System.out.println(cat.compareTo(act));
        System.out.println(dog.compareTo(cat));
        
        
        System.out.println(AnagramUtil.areAnagrams(empty, dog)); // Should return false
        System.out.println(AnagramUtil.areAnagrams(cat, cat)); // Should return true
        System.out.println(AnagramUtil.areAnagrams(cat, act)); // Should return true
        System.out.println(AnagramUtil.areAnagrams(cat, dog)); // Should return false
        System.out.println(AnagramUtil.areAnagrams(Cat, act)); // Should return true, testing case insensitivity
    
        InsertionSort<String> stringSorter = new InsertionSort<String>();
        InsertionSort<Integer> numberSorter = new InsertionSort<Integer>();

        String[] oneElement = {"apple"};
        String[] twoElements = {"banana", "apple"};

        Integer[] sortedNumbers = {1, 2, 3, 4, 5};
        Integer[] randomNumbers = {5, 3, 2, 4, 1};

        System.out.println(Arrays.toString(stringSorter.sort(oneElement))); // Should return ["apple"]
        System.out.println(Arrays.toString(stringSorter.sort(twoElements))); // Should return ["apple", "banana"]

        System.out.println(Arrays.toString(numberSorter.sort(sortedNumbers))); // Should return [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(numberSorter.sort(randomNumbers))); // Should return [1, 2, 3, 4, 5]
        
        // tests for lab part 4
        numberSorter.fit(randomNumbers);
        
        double largeTest = numberSorter.predict(1000000);
        System.out.println("Predicted time for 1,000,000 elements: " + largeTest + " microseconds");
        
        double mediumTest = numberSorter.predict(100000);
        System.out.println("Predicted time for 100,000 elements: " + mediumTest + " microseconds");
        
        // assignment part 1
        String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println(Arrays.toString(s3));
        
        // assignment part 2
        MergeSort<Integer> mergeIntegerSorter = new MergeSort<Integer>();
        
        Integer[] oneElementInteger = {5};
        Integer[] twoElementsInteger = {5, 3};
        
        System.out.println(Arrays.toString(mergeIntegerSorter.sort(oneElementInteger))); // Should return [5]
        System.out.println(Arrays.toString(mergeIntegerSorter.sort(twoElementsInteger))); // Should return [3, 5]
        System.out.println(Arrays.toString(mergeIntegerSorter.sort(sortedNumbers))); // Should return [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(mergeIntegerSorter.sort(randomNumbers))); // Should return [1, 2, 3, 4, 5]
        
        // assignment part 3
        Integer[] array10 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeIntegerSorter.fit(array10);
        
        System.out.println("MergeSort predicted time for 100,000 elements: " + mergeIntegerSorter.predict(100000) + " microseconds");
        System.out.println("InsertionSort predicted time for 100,000 elements: " + numberSorter.predict(100000) + " microseconds");

        System.out.println("MergeSort predicted time for 1,000,000 elements: " + mergeIntegerSorter.predict(1000000) + " microseconds");
        System.out.println("InsertionSort predicted time for 1,000,000 elements: " + numberSorter.predict(1000000) + " microseconds");

        

	}
	
	
    

    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */

}

