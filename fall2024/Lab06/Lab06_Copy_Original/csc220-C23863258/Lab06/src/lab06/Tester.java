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
	
    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */
	
	
	public static void main(String[] args) {
		
		
		
//		String[] strings = {"Zebra", "batch", "alpha",};;
		Integer[] ints = {1, 3, 2,};
//		
//		InsertionSort<String> sorter = new InsertionSort<String>();
		InsertionSort<Integer> sorter2 = new InsertionSort<Integer>();
//		
//		for (int i = 0; i < strings.length; i++) {
//			System.out.println(sorter.sort(strings)[i]);
//		}
//		for (int i = 0; i < ints.length; i++) {
//			System.out.println(sorter2.sort(ints)[i]);
//		}
//		
//		
//		SortedString str1 = new SortedString("Cat");
//		SortedString str2 = new SortedString("act");
//		System.out.println(AnagramUtil.areAnagrams(str1, str2));
//		
//		
//		InsertionSort<SortedString> sorter3 = new InsertionSort<SortedString>();
//		
//		SortedString string1 = new SortedString("Zebra");
//		SortedString string2 = new SortedString("alpha");
//		SortedString string3 = new SortedString("batch");
//		
//		SortedString[] sortedstrings = {string1, string2, string3};
//		
//		
//		
//		
//		for (int i = 0; i < sortedstrings.length; i++) {
//			System.out.println(sortedstrings[i].getSorted());
//			System.out.println(sorter3.sort(sortedstrings)[i]);
//		}
//		
//		
		sorter2.fit(ints);
		System.out.println(sorter2.predict(100000000));
//		
//		
//		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
//		
//		for (int k = 0; k < s3.length; k++) {
//			System.out.println(s3[k]);
//		}
//		
//		String[] s4 = AnagramUtil.getLargestAnagramGroup("empty_file");
//		
//		for (int k = 0; k < s4.length; k++) {
//			System.out.println(s4[k]);
//		}
//		
//		String[] s5 = AnagramUtil.getLargestAnagramGroup("no_anagrams");
//		
//		for (int k = 0; k < s5.length; k++) {
//			System.out.println(s5[k]);
//		}
//		
//		String[] s6 = AnagramUtil.getLargestAnagramGroup("single_file");
//		
//		for (int k = 0; k < s6.length; k++) {
//			System.out.println(s6[k]);
//		}
		
//		String[] s7 = AnagramUtil.getLargestAnagramGroup("last_group");
//		
//		for (int k = 0; k < s7.length; k++) {
//			System.out.println(s7[k]);
//		}
		
//		String[] s8 = AnagramUtil.getLargestAnagramGroup("middle_anagram");
//		
//		for (int k = 0; k < s8.length; k++) {
//			System.out.println(s8[k]);
//		}
		
		MergeSort<Integer> sorter3 = new MergeSort<Integer>();
		
		Integer[] ints2 = {1, 3, 2,};
		sorter2.fit(ints2);
		System.out.println(sorter2.predict(100000000));
		
	}
	
	
	
	
	

}

