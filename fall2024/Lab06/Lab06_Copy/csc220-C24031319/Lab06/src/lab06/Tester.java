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
		
		String[] myStrings = {"caT", "Act", "baT", "car"};
		SortedString[] sortedStrings = SortedString.toSortedString(myStrings);
		
		//Lab Testing
		//////////////////////////////////
		//tests 1.1
		SortedString str = new SortedString("Cab");
		System.out.println(str);
		
		//tests 1.2
		//compares "caT" to "Act" should return 0;
		System.out.println(sortedStrings[0].compareTo(sortedStrings[1])); 
		//compares "caT" to "baT" should return 1;
		System.out.println(sortedStrings[0].compareTo(sortedStrings[2])); 
		//compares "baT" to "caT" should return -1;
		System.out.println(sortedStrings[2].compareTo(sortedStrings[0])); 
			
		//tests 2
		//tests two shuffled strings "caT" and "Act" -- should return true
		System.out.println(AnagramUtil.areAnagrams(sortedStrings[0], sortedStrings[1]));
		//tests an empty string and "caT" -- should return false
		SortedString empty = new SortedString("");
		System.out.println(AnagramUtil.areAnagrams(sortedStrings[0], empty));
		//tests the exactly same string -- should return true
		System.out.println(AnagramUtil.areAnagrams(sortedStrings[0], sortedStrings[0]));
		//tests different strings that are not anagrams -- should return false
		System.out.println(AnagramUtil.areAnagrams(sortedStrings[0], sortedStrings[2]));
		
		//tests 3
		InsertionSort<SortedString> myInsertion = new InsertionSort<SortedString>();
		
		SortedString[] newList = myInsertion.sort(sortedStrings);
		System.out.print("{");
		for (SortedString s : newList) {
			System.out.print("(" + s + "),");
			
		}
		System.out.println("}");
		
		//tests 4.1
		System.out.println(myInsertion.O(2));
		//tests 4.2
		myInsertion.fit(newList);
		//tests 4.3
		System.out.println(myInsertion.predict(1000000000));
		
		//Assignment testing
		////////////////////////////////////////////
		System.out.println("\nAssignment Testing: \n");
		
		//Tests 1
		System.out.println("Testing AnagramUtil: \n");
		
		//text file test
		System.out.println("Testing sample_word_list.txt");
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		System.out.print("{");
		for (String str1 : s3) {
			System.out.print(str1 + ", ");
		}
		System.out.println("}");
		
		//no anagrams test
		System.out.println("Testing a list with no anagrams:");
		String[] strList1 = {"act", "tab", "rob"};
		SortedString[] sortedStrings2 = SortedString.toSortedString(strList1);
		String[] s4 = AnagramUtil.getLargestAnagramGroup(sortedStrings2);
		System.out.print("{");
		for (String str1 : s4) {
			System.out.print(str1 + ", ");
		}
		System.out.println("}");
		
		//empty list test
		System.out.println("Testing an empty list:");
		String[] strList2 = {};
		SortedString[] sortedStrings0 = SortedString.toSortedString(strList2);
		String[] s5 = AnagramUtil.getLargestAnagramGroup(sortedStrings0);
		System.out.print("{");
		for (String str1 : s5) {
			System.out.print(str1 + ", ");
		}
		System.out.println("}");
		
		//test largest anagram group at end
		System.out.println("Largest anagram group at end:");
		String[] strList3 = {"bat", "tab", "bear", "act", "cat", "tac"};
		SortedString[] sortedStrings00 = SortedString.toSortedString(strList3);
		String[] s6 = AnagramUtil.getLargestAnagramGroup(sortedStrings00);
		System.out.print("{");
		for (String str1 : s6) {
			System.out.print(str1 + ", ");
		}
		System.out.println("}");
		
		
		//Tests 2
		String[] myStrings2 = {"Rab", "shot", "baT", "car", "oak"};
		String[] mList1 = {"cat"};
		
		System.out.println("\nTesting Merge Sort:");
		SortedString[] sortedStrings3 = SortedString.toSortedString(myStrings2);
		SortedString[] sortedStrings4 = SortedString.toSortedString(mList1);
		MergeSort<SortedString> myMerge = new MergeSort<SortedString>();
		
		
		SortedString[] mergedList1 = myMerge.sort(sortedStrings3);
		System.out.print("Normal Test: ");
		System.out.print("{");
		for (SortedString s : mergedList1) {
			System.out.print("(" + s + "),");
			
		}
		System.out.println("}");
		
		System.out.print("1 element: ");
		SortedString[] mergedList2 = myMerge.sort(sortedStrings4);
		System.out.print("{");
		for (SortedString s : mergedList2) {
			System.out.print("(" + s + "),");
			
		}
		System.out.println("}");
		
		
		System.out.println("\nTesting 4: ");
		//tests 4.1
		System.out.println(myMerge.O(2));
		//tests 4.2
		myMerge.fit(newList);
		//tests 4.3
		System.out.println(myMerge.predict(1000000000));
	}
	
    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */

}

