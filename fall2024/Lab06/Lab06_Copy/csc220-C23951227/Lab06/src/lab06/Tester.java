package lab06;

import java.util.Arrays;
public class Tester {

    //You will need to write your own tests
	public static void main(String[] args) {

    /* 
    * As a reminder these are the methods we did in lab:
    * 1.1) SortedString Constuctor
    * 1.2) SortedString compareTo(SortedString other)
    * 2) AnagramUtil areAnagrams(SortedString str1, SortedString str2)
    * 3) InsetionSort sort(E[] array) (HINT: use the toSortedString() convenience function from SortedString)
    * 4.1, 4.2, 4.3) InsertionSort  O(int n), fit(E[] array), and predict(int n)
    */
	
	
	//1.1
	SortedString mySortedString = new SortedString("racecar");
	System.out.println(mySortedString.getUnsorted());
	System.out.println(mySortedString.getSorted());
	
	//1.2
	SortedString mySortedString2 = new SortedString("racecarrrrrrr");
	SortedString mySortedString3 = new SortedString("carrace");
	SortedString mySortedString4 = new SortedString("RACEcra");
	
	
	AnagramUtil checker = new AnagramUtil();
	if (checker.areAnagrams(mySortedString, mySortedString2)) {
		System.out.println("Error 1");
	}
	if (!(checker.areAnagrams(mySortedString, mySortedString3))) {
		System.out.println("Error 2");
	}
	if (!(checker.areAnagrams(mySortedString, mySortedString4))) {
		System.out.println("Error 3");
	}
	
	String[] stringArray = {"pedoifa", "california", "macaroon"};
	SortedString[] SortedStringArray = mySortedString2.toSortedString(stringArray);
	for (SortedString string: SortedStringArray) {
		System.out.println(string.toString());
	}
	
	
	InsertionSort <String> tester = new InsertionSort<>();
	String[] randomArray = {"california", "butter" , "oragami" , "freefood" , "Budoof" , "Butterfree", "Charmander"};
	
	System.out.println("Original array: " + Arrays.toString(randomArray));
	System.out.println("Sorted array: " + Arrays.toString(tester.sort(randomArray)));
	
	
	tester.fit(randomArray);
	System.out.println("predicted time for 100,000:    "+ tester.predict(100000) + " microseconds");
	System.out.println("predicted time for 1,000,000:  "+ tester.predict(1000000) + " microseconds");

    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */
	
	String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
	System.out.println("Largest anagram group: " + Arrays.toString(s3));
	
	
	
	
	MergeSort <String> tester2 = new MergeSort<>();
	String[] randomArray2 = {"california", "butter" , "oragami" , "freefood" , "Budoof" , "Butterfree", "Charmander"};

	tester2.fit(randomArray2);
	System.out.println("predicted time for 100,000:    "+ tester2.predict(100000) + " microseconds");
	System.out.println("predicted time for 1,000,000:  "+ tester2.predict(1000000) + " microseconds");
	
	}
	
	
	

}

