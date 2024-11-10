package lab06;


public class Tester {
	
	public static void main(String [] args) {
		SortedString str = new SortedString("cat");
		System.out.println(str.getSorted());
		System.out.println();
		SortedString compareString = new SortedString("dog");
		SortedString compareString1 = new SortedString("cat");
		SortedString compareString2 = new SortedString("bat");
		
		System.out.println("Checking our compareTo()");
		System.out.println(str.compareTo(compareString));
		System.out.println(str.compareTo(compareString1));
		System.out.println(str.compareTo(compareString2));
		
		System.out.println();
		System.out.println("Checking anagram function!");
		SortedString anString1 = new SortedString("act");
		SortedString anString2 = new SortedString("");
		SortedString anString3 = new SortedString("catcat");
		
		System.out.println("Should be true: " + AnagramUtil.areAnagrams(str, anString1));
		System.out.println("With empty string: " + AnagramUtil.areAnagrams(str, anString2));
		System.out.println("With repeating string: " + AnagramUtil.areAnagrams(str, anString3));
		
		String[] stringArray = {"dog", "cat", "fish", "creature"};
		Integer[] integerArray = {1, 2, 4, 3, 24, 12};
		
		System.out.println();
		System.out.println("Checking insertion sort!");
		InsertionSort<String> sortyString = new InsertionSort<String>();
		String[] myFixed = sortyString.sort(stringArray);
		for(int i = 0; i < stringArray.length; i++) {
			System.out.print(myFixed[i] + " ");
		}
		
		System.out.println();
		InsertionSort<Integer> sortyInt = new InsertionSort<Integer>();
		Integer[] myFixed2 = sortyInt.sort(integerArray);
		for(int i = 0; i < integerArray.length; i++) {
			System.out.print(myFixed2[i] + " ");
		}
		
		
		
		// finish tests for different kinds of array
		
		System.out.println();
		System.out.println("Checking the time: ");
		sortyString.fit(stringArray);
		System.out.println(sortyString.predict(stringArray.length));
		System.out.println(sortyString.predict(1000000000));
		
		
		
		// testing our anagram groups counter!!
		
		String[] words = {"act", "cat", "rat", "bat", "mat", "tac"};
		SortedString[] sortedWords = SortedString.toSortedString(words);
		
		String [] largestGroup = AnagramUtil.getLargestAnagramGroup(sortedWords);
		
		System.out.println("Testing Anagram Groups:");
		System.out.println("Correct Answer Should be: act, cat, tac");
		System.out.println("Our answer: ");
		for(int i = 0; i < largestGroup.length; i++) {
			System.out.print(largestGroup[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("Checking with sample text: ");
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		
		for(int i = 0; i< s3.length; i++) {
			System.out.print(s3[i] + " ");
		}	
		
		
		
		// testing for mergeSort timing
		
		
		MergeSort<String> sortyIt = new MergeSort<String>();
		System.out.println();
		System.out.println("Checking the time: ");
		sortyIt.fit(stringArray);
		System.out.println(sortyIt.predict(stringArray.length));
		System.out.println(sortyIt.predict(1000000000));
		
		
		
		// Testing insertion vs mergesort with a 10 element, unordered array
		String[] exampleArray = {
			    "banana",
			    "apple",
			    "grape",
			    "orange",
			    "kiwi",
			    "pear",
			    "mango",
			    "peach",
			    "strawberry",
			    "blueberry"
			};
		// our insertion is called sortyString & our merge is called sortyIt
		
		System.out.println("For merge: ");
		sortyIt.fit(exampleArray);
		System.out.println(sortyIt.predict(1000000000));
		
		System.out.println("For insertion: ");
		sortyString.fit(exampleArray);
		System.out.println(sortyString.predict(1000000000));
		
		
		
		
		// testing the mergesort some more!
		System.out.println("Extra mergesort tests!!");
		String[] singleElement = {"apple"};
		MergeSort<String> mergeSortSingle = new MergeSort<>();
		String[] sortedSingle = mergeSortSingle.sort(singleElement);
		System.out.println("Single Element: ");
		for(int i = 0; i < sortedSingle.length; i++) {
			System.out.print(sortedSingle[i]);
		}
		
		
		System.out.println();
		String[] twoElements = {"banana", "apple"};
		MergeSort<String> mergeSortTwo = new MergeSort<>();
		String[] sortedTwo = mergeSortTwo.sort(twoElements);
		for(int i = 0; i < sortedTwo.length; i++) {
			System.out.print(sortedTwo[i] + " ");
		}
		
		
		
		
		
		
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

