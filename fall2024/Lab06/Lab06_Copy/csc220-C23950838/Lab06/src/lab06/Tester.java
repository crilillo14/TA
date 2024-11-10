package lab06;

import java.util.ArrayList;

public class Tester {

    //You will need to write your own tests

    /* 
    * As a reminder these are the methods we did in lab:
    * 1.1) SortedString Constructor
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
    * 
    */
	
	public static void main(String[] args) {
		System.out.println("Are you ready?");
		
//		SortedString emptyString = new SortedString("");
//		SortedString spaceString = new SortedString(" ");
//		SortedString word1 = new SortedString("Cater");
//		SortedString word2 = new SortedString("React ");
//		
//		System.out.println("React and cater are anagrams. Should return 0 and true: "
//				+ word1.compareTo(word2) + ", " + AnagramUtil.areAnagrams(word1, word2));
//		
//		SortedString word3 = new SortedString("Butter");
//		SortedString word4 = new SortedString("Buttery");
//		
//		System.out.println("Butter and buttery are not anagrams. Should return negative number and false: "
//				+ word3.compareTo(word4) + ", " + AnagramUtil.areAnagrams(word3, word4));
//		
//		System.out.println("Should return positive number: " + word4.compareTo(word1));
//		
//		System.out.println(spaceString.compareTo(word4));
//		
//		InsertionSort<String> theSorter = new InsertionSort<String>();
//		
//		String[] listOfStrings = new String[10];
//		
//		listOfStrings[0] = "Alabama";
//		listOfStrings[1] = "Cornhouse";
//		listOfStrings[2] = "E";
//		listOfStrings[3] = "BruhMoment";
//		listOfStrings[4] = "DoctorEggman";
//		listOfStrings[5] = "antidisestablishmentarianism";
//		listOfStrings[6] = "flip";
//		listOfStrings[7] = "error500";
//		listOfStrings[8] = "obtuse";
//		listOfStrings[9] = "proposition";
//		
//		
//		String[] sortedStrings = theSorter.sort(listOfStrings);
//		
//		for (int i = 0; i < sortedStrings.length; ++i) {
//			System.out.println(sortedStrings[i]);
//		}
//		
//		theSorter.fit(listOfStrings);
//		
//		System.out.println(theSorter.predict(100000)); // Does not work without fit method
//		
//		SortedString[] listOfStrings = new SortedString[10];
//		
//		listOfStrings[0] = new SortedString("Rifle");
//		listOfStrings[6] = new SortedString("Filer");
//		listOfStrings[8] = new SortedString("Flier");
//		listOfStrings[7] = new SortedString("Neist");
//		listOfStrings[2] = new SortedString("Inset");
//		listOfStrings[5] = new SortedString("Stein");
//		listOfStrings[9] = new SortedString("Crate");
//		listOfStrings[3] = new SortedString("Carte");
//		listOfStrings[4] = new SortedString("Caret");
//		listOfStrings[1] = new SortedString("Lifer");
//		
//		for (int i = 0; i < listOfStrings.length; ++i) {
//			System.out.println(listOfStrings[i]);
//		}
//		
//		System.out.println();
//		InsertionSort<SortedString> theSorter = new InsertionSort<SortedString>();
//		
//		for (int i = 0; i < theSorter.sort(listOfStrings).length; ++i) {
//			System.out.println(theSorter.sort(listOfStrings)[i]);
//		}
//		
//		System.out.println();
//		
//		for (int i = 0; i < AnagramUtil.getLargestAnagramGroup(listOfStrings).length; ++i) {
//			System.out.println(AnagramUtil.getLargestAnagramGroup(listOfStrings)[i]);
//		}
//		
//		SortedString[] list2 = new SortedString[5];
//		
//		System.out.println();
//		
//		list2[0] = new SortedString("Carte");
//		list2[4] = new SortedString("Crate");
//		list2[3] = new SortedString("Inset");
//		list2[2] = new SortedString("Nites");
//		list2[1] = new SortedString("Tines");
//		
//		for (int i = 0; i < theSorter.sort(list2).length; ++i) {
//			System.out.println(theSorter.sort(list2)[i]);
//		}
//		
//		System.out.println();
//		
//		for (int i = 0; i < AnagramUtil.getLargestAnagramGroup(list2).length; ++i) {
//			System.out.println(AnagramUtil.getLargestAnagramGroup(list2)[i]);
//		}
//		
//		SortedString[] list3 = new SortedString[5];
//		
//		System.out.println();
//		
//		list3[0] = new SortedString("Clone");
//		list3[1] = new SortedString("Sprad");
//		list3[2] = new SortedString("Might");
//		list3[3] = new SortedString("Buffy");
//		list3[4] = new SortedString("Kvass");
//		
//		for (int i = 0; i < theSorter.sort(list3).length; ++i) {
//			System.out.println(theSorter.sort(list3)[i]);
//		}
//		
//		System.out.println();
//		
//		for (int i = 0; i < AnagramUtil.getLargestAnagramGroup(list3).length; ++i) {
//			System.out.println(AnagramUtil.getLargestAnagramGroup(list3)[i]);
//		}
//		
//		SortedString[] list4 = {new SortedString("Singularity")};
//		
//		for (int i = 0; i < theSorter.sort(list4).length; ++i) {
//			System.out.println(theSorter.sort(list4)[i]);
//		}
//		
//		for (int i = 0; i < AnagramUtil.getLargestAnagramGroup(list4).length; ++i) {
//			System.out.println(AnagramUtil.getLargestAnagramGroup(list4)[i]);
//		}
//		
//		SortedString[] list5 = AnagramUtil.readFile("sample_word_list.txt");
		MergeSort<SortedString> theSorter = new MergeSort<SortedString>();
//		
//		for (int i = 0; i < list5.length; ++i) {
//			System.out.println(list5[i]);
//		}
//		
//		System.out.println();
//		
//		SortedString[] sortedList5 = theSorter.sort(list5);
//		
//		for (int i = 0; i < sortedList5.length; ++i) {
//			System.out.println(sortedList5[i]);
//		}
//		
//		System.out.println();
//		
//		String[] anagramList5 = AnagramUtil.getLargestAnagramGroup(list5);
//		
//		for (int i = 0; i < anagramList5.length; ++i) {
//			System.out.println(anagramList5[i]);
//		}
//		
//		System.out.println();
		SortedString[] list6 = AnagramUtil.readFile("otherTestFile.txt");
		
		for (int i = 0; i < list6.length; ++i) {
			System.out.println(list6[i]);
		}
		
		System.out.println();
		
		SortedString[] sortedList6 = theSorter.sort(list6);
		
		for (int i = 0; i < sortedList6.length; ++i) {
			System.out.println(sortedList6[i]);
		}
		
		System.out.println();
		
		String[] anagramList6 = AnagramUtil.getLargestAnagramGroup(list6);
		
		for (int i = 0; i < anagramList6.length; ++i) {
			System.out.println(anagramList6[i]);
		}
		
	}

}

