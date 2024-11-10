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
		//test part 1 
		SortedString firstTest = new SortedString("cat"); 
		System.out.println(firstTest.toString()); 
		SortedString compareTest = new SortedString("dog");
		System.out.println(firstTest.compareTo(compareTest)); 
		// test anagram compare
		System.out.println(AnagramUtil.areAnagrams(firstTest, compareTest)); // false
		SortedString t1 = new SortedString("ava"); 
		SortedString t2 = new SortedString("vaa"); 
		System.out.println(AnagramUtil.areAnagrams(t1, t2)); //true
		
		//test insertion sort
//		InsertionSort<String> stringSorter = new InsertionSort<>(); 
//		String[] insertionTest = {"a", "d", "c"}; 
//		
//		System.out.println(Arrays.toString(stringSorter.sort(insertionTest))); 
		
		
		// test merge sort
		MergeSort<String> stringSorter = new MergeSort<>(); 
		String[] mergeTest = {"a", "d", "c"}; 
		String[] mergeTest2 = {"z", "c", "f"}; 
		String[] mergeTest3 = {"ava", "topher", "nikki"}; 
		
		System.out.println(Arrays.toString(stringSorter.sort(mergeTest))); 
		System.out.println(Arrays.toString(stringSorter.sort(mergeTest2))); 
		System.out.println(Arrays.toString(stringSorter.sort(mergeTest3))); 
		
		// test getLargestAnagramGroup 
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		for (int i = 0; i < s3.length; i++) {
		    System.out.print(s3[i] + " ");
		}
		System.out.println();
		
//		System.out.println(Arrays.toString(s3)); 
		
		// test big o methods 
		MergeSort<Integer> mergeSort = new MergeSort<>();
		int n = 100;
        double expectedO = n * Math.log(n);  // Calculate the expected value
        double calculatedO = mergeSort.O(n); 
        
        System.out.println(expectedO);
        System.out.println(calculatedO);

	}
	
    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */

}

