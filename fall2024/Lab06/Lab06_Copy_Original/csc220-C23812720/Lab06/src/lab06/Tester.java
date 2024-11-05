package lab06;

public class Tester {

    //You will need to write your own tests
	
	

    /* 
    * As a reminder these are the methods we did in lab:
    * 1.1) SortedString Constructor
    * 1.2) SortedString compareTo(SortedString other)
    */
//	SortedString string = new SortedString("i am cool")
//	
//	if (getUnsorted(string).equals("cool i am") && string.unsorted.equals("i am cool")) {
//		System.out.println("pass");
//	}
//	else {
//		System.out.println("fail");
//	}
	
	SortedString ss1 = new SortedString("bca");
	
    if (ss1.getUnsorted().equals("bca") && ss1.getSorted().equals("abc")) {
        System.out.println("Test case 1 passed.");
    } else {
        System.out.println("Test case 1 failed.");
    }
	
	/* 
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

