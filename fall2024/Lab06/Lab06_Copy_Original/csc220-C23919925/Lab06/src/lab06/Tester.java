package lab06;

public class Tester {

    //You will need to write your own tests

    /* 
    * As a reminder these are the methods we did in lab:
    * 1.1) SortedString Constructor
    * 1.2) SortedString compareTo(SortedString other)
    * 2) AnagramUtil areAnagrams(SortedString str1, SortedString str2)
    * 3) InsertionSort sort(E[] array) (HINT: use the toSortedString() convenience function from SortedString)
    * 4.1, 4.2, 4.3) InsertionSort  O(int n), fit(E[] array), and predict(int n)
     */

 /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
     */
    public static void main(String[] args) {
        // Anagram

        SortedString str1 = new SortedString("abc");
        SortedString str2 = new SortedString("abcd");

        System.out.println(AnagramUtil.areAnagrams(str1, str2));

        // Insertion Sort
        MergeSort<Double> MergeSort = new MergeSort<Double>();
        Double[] arr = {1.0, 2.0, 3.0};
        arr = MergeSort.sort(arr);
        for (Object i : arr) {
            System.out.println(i);
        }

        String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        for (String s : s3) {
            System.out.println(s);
        }

        // Merge Sort
        MergeSort<Double> mergeSort = new MergeSort<Double>();
        Double[] arr2 = {2.0, 5.0};
        arr2 = mergeSort.sort(arr2);
        for (Object i : arr2) {
            System.out.println(i);
        }
    }

}
