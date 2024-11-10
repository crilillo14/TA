package lab06;

public class Tester {

	// just a helper method to help me to stuff
	public static void print(String[] strings) {

		System.out.print("[  ");
		for (int index = 0; index < strings.length; index++) {
			System.out.print(strings[index] + "  ");
		}
		System.out.println(" ]\n");

	}
	public static void print(Integer[] strings) {

		System.out.print("[  ");
		for (int index = 0; index < strings.length; index++) {
			System.out.print(strings[index] + "  ");
		}
		System.out.println("]\n");

	}

	public static void main(String[] args) {


	    //You will need to write your own tests

	    /*
	    * As a reminder these are the methods we did in lab:
	    * 1.1) SortedString Constuctor
	    * 1.2) SortedString compareTo(SortedString other)
	    * 2) AnagramUtil areAnagrams(SortedString str1, SortedString str2)
	    * 3) InsetionSort sort(E[] array) (HINT: use the toSortedString() convenience function from SortedString)
	    * 4.1, 4.2, 4.3) InsertionSort  O(int n), fit(E[] array), and predict(int n)
	    */

		// test SortedString stuff right here
		SortedString sortedString1 = new SortedString("cat");
		SortedString sortedString2 = new SortedString("dog");

		System.out.println(sortedString1.compareTo(sortedString2));


		// test AnagramUtil stuff now
		System.out.println(AnagramUtil.areAnagrams(sortedString1, sortedString2));
		System.out.println(AnagramUtil.areAnagrams(new SortedString(""), new SortedString("cat")));
		System.out.println(AnagramUtil.areAnagrams(new SortedString("cat"), new SortedString("cat")));
		System.out.println(AnagramUtil.areAnagrams(new SortedString("cat"), new SortedString("act")));
		System.out.println(AnagramUtil.areAnagrams(new SortedString("cat"), new SortedString("dog")));



		// testing Insertionsort things right now
		InsertionSort<String> insertionSort = new InsertionSort<String>();

		String[] strings1 = {"dog", "cat", "zebra", "toyota"};
		strings1 = insertionSort.sort(strings1);
		print(strings1);

		String[] strings2 = {"bruh"};
		strings2 = insertionSort.sort(strings2);
		print(strings2);

		InsertionSort<Integer> sorting = new InsertionSort<Integer>();
		Integer[] smallArray = {1, 5, 3, 7, 8, 9, 10, 432, 2, 143};
		sorting.fit(smallArray);

		System.out.println(sorting.predict(1000));


		Integer[] bigArray = new Integer[1000];
		for (int index = 0; index < bigArray.length; index++) {
			bigArray[index] = (int) Math.random() * 10000;
		}

		long startTime = System.nanoTime();
    	sorting.sort(bigArray);
    	long endTime = System.nanoTime();

    	System.out.println((endTime - startTime) / 1000.0);




	    /*
	    * As a reminder these are the methods we did in assignment:
	    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
	    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
	    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
	    */


    	// TESTING GETLARGESTANAGRAMGROUP

    	String[] strings3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
    	print(strings3);

    	String[] strings4 = AnagramUtil.getLargestAnagramGroup("words1.txt");
    	print(strings4);

    	String[] strings5 = AnagramUtil.getLargestAnagramGroup("words2.txt");
    	print(strings5);

    	String[] strings6 = AnagramUtil.getLargestAnagramGroup("words3.txt");
    	print(strings6);

    	String[] strings7 = AnagramUtil.getLargestAnagramGroup("words4.txt");
    	print(strings7);



    	// TESTING MERGESORT

    	MergeSort<Integer> mergeSort = new MergeSort<Integer>();

    	Integer[] ints1 = {5, 4, 10, 2, 7, 9, 1};
    	ints1 = mergeSort.sort(ints1);
    	print(ints1);

    	Integer[] ints2 = {7, 3, 1, 6, 2};
    	ints2 = mergeSort.sort(ints2);
    	print(ints2);



    	// TESTING THE PREDICT MERGESORT TIME

    	Integer[] ints3 = {10, 4, 3, 6, 1, 5, 7, 9, 8, 2};
    	mergeSort.fit(ints3);
    	System.out.println(mergeSort.predict(100000));
	}

}

