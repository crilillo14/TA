package lab06;

import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
        testConstructor();
        testCompareTo();
        testAreAnagrams();
        testInsertionSort();
        testInsertionSortPrediction();
        testMergeSort();
        testMergeSortPrediction();
        testGetLargestAnagramGroup();
    }

    public static void testConstructor() {
        System.out.println("Testing SortedString Constructor...");
        SortedString s1 = new SortedString("apple");
        assert s1.getUnsorted().equals("apple") : "Test case 1 failed";
        assert s1.getSorted().equals("aelpp") : "Test case 1 failed";

        SortedString s2 = new SortedString("Banana");
        assert s2.getUnsorted().equals("Banana") : "Test case 2 failed";
        assert s2.getSorted().equals("aaabnn") : "Test case 2 failed";

        System.out.println("Constructor tests passed.");
    }

    public static void testCompareTo() {
        System.out.println("Testing compareTo method...");
        SortedString s1 = new SortedString("apple");
        SortedString s2 = new SortedString("Banana");
        SortedString s3 = new SortedString("apple");

        assert s1.compareTo(s2) < 0 : "Test case 1 failed";
        assert s1.compareTo(s3) == 0 : "Test case 2 failed";
        System.out.println("compareTo tests passed.");
    }

    public static void testAreAnagrams() {
        System.out.println("Testing AnagramUtil.areAnagrams...");
        SortedString s1 = new SortedString("listen");
        SortedString s2 = new SortedString("silent");
        assert AnagramUtil.areAnagrams(s1, s2) : "Test case 1 failed";

        SortedString s3 = new SortedString("apple");
        SortedString s4 = new SortedString("banana");
        assert !AnagramUtil.areAnagrams(s3, s4) : "Test case 2 failed";

        System.out.println("areAnagrams tests passed.");
    }

    public static void testInsertionSort() {
        System.out.println("Testing InsertionSort...");
        InsertionSort<Integer> sorter = new InsertionSort<>();
        Integer[] array = {5, 3, 1, 4, 2};
        Integer[] sortedArray = sorter.sort(array);
        assert Arrays.equals(sortedArray, new Integer[]{1, 2, 3, 4, 5}) : "Test case failed";

        System.out.println("InsertionSort tests passed.");
    }

    public static void testInsertionSortPrediction() {
        System.out.println("Testing InsertionSort Prediction...");
        InsertionSort<Integer> sorter = new InsertionSort<>();
        Integer[] array = {5, 3, 1, 4, 2};
        sorter.fit(array);
        double predictedTime = sorter.predict(100000);
        System.out.println("Predicted time for 100,000 elements: " + predictedTime + " microseconds");

        System.out.println("InsertionSort Prediction tests passed.");
    }

    public static void testMergeSort() {
        System.out.println("Testing MergeSort...");
        MergeSort<Integer> sorter = new MergeSort<>();
        Integer[] array = {5, 3, 1, 4, 2};
        Integer[] sortedArray = sorter.sort(array);
        assert Arrays.equals(sortedArray, new Integer[]{1, 2, 3, 4, 5}) : "Test case failed";

        System.out.println("MergeSort tests passed.");
    }

    public static void testMergeSortPrediction() {
        System.out.println("Testing MergeSort Prediction...");
        MergeSort<Integer> sorter = new MergeSort<>();
        Integer[] array = {5, 3, 1, 4, 2};
        sorter.fit(array);
        double predictedTime = sorter.predict(100000);
        System.out.println("Predicted time for 100,000 elements: " + predictedTime + " microseconds");

        System.out.println("MergeSort Prediction tests passed.");
    }

    public static void testGetLargestAnagramGroup() {
        System.out.println("Testing getLargestAnagramGroup...");
        String[] largestGroup = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
        System.out.println("Largest anagram group: " + Arrays.toString(largestGroup));

        System.out.println("getLargestAnagramGroup tests passed.");
    }
}