package lab06;

public class Tester 
{
    public static void main(String[] args)
    {
    //You will need to write your own tests


    // * As a reminder these are the methods we did in lab:
    // * 1.1) SortedString Constuctor
    SortedString str1 = new SortedString("cat");
    SortedString str2 = new SortedString("dog");
    SortedString str3 = new SortedString("Act");

    System.out.println("str1: " + str1);
    System.out.println("str2: " + str2);
    System.out.println("str3: " + str3);
    System.out.println();
    
    // * 1.2) SortedString compareTo(SortedString other)
    System.out.println("str1.compareTo(str2): " + str1.compareTo(str2)); 
    System.out.println("str1.compareTo(str3): " + str1.compareTo(str3));
    System.out.println();

    // * 2) AnagramUtil areAnagrams(SortedString str1, SortedString str2)
//    An empty string vs. another string
    SortedString empty = new SortedString("");
    System.out.println("Empty vs String: " + AnagramUtil.areAnagrams(empty, str1));
    System.out.println();
    
//    Exactly the same string
    SortedString str4 = new SortedString("hello");
    SortedString str5 = new SortedString("hello");
    System.out.println("Same String: " + AnagramUtil.areAnagrams(str4, str5));
    System.out.println();
    
//    Shuffled strings
    System.out.println("Shuffled Strings: " + AnagramUtil.areAnagrams(str1, str3));
    System.out.println();
    
//    Two different strings
    System.out.println("Different Strings: " + AnagramUtil.areAnagrams(str1, str2));
    
    // * 3) InsetionSort sort(E[] array) (HINT: use the toSortedString() convenience function from SortedString)
    InsertionSort<SortedString> insertionSorter = new InsertionSort<>();
    SortedString[] toSort = {new SortedString("Act"), new SortedString("dog"), new SortedString("cat")}; 
    SortedString[] sorted = insertionSorter.sort(toSort);
    System.out.println("Sorted Strings (using toSortedString):");
    for (SortedString s : sorted) {
        System.out.println(s.toString());
    }
    
    // * 4.1, 4.2, 4.3) InsertionSort  O(int n), fit(E[] array), and predict(int n)
    // */

    insertionSorter.fit(toSort); // Calculate constant c
    double predictedTime = insertionSorter.predict(10000);
    System.out.println("Predicted Runtime for 10,000 elements: " + predictedTime + " microseconds");
    System.out.println();
    
    // /* 
    // * As a reminder these are the methods we did in assignment:
    // * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    AnagramUtil anagramUtil = new AnagramUtil();
    String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
    System.out.println();
    
    
    // * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    MergeSort<Integer> mergeSorter = new MergeSort<>();
    Integer[] intArray = {7, 3, 1, 6, 2};
    Integer[] sortedIntArray = mergeSorter.sort(intArray);
    System.out.println("Sorted Integer Array (Merge Sort): ");
    for (int i : sortedIntArray) 
    {
        System.out.print(i + " ");
    }
    System.out.println();
    
    // * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    MergeSort<Integer> sorter = new MergeSort<>();
    Integer[] smallArray = {5, 2, 4, 6, 1, 3};
    sorter.fit(smallArray);
    System.out.println();
    
    double predictedRuntime = sorter.predict(100000);
    System.out.println("Predicted Runtime: " + predictedRuntime + " microseconds");
    }

}

