package lab06;

public class Tester {

    //You will need to write your own tests
	public static void main(String[] args)
	{
    /* 
    * As a reminder these are the methods we did in lab:
    * 1.1) SortedString Constuctor- try a bunch of different things
    * 1.2) SortedString compareTo(SortedString other)
    * 2) AnagramUtil areAnagrams(SortedString str1, SortedString str2)
    * 3) InsetionSort sort(E[] array) (HINT: use the toSortedString() convenience function from SortedString)
    * 4.1, 4.2, 4.3) InsertionSort  O(int n), fit(E[] array), and predict(int n)
    */
		SortedString string1 = new SortedString("yAlXBoi");
		System.out.println(string1);
		SortedString string2 = new SortedString("x");
		System.out.println(string2);
		SortedString string3 = new SortedString("aBcDeFg");
		System.out.println(string3);
		SortedString string4 = new SortedString("");
		SortedString string5 = new SortedString("gfedcba");
		SortedString string6 = new SortedString("yAlXBoi");
		System.out.println(AnagramUtil.areAnagrams(string2, string4)); //tests areAnagrams with an empty string (false)
		System.out.println(AnagramUtil.areAnagrams(string1, string6)); //tests areAnagrams with two of the same string (true)
		System.out.println(AnagramUtil.areAnagrams(string3, string5)); //tests areAnagrams with shuffled strings (true)
		System.out.println(AnagramUtil.areAnagrams(string1, string2)); //tests areAnagrams with two different strings (false)
		InsertionSort<String> insertion1 = new InsertionSort<String>();
		String[] strings1 = {"rachel"};
		strings1 = insertion1.sort(strings1);
		for(int i = 0; i<strings1.length; i++) //tests insertion sort on an array with one element, should print rachel
		{
			System.out.println(strings1[i]);
		}
		String[] strings2 = {"lauren", "rachel"};
		strings2 = insertion1.sort(strings2);
		for(int i = 0; i<strings2.length; i++) //tests insertion sort on an array with two element, should print lauren rachel
		{
			System.out.println(strings2[i]);
		}
		InsertionSort<Integer> insertion2 = new InsertionSort<Integer>();
		Integer[] ints1 = {1,2,3,4,5};
		ints1 = insertion2.sort(ints1);
		for(int i = 0; i<ints1.length; i++) //tests insertion sort on a sorted integer array, should print 1 2 3 4 5 
		{
			System.out.println(ints1[i]);
		}
		Integer[] ints2 = {3,1,5,4,2};
		ints2 = insertion2.sort(ints2);
		for(int i = 0; i<ints2.length; i++) //tests insertion sort on an unsorted integer array, should print 1 2 3 4 5 
		{
			System.out.println(ints2[i]);
		}
		InsertionSort<SortedString> insertion = new InsertionSort<SortedString>();
		String[] strings = {"fat", "act", "car", "bat", "cat"};
		SortedString[] sortedStrings = SortedString.toSortedString(strings);
		sortedStrings =insertion.sort(sortedStrings);
		for(int i = 0; i<sortedStrings.length; i++) //tests insertion sort on sorted string array
		{
			System.out.println(sortedStrings[i]);
		}
		String[] sorted = {"act", "cat", "bat", "lat", "hat", "what", "seven", "eight", "nine", "ten"};
		SortedString[] sortedArr = SortedString.toSortedString(sorted);
		insertion.fit(sortedStrings); //fits insertion on an array of 10 strings
		System.out.println("The O value for an insertion sort of 8 is " + insertion.O(8) + ".");
		System.out.println("The O value for an insertion sort of 100 is " + insertion.O(100) + ".");
		double prediction = insertion.predict(100);
		System.out.println("Prediciton for runtime for n = 100: " + prediction + " microseconds.");
		double prediction1 = insertion.predict(10000);
		System.out.println("Prediciton for runtime for n = 10000: " + prediction1 + " microseconds.");
		double prediction2 = insertion.predict(8000000);
		System.out.println("Prediciton for runtime for n = 8000000: " + prediction2 + " microseconds.");
		
		 /* 
		    * As a reminder these are the methods we did in assignment:
		    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
		    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
		    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
		    */
		
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		for (int i =0; i<s3.length; i++) //tests sample word list
		{
			System.out.println(s3[i]); 
		}
		String[] s4 = AnagramUtil.getLargestAnagramGroup("empty_file");
		for (int i =0; i<s4.length; i++) //tests empty file, should print nothing
		{
			System.out.println(s4[i]); 
		}
		System.out.println();

		String[] s5 = AnagramUtil.getLargestAnagramGroup("file_with_one_word");
		for (int i =0; i<s5.length; i++) //tests one word file, should print rachel
		{
			System.out.println(s5[i]); 
		}
		System.out.println();
		
		String[] s7 = AnagramUtil.getLargestAnagramGroup("anagrams_at_end");
		for (int i =0; i<s7.length; i++) //tests file with anagrams at end, should print shed, desh, eshd, heds
		{
			System.out.println(s7[i]); 
		}
		System.out.println();

		String[] s8 = AnagramUtil.getLargestAnagramGroup("anagrams_in_middle");
		for (int i =0; i<s8.length; i++) //tests file with anagrams in middle, should print bit tib ibt
		{
			System.out.println(s8[i]); 
		}
		System.out.println();
		
		String[] s6 = AnagramUtil.getLargestAnagramGroup("file_with_no_anagrams");
		for (int i =0; i<s6.length; i++) //tests file with no anagrams, should print nothing
		{
			System.out.println(s6[i]); 
		}
		MergeSort<String> merge1 = new MergeSort<String>();
		String[] strings3 = {"computer"};
		strings3 = merge1.sort(strings3);
		for(int i = 0; i<strings3.length; i++) //tests merge sort on an array with one element, should print computer
		{
			System.out.println(strings3[i]);
		}
		String[] strings4 = {"dog", "cat"};
		strings4 = merge1.sort(strings4);
		for(int i = 0; i<strings4.length; i++) //tests merge sort on an array with two element, should print cat dog
		{
			System.out.println(strings4[i]);
		}
		MergeSort<Integer> merge2 = new MergeSort<Integer>();
		Integer[] ints3 = {5,6,7,8,9};
		ints3 = merge2.sort(ints3);
		for(int i = 0; i<ints3.length; i++) //tests merge sort on a sorted integer array, should print 5 6 7 8 9 
		{
			System.out.println(ints3[i]);
		}
		Integer[] ints4 = {7,5,9,8,6};
		ints4 = merge2.sort(ints4);
		for(int i = 0; i<ints4.length; i++) //tests merge sort on an unsorted integer array, should print 5 6 7 8 9
		{
			System.out.println(ints4[i]);
		}
		MergeSort<SortedString> merge = new MergeSort<SortedString>();
		System.out.println("The O value for a merge sort of 8 is " + merge.O(8) + ".");
		System.out.println("The O value for a merge sort of 100 is " + merge.O(100) + ".");
		merge.fit(sortedArr); //fits merge on the same array of 10 strings as insertion
		double prediction3 = merge.predict(100);
		System.out.println("Prediciton for runtime for n = 100: " + prediction3 + " microseconds.");
		double prediction4 = merge.predict(10000);
		System.out.println("Prediciton for runtime for n = 10000: " + prediction4 + " microseconds.");
		double prediction5 = merge.predict(8000000);
		System.out.println("Prediciton for runtime for n = 8000000: " + prediction5 + " microseconds.");
		
	}
	
}

