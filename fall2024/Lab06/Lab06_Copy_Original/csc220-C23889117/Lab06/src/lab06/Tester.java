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
		SortedString[] wordList = AnagramUtil.readFile("src/sample_word_list.txt");
		
        SortedString s1 = new SortedString("carets");
        SortedString s2 = new SortedString("Caters");
        SortedString s3 = new SortedString("recast");

        System.out.println(AnagramUtil.areAnagrams(s1, s2));
        System.out.println(AnagramUtil.areAnagrams(s1, s3));

        String[] largestGroup = AnagramUtil.getLargestAnagramGroup(wordList);
        
        for (String word : largestGroup) {
            System.out.println(word);
        }

        InsertionSort<SortedString> insertionSort = new InsertionSort<>();
        SortedString[] sortedWordsInsertion = insertionSort.sort(wordList);

        for (SortedString word : sortedWordsInsertion) {
            System.out.println(word.getUnsorted());
        }

        MergeSort<SortedString> mergeSort = new MergeSort<>();
        SortedString[] sortedWordsMerge = mergeSort.sort(wordList);

        for (SortedString word : sortedWordsMerge) {
            System.out.println(word.getUnsorted());
        }
    }

}

