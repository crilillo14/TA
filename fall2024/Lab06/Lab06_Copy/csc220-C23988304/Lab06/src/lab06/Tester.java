package lab06;

public class Tester{

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
		SortedString test1 = new SortedString("im a dotinplace");
		SortedString test2 = new SortedString("a decimal point");
		String[] stuff = {"im a dotinplace", "a decimal point", "aijjvn", "vbkdjur"};
		
		boolean answer = AnagramUtil.areAnagrams(test1, test2);
		System.out.println(answer + " this is result");
		
		
		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
		Integer[] list = {5, 7};
		Integer[] ans = insertionSort.sort(list);
		Tester.printIntArr(ans);
		
		InsertionSort<SortedString> insertionsorter = new InsertionSort<SortedString>();
		SortedString[] stuff2 = SortedString.toSortedString(stuff);
		SortedString[] ans3 = insertionsorter.sort(stuff2);
		Tester.printSSArr(ans3);
		
		Double[] longstuff = new Double[1000];
		
		for(int index = 0; index < longstuff.length; index++) {
			longstuff[index] = Math.random() * 20 + (Math.random()- 1/2);
			
		}
		InsertionSort<Double> insertionDouble = new InsertionSort<Double>();
		System.out.println("running fit");
		insertionDouble.fit(longstuff);
		System.out.println("end of  fit");
		System.out.println(insertionDouble.predict(1000));
//		
		Integer[] nums = {5,-2,500,-26,3,0,-1,4,1,0,29,25};
		
		
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		printStrArr(s3);
		MergeSort<Integer> mergeSorter = new MergeSort<Integer>();
		Integer[] res = mergeSorter.sort(nums);
		printIntArr(res);
		insertionSort.fit(nums);
		mergeSorter.fit(nums);
		double y = insertionSort.predict(100);
		double x= mergeSorter.predict(100);
		System.out.println(" asdhfkladjf");
		System.out.println(y);
		System.out.println(x);
		
		
		
		
	}// end of main method
	
	public static void printStrArr(String[] arr) {
		for (int index = 0; index < arr.length; index++) {
			System.out.print(arr[index] + " ");
			
		}// end of for loop 
		
	}
	public static void printIntArr(Integer[] arr) {
		for (int index = 0; index < arr.length; index++) {
			System.out.print(arr[index] + " ");
			
		}// end of for loop 
		
	}
	public static void printSSArr(SortedString[] arr) {
		for (int index = 0; index < arr.length; index++) {
			System.out.print(arr[index].getSorted() + " ");
			
		}// end of for loop 
	}
	}// end of tester callss.

