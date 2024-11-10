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
	public static void main(String[] args) {
		
		//LAB TESTS
		SortedString word = new SortedString("cat");
		System.out.println(word);
		 
		SortedString word2 = new SortedString("dog");
		 
		System.out.println(word.compareTo(word2));
		 
		SortedString word3 = new SortedString("cat");
		SortedString word4 = new SortedString("dog");
		SortedString word5 = new SortedString("sit");
		SortedString word6 = new SortedString("");
		SortedString word7 = new SortedString("back");
		SortedString word8 = new SortedString("funny");
		 
		System.out.println(AnagramUtil.areAnagrams(word, word3));
		System.out.println(AnagramUtil.areAnagrams(word6, word3));
		System.out.println(AnagramUtil.areAnagrams(word7, word8));
		 
		InsertionSort<Integer> intSorter = new InsertionSort<>();
		InsertionSort<String> stringSorter = new InsertionSort<>();
	
		 
		Integer[] array1 = {10, 2, 3, 5, 1, 26, 20};
		System.out.println(Arrays.toString(intSorter.sort(array1)));
		 
		String[] array2 = {"a", "z", "b", "f", "x"};
		System.out.println(Arrays.toString(stringSorter.sort(array2)));
		 
		 
		//Lab Part 4
		
		//Test Fit and Predict
		//Prepare an unsorted array to fit
        Integer[] array = new Integer[] {5, 3, 1, 4, 2};

        // Fit the model to calculate the constant c
        intSorter.fit(array);

        // Predict the time for different array sizes
        int n = 10;
        double predictedTime = intSorter.predict(n);
        System.out.println(predictedTime);

        n = 100;
        predictedTime = intSorter.predict(n);
        System.out.println(predictedTime);
        
        //predict for a huge n
        n = 100000000;
        predictedTime = intSorter.predict(n);
        System.out.println(predictedTime);
        
        
        
        
        //ASSIGNMENT TESTS	
     
            
		String[]s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		System.out.println("Largest Anagram Group: " + Arrays.toString(s3));
		
		MergeSort<Integer> intMergeSorter = new MergeSort<>();
		MergeSort<String> stringMergeSorter = new MergeSort<>();
	
		 
		//array1 = {10, 2, 3, 5, 1, 26, 20};
		System.out.println(Arrays.toString(intMergeSorter.sort(array1)));
		 
		//array2 = {"a", "z", "b", "f", "x"};
		System.out.println(Arrays.toString(stringMergeSorter.sort(array2)));

		
		intMergeSorter.fit(array1);
		
		 n = 100;
	     predictedTime = intMergeSorter.predict(n);
	     System.out.println(predictedTime);
	     
		 n = 10000000;
	     predictedTime = intMergeSorter.predict(n);
	     System.out.println(predictedTime);
		
		 
		 
	}// end of main
	
	 

	
	
    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */

}

