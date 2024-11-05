package lab06;

public class Tester {
    public static void main(String[] args) {
        testSortedString();
        testAnagramUtil();
        testInsertionSort();
        testMergeSort();
    }

    // Test SortedString functionality
    public static void testSortedString() {
        System.out.println("Testing SortedString...");

        SortedString str1 = new SortedString("listen");
        SortedString str2 = new SortedString("silent");  // anagrams
        SortedString str3 = new SortedString("deco");
        SortedString str4 = new SortedString("coed");    // anagrams
        SortedString str5 = new SortedString("apple");
        SortedString str6 = new SortedString("banana");  // Not anagrams
        
        assert str1.compareTo(str2) == 0 : "Test failed: 'listen' and 'silent' should be equal.";
        assert str3.compareTo(str4) == 0 : "Test failed: 'deco' and 'coed' should be equal.";
        assert str5.compareTo(str6) != 0 : "Test failed: 'apple' and 'banana' should not be equal.";
        
        System.out.println("SortedString tests passed.");
    }

    // Test AnagramUtil functionality
    public static void testAnagramUtil() {
        System.out.println("Testing AnagramUtil...");

        SortedString str1 = new SortedString("deco");
        SortedString str2 = new SortedString("coed");  // Anagrams
        SortedString str3 = new SortedString("listen");
        SortedString str4 = new SortedString("silent");  // Anagrams
        SortedString str5 = new SortedString("apple");
        SortedString str6 = new SortedString("banana");  // Not anagrams

        assert AnagramUtil.areAnagrams(str1, str2) : "Test failed: 'deco' and 'coed' should be anagrams.";
        assert AnagramUtil.areAnagrams(str3, str4) : "Test failed: 'listen' and 'silent' should be anagrams.";
        assert !AnagramUtil.areAnagrams(str5, str6) : "Test failed: 'apple' and 'banana' should not be anagrams.";
        
        // Edge cases
        SortedString emptyStr = new SortedString("");
        SortedString nonEmptyStr = new SortedString("a");
        
        assert !AnagramUtil.areAnagrams(emptyStr, nonEmptyStr) : "Test failed: Empty string and 'a' should not be anagrams.";
        assert AnagramUtil.areAnagrams(emptyStr, new SortedString("")) : "Test failed: Two empty strings should be anagrams.";
        
        System.out.println("AnagramUtil tests passed.");
    }

    // Test InsertionSort functionality
    public static void testInsertionSort() {
        System.out.println("Testing InsertionSort...");

        InsertionSort<SortedString> sorter = new InsertionSort<>();

        SortedString[] input = {
            new SortedString("deco"),
            new SortedString("apple"),
            new SortedString("coed"),
            new SortedString("banana")
        };

        SortedString[] sorted = sorter.sort(input);

        assert sorted[0].getUnsorted().equals("apple") : "Test failed: First element should be 'apple'.";
        assert sorted[1].getUnsorted().equals("banana") : "Test failed: Second element should be 'banana'.";
        assert sorted[2].getUnsorted().equals("coed") : "Test failed: Third element should be 'coed'.";
        assert sorted[3].getUnsorted().equals("deco") : "Test failed: Fourth element should be 'deco'.";

        System.out.println("InsertionSort tests passed.");
    }

    // Test MergeSort functionality
    public static void testMergeSort() {
        System.out.println("Testing MergeSort...");

        MergeSort<SortedString> sorter = new MergeSort<>();

        SortedString[] input = {
            new SortedString("deco"),
            new SortedString("apple"),
            new SortedString("coed"),
            new SortedString("banana")
        };

        SortedString[] sorted = sorter.sort(input);

        assert sorted[0].getUnsorted().equals("apple") : "Test failed: First element should be 'apple'.";
        assert sorted[1].getUnsorted().equals("banana") : "Test failed: Second element should be 'banana'.";
        assert sorted[2].getUnsorted().equals("coed") : "Test failed: Third element should be 'coed'.";
        assert sorted[3].getUnsorted().equals("deco") : "Test failed: Fourth element should be 'deco'.";

        System.out.println("MergeSort tests passed.");
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

	
	
	// InsertionSort<String> sorter = new InsertionSort<Strings>();
	// sorter.sort(STRING ARRAY) -> returns the sorted array
    /* 
    * As a reminder these are the methods we did in assignment:
    * 1) AnagramUtil getLargestAnagramGroup(SortedString[] stringList) (Hint: You can use getLargestAnagramGroup(String filename))
    * 2) MergeSort sort(E[] array1, E[] array2, int first, int last) (Hint: You can use sort(E[] array))
    * 3.1, 3.2, 3.3) MergeSort  O(int n), fit(E[] array), and predict(int n)
    */



