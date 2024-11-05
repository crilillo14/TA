package lab06;
import java.util.*;

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
	SortedString m = new SortedString("Cat");
	SortedString k = new SortedString("dog");
	System.out.println(AnagramUtil.areAnagrams(m,k));
	String array[] = new String[]{"dong","Cat","cat","act","lame"};

	SortedString arr[] = SortedString.toSortedString(array);
	System.out.println(AnagramUtil.areAnagrams(arr[2],arr[3]));
	MergeSort<SortedString> sorter = new MergeSort<SortedString>();
	SortedString arr2[] = sorter.sort(arr);
	for(int i = 0; i<arr2.length;i++) {
		System.out.println(arr2[i]);
	}
	sorter.fit(arr2);
	System.out.println(sorter.predict(arr2.length));
	
	SortedString[] s4 = AnagramUtil.readFile("sample_word_list.txt");
	InsertionSort<SortedString> sorti = new InsertionSort<>();
    SortedString[] sortedResult = sorti.sort(s4);
    System.out.println("Sorted Result:");
    for (SortedString ss : sortedResult) {
        System.out.println(ss);
    }
    String[] convert = AnagramUtil.getLargestAnagramGroup(sortedResult);
    String concate = "";
    for(int i = 0; i<convert.length;i++) {
    	concate = concate + convert[i] + " "; 
		
	}
    System.out.println(concate);
  
    }
	}
    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */



