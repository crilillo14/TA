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
		// Test 1: Basic sorting test
        SortedString test1 = new SortedString("apple");
        System.out.println("Test 1 (apple): " + test1);
        // Expected output: "apple/aelpp"

        // Test 2: Case insensitivity
        SortedString test2 = new SortedString("BaNaNa");
        System.out.println("Test 2 (BaNaNa): " + test2);
        // Expected output: "BaNaNa/aaabnn"

        // Test 3: Sorting with special characters
        SortedString test3 = new SortedString("hello!");
        System.out.println("Test 3 (hello!): " + test3);
        // Expected output: "hello!/!ehllo"

        // Test 4: Sorting empty string
        SortedString test4 = new SortedString("");
        System.out.println("Test 4 (empty string): " + test4);
        // Expected output: "/"

        // Test 5: Sorting a string with repeated characters
        SortedString test5 = new SortedString("mississippi");
        System.out.println("Test 5 (mississippi): " + test5);
        // Expected output: "mississippi/iiiimppssss"

        // Test 6: Comparing two sorted strings
        SortedString test6 = new SortedString("apple");
        SortedString test7 = new SortedString("pear");
        System.out.println("Comparing 'apple' and 'pear': " + test6.compareTo(test7));
        // Expected output: Negative value (since 'aelpp' comes before 'aeprr')

        // Test 7: Sorting array of strings using SortedString
        String[] words = {"banana", "apple", "cherry"};
        SortedString[] sortedWords = SortedString.toSortedString(words);
        for (SortedString word : sortedWords) {
            System.out.println(word);
        }
        // Expected output:
        // "banana/aaabnn"
        // "apple/aelpp"
        // "cherry/cehrry"
	}

}

