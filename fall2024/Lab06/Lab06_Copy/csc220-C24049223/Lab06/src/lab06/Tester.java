package lab06;

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
		
		
		SortedString a = new SortedString("alert");
		SortedString b = new SortedString("LatEr");
		System.out.println(AnagramUtil.areAnagrams(a, b));
		
		MergeSort<Integer> sorter = new MergeSort<Integer>();
		
		Integer[] array = new Integer[100];
		for (int i = 0; i < array.length; i++) {
			
			array[i] = (int) (Math.random() * 5000);
		}
		sorter.fit(array);
		long start = System.nanoTime() / 1000;
		Integer[] sorted = sorter.sort(array);
		long end = System.nanoTime() / 1000;
		System.out.println(sorter.predict(array.length));
		System.out.println(end - start);
		
		
		array = new Integer[10000];
		for (int i = 0; i < array.length; i++) {
			
			array[i] = (int) (Math.random() * 5000);
		}
		start = System.nanoTime() / 1000;
		sorted = sorter.sort(array);
		end = System.nanoTime() / 1000;
		System.out.println(sorter.predict(array.length));
		System.out.println(end - start);
		
		
		String[] s3	= AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		for (int i = 0; i < s3.length; i ++) {
			
			System.out.println(s3[i]);
		}
	}
	

    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */

}

