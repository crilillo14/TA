package lab06;

import java.util.ArrayList;
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

    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */

	public static void main(String[] args) {
		//Anagram testing
		//empty vs another string
		SortedString object5 = new SortedString("");
		SortedString object6 = new SortedString("car");
		System.out.println("Is null and \"car\" anagram? " + AnagramUtil.areAnagrams(object6, object5));
		
		//exact strings
		SortedString object7 = new SortedString("meow");
		SortedString object8 = new SortedString("meow");
		System.out.println("Is \"meow\" and \"meow\" anagram? " + AnagramUtil.areAnagrams(object7, object8));
		
		//two different strings
		SortedString object1 = new SortedString("cat");
		SortedString object2 = new SortedString("car");
		System.out.println("Is \"cat\" and \"car\" anagram? " + AnagramUtil.areAnagrams(object1, object2));
		
		//shuffled strings
		SortedString object3 = new SortedString("owl");
		SortedString object4 = new SortedString("low");
		System.out.println("Is \"owl\" and \"low\" anagram? " + AnagramUtil.areAnagrams(object3, object4));
		
		//Insertion sort testing
		//A list with one element
		InsertionSort<Integer> oneElement = new InsertionSort<>();
		Integer [] intArray = {20};
		intArray = oneElement.sort(intArray);
		System.out.println(oneElement.toString(intArray));
		
		//A list with two element
		InsertionSort<String> twoElement = new InsertionSort<>();
		String [] stringArray = {"cat", "car"};
		stringArray = twoElement.sort(stringArray);
		System.out.println(twoElement.toString(stringArray));
		
		//A sorted list of numbers
		InsertionSort<Double> sortedList = new InsertionSort<>();
		Double [] sortedArray = {4.0, 6.0, 58.0, 60.0, 150.0};
		sortedArray = sortedList.sort(sortedArray);
		System.out.println(sortedList.toString(sortedArray));
		
		//A random list of number
		InsertionSort<Double> randomList = new InsertionSort<>();
		Double [] randomArray = {5.0, 2.0, 3.4, 6.8, 1.2, 15.8, 13.2};
		randomArray = randomList.sort(randomArray);
		
		System.out.println(randomList.toString(randomArray));
		
//		SortedString.toSortedString(stringArray);
//		InsertionSort<SortedString> sortedString = new InsertionSort<>();
		
		//run time insertion sort
		InsertionSort<Double> runtime = new InsertionSort<>();
		Double [] smallSample = {1.3, 2.5, 4.6, 1.4, 1.8, 1.9, 9.5, 4.7, 6.7, 8.6, 3.9};
		runtime.fit(smallSample);
		double cOfSmallSample = runtime.getC();
		double cOfSampleSize100000 = runtime.predict(100000) / runtime.O(100000);
		double diff = cOfSmallSample - cOfSampleSize100000;
		System.out.println("The difference between constant c of small sample and sample size 100000: " + diff);
		
		//get largest anagram
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		Arrays.toString(s3);
		System.out.println(Arrays.toString(s3));
		
		//merge sort
		//a list with one element
		MergeSort<Integer> moneElement = new MergeSort<>();
		Integer [] mintArray = {50};
		mintArray = moneElement.sort(mintArray);
		System.out.println(moneElement.toString(mintArray));
		
		//a list with two element
		MergeSort<String> mtwoElement = new MergeSort<>();
		String [] mstringArray = {"cow", "owc"};
		mstringArray = mtwoElement.sort(mstringArray);
		System.out.println(mtwoElement.toString(mstringArray));
		//a sorted list of numbers
		MergeSort<Double> msortedList = new MergeSort<>();
		Double [] msortedArray = {5.0, 7.0, 59.0, 61.0, 160.0};
		msortedArray = msortedList.sort(msortedArray);
		System.out.println(msortedList.toString(msortedArray));
		
		//a random list of numbers
		MergeSort<Double> mrandomList = new MergeSort<>();
		Double [] mrandomArray = {7.0, 3.0, 1.0, 6.0, 2.0};
		mrandomArray = mrandomList.sort(mrandomArray);
		
		System.out.println(mrandomList.toString(mrandomArray));
		
		
		//run time merge sort
		MergeSort<Double> mruntime = new MergeSort<>();
		Double [] msmallSample = {1.3, 2.5, 4.6, 1.4, 1.8, 1.9, 9.5, 4.7, 6.7, 8.6};
		mruntime.fit(msmallSample);
		double mcOfSmallSample = mruntime.getC();
		double mcOfSampleSize100000 = mruntime.predict(100000000) / mruntime.O(100000000);
		double mdiff = mcOfSmallSample - mcOfSampleSize100000;
		System.out.println("The difference between constant c of small sample and sample size 100000: " + mdiff);
		
		//compare run time
		double diffruntime = runtime.O(100000000) - mruntime.O(100000000);
		System.out.println("The difference between run time of insertion sort and merge sort: " + diffruntime);
		System.out.println("With large N, insertion sort O(N^2) takes more time than merge sort O(NlogN)");
	}
}

