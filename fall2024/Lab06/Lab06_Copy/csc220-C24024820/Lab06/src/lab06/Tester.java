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
//		SortedString ss=new SortedString("TENNESSEE");
//		System.out.println(ss);
//		SortedString ss2=new SortedString("eeSSEteNN");
//		System.out.println(ss.compareTo(ss2));
//		SortedString ss3=new SortedString("eeeennssta");
//		System.out.println(ss.compareTo(ss3));
//		SortedString ss4=new SortedString("YOUtube");
//		System.out.println(ss4.compareTo(ss));
//		SortedString ss5=new SortedString("");
//		SortedString ss6=new SortedString("TENNessee");
//		System.out.println(AnagramUtil.areAnagrams(ss,ss2));
//		System.out.println(AnagramUtil.areAnagrams(ss,ss3));
//		System.out.println(AnagramUtil.areAnagrams(ss,ss5));
//		System.out.println(AnagramUtil.areAnagrams(ss,ss6));
//		InsertionSort<SortedString> is = new InsertionSort<SortedString>();
//		String[] s = {"car", "cat", "dog", "mouse", "bark", "eat", "zed", "dot"};
//		SortedString s2[] = SortedString.toSortedString(s);
//		s2 = is.sort(s2);
//		for(SortedString str:s2) {
//			System.out.println(str);
//		}
//		InsertionSort<Integer> is2 = new InsertionSort<Integer>();
//		Integer[] i = {1,2,3,4,5,6,7,8,9,10};
//		is2.fit(i);
//		System.out.println(is2.predict(1000000));
//		i = is2.sort(i);
//		for(Integer in:i) {
//			System.out.println(in);
//		}

//		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
//		for(String s:s3) {
//			System.out.println(s);
//		}
//		String[] s4 = AnagramUtil.getLargestAnagramGroup("anagramsAtEnd.txt");
//		for(String s:s4) {
//			System.out.println(s);
//		}
		MergeSort<Integer> ms = new MergeSort<Integer>();
		Integer[] arr = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(ms.O(100));
		ms.fit(arr);
		System.out.println(ms.predict(10));
		
		
//		for(Integer i:arr) {
//			System.out.println(i);
//		}
		
	}
}

