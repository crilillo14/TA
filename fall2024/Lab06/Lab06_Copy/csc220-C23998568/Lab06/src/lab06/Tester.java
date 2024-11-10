package lab06;

public class Tester {

    //You will need to write your own tests
	public static void main(String[] args) {
		
		SortedString test1 = new SortedString("cab");
		SortedString test2 = new SortedString("act");
		SortedString test3 = new SortedString("baf");
		SortedString test4 = new SortedString("sna");
		SortedString test5 = new SortedString("bac");
		SortedString test6 = new SortedString("acb");

		
		System.out.println(test1.getUnsorted());
		System.out.println(test1.getSorted());
		System.out.println(test1.compareTo(test2));
		
		
		AnagramUtil anaTest1 = new AnagramUtil();
		
		System.out.println(anaTest1.areAnagrams(test1, test2));
		
		
		
		InsertionSort<Integer> sorter = new InsertionSort<Integer>();
		Integer[] arr = {2,5,3,4};
		Integer[] arr1 = {1,2,3,4};
		Integer[] arr2 = {89,13,3,22};
		Integer[] arr3 = {99,1,33,22};
		Integer[] sorted = sorter.sort(arr3);
		System.out.println("Print out: ");
		for(int i = 0; i < sorted.length; i ++) {
			System.out.print(sorted[i] + ", ");
			
		}
		
		InsertionSort<String> sorter1 = new InsertionSort<String>();
		String[] arrS = {"Cat", "App", "Bat"};
		String[] sorted1 = sorter1.sort(arrS);
		System.out.println("Print out: ");
		for(int i = 0; i < sorted1.length; i ++) {
			System.out.print(sorted1[i] + ", ");
		}
		
		sorter1.fit(arrS);
		
		System.out.println(sorter1.predict(4));
		
		
		InsertionSort<Character> sorter2 = new InsertionSort<Character>();
		Character[] arrC = {'z','b', 'c', 'a','t'};
		Character[] sorted2 = sorter2.sort(arrC);
		System.out.println("Print out: ");
		for(int i = 0; i < sorted2.length; i ++) {
			System.out.print(sorted2[i] + "  ");
			if(i == sorted2.length -1 ) System.out.println();
			
		}
		
	
		AnagramUtil trial1 = new AnagramUtil();
		SortedString[] stringArr = {test1, test2, test3, test4, test5, test6};
	
		String[] answer = trial1.getLargestAnagramGroup(stringArr);
		
		for(int i = 0; i < answer.length; i ++) {
			System.out.print(answer[i] + "  ");
			if(i == answer.length -1 ) System.out.println();
			
		}
	
		
		String[] s3 = trial1.getLargestAnagramGroup("sample_word_list.txt");
		for(int i = 0; i < s3.length; i ++) {
			System.out.print(s3[i] + " ");
			if(i == s3.length -1 ) System.out.println();
			
		}
	
		MergeSort<Integer> sorter12 = new MergeSort<Integer>();
		Integer[] intArr = {7, 3, 1, 6, 2};
		
		Integer[] s4 = sorter12.sort(intArr);
		for(int i = 0; i < s4.length; i ++) {
			System.out.print(s4[i] + " ");
			if(i == s4.length -1 ) System.out.println();
			
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
}

