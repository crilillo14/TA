package lab06;

public class Tester {
	public static void main (String[] args) {
		String i = "maso";
		SortedString n = new SortedString(i);
		System.out.println(i+ " ::"+ n.getSorted());
		String w = "mason";
		SortedString x = new SortedString(w);
		System.out.println(w+ " ::"+ x.getSorted());
		System.out.println(AnagramUtil.areAnagrams(n, x));
		//System.out.println(x.getSorted()==n.getSorted());
		String[] arr = {"apple","Orange","Banana"};
		SortedString[] array = SortedString.toSortedString(arr);
		String[] nums= {"1","2","3","4","5"};
		InsertionSort sort = new InsertionSort<>();
		SortedString[] ints = (SortedString[]) sort.sort(SortedString.toSortedString(nums));
		
		SortedString[] sorted = (SortedString[]) sort.sort(array);
		
		for(SortedString e : ints)
			System.out.print(e+" ");
		sort.fit(ints);
		System.out.println(sort.getC());
		System.out.println();
		System.out.println(ints.length);
		System.out.println(sort.predict(ints.length));
		System.out.println(sort.predict(1000));
		System.out.println(sort.predict(5));
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		String[] s2 = AnagramUtil.getLargestAnagramGroup("empty_file.txt");
 		for(String e : s3)	
			System.out.print(e+" ");
 		for(String e: s2)
 			System.out.println(e+ " ");
 		//for()
		//System.out.println(sort.sort(array).toString());
		
		
		//assignment
		
		
	}

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

}

